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
import java.util.List;
import java.util.Set;

/**
 * Created by mingyangling on 11/17/15.
 */
@Named
@Singleton
public class AtestController extends Controller {

    private final AtestRepository atestRepository;
    private final BtestRepository btestRepository;

    @Inject
    public AtestController(final AtestRepository atestRepository, BtestRepository btestRepository) {
        this.atestRepository = atestRepository;
        this.btestRepository = btestRepository;
    }


    public Result addAtest() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Task not created, expecting Json data");
            return badRequest("Task not created, expecting Json data");
        }

        String name = json.path("name").asText();
        String content = json.path("content").asText();
        JsonNode tags = json.path("tag");


        try {
            if (atestRepository.findFirstByName(name) != null) {
                System.out.println("Name existed: " + name);
                return badRequest("Name existed");
            }
            Set<Btest> set = new HashSet<Btest>();
            Atest atest = new Atest(name, content, set);

            for (int i = 0; i < tags.size(); i++) {
                String tag = tags.get(i).asText();
                set.add(new Btest(tag, atest));
            }

            atestRepository.save(atest);
            System.out.println("Page saved: " + atest.toString());
            return created(new Gson().toJson(atest.toString()));
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("Page not saved: " + name);
            return badRequest("Page not saved: " + name);
        }
    }

    public Result updateTag() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Task not created, expecting Json data");
            return badRequest("Task not created, expecting Json data");
        }
        String name = json.path("name").asText();
        JsonNode tags = json.path("tag");

        try {
            Atest atest = atestRepository.findFirstByName(name);
            if (atest == null) {
                System.out.println("Name not exised: " + name);
                return badRequest("Name not existed");
            }
//            List<Btest> list=btestRepository.findByAtest(atest);
            atest.getTests().clear();
//            for(Btest b: list){
//                System.out.println(b.getName());
//                btestRepository.delete(b);
//            }
            for (int i = 0; i < tags.size(); i++) {
                String tag = tags.get(i).asText();
                atest.getTests().add(new Btest(tag, atest));
            }

            atestRepository.save(atest);
            System.out.println("Page saved: " + atest.toString());
            return created(new Gson().toJson(atest.toString()));
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("Page not saved: " + name);
            return badRequest("Page not saved: " + name);
        }

    }


    public Result getAtest(String name) {
        try {
            Atest atest = atestRepository.findFirstByName(name);
            if (atest == null) {
                System.out.println("Name not existed: " + name);
                return badRequest("Name not existed");
            }
            String tags = "";

            for (Btest b : atest.getTests()) {
                tags += b.getName() + " ";
            }
            return created(new Gson().toJson(tags));
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("getAtest: " + name);
            return badRequest("getAtest " + name);
        }
    }
}
