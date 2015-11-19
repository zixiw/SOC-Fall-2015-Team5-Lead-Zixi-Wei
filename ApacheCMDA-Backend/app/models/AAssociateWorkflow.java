package models;

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
}
