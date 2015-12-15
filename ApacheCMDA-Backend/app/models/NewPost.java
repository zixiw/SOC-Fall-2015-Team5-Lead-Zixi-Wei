package models;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Zixi Wei, Mingyang Ling, Zheng Lei, Sen Yue on 11/30/15.
 */
@Entity
public class NewPost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String domain;               // [workflow|service|group]
    private String domainName;           // [workflowName|serviceName|groupName]

    private String title;                // post title
    private String content;              // post content
    private String attachment;           // attachment link of image, pdf or video
    private boolean isQuestion;          // When a user intends to post, she has an option to
                                         // decide whether to mark it as a discussion or a
                                         // question (if it is a question, then the starter of
                                         // the thread will be able to select a later reply as an
                                         // answer (i.e., the “mark as answer” as in Stackoverflow style).
    private int questionableCount;

    // a user can have many post one to many, the user here is the creator
    @ManyToOne
    @JoinColumn(name = "newUserId", referencedColumnName = "id")
    private NewUser newUser;

    // the tag that the user is most associated with can  be retrieve here with sum up with the user's other workflow
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "NewPost_NewPostTag",
            joinColumns = {@JoinColumn(name = "newPostId", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "newTagId", referencedColumnName = "id")})
    private Set<NewTag> postTags = new HashSet<NewTag>();

    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "newPost")
    private List<NewReply> newReplies = new ArrayList<NewReply>();

    public NewPost() {}

    public NewPost(String domain, String domainName, String title, String content, String attachment, boolean isQuestion, int questionableCount) {
        this.domain = domain;
        this.domainName = domainName;
        this.title = title;
        this.content = content;
        this.attachment = attachment;
        this.isQuestion = isQuestion;
        this.questionableCount = questionableCount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public boolean isQuestion() {
        return isQuestion;
    }

    public void setQuestion(boolean question) {
        isQuestion = question;
    }

    public int getQuestionableCount() {
        return questionableCount;
    }

    public void setQuestionableCount(int questionableCount) {
        this.questionableCount = questionableCount;
    }

    public NewUser getNewUser() {
        return newUser;
    }

    public void setNewUser(NewUser newUser) {
        this.newUser = newUser;
    }

    public Set<NewTag> getPostTags() {
        return postTags;
    }

    public void setPostTags(Set<NewTag> postTags) {
        this.postTags = postTags;
    }

    public List<NewReply> getNewReplies() {
        return newReplies;
    }

    public void setNewReplies(List<NewReply> newReplies) {
        this.newReplies = newReplies;
    }

    public JsonObject toBasicJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("postId", this.id);
        jsonObject.addProperty("domain", this.domain);
        jsonObject.addProperty("domainName", this.domainName);
        jsonObject.addProperty("title", this.title);
        jsonObject.addProperty("content", this.content);
        jsonObject.addProperty("attachment", this.attachment);
        jsonObject.addProperty("isQuestion", this.isQuestion);
        jsonObject.addProperty("questionableCount", this.questionableCount);
        return jsonObject;
    }

    public JsonObject toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("postId", this.id);
        jsonObject.addProperty("domain", this.domain);
        jsonObject.addProperty("domainName", this.domainName);
        jsonObject.addProperty("title", this.title);
        jsonObject.addProperty("content", this.content);
        jsonObject.addProperty("attachment", this.attachment);
        jsonObject.addProperty("isQuestion", this.isQuestion);
        jsonObject.addProperty("questionableCount", this.questionableCount);

        JsonArray jsonArrayCreatorUsers = new JsonArray();
        jsonArrayCreatorUsers.add(newUser.toBasicJson());
        jsonObject.add("creatorUser", jsonArrayCreatorUsers);

        JsonArray jsonArrayPostTags = new JsonArray();
        for (NewTag postTag : postTags) {
            jsonArrayPostTags.add(postTag.toBasicJson());
        }
        jsonObject.add("tags", jsonArrayPostTags);

        JsonArray jsonArrayReplies = new JsonArray();
        for (NewReply newReply : newReplies) {
            jsonArrayReplies.add(newReply.toJson());
        }
        jsonObject.add("replies", jsonArrayReplies);

        return jsonObject;
    }
}
