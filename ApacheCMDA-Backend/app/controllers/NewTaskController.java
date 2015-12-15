package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.NewTask;
import models.NewTaskRepository;
import models.NewWorkflow;
import models.NewWorkflowRepository;
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
public class NewTaskController extends Controller {
    private final NewTaskRepository newTaskRepository;
    private final NewWorkflowRepository newWorkflowRepository;

    @Inject
    public NewTaskController(final NewTaskRepository newTaskRepository,
                             final NewWorkflowRepository newWorkflowRepository) {
        this.newTaskRepository = newTaskRepository;
        this.newWorkflowRepository = newWorkflowRepository;
    }

    // add
    public Result addTask() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Add task failed, expecting Json data");
            return badRequest("Add task failed, expecting Json data");
        }

        String name = json.path("name").asText();
        String description = json.path("description").asText();

        try {
            NewTask task = new NewTask(name, description);
            NewTask savedTask = newTaskRepository.save(task);
            System.out.println("Add task success: " + savedTask.getId());
            return created(savedTask.toJson().toString());
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("Add task failed: " + name);
            return badRequest("Add task failed: " + name);
        }
    }

    public Result addTaskToWorkflow() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Add task to Workflow failed, expecting Json data");
            return badRequest("Add task to Workflow failed, expecting Json data");
        }

        long taskId = json.path("taskId").asLong();
        long workflowId = json.path("workflowId").asLong();

        NewTask task = newTaskRepository.findOne(taskId);
        if (task == null) {
            System.out.println("Task not found with id: " + taskId);
            return notFound("Task not found with id: " + taskId);
        }

        NewWorkflow workflow = newWorkflowRepository.findOne(workflowId);
        if (workflow == null) {
            System.out.println("Workflow not found with id: " + workflowId);
            return notFound("Workflow not found with id: " + workflowId);
        }

        List<NewTask> workflowsTasks = workflow.getNewTasks();
        for (NewTask workflowsTask : workflowsTasks) {
            if (workflowsTask.getId() == taskId) {
                System.out.println("Add task failed, task id " + taskId + " has existed in workflow id: " + workflowId);
                return badRequest("Add task failed, task id " + taskId + " has existed in workflow id: " + workflowId);
            }
        }

        // set up the link
        task.setNewWorkflow(workflow);

        try {
            newTaskRepository.save(task);
            System.out.println("Add task to Workflow success");
            workflow = null;
            workflow = newWorkflowRepository.findOne(workflowId);
            return created(workflow.toJson().toString());
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("Add task to Workflow failed, task id: " + taskId + " workflow id: " + workflowId);
            return badRequest("Add task to Workflow failed, task id: " + taskId + " workflow id: " + workflowId);
        }
    }

    // delete
    public Result deleteTask() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Delete task failed, expecting Json data");
            return badRequest("Delete task failed, expecting Json data");
        }

        long id = json.path("taskId").asLong();

        NewTask task = newTaskRepository.findOne(id);
        if (task == null) {
            System.out.println("Task not found with id: " + id);
            return notFound("Task not found with id: " + id);
        }

        newTaskRepository.delete(task);

        System.out.println("Delete task success: " + id);
        return ok("Delete task success: " + id);
    }

    // update
    public Result updateTask() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Update task failed, expecting Json data");
            return badRequest("Update task failed, expecting Json data");
        }

        long id = json.path("taskId").asLong();
        String name = json.path("name").asText();
        String description = json.path("description").asText();

        NewTask task = newTaskRepository.findOne(id);
        if (task == null) {
            System.out.println("Task not found with id: " + id);
            return notFound("Task not found with id: " + id);
        }

        try {
            task.setName(name);
            task.setDescription(description);

            NewTask savedTask = newTaskRepository.save(task);
            System.out.println("Update task success: " + savedTask.getId());
            return created(savedTask.toJson().toString());
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("Update task failed: " + id);
            return badRequest("Update task failed: " + id);
        }
    }

    // get
    public Result getTask() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Get task failed, expecting Json data");
            return badRequest("Get task failed, expecting Json data");
        }

        long id = json.path("taskId").asLong();

        NewTask task = newTaskRepository.findOne(id);
        if (task == null) {
            System.out.println("Task not found with id: " + id);
            return notFound("Task not found with id: " + id);
        }

        return created(task.toJson().toString());
    }
}
