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
public class NewInstructionController extends Controller {
    private final NewInstructionRepository newInstructionRepository;
    private final NewWorkflowRepository newWorkflowRepository;

    @Inject
    public NewInstructionController(final NewInstructionRepository newInstructionRepository,
                             final NewWorkflowRepository newWorkflowRepository) {
        this.newInstructionRepository = newInstructionRepository;
        this.newWorkflowRepository = newWorkflowRepository;
    }

    // add
    public Result addInstruction() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Add instruction failed, expecting Json data");
            return badRequest("Add instruction failed, expecting Json data");
        }

        String name = json.path("name").asText();
        String description = json.path("description").asText();

        try {
            NewInstruction instruction = new NewInstruction(name, description);
            NewInstruction savedInstruction = newInstructionRepository.save(instruction);
            System.out.println("Add instruction success: " + savedInstruction.getId());
            return created(savedInstruction.toJson().toString());
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("Add instruction failed: " + name);
            return badRequest("Add instruction failed: " + name);
        }
    }

    public Result addInstructionToWorkflow() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Add instruction to Workflow failed, expecting Json data");
            return badRequest("Add instruction to Workflow failed, expecting Json data");
        }

        long instructionId = json.path("instructionId").asLong();
        long workflowId = json.path("workflowId").asLong();

        NewInstruction instruction = newInstructionRepository.findOne(instructionId);
        if (instruction == null) {
            System.out.println("Instruction not found with id: " + instructionId);
            return notFound("Instruction not found with id: " + instructionId);
        }

        NewWorkflow workflow = newWorkflowRepository.findOne(workflowId);
        if (workflow == null) {
            System.out.println("Workflow not found with id: " + workflowId);
            return notFound("Workflow not found with id: " + workflowId);
        }

        List<NewInstruction> workflowsInstructions = workflow.getNewInstructions();
        for (NewInstruction workflowsInstruction : workflowsInstructions) {
            if (workflowsInstruction.getId() == instructionId) {
                System.out.println("Add instruction failed, instruction id " + instructionId + " has existed in workflow id: " + workflowId);
                return badRequest("Add instruction failed, instruction id " + instructionId + " has existed in workflow id: " + workflowId);
            }
        }

        // set up the link
        instruction.setNewWorkflow(workflow);

        try {
            newInstructionRepository.save(instruction);
            System.out.println("Add instruction to Workflow success");
            workflow = newWorkflowRepository.findOne(workflowId);
            return created(workflow.toJson().toString());
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("Add instruction to Workflow failed, instruction id: " + instructionId + " workflow id: " + workflowId);
            return badRequest("Add instruction to Workflow failed, instruction id: " + instructionId + " workflow id: " + workflowId);
        }
    }

    // delete
    public Result deleteInstruction() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Delete instruction failed, expecting Json data");
            return badRequest("Delete instruction failed, expecting Json data");
        }

        long id = json.path("instructionId").asLong();

        NewInstruction instruction = newInstructionRepository.findOne(id);
        if (instruction == null) {
            System.out.println("Instruction not found with id: " + id);
            return notFound("Instruction not found with id: " + id);
        }

        newInstructionRepository.delete(instruction);

        System.out.println("Delete instruction success: " + id);
        return ok("Delete instruction success: " + id);
    }

    // update
    public Result updateInstruction() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Update instruction failed, expecting Json data");
            return badRequest("Update instruction failed, expecting Json data");
        }

        long id = json.path("instructionId").asLong();
        String name = json.path("name").asText();
        String description = json.path("description").asText();

        NewInstruction instruction = newInstructionRepository.findOne(id);
        if (instruction == null) {
            System.out.println("Instruction not found with id: " + id);
            return notFound("Instruction not found with id: " + id);
        }

        try {
            instruction.setName(name);
            instruction.setDescription(description);

            NewInstruction savedInstruction = newInstructionRepository.save(instruction);
            System.out.println("Update instruction success: " + savedInstruction.getId());
            return created(savedInstruction.toJson().toString());
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("Update instruction failed: " + id);
            return badRequest("Update instruction failed: " + id);
        }
    }

    // get
    public Result getInstruction() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Get instruction failed, expecting Json data");
            return badRequest("Get instruction failed, expecting Json data");
        }

        long id = json.path("instructionId").asLong();

        NewInstruction instruction = newInstructionRepository.findOne(id);
        if (instruction == null) {
            System.out.println("Instruction not found with id: " + id);
            return notFound("Instruction not found with id: " + id);
        }

        return created(instruction.toJson().toString());
    }
}
