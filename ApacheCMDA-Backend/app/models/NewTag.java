package models;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Zixi Wei, Mingyang Ling, Zheng Lei, Sen Yue on 11/30/15.
 */
@Entity
public class NewTag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;                // tag name, should be unique

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "workflowTags")
    private Set<NewWorkflow> newWorkflows = new HashSet<NewWorkflow>();

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "postTags")
    private Set<NewPost> newPosts = new HashSet<NewPost>();

    public NewTag() {}

    public NewTag(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<NewWorkflow> getNewWorkflows() {
        return newWorkflows;
    }

    public void setNewWorkflows(Set<NewWorkflow> newWorkflows) {
        this.newWorkflows = newWorkflows;
    }

    public Set<NewPost> getNewPosts() {
        return newPosts;
    }

    public void setNewPosts(Set<NewPost> newPosts) {
        this.newPosts = newPosts;
    }

    public JsonObject toBasicJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("tagId", this.id);
        jsonObject.addProperty("name", this.name);
        return jsonObject;
    }

    public JsonObject toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("tagId", this.id);
        jsonObject.addProperty("name", this.name);

        JsonArray jsonArrayWorkflows = new JsonArray();
        for (NewWorkflow newWorkflow : newWorkflows) {
            jsonArrayWorkflows.add(newWorkflow.toBasicJson());
        }
        jsonObject.add("workflows", jsonArrayWorkflows);

        JsonArray jsonArrayPosts = new JsonArray();
        for (NewPost newPost : newPosts) {
            jsonArrayPosts.add(newPost.toBasicJson());
        }
        jsonObject.add("posts", jsonArrayPosts);

        return jsonObject;
    }
}
