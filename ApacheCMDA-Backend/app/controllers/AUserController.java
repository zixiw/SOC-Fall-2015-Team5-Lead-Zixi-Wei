package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import models.*;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.persistence.PersistenceException;

/**
 * Created by ethan on 11/20/15.
 */

@Named
@Singleton
public class AUserController extends Controller {


    private final AUserRepository aUserRepository;

    @Inject
    public AUserController(final AUserRepository aUserRepository) {
        this.aUserRepository = aUserRepository;
    }

    public Result login() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("login data not created, expecting Json data");
            return badRequest("login data created, expecting Json data");
        }
// Parse JSON file
        String email = json.path("email").asText();
        String password = json.path("password").asText();
//        System.out.println("email received: " + email);
//        System.out.println("password received: " + password);
        AUser user = null;
        try {
            if ((user = aUserRepository.findByEmail(email)) != null) {
                if (user.getPassword().equals(password)) {
                    System.out.println("login successful");
                    return ok("login successful");
                } else {
                    System.out.println("login failed, password does not match");
                    return badRequest("login failed, password does not match");
                }

            } else {
                System.out.println("login failed, password does not match");
                return badRequest("login failed, password does not match");
            }
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("login failed, no such user");
            return badRequest("login failed, no such user");
        }
    }


    public Result register() {
        JsonNode user = request().body().asJson();
        if (user == null) {
            System.out.println("register failed, expecting Json data");
            return badRequest("register failed, expecting Json data");
        }

        String userName= user.path("userName").asText();
        if(aUserRepository.findFirstByUserName(userName) != null) {
            System.out.println("user already existed");
            return badRequest("user already existed");
        }
        String password= user.path("password").asText();
        String firstName= user.path("firstName").asText();
        String lastName= user.path("lastName").asText();
        String middleInitial= user.path("middleInitial").asText();
        String affiliation= user.path("affiliation").asText();
        String title= user.path("title").asText();
        String email= user.path("email").asText();
        String mailingAddress= user.path("mailingAddress").asText();
        String phoneNumber= user.path("phoneNumber").asText();
        String faxNumber= user.path("faxNumber").asText();
        String researchFields= user.path("researchFields").asText();
        String highestDegree= user.path("highestDegree").asText();
        AUser aUser = new AUser(userName, password,firstName, lastName, middleInitial, affiliation, title, email, mailingAddress, phoneNumber, faxNumber, researchFields, highestDegree, null, null );
        aUserRepository.save(aUser);
        return ok("register successful");
    }


    public Result getUser(String email) {
        AUser aUser = aUserRepository.findByEmail(email);
        if(aUser == null) {
            System.out.println("cannot find requested user");
            return badRequest("cannot find requested user");
        }
        JsonObject jsonObject = aUser.toJson();
        AWorkflow aWorkflow = aUser.getaWorkflow();
        JsonArray jsonArray = new JsonArray();
        jsonArray.add(aWorkflow.toJson());
        jsonObject.add("workflows", jsonArray);
        return created(jsonObject.toString());
    }


}
