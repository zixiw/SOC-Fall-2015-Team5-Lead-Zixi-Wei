package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.*;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.persistence.PersistenceException;
import java.util.Date;
import java.util.List;

/**
 * Created by Zixi Wei, Mingyang Ling, Zheng Lei, Sen Yue on 12/2/15.
 */
@Named
@Singleton
public class NewReplyController extends Controller {
    private final NewReplyRepository newReplyRepository;
    private final NewPostRepository newPostRepository;

    @Inject
    public NewReplyController(final NewReplyRepository newReplyRepository,
                              final NewPostRepository newPostRepository) {
        this.newReplyRepository = newReplyRepository;
        this.newPostRepository = newPostRepository;
    }

    // add
    public Result addReply() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Add reply failed, expecting Json data");
            return badRequest("Add reply failed, expecting Json data");
        }

        String content = json.path("content").asText();
        Date date = new Date();
        boolean isAnswer = false;

        try {
            NewReply reply = new NewReply(content, date, isAnswer);
            NewReply savedReply = newReplyRepository.save(reply);
            System.out.println("Add reply success: " + savedReply.getId());
            return created(savedReply.toJson().toString());
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("Add reply failed: " + content);
            return badRequest("Add reply failed: " + content);
        }
    }

    public Result addReplyToPost() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Add reply to post failed, expecting Json data");
            return badRequest("Add reply to post failed, expecting Json data");
        }

        long replyId = json.path("replyId").asLong();
        long postId = json.path("postId").asLong();

        NewReply reply = newReplyRepository.findOne(replyId);
        if (reply == null) {
            System.out.println("Reply not found with id: " + replyId);
            return notFound("Reply not found with id: " + replyId);
        }

        NewPost post = newPostRepository.findOne(postId);
        if (post == null) {
            System.out.println("Post not found with id: " + postId);
            return notFound("Post not found with id: " + postId);
        }

        List<NewReply> postsReplies = post.getNewReplies();
        for (NewReply postsReply : postsReplies) {
            if (postsReply.getId() == replyId) {
                System.out.println("Add reply failed, reply id " + replyId + " has existed in post id: " + postId);
                return badRequest("Add reply failed, reply id " + replyId + " has existed in post id: " + postId);
            }
        }

        // set up the link
        reply.setNewPost(post);

        try {
            newReplyRepository.save(reply);
            System.out.println("Add reply to post success");
            post = newPostRepository.findOne(postId);
            return created(post.toJson().toString());
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("Add reply to post failed, reply id: " + replyId + " post id: " + postId);
            return badRequest("Add reply to post failed, reply id: " + replyId + " post id: " + postId);
        }
    }

    // delete
    public Result deleteReply() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Delete reply failed, expecting Json data");
            return badRequest("Delete reply failed, expecting Json data");
        }

        long id = json.path("replyId").asLong();

        NewReply reply = newReplyRepository.findOne(id);
        if (reply == null) {
            System.out.println("Reply not found with id: " + id);
            return notFound("Reply not found with id: " + id);
        }

        newReplyRepository.delete(reply);

        System.out.println("Delete reply success: " + id);
        return ok("Delete reply success: " + id);
    }

    // update
    public Result updateReply() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Update reply failed, expecting Json data");
            return badRequest("Update reply failed, expecting Json data");
        }

        long id = json.path("replyId").asLong();

        String content = json.path("content").asText();
        boolean isAnswer = json.path("isAnswer").asBoolean();

        NewReply reply = newReplyRepository.findOne(id);
        if (reply == null) {
            System.out.println("Reply not found with id: " + id);
            return notFound("Reply not found with id: " + id);
        }

        try {
            reply.setContent(content);
            reply.setAnswer(isAnswer);

            NewReply savedReply = newReplyRepository.save(reply);
            System.out.println("Update reply success: " + savedReply.getId());
            return created(savedReply.toJson().toString());
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            System.out.println("Update reply failed: " + id);
            return badRequest("Update reply failed: " + id);
        }
    }

    // get
    public Result getReply() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            System.out.println("Get reply failed, expecting Json data");
            return badRequest("Get reply failed, expecting Json data");
        }

        long id = json.path("replyId").asLong();

        NewReply reply = newReplyRepository.findOne(id);
        if (reply == null) {
            System.out.println("Reply not found with id: " + id);
            return notFound("Reply not found with id: " + id);
        }

        return created(reply.toJson().toString());
    }
}
