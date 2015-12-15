package models;

import com.google.gson.JsonObject;

import javax.persistence.*;

/**
 * Created by Zixi Wei, Mingyang Ling, Zheng Lei, Sen Yue on 11/29/15.
 */
@Entity
public class NewTask {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;                        // task name
    private String description;                 // task description

    @ManyToOne
    @JoinColumn(name = "newWorkflowId", referencedColumnName = "id")
    private NewWorkflow newWorkflow;            // task under the workflow

    public NewTask() {}

    public NewTask(String name, String description) {
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
        jsonObject.addProperty("taskId", this.id);
        jsonObject.addProperty("name", this.name);
        jsonObject.addProperty("description", this.description);
        return jsonObject;
    }
}
