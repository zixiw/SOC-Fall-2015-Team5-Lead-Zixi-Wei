package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;
import models.*;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.persistence.PersistenceException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mingyangling on 11/17/15.
 */
@Named
@Singleton
public class AWrokflowController extends Controller {

    private final AWorkflowRepository aWorkflowRepository;

    @Inject
    public AWrokflowController(final AWorkflowRepository aWorkflowRepository) {
        this.aWorkflowRepository = aWorkflowRepository;
    }


    public Result addWorkflow() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Task not created, expecting Json data");
            return badRequest("Task not created, expecting Json data");
        }

        String name = json.path("name").asText();
        String description = json.path("description").asText();
        String previewImage = json.path("previewImage").asText();
        JsonNode tasks = json.path("tasks");
        JsonNode inputs = json.path("inputs");
        JsonNode outputs = json.path("outputs");
        JsonNode contributors = json.path("contributors");
        JsonNode tags = json.path("tags");
        JsonNode links = json.path("links");
        JsonNode instruments = json.path("instruments");
        JsonNode associatedDatasets = json.path("associatedDatasets");
        JsonNode associateWorkflow = json.path("associateWorkflow");



        try {
            if (aWorkflowRepository.findFirstByName(name) != null) {
                System.out.println("Name existed: " + name);
                return badRequest("Name existed");
            }
            AWorkflow workflow = new AWorkflow();
            workflow.setName(name);
            workflow.setDescription(description);
            workflow.setPreviewImage(previewImage);
            Set<ATask> taskSet = new HashSet<ATask>();
            for (int i = 0; i < tasks.size(); i++) {
                JsonNode task = tasks.get(i);
                String taskname= task.path("name").asText();
                String taskcontent=task.path("content").asText();
                taskSet.add(new ATask(taskname,taskcontent,workflow ));
            }
            workflow.setTasks(taskSet);
            Set<AInput> inputSet = new HashSet<AInput>();
            for (int i = 0; i < inputs.size(); i++) {
                JsonNode input = inputs.get(i);
                String inputname= input.path("name").asText();
                String inputcontent=input.path("content").asText();
                inputSet.add(new AInput(inputname,inputcontent,workflow ));
            }
            workflow.setInputs(inputSet);
            aWorkflowRepository.save(workflow);
            System.out.println("Page saved: " + workflow.toString());
            return created(new Gson().toJson(workflow.toString()));
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("Page not saved: " + name);
            return badRequest("Page not saved: " + name);
        }
    }

//    public Result updateTag() {
//        JsonNode json = request().body().asJson();
//        if (json == null) {
//            System.out.println("Task not created, expecting Json data");
//            return badRequest("Task not created, expecting Json data");
//        }
//        String name = json.path("name").asText();
//        JsonNode tags = json.path("tag");
//
//        try {
//            Atest atest = atestRepository.findFirstByName(name);
//            if (atest == null) {
//                System.out.println("Name not exised: " + name);
//                return badRequest("Name not existed");
//            }
////            List<Btest> list=btestRepository.findByAtest(atest);
//            atest.getTests().clear();
////            for(Btest b: list){
////                System.out.println(b.getName());
////                btestRepository.delete(b);
////            }
//            for (int i = 0; i < tags.size(); i++) {
//                String tag = tags.get(i).asText();
//                atest.getTests().add(new Btest(tag, atest));
//            }
//
//            atestRepository.save(atest);
//            System.out.println("Page saved: " + atest.toString());
//            return created(new Gson().toJson(atest.toString()));
//        } catch (PersistenceException pe) {
//            pe.printStackTrace();
//            System.out.println("Page not saved: " + name);
//            return badRequest("Page not saved: " + name);
//        }
//
//    }


    public Result getWorkflow(String name) {
        try {
            AWorkflow aWorkflow = aWorkflowRepository.findFirstByName(name);
            if (aWorkflow == null) {
                System.out.println("Name not existed: " + name);
                return badRequest("Name not existed");
            }
            String tasks = "";

            for (ATask task : aWorkflow.getTasks()) {
                tasks += task.getName() + " "+task.getContent()+"......";
            }
            return created(new Gson().toJson(tasks));
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("getAtest: " + name);
            return badRequest("getAtest " + name);
        }
    }
}
