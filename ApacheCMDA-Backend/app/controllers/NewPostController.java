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
 * Created by Zixi Wei, Mingyang Ling, Zheng Lei, Sen Yue on 12/1/15.
 */
@Named
@Singleton
public class NewPostController extends Controller {
    private final NewPostRepository newPostRepository;
    private final NewWorkflowRepository newWorkflowRepository;
    private final ClimateServiceRepository climateServiceRepository;
    private final NewGroupRepository newGroupRepository;
    private final NewUserRepository newUserRepository;
    private final NewTagRepository newTagRepository;

    @Inject
    public NewPostController(final NewPostRepository newPostRepository,
                             final NewWorkflowRepository newWorkflowRepository,
                             final ClimateServiceRepository climateServiceRepository,
                             final NewGroupRepository newGroupRepository,
                             final NewUserRepository newUserRepository,
                             final NewTagRepository newTagRepository) {
        this.newPostRepository = newPostRepository;
        this.newWorkflowRepository = newWorkflowRepository;
        this.climateServiceRepository = climateServiceRepository;
        this.newGroupRepository = newGroupRepository;
        this.newUserRepository = newUserRepository;
        this.newTagRepository = newTagRepository;
    }

    // add
    public Result addPost() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Add post failed, expecting Json data");
            return badRequest("Add post failed, expecting Json data");
        }

        String domain = json.path("domain").asText();               // [workflow|service|group]
        String domainName = json.path("domainName").asText();           // [workflowName|serviceName|groupName]
        String title = json.path("title").asText();
        String content = json.path("content").asText();
        String attachment = json.path("attachment").asText();
        boolean isQuestion = json.path("isQuestion").asBoolean();
        int questionableCount = 0;

        try {
            if (!domain.equals("workflow") && !domain.equals("service") && !domain.equals("group")) {
                System.out.println("Post's domain must be workflow / service / group, " + domain + " is invalid");
                return badRequest("Post's domain must be workflow / service / group, " + domain + " is invalid");
            }

            if (domain.equals("workflow")) {
                if (newWorkflowRepository.findFirstByName(domainName) == null) {
                    System.out.println("Add post failed, workflow not exist: " + domainName);
                    return badRequest("Add post failed, workflow not exist: " + domainName);
                }
            } else if (domain.equals("service")) {
                if (climateServiceRepository.findFirstByName(domainName) == null) {
                    System.out.println("Add post failed, service not exist: " + domainName);
                    return badRequest("Add post failed, service not exist: " + domainName);
                }
            } else {
                if (newGroupRepository.findFirstByName(domainName) == null) {
                    System.out.println("Add post failed, group not exist: " + domainName);
                    return badRequest("Add post failed, group not exist: " + domainName);
                }
            }

            NewPost post = new NewPost(domain, domainName, title, content, attachment, isQuestion, questionableCount);
            NewPost savedPost = newPostRepository.save(post);
            System.out.println("Add post success: " + savedPost.getId());
            return created(savedPost.toBasicJson().toString());
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("Add post failed: " + domain + " " + domainName + " " + title);
            return badRequest("Add post failed: " + domain + " " + domainName + " " + title);
        }
    }

    public Result addPostToUser() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Add post to user failed, expecting Json data");
            return badRequest("Add post to user failed, expecting Json data");
        }

        long postId = json.path("postId").asLong();
        long userId = json.path("userId").asLong();

        NewPost post = newPostRepository.findOne(postId);
        if (post == null) {
            System.out.println("Post not found with id: " + postId);
            return notFound("Post not found with id: " + postId);
        }

        NewUser user = newUserRepository.findOne(userId);
        if (user == null) {
            System.out.println("User not found with id: " + userId);
            return notFound("User not found with id: " + userId);
        }

        List<NewPost> usersPosts = user.getNewPosts();
        for (NewPost usersPost : usersPosts) {
            if (usersPost.getId() == postId) {
                System.out.println("Add post failed, post id " + postId + " has existed in user id: " + userId);
                return badRequest("Add post failed, post id " + postId + " has existed in user id: " + userId);
            }
        }

        // set up the link
        post.setNewUser(user);

        try {
            newPostRepository.save(post);
            System.out.println("Add post to user success");
            user = newUserRepository.findOne(userId);
            return created(user.toJson().toString());
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("Add post to user failed, post id: " + postId + " user id: " + userId);
            return badRequest("Add post to user failed, post id: " + postId + " user id: " + userId);
        }
    }

    public Result addTagToPost() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Add tag to post failed, expecting Json data");
            return badRequest("Add tag to post failed, expecting Json data");
        }

        long tagId = json.path("tagId").asLong();
        long postId = json.path("postId").asLong();

        NewTag tag = newTagRepository.findOne(tagId);
        if (tag == null) {
            System.out.println("Tag not found with id: " + tagId);
            return notFound("Tag not found with id: " + tagId);
        }

        NewPost post = newPostRepository.findOne(postId);
        if (post == null) {
            System.out.println("Post not found with id: " + postId);
            return notFound("Post not found with id: " + postId);
        }

        try {
            // set up the link
            post.getPostTags().add(tag);

            NewPost savedPost = newPostRepository.save(post);

            System.out.println("Add tag to post success, post id: " + postId + " tag id: " + tagId);
            return created(savedPost.toJson().toString());
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("Add tag to post failed, post id: " + postId + " tag id: " + tagId);
            return badRequest("Add tag to post failed, post id: " + postId + " tag id: " + tagId);
        }
    }

    // delete
    public Result deletePost() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Delete post failed, expecting Json data");
            return badRequest("Delete post failed, expecting Json data");
        }

        long id = json.path("postId").asLong();

        NewPost post = newPostRepository.findOne(id);
        if (post == null) {
            System.out.println("Post not found with id: " + id);
            return notFound("Post not found with id: " + id);
        }

        newPostRepository.delete(post);

        System.out.println("Delete post success: " + id);
        return ok("Delete post success: " + id);
    }

    public Result deleteTagFromPost() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Delete tag from post failed, expecting Json data");
            return badRequest("Delete tag from post failed, expecting Json data");
        }

        long tagId = json.path("tagId").asLong();
        long postId = json.path("postId").asLong();

        NewTag tag = newTagRepository.findOne(tagId);
        if (tag == null) {
            System.out.println("Tag not found with id: " + tagId);
            return notFound("Tag not found with id: " + tagId);
        }

        NewPost post = newPostRepository.findOne(postId);
        if (post == null) {
            System.out.println("Post not found with id: " + postId);
            return notFound("Post not found with id: " + postId);
        }

        Set<NewTag> postsTags = post.getPostTags();
        for (NewTag postsTag : postsTags) {
            if (postsTag.getId() == tagId) {
                postsTags.remove(postsTag);
                newPostRepository.save(post);
                break;
            }
        }

        tag = newTagRepository.findOne(tagId);
        Set<NewPost> tagsPosts = tag.getNewPosts();
        for (NewPost tagsPost : tagsPosts) {
            if (tagsPost.getId() == postId) {
                System.out.println("Delete tag from post failed, post id: " + postId + " tag id: " + tagId);
                return badRequest("Delete tag from post failed, post id: " + postId + " tag id: " + tagId);
            }
        }

        System.out.println("Delete tag from post success, post id: " + postId + " tag id: " + tagId);
        return ok("Delete tag from post success, post id: " + postId + " tag id: " + tagId);
    }

    // update
    public Result updatePost() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Update post failed, expecting Json data");
            return badRequest("Update post failed, expecting Json data");
        }

        long id = json.path("postId").asLong();
        String domain = json.path("domain").asText();
        String domainName = json.path("domainName").asText();
        String title = json.path("title").asText();
        String content = json.path("content").asText();
        String attachment = json.path("attachment").asText();
        boolean isQuestion = json.path("isQuestion").asBoolean();
        int questionableCount = json.path("questionableCount").asInt();

        NewPost post = newPostRepository.findOne(id);
        if (post == null) {
            System.out.println("Post not found with id: " + id);
            return notFound("Post not found with id: " + id);
        }
        if (!domain.equals("workflow") && !domain.equals("service") && !domain.equals("group")) {
            System.out.println("Post's domain must be workflow / service / group, " + domain + " is invalid");
            return badRequest("Post's domain must be workflow / service / group, " + domain + " is invalid");
        }
        if (domain.equals("workflow")) {
            if (newWorkflowRepository.findFirstByName(domainName) == null) {
                System.out.println("Update post failed, workflow not exist: " + domainName);
                return badRequest("Update post failed, workflow not exist: " + domainName);
            }
        } else if (domain.equals("service")) {
            if (climateServiceRepository.findFirstByName(domainName) == null) {
                System.out.println("Update post failed, service not exist: " + domainName);
                return badRequest("Update post failed, service not exist: " + domainName);
            }
        } else {
            if (newGroupRepository.findFirstByName(domainName) == null) {
                System.out.println("Update post failed, group not exist: " + domainName);
                return badRequest("Update post failed, group not exist: " + domainName);
            }
        }

        try {
            post.setDomain(domain);
            post.setDomainName(domainName);
            post.setTitle(title);
            post.setContent(content);
            post.setAttachment(attachment);
            post.setQuestion(isQuestion);
            post.setQuestionableCount(questionableCount);

            NewPost savedPost = newPostRepository.save(post);
            System.out.println("Update post success: " + savedPost.getId());
            return created(savedPost.toBasicJson().toString());
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("Update post failed: " + id);
            return badRequest("Update post failed: " + id);
        }
    }

    // get
    public Result getPost() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Get post failed, expecting Json data");
            return badRequest("Get post failed, expecting Json data");
        }

        long id = json.path("postId").asLong();

        NewPost post = newPostRepository.findOne(id);
        if (post == null) {
            System.out.println("Post not found with id: " + id);
            return notFound("Post not found with id: " + id);
        }

        if (post.getNewUser() == null) {
            return created(post.toBasicJson().toString());
        } else {
            return created(post.toJson().toString());
        }
    }

    public Result getPostsUnderDomainAndDomainName() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Get post failed, expecting Json data");
            return badRequest("Get post failed, expecting Json data");
        }

        String domain = json.path("domain").asText();
        String domainName = json.path("domainName").asText();

        JsonObject jsonObject = new JsonObject();
        JsonArray jsonArrayPosts = new JsonArray();

        List<NewPost> posts = newPostRepository.findByDomain(domain);
        for (NewPost post : posts) {
            if (post.getDomainName().equals(domainName)) {
                jsonArrayPosts.add(post.toBasicJson());
            }
        }
        jsonObject.add("posts", jsonArrayPosts);
        return created(jsonObject.toString());
    }
}
