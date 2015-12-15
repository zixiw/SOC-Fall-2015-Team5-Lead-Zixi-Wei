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
import java.util.Set;

/**
 * Created by Zixi Wei, Mingyang Ling, Zheng Lei, Sen Yue on 12/1/15.
 */
@Named
@Singleton
public class NewTagController extends Controller {
    private final NewTagRepository newTagRepository;
    private final NewWorkflowRepository newWorkflowRepository;
    private final NewPostRepository newPostRepository;

    @Inject
    public NewTagController(final NewTagRepository newTagRepository,
                            final NewWorkflowRepository newWorkflowRepository,
                            NewPostRepository newPostRepository) {
        this.newTagRepository = newTagRepository;
        this.newWorkflowRepository = newWorkflowRepository;
        this.newPostRepository = newPostRepository;
    }

    // add
    public Result addTag() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Add tag failed, expecting Json data");
            return badRequest("Add tag failed, expecting Json data");
        }

        String name = json.path("name").asText();

        try {
            if (newTagRepository.findFirstByName(name) != null) {
                System.out.println("Tag name has been used: " + name);
                return badRequest("Tag name has been used: " + name);
            }

            NewTag tag = new NewTag(name);
            NewTag savedTag = newTagRepository.save(tag);
            System.out.println("Add tag success: " + savedTag.getId());
            return created(savedTag.toJson().toString());
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("Add tag failed: " + name);
            return badRequest("Add tag failed: " + name);
        }
    }

    // delete
    public Result deleteTag() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Delete tag failed, expecting Json data");
            return badRequest("Delete tag failed, expecting Json data");
        }

        long id = json.path("tagId").asLong();

        NewTag tag = newTagRepository.findOne(id);
        if (tag == null) {
            System.out.println("Tag not found with id: " + id);
            return notFound("Tag not found with id: " + id);
        }

        Set<NewWorkflow> tagsWorkflows = tag.getNewWorkflows();
        for (NewWorkflow tagsWorkflow : tagsWorkflows) {
            NewWorkflow theWorkflow = newWorkflowRepository.findOne(tagsWorkflow.getId());
            Set<NewTag> theWorkflowsTags = theWorkflow.getWorkflowTags();
            for (NewTag theWorkflowsTag : theWorkflowsTags) {
                if (theWorkflowsTag.getId() == id) {
                    theWorkflowsTags.remove(theWorkflowsTag);
                    newWorkflowRepository.save(theWorkflow);
                    break;
                }
            }
        }

        Set<NewPost> tagsPosts = tag.getNewPosts();
        for (NewPost tagsPost : tagsPosts) {
            NewPost thePost = newPostRepository.findOne(tagsPost.getId());
            Set<NewTag> thePostsTags = thePost.getPostTags();
            for (NewTag thePostsTag : thePostsTags) {
                if (thePostsTag.getId() == id) {
                    thePostsTags.remove(thePostsTag);
                    newPostRepository.save(thePost);
                    break;
                }
            }
        }

        newTagRepository.delete(tag);

        System.out.println("Delete tag success: " + id);
        return ok("Delete tag success: " + id);
    }

    // update
    public Result updateTag() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Update tag failed, expecting Json data");
            return badRequest("Update tag failed, expecting Json data");
        }

        long id = json.path("tagId").asLong();
        String name  = json.path("name").asText();

        NewTag tag = newTagRepository.findOne(id);
        if (tag == null) {
            System.out.println("Tag not found with id: " + id);
            return notFound("Tag not found with id: " + id);
        }

        try {
            tag.setName(name);

            NewTag savedTag = newTagRepository.save(tag);
            System.out.println("Update tag success: " + savedTag.getId());
            return created(savedTag.toJson().toString());
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("Update tag failed: " + id);
            return badRequest("Update tag failed: " + id);
        }
    }

    // get
    public Result getTag() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Get tag failed, expecting Json data");
            return badRequest("Get tag failed, expecting Json data");
        }

        long id = json.path("tagId").asLong();

        NewTag tag = newTagRepository.findOne(id);
        if (tag == null) {
            System.out.println("Tag not found with id: " + id);
            return notFound("Tag not found with id: " + id);
        }

        return created(tag.toJson().toString());
    }

    public Result getTagIdByName() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Get tag failed, expecting Json data");
            return badRequest("Get tag failed, expecting Json data");
        }

        String name = json.path("name").asText();

        NewTag tag = newTagRepository.findFirstByName(name);
        if (tag == null) {
            System.out.println("Tag not found with tag name: " + name);
            return notFound("Tag not found with tag name: " + name);
        }

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("tagId", tag.getId());
        return created(jsonObject.toString());
    }

    public Result getAllTags() {
        JsonObject jsonObject = new JsonObject();
        JsonArray jsonArrayAllTags = new JsonArray();
        Iterable<NewTag> tags = newTagRepository.findAll();
        for (NewTag tag : tags) {
            jsonArrayAllTags.add(tag.toBasicJson());
        }
        jsonObject.add("allTags", jsonArrayAllTags);
        return created(jsonObject.toString());
    }
}
