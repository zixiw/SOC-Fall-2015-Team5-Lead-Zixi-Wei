package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;
import models.Atest;
import models.AtestRepository;
import models.Btest;
import models.BtestRepository;
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
public class BtestController extends Controller {

    private final BtestRepository btestRepository;
    private final AtestRepository atestRepository;

    @Inject
    public BtestController(final BtestRepository btestRepository, AtestRepository atestRepository) {
        this.btestRepository = btestRepository;
        this.atestRepository = atestRepository;
    }


    public Result addBtest() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Task not created, expecting Json data");
            return badRequest("Task not created, expecting Json data");
        }

        // Parse JSON file
        String cname = json.path("childname").asText();
        String pname = json.path("parentname").asText();
        Btest btest= btestRepository.findFirstByName(cname);
        Atest atest=atestRepository.findFirstByName(pname);
        try {
            if(atest==null){
                System.out.println("PName not existed: " + pname);
                return badRequest("PName not existed");
            }
            if(btest==null){
                btest = new Btest(cname, atest);
            }
            atest.getTests().add(btest);
            btest.setAtest(atest);
            atestRepository.save(atest);
            btestRepository.save(btest);
            System.out.println("tag saved: " + btest.getId());
            return created(new Gson().toJson(atest.getId()));
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("tag not saved: " + cname);
            return badRequest("tag not saved: " + cname);
        }
    }
}
