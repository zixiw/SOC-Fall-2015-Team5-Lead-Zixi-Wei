package models;

import com.google.gson.JsonObject;
import javax.persistence.*;

/**
 * Created by Zixi Wei, Mingyang Ling, Zheng Lei, Sen Yue on 11/30/15.
 */
@Entity
public class NewLink {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String source;
    private String sink;

    @ManyToOne
    @JoinColumn(name = "newWorkflowId", referencedColumnName = "id")
    private NewWorkflow newWorkflow;

    public NewLink() {
    }

    public NewLink(String source, String sink) {
        this.source = source;
        this.sink = sink;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSink() {
        return sink;
    }

    public void setSink(String sink) {
        this.sink = sink;
    }

    public NewWorkflow getNewWorkflow() {
        return newWorkflow;
    }

    public void setNewWorkflow(NewWorkflow newWorkflow) {
        this.newWorkflow = newWorkflow;
    }

    public JsonObject toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("linkId", this.id);
        jsonObject.addProperty("source", this.source);
        jsonObject.addProperty("sink", this.sink);
        return jsonObject;
    }
}
