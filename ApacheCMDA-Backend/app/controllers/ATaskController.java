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

/**
 * Created by mingyangling on 11/17/15.
 */
@Named
@Singleton
public class ATaskController extends Controller {

    private final ATaskRepository aTaskRepository;

    @Inject
    public ATaskController(final ATaskRepository aTaskRepository) {
        this.aTaskRepository = aTaskRepository;
    }


    public Result addATask() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Task not created, expecting Json data");
            return badRequest("Task not created, expecting Json data");
        }

        // Parse JSON file
        String name = json.path("name").asText();
        String content = json.path("content").asText();


        try {
            if (aTaskRepository.findFirstByName(name)!=null) {
                System.out.println("Task has been used: " + name);
                return badRequest("Task has been used");
            }
            ATask aTask=new ATask(name,content,new AWorkflow());
            aTaskRepository.save(aTask);
            System.out.println("Task saved: " + aTask.getId());
            return created(new Gson().toJson(aTask.getId()));
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("Task not saved: " + name);
            return badRequest("Task not saved: " + name);
        }
    }
}
