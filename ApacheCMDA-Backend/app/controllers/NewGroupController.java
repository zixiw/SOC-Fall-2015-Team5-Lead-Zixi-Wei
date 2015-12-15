package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import models.NewGroup;
import models.NewGroupRepository;
import models.NewUser;
import models.NewUserRepository;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.persistence.PersistenceException;
import java.util.Set;

/**
 * Created by Zixi Wei, Mingyang Ling, Zheng Lei, Sen Yue on 12/1/15.
 */
@Named
@Singleton
public class NewGroupController extends Controller {
    private final NewGroupRepository newGroupRepository;
    private final NewUserRepository newUserRepository;

    @Inject
    public NewGroupController(final NewGroupRepository newGroupRepository,
                              final NewUserRepository newUserRepository) {
        this.newGroupRepository = newGroupRepository;
        this.newUserRepository = newUserRepository;
    }

    // add
    public Result addGroup() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Add group failed, expecting Json data");
            return badRequest("Add group failed, expecting Json data");
        }

        long creatorId  = json.path("creatorId").asLong();
        String name  = json.path("name").asText();
        boolean isPublic  = json.path("isPublic").asBoolean();

        try {
            if (newGroupRepository.findFirstByName(name) != null) {
                System.out.println("Group name has been used: " + name);
                return badRequest("Group name has been used: " + name);
            }

            NewGroup group = new NewGroup(creatorId, name, isPublic);
            NewGroup savedGroup = newGroupRepository.save(group);
            System.out.println("Add group success: " + savedGroup.getId());
            return created(savedGroup.toJson().toString());
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("Add group failed: " + name);
            return badRequest("Add group failed: " + name);
        }
    }

    // delete
    public Result deleteGroup() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Delete group failed, expecting Json data");
            return badRequest("Delete group failed, expecting Json data");
        }

        long id = json.path("groupId").asLong();

        NewGroup group = newGroupRepository.findOne(id);
        if (group == null) {
            System.out.println("Group not found with id: " + id);
            return notFound("Group not found with id: " + id);
        }

        Set<NewUser> groupsAdminUsers = group.getAdminUsers();
        for (NewUser groupsAdminUser : groupsAdminUsers) {
            NewUser theAdminUser = newUserRepository.findOne(groupsAdminUser.getId());
            Set<NewGroup> theAdminUsersAdminGroups = theAdminUser.getAdminGroups();
            for (NewGroup theAdminUsersAdminGroup : theAdminUsersAdminGroups) {
                if (theAdminUsersAdminGroup.getId() == id) {
                    theAdminUsersAdminGroups.remove(theAdminUsersAdminGroup);
                    newUserRepository.save(theAdminUser);
                    break;
                }
            }
        }

        Set<NewUser> groupsMemberUsers = group.getMemberUsers();
        for (NewUser groupsMemberUser : groupsMemberUsers) {
            NewUser theMemberUser = newUserRepository.findOne(groupsMemberUser.getId());
            Set<NewGroup> theMemberUsersMemberGroups = theMemberUser.getMemberGroups();
            for (NewGroup theMemberUsersMemberGroup : theMemberUsersMemberGroups) {
                if (theMemberUsersMemberGroup.getId() == id) {
                    theMemberUsersMemberGroups.remove(theMemberUsersMemberGroup);
                    newUserRepository.save(theMemberUser);
                    break;
                }
            }
        }

        Set<NewUser> groupsSubscribedUsers = group.getSubscribedUsers();
        for (NewUser groupsSubscribedUser : groupsSubscribedUsers) {
            NewUser theSubscribedUser = newUserRepository.findOne(groupsSubscribedUser.getId());
            Set<NewGroup> theSubscribedUsersSubscribeGroups = theSubscribedUser.getSubscribeGroups();
            for (NewGroup theSubscribedUsersSubscribeGroup : theSubscribedUsersSubscribeGroups) {
                if (theSubscribedUsersSubscribeGroup.getId() == id) {
                    theSubscribedUsersSubscribeGroups.remove(theSubscribedUsersSubscribeGroup);
                    newUserRepository.save(theSubscribedUser);
                    break;
                }
            }
        }

        newGroupRepository.delete(group);

        System.out.println("Delete group success: " + id);
        return ok("Delete group success: " + id);
    }

    // update
    public Result updateGroup() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Update group failed, expecting Json data");
            return badRequest("Update group failed, expecting Json data");
        }

        long id = json.path("groupId").asLong();
        long creatorId  = json.path("creatorId").asLong();
        String name  = json.path("name").asText();
        boolean isPublic  = json.path("isPublic").asBoolean();

        NewGroup group = newGroupRepository.findOne(id);
        if (group == null) {
            System.out.println("Group not found with id: " + id);
            return notFound("Group not found with id: " + id);
        }

        try {
            group.setCreatorId(creatorId);
            group.setName(name);
            group.setPublic(isPublic);

            NewGroup savedGroup = newGroupRepository.save(group);
            System.out.println("Update group success: " + savedGroup.getId());
            return created(savedGroup.toJson().toString());
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("Update group failed: " + id);
            return badRequest("Update group failed: " + id);
        }
    }

    // get
    public Result getGroup() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Get group failed, expecting Json data");
            return badRequest("Get group failed, expecting Json data");
        }

        long id = json.path("groupId").asLong();

        NewGroup group = newGroupRepository.findOne(id);
        if (group == null) {
            System.out.println("Group not found with id: " + id);
            return notFound("Group not found with id: " + id);
        }

        return created(group.toJson().toString());
    }

    public Result getGroupIdByName() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Get group failed, expecting Json data");
            return badRequest("Get group failed, expecting Json data");
        }

        String name = json.path("name").asText();

        NewGroup group = newGroupRepository.findFirstByName(name);
        if (group == null) {
            System.out.println("Group not found with group name: " + name);
            return notFound("Group not found with group name: " + name);
        }

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("groupId", group.getId());
        return created(jsonObject.toString());
    }

    public Result getAllGroups() {
        JsonObject jsonObject = new JsonObject();
        JsonArray jsonArrayAllGroups = new JsonArray();
        Iterable<NewGroup> groups = newGroupRepository.findAll();
        for (NewGroup group : groups) {
            jsonArrayAllGroups.add(group.toBasicJson());
        }
        jsonObject.add("allGroups", jsonArrayAllGroups);
        return created(jsonObject.toString());
    }
}
