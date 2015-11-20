package models;

import com.google.gson.JsonObject;

import javax.persistence.*;

/**
 * Created by mingyangling on 11/17/15.
 */
@Entity
public class ALink {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String content;
    @ManyToOne
    @JoinColumn(name = "aworkflow_id", referencedColumnName = "id")
    private AWorkflow aWorkflow;

    public ALink() {}

    public ALink(String content, AWorkflow aWorkflow) {
        this.content = content;
        this.aWorkflow = aWorkflow;
    }

    public long getId() {
        return id;
    }


    public String getContent() {
        return content;
    }

    public void setId(long id) {
        this.id = id;
    }


    public void setContent(String content) {
        this.content = content;
    }

    public AWorkflow getaWorkflow() {
        return aWorkflow;
    }

    public void setaWorkflow(AWorkflow aWorkflow) {
        this.aWorkflow = aWorkflow;
    }

    public JsonObject toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("content", this.content);
        return jsonObject;
    }
}
