package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
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
 * Created by Zixi Wei, Mingyang Ling, Zheng Lei, Sen Yue on 11/30/15.
 */
@Named
@Singleton
public class NewUserController extends Controller {
    private final NewUserRepository newUserRepository;
    private final NewWorkflowRepository newWorkflowRepository;
    private final NewPostRepository newPostRepository;
    private final NewGroupRepository newGroupRepository;

    @Inject
    public NewUserController(final NewUserRepository newUserRepository,
                             final NewWorkflowRepository newWorkflowRepository,
                             final NewPostRepository newPostRepository,
                             final NewGroupRepository newGroupRepository) {
        this.newUserRepository = newUserRepository;
        this.newWorkflowRepository = newWorkflowRepository;
        this.newPostRepository = newPostRepository;
        this.newGroupRepository = newGroupRepository;
    }

    // add
    public Result addUser() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Add user failed, expecting Json data");
            return badRequest("Add user failed, expecting Json data");
        }

        String userName = json.path("userName").asText();
        String password = json.path("password").asText();
        String firstName = json.path("firstName").asText();
        String lastName = json.path("lastName").asText();
        String middleInitial = json.path("middleInitial").asText();
        String affiliation = json.path("affiliation").asText();
        String title = json.path("title").asText();
        String email = json.path("email").asText();
        String mailingAddress = json.path("mailingAddress").asText();
        String phoneNumber = json.path("phoneNumber").asText();
        String faxNumber = json.path("faxNumber").asText();
        String researchFields = json.path("researchFields").asText();
        String highestDegree = json.path("highestDegree").asText();

        try {
            if (newUserRepository.findFirstByUserName(userName) != null) {
                System.out.println("UserName has been used: " + userName);
                return badRequest("UserName has been used: " + userName);
            }
            if (newUserRepository.findFirstByEmail(email) != null) {
                System.out.println("Email has been used: " + email);
                return badRequest("Email has been used");
            }

            NewUser user = new NewUser(userName, password, firstName, lastName, middleInitial, affiliation, title, email, mailingAddress, phoneNumber, faxNumber, researchFields, highestDegree);
            NewUser savedUser = newUserRepository.save(user);
            System.out.println("Add user success: " + savedUser.getId());
            return created(savedUser.toJson().toString());
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("Add user failed: " + firstName + " " + lastName);
            return badRequest("Add user failed: " + firstName + " " + lastName);
        }
    }

    public Result login() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Login failed, expecting Json data");
            return badRequest("Login failed, expecting Json data");
        }

        String email = json.path("email").asText();
        String password = json.path("password").asText();

        NewUser user = newUserRepository.findFirstByEmail(email);
        if (user == null) {
            System.out.println("User not exist");
            return badRequest("User not exist");
        }
        if (user.getPassword().equals(password)) {
            System.out.println("Login success");
            return ok("Login success");
        } else {
            System.out.println("Login failed for wrong password");
            return badRequest("Login failed for wrong password");
        }
    }

    public Result addContributorToWorkflow() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Add contributor to workflow failed, expecting Json data");
            return badRequest("Add contributor to workflow failed, expecting Json data");
        }

        long userId = json.path("userId").asLong();
        long workflowId = json.path("workflowId").asLong();

        NewUser user = newUserRepository.findOne(userId);
        if (user == null) {
            System.out.println("Contributor not found with id: " + userId);
            return notFound("Contributor not found with id: " + userId);
        }

        NewWorkflow workflow = newWorkflowRepository.findOne(workflowId);
        if (workflow == null) {
            System.out.println("Workflow not found with id: " + workflowId);
            return notFound("Workflow not found with id: " + workflowId);
        }

        // set up the link
        user.getNewWorkflows().add(workflow);

        try {
            newUserRepository.save(user);
            System.out.println("Add contributor to Workflow success, contributor id: " + userId + " workflow id: " + workflowId);
            workflow = newWorkflowRepository.findOne(workflowId);
            return created(workflow.toJson().toString());
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("Add contributor to Workflow failed, contributor id: " + userId + " workflow id: " + workflowId);
            return badRequest("Add contributor to Workflow failed, contributor id: " + userId + " workflow id: " + workflowId);
        }
    }

    public Result addUserToGroupAsAdmin() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Add user to group failed, expecting Json data");
            return badRequest("Add user to group failed, expecting Json data");
        }

        long userId = json.path("userId").asLong();
        long groupId = json.path("groupId").asLong();

        NewUser user = newUserRepository.findOne(userId);
        if (user == null) {
            System.out.println("User not found with id: " + userId);
            return notFound("User not found with id: " + userId);
        }

        NewGroup group = newGroupRepository.findOne(groupId);
        if (group == null) {
            System.out.println("Group not found with id: " + groupId);
            return notFound("Group not found with id: " + groupId);
        }

        try {
            Set<NewGroup> usersAdminGroups = user.getAdminGroups();
            for (NewGroup usersAdminGroup : usersAdminGroups) {
                if (usersAdminGroup.getId() == groupId) {
                    System.out.println("User has already in the group as admin");
                    return badRequest("User has already in the group as admin");
                }
            }

            Set<NewGroup> usersMemberGroups = user.getMemberGroups();
            for (NewGroup usersMemberGroup : usersMemberGroups) {
                if (usersMemberGroup.getId() == groupId) {
                    usersMemberGroups.remove(usersMemberGroup);
                    newUserRepository.save(user);
                    break;
                }
            }

            // set up the link
            user.getAdminGroups().add(group);

            NewUser savedUser = newUserRepository.save(user);

            System.out.println("Add user to group as admin success, user id: " + userId + " group id: " + groupId);
            return created(savedUser.toJson().toString());
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("Add user to group as admin failed, user id: " + userId + " group id: " + groupId);
            return badRequest("Add user to group as admin failed, user id: " + userId + " group id: " + groupId);
        }
    }

    public Result addUserToGroupAsMember() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Add user to group failed, expecting Json data");
            return badRequest("Add user to group failed, expecting Json data");
        }

        long userId = json.path("userId").asLong();
        long groupId = json.path("groupId").asLong();

        NewUser user = newUserRepository.findOne(userId);
        if (user == null) {
            System.out.println("User not found with id: " + userId);
            return notFound("User not found with id: " + userId);
        }

        NewGroup group = newGroupRepository.findOne(groupId);
        if (group == null) {
            System.out.println("Group not found with id: " + groupId);
            return notFound("Group not found with id: " + groupId);
        }

        try {
            Set<NewGroup> usersMemberGroups = user.getMemberGroups();
            for (NewGroup usersMemberGroup : usersMemberGroups) {
                if (usersMemberGroup.getId() == groupId) {
                    System.out.println("User has already in the group as member");
                    return badRequest("User has already in the group as member");
                }
            }

            Set<NewGroup> usersAdminGroups = user.getAdminGroups();
            for (NewGroup usersAdminGroup : usersAdminGroups) {
                if (usersAdminGroup.getId() == groupId) {
                    usersAdminGroups.remove(usersAdminGroup);
                    newUserRepository.save(user);
                    break;
                }
            }

            // set up the link
            user.getMemberGroups().add(group);

            NewUser savedUser = newUserRepository.save(user);

            System.out.println("Add user to group as member success, user id: " + userId + " group id: " + groupId);
            return created(savedUser.toJson().toString());
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("Add user to group as member failed, user id: " + userId + " group id: " + groupId);
            return badRequest("Add user to group as member failed, user id: " + userId + " group id: " + groupId);
        }
    }

    public Result addFriendToUser() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Add friend to user failed, expecting Json data");
            return badRequest("Add friend to user failed, expecting Json data");
        }

        long friendId = json.path("friendId").asLong();
        long userId = json.path("userId").asLong();

        NewUser friend = newUserRepository.findOne(friendId);
        if (friend == null) {
            System.out.println("Friend not found with id: " + friendId);
            return notFound("Friend not found with id: " + friendId);
        }

        NewUser user = newUserRepository.findOne(userId);
        if (user == null) {
            System.out.println("User not found with id: " + userId);
            return notFound("User not found with id: " + userId);
        }

        // set up the link
        user.getFriends().add(friend);

        try {
            NewUser savedUser = newUserRepository.save(user);

            System.out.println("Add friend to user success, friend id: " + friendId + " user id: " + userId);
            return created(savedUser.toJson().toString());
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("Add friend to user failed, friend id: " + friendId + " user id: " + userId);
            return badRequest("Add friend to user failed, friend id: " + friendId + " user id: " + userId);
        }
    }

    public Result addSubscribeUserToUser() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Add subscribe user to user failed, expecting Json data");
            return badRequest("Add subscribe user to user failed, expecting Json data");
        }

        long subscribeUserId = json.path("subscribeUserId").asLong();
        long userId = json.path("userId").asLong();

        NewUser subscribeUser = newUserRepository.findOne(subscribeUserId);
        if (subscribeUser == null) {
            System.out.println("Subscribe user not found with id: " + subscribeUserId);
            return notFound("Subscribe user not found with id: " + subscribeUserId);
        }

        NewUser user = newUserRepository.findOne(userId);
        if (user == null) {
            System.out.println("User not found with id: " + userId);
            return notFound("User not found with id: " + userId);
        }

        // set up the link
        user.getSubscribeUsers().add(subscribeUser);

        try {
            NewUser savedUser = newUserRepository.save(user);

            System.out.println("Add subscribe user to user success, subscribe user id: " + subscribeUserId + " user id: " + userId);
            return created(savedUser.toJson().toString());
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("Add subscribe user to user failed, subscribe user id: " + subscribeUserId + " user id: " + userId);
            return badRequest("Add subscribe user to user failed, subscribe user id: " + subscribeUserId + " user id: " + userId);
        }
    }

    public Result addSubscribeGroupToUser() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Add subscribe group to user failed, expecting Json data");
            return badRequest("Add subscribe group to user failed, expecting Json data");
        }

        long groupId = json.path("groupId").asLong();
        long userId = json.path("userId").asLong();

        NewGroup group = newGroupRepository.findOne(groupId);
        if (group == null) {
            System.out.println("Group not found with id: " + groupId);
            return notFound("Group not found with id: " + groupId);
        }

        NewUser user = newUserRepository.findOne(userId);
        if (user == null) {
            System.out.println("User not found with id: " + userId);
            return notFound("User not found with id: " + userId);
        }

        try {
            // set up the link
            user.getSubscribeGroups().add(group);

            NewUser savedUser = newUserRepository.save(user);

            System.out.println("Add subscribe group to user success, user id: " + userId + " group id: " + groupId);
            return created(savedUser.toJson().toString());
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("Add subscribe group to user failed, user id: " + userId + " group id: " + groupId);
            return badRequest("Add subscribe group to user failed, user id: " + userId + " group id: " + groupId);
        }
    }

    public Result addSubscribeWorkflowToUser() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Add subscribe workflow to user failed, expecting Json data");
            return badRequest("Add subscribe workflow to user failed, expecting Json data");
        }

        long workflowId = json.path("workflowId").asLong();
        long userId = json.path("userId").asLong();

        NewWorkflow workflow = newWorkflowRepository.findOne(workflowId);
        if (workflow == null) {
            System.out.println("Workflow not found with id: " + workflowId);
            return notFound("Workflow not found with id: " + workflowId);
        }

        NewUser user = newUserRepository.findOne(userId);
        if (user == null) {
            System.out.println("User not found with id: " + userId);
            return notFound("User not found with id: " + userId);
        }

        try {
            // set up the link
            user.getSubscribeWorkflows().add(workflow);

            NewUser savedUser = newUserRepository.save(user);

            System.out.println("Add subscribe workflow to user success, user id: " + userId + " workflow id: " + workflowId);
            return created(savedUser.toJson().toString());
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("Add subscribe workflow to user failed, user id: " + userId + " workflow id: " + workflowId);
            return badRequest("Add subscribe workflow to user failed, user id: " + userId + " workflow id: " + workflowId);
        }
    }

    // delete
    public Result deleteUser() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Delete user failed, expecting Json data");
            return badRequest("Delete user failed, expecting Json data");
        }

        long id = json.path("userId").asLong();

        NewUser user = newUserRepository.findOne(id);
        if (user == null) {
            System.out.println("User not found with id: " + id);
            return notFound("User not found with id: " + id);
        }

        removeRelationship(user);

        newUserRepository.delete(user);

        System.out.println("Delete user success: " + id);
        return ok("Delete user success: " + id);
    }

    public Result deleteUserByUserNameAndPassword() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Delete user failed, expecting Json data");
            return badRequest("Delete user failed, expecting Json data");
        }

        String userName = json.path("userName").asText();
        String password = json.path("password").asText();

        NewUser user = newUserRepository.findFirstByUserName(userName);
        if (user == null) {
            System.out.println("User not exist");
            return badRequest("User not exist");
        }
        if (user.getPassword().equals(password)) {
            removeRelationship(user);
            newUserRepository.delete(user);
            System.out.println("Delete user success: " + user.getId());
            return ok("Delete user success: " + user.getId());
        } else {
            System.out.println("User is not deleted for wrong password");
            return badRequest("User is not deleted for wrong password");
        }
    }

    public Result deleteContributorFromWorkflow() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Delete contributor from Workflow failed, expecting Json data");
            return badRequest("Delete contributor from Workflow failed, expecting Json data");
        }

        long userId = json.path("userId").asLong();
        long workflowId = json.path("workflowId").asLong();

        NewUser user = newUserRepository.findOne(userId);
        if (user == null) {
            System.out.println("Contributor not found with id: " + userId);
            return notFound("Contributor not found with id: " + userId);
        }

        NewWorkflow workflow = newWorkflowRepository.findOne(workflowId);
        if (workflow == null) {
            System.out.println("Workflow not found with id: " + workflowId);
            return notFound("Workflow not found with id: " + workflowId);
        }

        Set<NewWorkflow> usersWorkflows = user.getNewWorkflows();
        for (NewWorkflow usersWorkflow : usersWorkflows) {
            if (usersWorkflow.getId() == workflow.getId()) {
                usersWorkflows.remove(usersWorkflow);
                newUserRepository.save(user);
                break;
            }
        }

        workflow = newWorkflowRepository.findOne(workflowId);
        Set<NewUser> users = workflow.getNewUsers();
        for (NewUser usr : users) {
            if (usr.getId() == userId) {
                System.out.println("Delete contributor from Workflow failed, contributor id: " + userId + " workflow id: " + workflowId);
                return ok("Delete contributor from Workflow failed, contributor id: " + userId + " workflow id: " + workflowId);
            }
        }
        System.out.println("Delete contributor from Workflow success, contributor id: " + userId + " workflow id: " + workflowId);
        return ok("Delete contributor from Workflow success, contributor id: " + userId + " workflow id: " + workflowId);
    }

    public Result deleteUserFromGroup() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Delete user from group failed, expecting Json data");
            return badRequest("Delete user from group failed, expecting Json data");
        }

        long userId = json.path("userId").asLong();
        long groupId = json.path("groupId").asLong();

        NewUser user = newUserRepository.findOne(userId);
        if (user == null) {
            System.out.println("User not found with id: " + userId);
            return notFound("User not found with id: " + userId);
        }

        NewGroup group = newGroupRepository.findOne(groupId);
        if (group == null) {
            System.out.println("Group not found with id: " + groupId);
            return notFound("Group not found with id: " + groupId);
        }

        Set<NewGroup> usersAdminGroups = user.getAdminGroups();
        for (NewGroup usersAdminGroup : usersAdminGroups) {
            if (usersAdminGroup.getId() == groupId) {
                usersAdminGroups.remove(usersAdminGroup);
                newUserRepository.save(user);
                break;
            }
        }

        Set<NewGroup> usersMemberGroups = user.getMemberGroups();
        for (NewGroup usersMemberGroup : usersMemberGroups) {
            if (usersMemberGroup.getId() == groupId) {
                usersMemberGroups.remove(usersMemberGroup);
                newUserRepository.save(user);
                break;
            }
        }

        group = newGroupRepository.findOne(groupId);
        Set<NewUser> groupsAdminUsers = group.getAdminUsers();
        for (NewUser groupsAdminUser : groupsAdminUsers) {
            if (groupsAdminUser.getId() == userId) {
                System.out.println("Delete user from group failed, user id: " + userId + " group id: " + groupId);
                return badRequest("Delete user from group failed, user id: " + userId + " group id: " + groupId);
            }
        }

        group = newGroupRepository.findOne(groupId);
        Set<NewUser> groupsMemberUsers = group.getMemberUsers();
        for (NewUser groupsMemberUser : groupsMemberUsers) {
            if (groupsMemberUser.getId() == userId) {
                System.out.println("Delete user from group failed, user id: " + userId + " group id: " + groupId);
                return badRequest("Delete user from group failed, user id: " + userId + " group id: " + groupId);
            }
        }

        System.out.println("Delete user from group success, user id: " + userId + " group id: " + groupId);
        return ok("Delete user from group success, user id: " + userId + " group id: " + groupId);
    }

    public Result deleteFriendFromUser() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Delete friend to user failed, expecting Json data");
            return badRequest("Delete friend to user failed, expecting Json data");
        }

        long friendId = json.path("friendId").asLong();
        long userId = json.path("userId").asLong();

        NewUser friend = newUserRepository.findOne(friendId);
        if (friend == null) {
            System.out.println("Friend not found with id: " + friendId);
            return notFound("Friend not found with id: " + friendId);
        }

        NewUser user = newUserRepository.findOne(userId);
        if (user == null) {
            System.out.println("User not found with id: " + userId);
            return notFound("User not found with id: " + userId);
        }

        Set<NewUser> usersFriends = user.getFriends();
        for (NewUser usersFriend : usersFriends) {
            if (usersFriend.getId() == friendId) {
                usersFriends.remove(usersFriend);
                newUserRepository.save(user);
                break;
            }
        }

        System.out.println("Delete friend from user success, friend id: " + friendId + " user id: " + userId);
        return ok("Delete friend from user success, friend id: " + friendId + " user id: " + userId);
    }

    public Result deleteSubscribeUserFromUser() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Delete subscribe user to user failed, expecting Json data");
            return badRequest("Delete subscribe user to user failed, expecting Json data");
        }

        long subscribeUserId = json.path("subscribeUserId").asLong();
        long userId = json.path("userId").asLong();

        NewUser subscribeUser = newUserRepository.findOne(subscribeUserId);
        if (subscribeUser == null) {
            System.out.println("Subscribe user not found with id: " + subscribeUserId);
            return notFound("Subscribe user not found with id: " + subscribeUserId);
        }

        NewUser user = newUserRepository.findOne(userId);
        if (user == null) {
            System.out.println("User not found with id: " + userId);
            return notFound("User not found with id: " + userId);
        }

        Set<NewUser> usersSubscribeUsers = user.getSubscribeUsers();
        for (NewUser usersSubscribeUser : usersSubscribeUsers) {
            if (usersSubscribeUser.getId() == subscribeUserId) {
                usersSubscribeUsers.remove(usersSubscribeUser);
                newUserRepository.save(user);
                break;
            }
        }

        System.out.println("Delete subscribe user from user success, subscribe user id: " + subscribeUserId + " user id: " + userId);
        return ok("Delete subscribe user from user success, subscribe user id: " + subscribeUserId + " user id: " + userId);
    }

    public Result deleteSubscribeGroupFromUser() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Delete subscribe group from user failed, expecting Json data");
            return badRequest("Delete subscribe group from user failed, expecting Json data");
        }

        long groupId = json.path("groupId").asLong();
        long userId = json.path("userId").asLong();

        NewGroup group = newGroupRepository.findOne(groupId);
        if (group == null) {
            System.out.println("Group not found with id: " + groupId);
            return notFound("Group not found with id: " + groupId);
        }

        NewUser user = newUserRepository.findOne(userId);
        if (user == null) {
            System.out.println("User not found with id: " + userId);
            return notFound("User not found with id: " + userId);
        }

        Set<NewGroup> usersSubscribeGroups = user.getSubscribeGroups();
        for (NewGroup usersSubscribeGroup : usersSubscribeGroups) {
            if (usersSubscribeGroup.getId() == groupId) {
                usersSubscribeGroups.remove(usersSubscribeGroup);
                newUserRepository.save(user);
                break;
            }
        }

        group = newGroupRepository.findOne(groupId);
        Set<NewUser> groupsSubscribedUsers = group.getSubscribedUsers();
        for (NewUser groupsSubscribedUser : groupsSubscribedUsers) {
            if (groupsSubscribedUser.getId() == userId) {
                System.out.println("Delete subscribe group from user failed, user id: " + userId + " group id: " + groupId);
                return badRequest("Delete subscribe group from user failed, user id: " + userId + " group id: " + groupId);
            }
        }

        System.out.println("Delete subscribe group from user success, user id: " + userId + " group id: " + groupId);
        return ok("Delete subscribe group from user success, user id: " + userId + " group id: " + groupId);
    }

    public Result deleteSubscribeWorkflowFromUser() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Delete subscribe workflow from user failed, expecting Json data");
            return badRequest("Delete subscribe workflow from user failed, expecting Json data");
        }

        long workflowId = json.path("workflowId").asLong();
        long userId = json.path("userId").asLong();

        NewWorkflow workflow = newWorkflowRepository.findOne(workflowId);
        if (workflow == null) {
            System.out.println("Workflow not found with id: " + workflowId);
            return notFound("Workflow not found with id: " + workflowId);
        }

        NewUser user = newUserRepository.findOne(userId);
        if (user == null) {
            System.out.println("User not found with id: " + userId);
            return notFound("User not found with id: " + userId);
        }

        Set<NewWorkflow> usersSubscribeWorkflows = user.getSubscribeWorkflows();
        for (NewWorkflow usersSubscribeWorkflow : usersSubscribeWorkflows) {
            if (usersSubscribeWorkflow.getId() == workflowId) {
                usersSubscribeWorkflows.remove(usersSubscribeWorkflow);
                newUserRepository.save(user);
                break;
            }
        }

        workflow = newWorkflowRepository.findOne(workflowId);
        Set<NewUser> groupsSubscribedUsers = workflow.getSubscribedUsers();
        for (NewUser groupsSubscribedUser : groupsSubscribedUsers) {
            if (groupsSubscribedUser.getId() == userId) {
                System.out.println("Delete subscribe workflow from user failed, user id: " + userId + " workflow id: " + workflowId);
                return badRequest("Delete subscribe workflow from user failed, user id: " + userId + " workflow id: " + workflowId);
            }
        }

        System.out.println("Delete subscribe workflow from user success, user id: " + userId + " workflow id: " + workflowId);
        return ok("Delete subscribe workflow from user success, user id: " + userId + " workflow id: " + workflowId);
    }

    private void removeRelationship(NewUser user) {
        long id = user.getId();
        try {
            // remove one to many relationship -- post
            // even the user is deleted, his/her post won't be deleted
            List<NewPost> usersPosts = user.getNewPosts();
            for (NewPost usersPost : usersPosts) {
                NewPost thePost = newPostRepository.findOne(usersPost.getId());
                thePost.setNewUser(null);
                newPostRepository.save(thePost);
            }

            // remove many to many self join relationship -- friend
            Set<NewUser> usersFriends = user.getFriends();
            for (NewUser usersFriend : usersFriends) {
                NewUser theFriend = newUserRepository.findOne(usersFriend.getId());
                Set<NewUser> theFriendsFriends = theFriend.getFriends();
                for (NewUser theFriendsFriend : theFriendsFriends) {
                    if (theFriendsFriend.getId() == id) {
                        theFriendsFriends.remove(theFriendsFriend);
                        newUserRepository.save(theFriend);
                        break;
                    }
                }
            }
            user.getFriends().clear();
            newUserRepository.save(user);

            // remove many to many self join relationship -- subscribe user
            Set<NewUser> usersSubscribeUsers = user.getSubscribeUsers();
            for (NewUser usersSubscribeUser : usersSubscribeUsers) {
                NewUser theSubscribeUser = newUserRepository.findOne(usersSubscribeUser.getId());
                Set<NewUser> theSubscribeUsersSubscribeUsers = theSubscribeUser.getSubscribeUsers();
                for (NewUser theSubscribeUsersSubscribeUser : theSubscribeUsersSubscribeUsers) {
                    if (theSubscribeUsersSubscribeUser.getId() == id) {
                        theSubscribeUsersSubscribeUsers.remove(theSubscribeUsersSubscribeUser);
                        newUserRepository.save(theSubscribeUser);
                        break;
                    }
                }
            }
            user.getSubscribeUsers().clear();
            newUserRepository.save(user);
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("User not saved: " + id);
        }
    }

    // update
    public Result updateUser() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Update user failed, expecting Json data");
            return badRequest("Update user failed, expecting Json data");
        }

        long id = json.path("userId").asLong();
        String userName = json.path("userName").asText();
        String password = json.path("password").asText();
        String firstName = json.path("firstName").asText();
        String lastName = json.path("lastName").asText();
        String middleInitial = json.path("middleInitial").asText();
        String affiliation = json.path("affiliation").asText();
        String title = json.path("title").asText();
        String email = json.path("email").asText();
        String mailingAddress = json.path("mailingAddress").asText();
        String phoneNumber = json.path("phoneNumber").asText();
        String faxNumber = json.path("faxNumber").asText();
        String researchFields = json.path("researchFields").asText();
        String highestDegree = json.path("highestDegree").asText();

        NewUser user = newUserRepository.findOne(id);
        if (user == null) {
            System.out.println("User not found with id: " + id);
            return notFound("User not found with id: " + id);
        }

        try {
            user.setUserName(userName);
            user.setPassword(password);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setMiddleInitial(middleInitial);
            user.setAffiliation(affiliation);
            user.setTitle(title);
            user.setEmail(email);
            user.setMailingAddress(mailingAddress);
            user.setPhoneNumber(phoneNumber);
            user.setFaxNumber(faxNumber);
            user.setResearchFields(researchFields);
            user.setHighestDegree(highestDegree);

            NewUser savedUser = newUserRepository.save(user);
            System.out.println("Update user success: " + savedUser.getId());
            return created(savedUser.toJson().toString());
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("Update user failed: " + id);
            return badRequest("Update user failed: " + id);
        }
    }

    // get
    public Result getUser() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Get user failed, expecting Json data");
            return badRequest("Get user failed, expecting Json data");
        }

        long id = json.path("userId").asLong();

        NewUser user = newUserRepository.findOne(id);
        if (user == null) {
            System.out.println("User not found with id: " + id);
            return notFound("User not found with id: " + id);
        }

        return created(user.toJson().toString());
    }

    public Result getUserIdByUserName() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Get user failed, expecting Json data");
            return badRequest("Get user failed, expecting Json data");
        }

        String userName = json.path("userName").asText();

        NewUser user = newUserRepository.findFirstByUserName(userName);
        if (user == null) {
            System.out.println("User not found with user name: " + userName);
            return notFound("User not found with user name: " + userName);
        }

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("userId", user.getId());
        return created(jsonObject.toString());
    }

    public Result getUserIdByEmail() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Get user failed, expecting Json data");
            return badRequest("Get user failed, expecting Json data");
        }

        String email = json.path("email").asText();

        NewUser user = newUserRepository.findFirstByEmail(email);
        if (user == null) {
            System.out.println("User not found with user name: " + email);
            return notFound("User not found with user name: " + email);
        }

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("userId", user.getId());
        return created(jsonObject.toString());
    }

    public Result getAllUsers() {
        JsonObject jsonObject = new JsonObject();
        JsonArray jsonArrayAllUsers = new JsonArray();
        Iterable<NewUser> users = newUserRepository.findAll();
        for (NewUser user : users) {
            jsonArrayAllUsers.add(user.toBasicJson());
        }
        jsonObject.add("allUsers", jsonArrayAllUsers);
        return created(jsonObject.toString());
    }

    // other
    public Result getSubscribersNumber() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Get subscribers' number failed, expecting Json data");
            return badRequest("Get subscribers' number failed, expecting Json data");
        }

        long id = json.path("userId").asLong();

        NewUser user = newUserRepository.findOne(id);
        if (user == null) {
            System.out.println("User not found with id: " + id);
            return notFound("User not found with id: " + id);
        }

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("subscribersNumber", user.getSubscribeTeammates().size());
        return created(jsonObject.toString());
    }

    public Result getCollaboratorsNumber() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Get collaborators' number failed, expecting Json data");
            return badRequest("Get collaborators' number failed, expecting Json data");
        }

        long id = json.path("userId").asLong();

        NewUser user = newUserRepository.findOne(id);
        if (user == null) {
            System.out.println("User not found with id: " + id);
            return notFound("User not found with id: " + id);
        }

        Set<String> collaborators = new HashSet<String>();
        Set<NewWorkflow> usersWorkflows = user.getNewWorkflows();
        for (NewWorkflow usersWorkflow : usersWorkflows) {
            Set<NewUser> usersWorkflowsUsers = usersWorkflow.getNewUsers();
            for (NewUser usersWorkflowsUser : usersWorkflowsUsers) {
                collaborators.add(usersWorkflowsUser.getUserName());
            }
        }

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("collaboratorsNumber", collaborators.size());
        return created(jsonObject.toString());
    }
}
