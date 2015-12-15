package models;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Zixi Wei, Mingyang Ling, Zheng Lei, Sen Yue on 11/29/15.
 */
@Entity
public class NewWorkflow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;                                       // the workflow's name, should be unique
    private String description;                                // a short text description
    private String previewImage;                               // image preview url

    private int usageCount;                                    // number of usage
    private int viewCount;                                     // view count
    private int downloadCount;                                 // download count
    private int referenceCount;                                // reference count

    private int questionableCount;

    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "newWorkflow")
    private List<NewTask> newTasks = new ArrayList<NewTask>();                            // workflow components tasks

    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "newWorkflow")
    private List<NewInput> newInputs = new ArrayList<NewInput>();                          // workflow's inputs

    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "newWorkflow")
    private List<NewOutput> newOutputs = new ArrayList<NewOutput>();                        // workflow's outputs

    // user's collaborators can be retrieve here with sum up with the user's other workflow
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "newWorkflows")
    private Set<NewUser> newUsers = new HashSet<NewUser>();    // contributors

    // the tag that the user is most associated with can  be retrieve here with sum up with the user's other workflow
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "NewWorkflow_NewWorkflowTag",
            joinColumns = {@JoinColumn(name = "newWorkflowId", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "newTagId", referencedColumnName = "id")})
    private Set<NewTag> workflowTags = new HashSet<NewTag>();  // tags

    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "newWorkflow")
    private List<NewLink> newLinks = new ArrayList<NewLink>();                            // links

    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "newWorkflow")
    private List<NewInstruction> newInstructions = new ArrayList<NewInstruction>();              // instructions

    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "newWorkflow")
    private List<NewDataset> newDatasets = new ArrayList<NewDataset>();                      // associated datasets

    // other workflows that attribute this workflow
    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "NewWorkflow_AttributeWorkflow",
            joinColumns = {@JoinColumn(name = "newWorkflowId", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "attributeWorkflowId", referencedColumnName = "id")})
    private Set<NewWorkflow> attributeWorkflows = new HashSet<NewWorkflow>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH}, mappedBy = "attributeWorkflows")
    private Set<NewWorkflow> teamWorkflows = new HashSet<NewWorkflow>();

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "subscribeWorkflows")
    private Set<NewUser> subscribedUsers = new HashSet<NewUser>();

    public NewWorkflow() {}

    public NewWorkflow(String name, String description, String previewImage, int usageCount, int viewCount, int downloadCount, int referenceCount, int questionableCount) {
        this.name = name;
        this.description = description;
        this.previewImage = previewImage;
        this.usageCount = usageCount;
        this.viewCount = viewCount;
        this.downloadCount = downloadCount;
        this.referenceCount = referenceCount;
        this.questionableCount = questionableCount;
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

    public int getUsageCount() {
        return usageCount;
    }

    public void setUsageCount(int usageCount) {
        this.usageCount = usageCount;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public int getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(int downloadCount) {
        this.downloadCount = downloadCount;
    }

    public int getReferenceCount() {
        return referenceCount;
    }

    public void setReferenceCount(int referenceCount) {
        this.referenceCount = referenceCount;
    }

    public int getQuestionableCount() {
        return questionableCount;
    }

    public void setQuestionableCount(int questionableCount) {
        this.questionableCount = questionableCount;
    }

    public List<NewTask> getNewTasks() {
        return newTasks;
    }

    public void setNewTasks(List<NewTask> newTasks) {
        this.newTasks = newTasks;
    }

    public List<NewInput> getNewInputs() {
        return newInputs;
    }

    public void setNewInputs(List<NewInput> newInputs) {
        this.newInputs = newInputs;
    }

    public List<NewOutput> getNewOutputs() {
        return newOutputs;
    }

    public void setNewOutputs(List<NewOutput> newOutputs) {
        this.newOutputs = newOutputs;
    }

    public Set<NewUser> getNewUsers() {
        return newUsers;
    }

    public void setNewUsers(Set<NewUser> newUsers) {
        this.newUsers = newUsers;
    }

    public Set<NewTag> getWorkflowTags() {
        return workflowTags;
    }

    public void setWorkflowTags(Set<NewTag> workflowTags) {
        this.workflowTags = workflowTags;
    }

    public List<NewLink> getNewLinks() {
        return newLinks;
    }

    public void setNewLinks(List<NewLink> newLinks) {
        this.newLinks = newLinks;
    }

    public List<NewInstruction> getNewInstructions() {
        return newInstructions;
    }

    public void setNewInstructions(List<NewInstruction> newInstructions) {
        this.newInstructions = newInstructions;
    }

    public List<NewDataset> getNewDatasets() {
        return newDatasets;
    }

    public void setNewDatasets(List<NewDataset> newDatasets) {
        this.newDatasets = newDatasets;
    }

    public Set<NewWorkflow> getAttributeWorkflows() {
        return attributeWorkflows;
    }

    public void setAttributeWorkflows(Set<NewWorkflow> attributeWorkflows) {
        this.attributeWorkflows = attributeWorkflows;
    }

    public Set<NewWorkflow> getTeamWorkflows() {
        return teamWorkflows;
    }

    public void setTeamWorkflows(Set<NewWorkflow> teamWorkflows) {
        this.teamWorkflows = teamWorkflows;
    }

    public Set<NewUser> getSubscribedUsers() {
        return subscribedUsers;
    }

    public void setSubscribedUsers(Set<NewUser> subscribedUsers) {
        this.subscribedUsers = subscribedUsers;
    }

    public JsonObject toBasicJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("workflowId", this.id);
        jsonObject.addProperty("name", this.name);
        jsonObject.addProperty("description", this.description);
        jsonObject.addProperty("previewImage", this.previewImage);
        jsonObject.addProperty("usageCount", this.usageCount);
        jsonObject.addProperty("viewCount", this.viewCount);
        jsonObject.addProperty("downloadCount", this.downloadCount);
        jsonObject.addProperty("referenceCount", this.referenceCount);
        jsonObject.addProperty("questionableCount", this.questionableCount);
        return jsonObject;
    }

    public JsonObject toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("workflowId", this.id);
        jsonObject.addProperty("name", this.name);
        jsonObject.addProperty("description", this.description);
        jsonObject.addProperty("previewImage", this.previewImage);
        jsonObject.addProperty("usageCount", this.usageCount);
        jsonObject.addProperty("viewCount", this.viewCount);
        jsonObject.addProperty("downloadCount", this.downloadCount);
        jsonObject.addProperty("referenceCount", this.referenceCount);
        jsonObject.addProperty("questionableCount", this.questionableCount);

        JsonArray jsonArrayTasks = new JsonArray();
        for (NewTask newTask : newTasks) {
            jsonArrayTasks.add(newTask.toJson());
        }
        jsonObject.add("tasks", jsonArrayTasks);

        JsonArray jsonArrayInputs = new JsonArray();
        for (NewInput newInput : newInputs) {
            jsonArrayInputs.add(newInput.toJson());
        }
        jsonObject.add("inputs", jsonArrayInputs);

        JsonArray jsonArrayOutputs = new JsonArray();
        for (NewOutput newOutput : newOutputs) {
            jsonArrayOutputs.add(newOutput.toJson());
        }
        jsonObject.add("outputs", jsonArrayOutputs);

        JsonArray jsonArrayUsers = new JsonArray();
        for (NewUser newUser : newUsers) {
            jsonArrayUsers.add(newUser.toBasicJson());
        }
        jsonObject.add("contributors", jsonArrayUsers);

        JsonArray jsonArrayWorkflowTags = new JsonArray();
        for (NewTag newTag : workflowTags) {
            jsonArrayWorkflowTags.add(newTag.toBasicJson());
        }
        jsonObject.add("tags", jsonArrayWorkflowTags);

        JsonArray jsonArrayLinks = new JsonArray();
        for (NewLink newLink : newLinks) {
            jsonArrayLinks.add(newLink.toJson());
        }
        jsonObject.add("links", jsonArrayLinks);

        JsonArray jsonArrayInstructions = new JsonArray();
        for (NewInstruction newInstruction : newInstructions) {
            jsonArrayInstructions.add(newInstruction.toJson());
        }
        jsonObject.add("instructions", jsonArrayInstructions);

        JsonArray jsonArrayDatasets = new JsonArray();
        for (NewDataset newDataset : newDatasets) {
            jsonArrayDatasets.add(newDataset.toJson());
        }
        jsonObject.add("datasets", jsonArrayDatasets);

        JsonArray jsonArrayAttributeWorkflows = new JsonArray();
        for (NewWorkflow attributeWorkflow : attributeWorkflows) {
            jsonArrayAttributeWorkflows.add(attributeWorkflow.toBasicJson());
        }
        jsonObject.add("attributeWorkflows", jsonArrayAttributeWorkflows);

        JsonArray jsonArraySubscribedUsers = new JsonArray();
        for (NewUser subscribedUser : subscribedUsers) {
            jsonArraySubscribedUsers.add(subscribedUser.toBasicJson());
        }
        jsonObject.add("subscribedUsers", jsonArraySubscribedUsers);

        return jsonObject;
    }
}
