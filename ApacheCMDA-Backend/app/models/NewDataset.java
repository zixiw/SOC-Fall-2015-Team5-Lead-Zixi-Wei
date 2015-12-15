package models;

import com.google.gson.JsonObject;

import javax.persistence.*;

/**
 * Created by Zixi Wei, Mingyang Ling, Zheng Lei, Sen Yue on 11/30/15.
 */
@Entity
public class NewDataset {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String content;

    @ManyToOne
    @JoinColumn(name = "newWorkflowId", referencedColumnName = "id")
    private NewWorkflow newWorkflow;

    public NewDataset() {}

    public NewDataset(String name, String content) {
        this.name = name;
        this.content = content;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public NewWorkflow getNewWorkflow() {
        return newWorkflow;
    }

    public void setNewWorkflow(NewWorkflow newWorkflow) {
        this.newWorkflow = newWorkflow;
    }

    public JsonObject toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("datasetId", this.id);
        jsonObject.addProperty("name", this.name);
        jsonObject.addProperty("content", this.content);
        return jsonObject;
    }
}
