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
public class NewOutputController extends Controller {
    private final NewOutputRepository newOutputRepository;
    private final NewWorkflowRepository newWorkflowRepository;

    @Inject
    public NewOutputController(final NewOutputRepository newOutputRepository,
                             final NewWorkflowRepository newWorkflowRepository) {
        this.newOutputRepository = newOutputRepository;
        this.newWorkflowRepository = newWorkflowRepository;
    }

    // add
    public Result addOutput() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Add output failed, expecting Json data");
            return badRequest("Add output failed, expecting Json data");
        }

        String name = json.path("name").asText();
        String description = json.path("description").asText();

        try {
            NewOutput output = new NewOutput(name, description);
            NewOutput savedOutput = newOutputRepository.save(output);
            System.out.println("Add output success: " + savedOutput.getId());
            return created(savedOutput.toJson().toString());
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("Add output failed: " + name);
            return badRequest("Add output failed: " + name);
        }
    }

    public Result addOutputToWorkflow() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Add output to Workflow failed, expecting Json data");
            return badRequest("Add output to Workflow failed, expecting Json data");
        }

        long outputId = json.path("outputId").asLong();
        long workflowId = json.path("workflowId").asLong();

        NewOutput output = newOutputRepository.findOne(outputId);
        if (output == null) {
            System.out.println("Output not found with id: " + outputId);
            return notFound("Output not found with id: " + outputId);
        }

        NewWorkflow workflow = newWorkflowRepository.findOne(workflowId);
        if (workflow == null) {
            System.out.println("Workflow not found with id: " + workflowId);
            return notFound("Workflow not found with id: " + workflowId);
        }

        List<NewOutput> workflowsOutputs = workflow.getNewOutputs();
        for (NewOutput workflowsOutput : workflowsOutputs) {
            if (workflowsOutput.getId() == outputId) {
                System.out.println("Add output failed, output id " + outputId + " has existed in workflow id: " + workflowId);
                return badRequest("Add output failed, output id " + outputId + " has existed in workflow id: " + workflowId);
            }
        }

        // set up the link
        output.setNewWorkflow(workflow);

        try {
            newOutputRepository.save(output);
            System.out.println("Add output to Workflow success");
            workflow = newWorkflowRepository.findOne(workflowId);
            return created(workflow.toJson().toString());
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("Add output to Workflow failed, output id: " + outputId + " workflow id: " + workflowId);
            return badRequest("Add output to Workflow failed, output id: " + outputId + " workflow id: " + workflowId);
        }
    }

    // delete
    public Result deleteOutput() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Delete output failed, expecting Json data");
            return badRequest("Delete output failed, expecting Json data");
        }

        long id = json.path("outputId").asLong();

        NewOutput output = newOutputRepository.findOne(id);
        if (output == null) {
            System.out.println("Output not found with id: " + id);
            return notFound("Output not found with id: " + id);
        }

        newOutputRepository.delete(output);

        System.out.println("Delete output success: " + id);
        return ok("Delete output success: " + id);
    }

    // update
    public Result updateOutput() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Update output failed, expecting Json data");
            return badRequest("Update output failed, expecting Json data");
        }

        long id = json.path("outputId").asLong();
        String name = json.path("name").asText();
        String description = json.path("description").asText();

        NewOutput output = newOutputRepository.findOne(id);
        if (output == null) {
            System.out.println("Output not found with id: " + id);
            return notFound("Output not found with id: " + id);
        }

        try {
            output.setName(name);
            output.setDescription(description);

            NewOutput savedOutput = newOutputRepository.save(output);
            System.out.println("Update output success: " + savedOutput.getId());
            return created(savedOutput.toJson().toString());
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("Update output failed: " + id);
            return badRequest("Update output failed: " + id);
        }
    }

    // get
    public Result getOutput() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Get output failed, expecting Json data");
            return badRequest("Get output failed, expecting Json data");
        }

        long id = json.path("outputId").asLong();

        NewOutput output = newOutputRepository.findOne(id);
        if (output == null) {
            System.out.println("Output not found with id: " + id);
            return notFound("Output not found with id: " + id);
        }

        return created(output.toJson().toString());
    }
}
