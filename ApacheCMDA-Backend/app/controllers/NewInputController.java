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
public class NewInputController extends Controller {
    private final NewInputRepository newInputRepository;
    private final NewWorkflowRepository newWorkflowRepository;

    @Inject
    public NewInputController(final NewInputRepository newInputRepository,
                             final NewWorkflowRepository newWorkflowRepository) {
        this.newInputRepository = newInputRepository;
        this.newWorkflowRepository = newWorkflowRepository;
    }

    // add
    public Result addInput() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Add input failed, expecting Json data");
            return badRequest("Add input failed, expecting Json data");
        }

        String name = json.path("name").asText();
        String description = json.path("description").asText();

        try {
            NewInput input = new NewInput(name, description);
            NewInput savedInput = newInputRepository.save(input);
            System.out.println("Add input success: " + savedInput.getId());
            return created(savedInput.toJson().toString());
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("Add input failed: " + name);
            return badRequest("Add input failed: " + name);
        }
    }

    public Result addInputToWorkflow() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Add input to Workflow failed, expecting Json data");
            return badRequest("Add input to Workflow failed, expecting Json data");
        }

        long inputId = json.path("inputId").asLong();
        long workflowId = json.path("workflowId").asLong();

        NewInput input = newInputRepository.findOne(inputId);
        if (input == null) {
            System.out.println("Input not found with id: " + inputId);
            return notFound("Input not found with id: " + inputId);
        }

        NewWorkflow workflow = newWorkflowRepository.findOne(workflowId);
        if (workflow == null) {
            System.out.println("Workflow not found with id: " + workflowId);
            return notFound("Workflow not found with id: " + workflowId);
        }

        List<NewInput> worksInputs = workflow.getNewInputs();
        for (NewInput worksInput : worksInputs) {
            if (worksInput.getId() == inputId) {
                System.out.println("Add input failed, input id " + inputId + " has existed in workflow id: " + workflowId);
                return badRequest("Add input failed, input id " + inputId + " has existed in workflow id: " + workflowId);
            }
        }

        // set up the link
        input.setNewWorkflow(workflow);

        try {
            newInputRepository.save(input);
            System.out.println("Add input to Workflow success");
            workflow = newWorkflowRepository.findOne(workflowId);
            return created(workflow.toJson().toString());
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("Add input to Workflow failed, input id: " + inputId + " workflow id: " + workflowId);
            return badRequest("Add input to Workflow failed, input id: " + inputId + " workflow id: " + workflowId);
        }
    }

    // delete
    public Result deleteInput() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Delete input failed, expecting Json data");
            return badRequest("Delete input failed, expecting Json data");
        }

        long id = json.path("inputId").asLong();

        NewInput input = newInputRepository.findOne(id);
        if (input == null) {
            System.out.println("Input not found with id: " + id);
            return notFound("Input not found with id: " + id);
        }

        newInputRepository.delete(input);

        System.out.println("Delete input success: " + id);
        return ok("Delete input success: " + id);
    }

    // update
    public Result updateInput() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Update input failed, expecting Json data");
            return badRequest("Update input failed, expecting Json data");
        }

        long id = json.path("inputId").asLong();
        String name = json.path("name").asText();
        String description = json.path("description").asText();

        NewInput input = newInputRepository.findOne(id);
        if (input == null) {
            System.out.println("Input not found with id: " + id);
            return notFound("Input not found with id: " + id);
        }

        try {
            input.setName(name);
            input.setDescription(description);

            NewInput savedInput = newInputRepository.save(input);
            System.out.println("Update input success: " + savedInput.getId());
            return created(savedInput.toJson().toString());
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("Update input failed: " + id);
            return badRequest("Update input failed: " + id);
        }
    }

    // get
    public Result getInput() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Get input failed, expecting Json data");
            return badRequest("Get input failed, expecting Json data");
        }

        long id = json.path("inputId").asLong();

        NewInput input = newInputRepository.findOne(id);
        if (input == null) {
            System.out.println("Input not found with id: " + id);
            return notFound("Input not found with id: " + id);
        }

        return created(input.toJson().toString());
    }
}
