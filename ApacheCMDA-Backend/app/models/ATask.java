package models;

import javax.persistence.*;

/**
 * Created by mingyangling on 11/17/15.
 */
@Entity
public class ATask {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String content;
    @ManyToOne
    @JoinColumn(name = "aworkflow_id", referencedColumnName = "id")
    private AWorkflow aWorkflow;

    public ATask() {
    }

    public ATask(String name, String content, AWorkflow aWorkflow) {
        this.name = name;
        this.content = content;
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

    public String getContent() {
        return content;
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
}