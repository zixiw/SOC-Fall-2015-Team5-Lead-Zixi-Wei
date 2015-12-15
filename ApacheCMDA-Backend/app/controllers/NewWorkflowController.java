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
import java.util.List;
import java.util.Set;

/**
 * Created by Zixi Wei, Mingyang Ling, Zheng Lei, Sen Yue on 11/30/15.
 */
@Named
@Singleton
public class NewWorkflowController extends Controller {
    private final NewWorkflowRepository newWorkflowRepository;
    private final NewUserRepository newUserRepository;
    private final NewTagRepository newTagRepository;
    private final NewPostRepository newPostRepository;

    @Inject
    public NewWorkflowController(final NewWorkflowRepository newWorkflowRepository,
                                 final NewUserRepository newUserRepository,
                                 final NewTagRepository newTagRepository,
                                 final NewPostRepository newPostRepository) {
        this.newWorkflowRepository = newWorkflowRepository;
        this.newUserRepository = newUserRepository;
        this.newTagRepository = newTagRepository;
        this.newPostRepository = newPostRepository;
    }

    // add
    public Result addWorkflow() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Add workflow failed, expecting Json data");
            return badRequest("Add workflow failed, expecting Json data");
        }

        String name = json.path("name").asText();
        String description = json.path("description").asText();
        String previewImage = json.path("previewImage").asText();
        int usageCount = 0;
        int viewCount = 0;
        int downloadCount = 0;
        int referenceCount = 0;
        int questionableCount = 0;

        try {
            if (newWorkflowRepository.findFirstByName(name) != null) {
                System.out.println("Workflow name has been used: " + name);
                return badRequest("Workflow name has been used");
            }

            NewWorkflow workflow = new NewWorkflow(name, description, previewImage, usageCount, viewCount, downloadCount, referenceCount, questionableCount);
            NewWorkflow savedWorkflow = newWorkflowRepository.save(workflow);
            System.out.println("Add workflow success: " + savedWorkflow.getId());
            return created(savedWorkflow.toJson().toString());
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("Add workflow failed: " + name);
            return badRequest("Add workflow failed: " + name);
        }
    }

    public Result addAttributeWorkflowToWorkflow() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Add attribute workflow to Workflow failed, expecting Json data");
            return badRequest("Add attribute workflow to Workflow failed, expecting Json data");
        }

        long attributeWorkflowId = json.path("attributeWorkflowId").asLong();
        long workflowId = json.path("workflowId").asLong();

        NewWorkflow attributeWorkflow = newWorkflowRepository.findOne(attributeWorkflowId);
        if (attributeWorkflow == null) {
            System.out.println("Attribute Workflow not found with id: " + attributeWorkflowId);
            return notFound("Attribute Workflow not found with id: " + attributeWorkflowId);
        }

        NewWorkflow workflow = newWorkflowRepository.findOne(workflowId);
        if (workflow == null) {
            System.out.println("Workflow not found with id: " + workflowId);
            return notFound("Workflow not found with id: " + workflowId);
        }

        // set up the link
        workflow.getAttributeWorkflows().add(attributeWorkflow);

        try {
            NewWorkflow savedWorkflow = newWorkflowRepository.save(workflow);

            System.out.println("Add attribute workflow to Workflow success, attribute workflow id " + attributeWorkflowId + " workflow id: " + workflowId);
            return created(savedWorkflow.toJson().toString());
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("Add attribute workflow to Workflow failed, attribute workflow id " + attributeWorkflowId + " workflow id: " + workflowId);
            return badRequest("Add attribute workflow to Workflow failed, attribute workflow id " + attributeWorkflowId + " workflow id: " + workflowId);
        }
    }

    public Result addTagToWorkflow() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Add tag to workflow failed, expecting Json data");
            return badRequest("Add tag to workflow failed, expecting Json data");
        }

        long tagId = json.path("tagId").asLong();
        long workflowId = json.path("workflowId").asLong();

        NewTag tag = newTagRepository.findOne(tagId);
        if (tag == null) {
            System.out.println("Tag not found with id: " + tagId);
            return notFound("Tag not found with id: " + tagId);
        }

        NewWorkflow workflow = newWorkflowRepository.findOne(workflowId);
        if (workflow == null) {
            System.out.println("Workflow not found with id: " + workflowId);
            return notFound("Workflow not found with id: " + workflowId);
        }

        try {
            // set up the link
            workflow.getWorkflowTags().add(tag);

            NewWorkflow savedWorkflow = newWorkflowRepository.save(workflow);

            System.out.println("Add tag to workflow success, workflow id: " + workflowId + " tag id: " + tagId);
            return created(savedWorkflow.toJson().toString());
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("Add tag to workflow failed, workflow id: " + workflowId + " tag id: " + tagId);
            return badRequest("Add tag to workflow failed, workflow id: " + workflowId + " tag id: " + tagId);
        }
    }

    // delete
    public Result deleteWorkflow() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Delete workflow failed, expecting Json data");
            return badRequest("Delete workflow failed, expecting Json data");
        }

        long id = json.path("workflowId").asLong();

        NewWorkflow workflow = newWorkflowRepository.findOne(id);
        if (workflow == null) {
            System.out.println("Workflow not found with id: " + id);
            return notFound("Workflow not found with id: " + id);
        }

        removeRelationship(workflow);

        newWorkflowRepository.delete(workflow);

        System.out.println("Delete workflow success: " + id);
        return ok("Delete workflow success: " + id);
    }

    public Result deleteWorkflowByName() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Delete workflow failed, expecting Json data");
            return badRequest("Delete workflow failed, expecting Json data");
        }

        String name = json.path("name").asText();

        NewWorkflow workflow = newWorkflowRepository.findFirstByName(name);
        if (workflow == null) {
            System.out.println("Workflow not exist");
            return badRequest("Workflow not exist");
        } else {
            removeRelationship(workflow);
            newWorkflowRepository.delete(workflow);
            System.out.println("Delete workflow success: " + workflow.getId());
            return ok("Delete workflow success: " + workflow.getId());
        }
    }

    public Result deleteAttributeWorkflowFromWorkflow() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Delete attribute workflow to Workflow failed, expecting Json data");
            return badRequest("Delete attribute workflow to Workflow failed, expecting Json data");
        }

        long attributeWorkflowId = json.path("attributeWorkflowId").asLong();
        long workflowId = json.path("workflowId").asLong();

        NewWorkflow attributeWorkflow = newWorkflowRepository.findOne(attributeWorkflowId);
        if (attributeWorkflow == null) {
            System.out.println("Attribute Workflow not found with id: " + attributeWorkflowId);
            return notFound("Attribute Workflow not found with id: " + attributeWorkflowId);
        }

        NewWorkflow workflow = newWorkflowRepository.findOne(workflowId);
        if (workflow == null) {
            System.out.println("Workflow not found with id: " + workflowId);
            return notFound("Workflow not found with id: " + workflowId);
        }

        Set<NewWorkflow> workflowsAttributeWorkflows = workflow.getAttributeWorkflows();
        for (NewWorkflow workflowsAttributeWorkflow : workflowsAttributeWorkflows) {
            if (workflowsAttributeWorkflow.getId() == attributeWorkflowId) {
                workflowsAttributeWorkflows.remove(workflowsAttributeWorkflow);
                newWorkflowRepository.save(workflow);
                break;
            }
        }

        System.out.println("Delete attribute workflow from workflow success, attribute workflow id " + attributeWorkflowId + " workflow id: " + workflowId);
        return ok("Delete attribute workflow from workflow success, attribute workflow id " + attributeWorkflowId + " workflow id: " + workflowId);
    }

    public Result deleteTagFromWorkflow() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Delete tag from workflow failed, expecting Json data");
            return badRequest("Delete tag from workflow failed, expecting Json data");
        }

        long tagId = json.path("tagId").asLong();
        long workflowId = json.path("workflowId").asLong();

        NewTag tag = newTagRepository.findOne(tagId);
        if (tag == null) {
            System.out.println("Tag not found with id: " + tagId);
            return notFound("Tag not found with id: " + tagId);
        }

        NewWorkflow workflow = newWorkflowRepository.findOne(workflowId);
        if (workflow == null) {
            System.out.println("Workflow not found with id: " + workflowId);
            return notFound("Workflow not found with id: " + workflowId);
        }

        Set<NewTag> workflowsTags = workflow.getWorkflowTags();
        for (NewTag workflowsTag : workflowsTags) {
            if (workflowsTag.getId() == tagId) {
                workflowsTags.remove(workflowsTag);
                newWorkflowRepository.save(workflow);
                break;
            }
        }

        tag = newTagRepository.findOne(tagId);
        Set<NewWorkflow> tagsWorkflows = tag.getNewWorkflows();
        for (NewWorkflow tagsWorkflow : tagsWorkflows) {
            if (tagsWorkflow.getId() == workflowId) {
                System.out.println("Delete tag from workflow failed, workflow id: " + workflowId + " tag id: " + tagId);
                return badRequest("Delete tag from workflow failed, workflow id: " + workflowId + " tag id: " + tagId);
            }
        }

        System.out.println("Delete tag from workflow success, workflow id: " + workflowId + " tag id: " + tagId);
        return ok("Delete tag from workflow success, workflow id: " + workflowId + " tag id: " + tagId);
    }

    private void removeRelationship(NewWorkflow workflow) {
        long id = workflow.getId();
        try {
            // remove many to many relationship -- contributors
            Set<NewUser> workflowsUsers = workflow.getNewUsers();
            for (NewUser workflowsUser : workflowsUsers) {
                NewUser theUser = newUserRepository.findOne(workflowsUser.getId());
                Set<NewWorkflow> theUsersWorkflows = theUser.getNewWorkflows();
                for (NewWorkflow theUsersWorkflow : theUsersWorkflows) {
                    if (theUsersWorkflow.getId() == id) {
                        theUsersWorkflows.remove(theUsersWorkflow);
                        newUserRepository.save(theUser);
                        break;
                    }
                }
            }

            // remove many to many relationship -- tags
            Set<NewTag> workflowsTags = workflow.getWorkflowTags();
            for (NewTag workflowsTag : workflowsTags) {
                NewTag theTag = newTagRepository.findOne(workflowsTag.getId());
                Set<NewWorkflow> theTagsWorkflows = theTag.getNewWorkflows();
                for (NewWorkflow theTagsWorkflow : theTagsWorkflows) {
                    if (theTagsWorkflow.getId() == id) {
                        theTagsWorkflows.remove(theTagsWorkflow);
                        newTagRepository.save(theTag);
                        break;
                    }
                }
            }

            // remove many to many relationship -- subscribed users
            Set<NewUser> workflowsSubscribedUsers = workflow.getSubscribedUsers();
            for (NewUser workflowsSubscribedUser : workflowsSubscribedUsers) {
                NewUser theSubscribedUser = newUserRepository.findOne(workflowsSubscribedUser.getId());
                Set<NewWorkflow> theSubscribedUsersWorkflows = theSubscribedUser.getSubscribeWorkflows();
                for (NewWorkflow theSubscribedUsersWorkflow : theSubscribedUsersWorkflows) {
                    if (theSubscribedUsersWorkflow.getId() == id) {
                        theSubscribedUsersWorkflows.remove(theSubscribedUsersWorkflow);
                        newUserRepository.save(theSubscribedUser);
                        break;
                    }
                }
            }

            // remove many to many self join relationship -- other workflows that attribute this workflow
            Set<NewWorkflow> workflowsAttributeWorkflows = workflow.getAttributeWorkflows();
            for (NewWorkflow workflowsAttributeWorkflow : workflowsAttributeWorkflows) {
                NewWorkflow theAttributeWorkflow = newWorkflowRepository.findOne(workflowsAttributeWorkflow.getId());
                Set<NewWorkflow> theAttributeWorkflowsAttributeWorkflows = theAttributeWorkflow.getAttributeWorkflows();
                for (NewWorkflow theAttributeWorkflowsAttributeWorkflow : theAttributeWorkflowsAttributeWorkflows) {
                    if (theAttributeWorkflowsAttributeWorkflow.getId() == id) {
                        theAttributeWorkflowsAttributeWorkflows.remove(theAttributeWorkflowsAttributeWorkflow);
                        newWorkflowRepository.save(theAttributeWorkflow);
                        break;
                    }
                }
            }
            workflow.getAttributeWorkflows().clear();
            newWorkflowRepository.save(workflow);
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("Workflow not saved: " + id);
        }
    }

    // update
    public Result updateWorkflow() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Update workflow failed, expecting Json data");
            return badRequest("Update workflow failed, expecting Json data");
        }

        long id = json.path("workflowId").asLong();
        String name = json.path("name").asText();
        String description = json.path("description").asText();
        String previewImage = json.path("previewImage").asText();
        int usageCount = json.path("usageCount").asInt();
        int viewCount = json.path("viewCount").asInt();
        int downloadCount = json.path("downloadCount").asInt();
        int referenceCount = json.path("referenceCount").asInt();
        int questionableCount = json.path("questionableCount").asInt();

        NewWorkflow workflow = newWorkflowRepository.findOne(id);
        if (workflow == null) {
            System.out.println("Workflow not found with id: " + id);
            return notFound("Workflow not found with id: " + id);
        }

        try {
            workflow.setName(name);
            workflow.setDescription(description);
            workflow.setPreviewImage(previewImage);
            workflow.setUsageCount(usageCount);
            workflow.setViewCount(viewCount);
            workflow.setDownloadCount(downloadCount);
            workflow.setReferenceCount(referenceCount);
            workflow.setQuestionableCount(questionableCount);

            NewWorkflow savedWorkflow = newWorkflowRepository.save(workflow);
            System.out.println("Update workflow success: " + savedWorkflow.getId());
            return created(savedWorkflow.toJson().toString());
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("Update workflow failed: " + id);
            return badRequest("Update workflow failed: " + id);
        }
    }

    // get
    public Result getWorkflow() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Get workflow failed, expecting Json data");
            return badRequest("Get workflow failed, expecting Json data");
        }

        long id = json.path("workflowId").asLong();

        NewWorkflow workflow = newWorkflowRepository.findOne(id);
        if (workflow == null) {
            System.out.println("Workflow not found with id: " + id);
            return notFound("Workflow not found with id: " + id);
        }

        return created(workflow.toJson().toString());
    }

    public Result getWorkflowIdByName() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Get workflow failed, expecting Json data");
            return badRequest("Get workflow failed, expecting Json data");
        }

        String name = json.path("name").asText();

        NewWorkflow workflow = newWorkflowRepository.findFirstByName(name);
        if (workflow == null) {
            System.out.println("Workflow not found with name: " + name);
            return notFound("Workflow not found with name: " + name);
        }

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("workflowId", workflow.getId());
        return created(jsonObject.toString());
    }

    public Result getAllWorkflows() {
        JsonObject jsonObject = new JsonObject();
        JsonArray jsonArrayAllWorkflows = new JsonArray();
        Iterable<NewWorkflow> workflows = newWorkflowRepository.findAll();
        for (NewWorkflow workflow : workflows) {
            jsonArrayAllWorkflows.add(workflow.toBasicJson());
        }
        jsonObject.add("allWorkflows", jsonArrayAllWorkflows);
        return created(jsonObject.toString());
    }

    // other
    public Result getWorkflowPopularity() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Get workflow popularity failed, expecting Json data");
            return badRequest("Get workflow popularity failed, expecting Json data");
        }

        long id = json.path("workflowId").asLong();

        NewWorkflow workflow = newWorkflowRepository.findOne(id);
        if (workflow == null) {
            System.out.println("Workflow not found with id: " + id);
            return notFound("Workflow not found with id: " + id);
        }

        int usageCount = workflow.getUsageCount();
        int viewCount = workflow.getViewCount();
        int downloadCount = workflow.getDownloadCount();
        int referenceCount = workflow.getReferenceCount();
        int commentCount = 0;

        List<NewPost> posts = newPostRepository.findByDomain("workflow");
        for (NewPost post : posts) {
            if (post.getDomainName().equals(workflow.getName())) {
                commentCount += post.getNewReplies().size();
            }
        }

        int popularity = usageCount + viewCount + commentCount + downloadCount + referenceCount;

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("popularity", popularity);
        return created(jsonObject.toString());
    }
}
