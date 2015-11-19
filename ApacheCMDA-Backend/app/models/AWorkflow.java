package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Set;

/**
 * Created by mingyangling on 11/16/15.
 */
@Entity
public class AWorkflow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String description;
    private String previewImage;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "aWorkflow")
    private Set<ATask> tasks;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "aWorkflow")
    private Set<AInput> inputs;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "aWorkflow")
    private Set<AOutput> outputs;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "aWorkflow")
    private Set<AUser> contributors;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "aWorkflow")
    private Set<ATag> tags;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "aWorkflow")
    private Set<ALink> links;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "aWorkflow")
    private Set<AInstrument> instruments;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "aWorkflow")
    private Set<ADataset> associatedDatasets;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "aWorkflow")
    private Set<AAssociateWorkflow> associateWorkflow;

    public AWorkflow() {
    }

    public AWorkflow(String name, String description, String previewImage, Set<ATask> tasks, Set<AInput> inputs, Set<AOutput> outputs, Set<AUser> contributors, Set<ATag> tags, Set<ALink> links, Set<AInstrument> instruments, Set<ADataset> associatedDatasets, Set<AAssociateWorkflow> associateWorkflow) {
        this.description = description;
        this.name=name;
        this.previewImage = previewImage;
        this.tasks = tasks;
        this.inputs = inputs;
        this.outputs = outputs;
        this.contributors = contributors;
        this.tags = tags;
        this.links = links;
        this.instruments = instruments;
        this.associatedDatasets = associatedDatasets;
        this.associateWorkflow = associateWorkflow;
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

    public String getPreviewImage() {
        return previewImage;
    }

    public void setPreviewImage(String previewImage) {
        this.previewImage = previewImage;
    }

    public Set<ATask> getTasks() {
        return tasks;
    }

    public void setTasks(Set<ATask> tasks) {
        this.tasks = tasks;
    }

    public Set<AInput> getInputs() {
        return inputs;
    }

    public void setInputs(Set<AInput> inputs) {
        this.inputs = inputs;
    }

    public Set<AOutput> getOutputs() {
        return outputs;
    }

    public void setOutputs(Set<AOutput> outputs) {
        this.outputs = outputs;
    }

    public Set<AUser> getContributors() {
        return contributors;
    }

    public void setContributors(Set<AUser> contributors) {
        this.contributors = contributors;
    }

    public Set<ATag> getTags() {
        return tags;
    }

    public void setTags(Set<ATag> tags) {
        this.tags = tags;
    }

    public Set<ALink> getLinks() {
        return links;
    }

    public void setLinks(Set<ALink> links) {
        this.links = links;
    }

    public Set<AInstrument> getInstruments() {
        return instruments;
    }

    public void setInstruments(Set<AInstrument> instruments) {
        this.instruments = instruments;
    }

    public Set<ADataset> getAssociatedDatasets() {
        return associatedDatasets;
    }

    public void setAssociatedDatasets(Set<ADataset> associatedDatasets) {
        this.associatedDatasets = associatedDatasets;
    }

    public Set<AAssociateWorkflow> getAssociateWorkflow() {
        return associateWorkflow;
    }

    public void setAssociateWorkflow(Set<AAssociateWorkflow> associateWorkflow) {
        this.associateWorkflow = associateWorkflow;
    }

    public String toString(){
        return getDescription()+getName()+getPreviewImage()+getInputs()+getTasks();
    }
}
