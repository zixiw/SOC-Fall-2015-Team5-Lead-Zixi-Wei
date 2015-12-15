package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.*;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.persistence.PersistenceException;
import java.util.List;

/**
 * Created by Zixi Wei, Mingyang Ling, Zheng Lei, Sen Yue on 12/1/15.
 */
@Named
@Singleton
public class NewDatasetController extends Controller {
    private final NewDatasetRepository newDatasetRepository;
    private final NewWorkflowRepository newWorkflowRepository;

    @Inject
    public NewDatasetController(final NewDatasetRepository newDatasetRepository,
                             final NewWorkflowRepository newWorkflowRepository) {
        this.newDatasetRepository = newDatasetRepository;
        this.newWorkflowRepository = newWorkflowRepository;
    }

    // add
    public Result addDataset() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Add dataset failed, expecting Json data");
            return badRequest("Add dataset failed, expecting Json data");
        }

        String name = json.path("name").asText();
        String content = json.path("content").asText();

        try {
            NewDataset dataset = new NewDataset(name, content);
            NewDataset savedDataset = newDatasetRepository.save(dataset);
            System.out.println("Add dataset success: " + savedDataset.getId());
            return created(savedDataset.toJson().toString());
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("Add dataset failed: " + name);
            return badRequest("Add dataset failed: " + name);
        }
    }

    public Result addDatasetToWorkflow() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Add dataset to Workflow failed, expecting Json data");
            return badRequest("Add dataset to Workflow failed, expecting Json data");
        }

        long datasetId = json.path("datasetId").asLong();
        long workflowId = json.path("workflowId").asLong();

        NewDataset dataset = newDatasetRepository.findOne(datasetId);
        if (dataset == null) {
            System.out.println("Dataset not found with id: " + datasetId);
            return notFound("Dataset not found with id: " + datasetId);
        }

        NewWorkflow workflow = newWorkflowRepository.findOne(workflowId);
        if (workflow == null) {
            System.out.println("Workflow not found with id: " + workflowId);
            return notFound("Workflow not found with id: " + workflowId);
        }

        List<NewDataset> workflowsDatasets = workflow.getNewDatasets();
        for (NewDataset workflowsDataset : workflowsDatasets) {
            if (workflowsDataset.getId() == datasetId) {
                System.out.println("Add dataset failed, dataset id " + datasetId + " has existed in workflow id: " + workflowId);
                return badRequest("Add dataset failed, dataset id " + datasetId + " has existed in workflow id: " + workflowId);
            }
        }

        // set up the link
        dataset.setNewWorkflow(workflow);

        try {
            newDatasetRepository.save(dataset);
            System.out.println("Add dataset to Workflow success");
            workflow = newWorkflowRepository.findOne(workflowId);
            return created(workflow.toJson().toString());
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("Add dataset to Workflow failed, dataset id: " + datasetId + " workflow id: " + workflowId);
            return badRequest("Add dataset to Workflow failed, dataset id: " + datasetId + " workflow id: " + workflowId);
        }
    }

    // delete
    public Result deleteDataset() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Delete dataset failed, expecting Json data");
            return badRequest("Delete dataset failed, expecting Json data");
        }

        long id = json.path("datasetId").asLong();

        NewDataset dataset = newDatasetRepository.findOne(id);
        if (dataset == null) {
            System.out.println("Dataset not found with id: " + id);
            return notFound("Dataset not found with id: " + id);
        }

        newDatasetRepository.delete(dataset);

        System.out.println("Delete dataset success: " + id);
        return ok("Delete dataset success: " + id);
    }

    // update
    public Result updateDataset() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Update dataset failed, expecting Json data");
            return badRequest("Update dataset failed, expecting Json data");
        }

        long id = json.path("datasetId").asLong();
        String name = json.path("name").asText();
        String content = json.path("content").asText();

        NewDataset dataset = newDatasetRepository.findOne(id);
        if (dataset == null) {
            System.out.println("Dataset not found with id: " + id);
            return notFound("Dataset not found with id: " + id);
        }

        try {
            dataset.setName(name);
            dataset.setContent(content);

            NewDataset savedDataset = newDatasetRepository.save(dataset);
            System.out.println("Update dataset success: " + savedDataset.getId());
            return created(savedDataset.toJson().toString());
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("Update dataset failed: " + id);
            return badRequest("Update dataset failed: " + id);
        }
    }

    // get
    public Result getDataset() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Get dataset failed, expecting Json data");
            return badRequest("Get dataset failed, expecting Json data");
        }

        long id = json.path("datasetId").asLong();

        NewDataset dataset = newDatasetRepository.findOne(id);
        if (dataset == null) {
            System.out.println("Dataset not found with id: " + id);
            return notFound("Dataset not found with id: " + id);
        }

        return created(dataset.toJson().toString());
    }
}
