package models;

import com.google.gson.JsonObject;

import javax.persistence.*;

/**
 * Created by mingyangling on 11/17/15.
 */
@Entity
public class AAssociateWorkflow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "aworkflow_id", referencedColumnName = "id")
    private AWorkflow aWorkflow;

    public AAssociateWorkflow() {

    }

    public AAssociateWorkflow(String name, AWorkflow aWorkflow) {
        this.name = name;
        this.aWorkflow = aWorkflow;
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

    public AWorkflow getaWorkflow() {
        return aWorkflow;
    }

    public void setaWorkflow(AWorkflow aWorkflow) {
        this.aWorkflow = aWorkflow;
    }

    public JsonObject toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name", this.name);
        return jsonObject;
    }
}
