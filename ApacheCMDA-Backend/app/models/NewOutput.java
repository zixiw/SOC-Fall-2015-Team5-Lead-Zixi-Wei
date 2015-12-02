package models;

import com.google.gson.JsonObject;

import javax.persistence.*;

/**
 * Created by zixiwei on 11/30/15.
 */
@Entity
public class NewOutput {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;                     // output name
    private String description;              // output description

    @ManyToOne
    @JoinColumn(name = "newWorkflowId", referencedColumnName = "id")
    private NewWorkflow newWorkflow;

    public NewOutput() {}

    public NewOutput(String name, String description) {
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public NewWorkflow getNewWorkflow() {
        return newWorkflow;
    }

    public void setNewWorkflow(NewWorkflow newWorkflow) {
        this.newWorkflow = newWorkflow;
    }

    public JsonObject toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("outputId", this.id);
        jsonObject.addProperty("name", this.name);
        jsonObject.addProperty("description", this.description);
        return jsonObject;
    }
}
