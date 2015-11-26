package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.AGroup;
import models.AGroupRepository;

import models.AUser;
import models.AUserRepository;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ethan on 11/20/15.
 */
@Named
@Singleton
public class AGroupController extends Controller {
    private final AGroupRepository aGroupRepository;
    private final AUserRepository aUserRepository;

    @Inject
    public AGroupController(final AGroupRepository aGroupRepository, AUserRepository aUserRepository) {
        this.aGroupRepository = aGroupRepository;
        this.aUserRepository = aUserRepository;
    }

    public Result createGroup() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("group not created, expecting Json data");
            return badRequest("group not created, expecting Json data");
        }
        String groupname = json.get("groupname").asText();
        Set<AUser> users = new HashSet<>();
        AGroup aGroup = new AGroup(groupname, users);
        aGroupRepository.save(aGroup);
        return ok("group created successful");
    }


    public Result addUser() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Task not created, expecting Json data");
            return badRequest("Task not created, expecting Json data");
        }
        String username = json.get("username").asText();
        String groupname = json.get("groupname").asText();

        AUser auser = aUserRepository.findFirstByUserName(username);
        if(auser == null) {
            System.out.println("cannot find user");
            return badRequest("cannot find user");
        }

        AGroup aGroup = aGroupRepository.findFirstByName(groupname);
        if(aGroup == null) {
            System.out.println("cannot find group");
            return badRequest("cannot find group");
        }

        Set<AUser> users = aGroup.getUsers();
        users.add(auser);
        aGroup.setUsers(users);
        System.out.println(auser.getUserName());
        aGroupRepository.save(aGroup);
        return ok("add user successful");
    }


    public Result getGroup(String groupname) {
        AGroup aGroup = aGroupRepository.findFirstByName(groupname);
        if(aGroup == null) {
            System.out.println("cannot find request group");
            return badRequest("cannot find request group");
        }
        return created(aGroup.toJson().toString());
    }


}
