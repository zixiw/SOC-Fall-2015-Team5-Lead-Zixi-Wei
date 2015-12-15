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
public class NewUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String userName;                         // userName should be unique
    private String password;
    private String firstName;
    private String lastName;
    private String middleInitial;
    private String affiliation;
    private String title;
    private String email;                            // email should be unique
    private String mailingAddress;
    private String phoneNumber;
    private String faxNumber;
    private String researchFields;                   // a summary of her research interests
    private String highestDegree;

    // the list of workflows that he/she is a contributor to
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "NewUser_NewWorkflow",
            joinColumns = {@JoinColumn(name = "newUserId", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "newWorkflowId", referencedColumnName = "id")})
    private Set<NewWorkflow> newWorkflows = new HashSet<NewWorkflow>();

    // the list of post that he/she posts
    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "newUser")
    private List<NewPost> newPosts = new ArrayList<NewPost>();

    // access control
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "NewUser_NewAdminGroup",
    joinColumns = {@JoinColumn(name = "newUserId", referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name = "newGroupId", referencedColumnName = "id")})
    private Set<NewGroup> adminGroups = new HashSet<NewGroup>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "NewUser_NewMemberGroup",
            joinColumns = {@JoinColumn(name = "newUserId", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "newGroupId", referencedColumnName = "id")})
    private Set<NewGroup> memberGroups = new HashSet<NewGroup>();

    // the friend here means the people that the user send friend request to, it's one side
    // to obtain a friend list, you should make an intersection between two users
    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "NewUser_Friend",
            joinColumns = {@JoinColumn(name = "newUserId", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "friendId", referencedColumnName = "id")})
    private Set<NewUser> friends = new HashSet<NewUser>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH}, mappedBy = "friends")
    private Set<NewUser> teammates = new HashSet<NewUser>();

    // subscribe user
    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "NewUser_SubscribeUser",
            joinColumns = {@JoinColumn(name = "newUserId", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "subscribeUserId", referencedColumnName = "id")})
    private Set<NewUser> subscribeUsers = new HashSet<NewUser>();

    // the number of subscribers
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH}, mappedBy = "subscribeUsers")
    private Set<NewUser> subscribeTeammates = new HashSet<NewUser>();

    // subscribe group
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "NewUser_SubscribeGroup",
            joinColumns = {@JoinColumn(name = "newUserId", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "subscribeGroupId", referencedColumnName = "id")})
    private Set<NewGroup> subscribeGroups = new HashSet<NewGroup>();

    // subscribe workflow
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "NewUser_SubscribeWorkflow",
            joinColumns = {@JoinColumn(name = "newUserId", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "subscribeWorkflowId", referencedColumnName = "id")})
    private Set<NewWorkflow> subscribeWorkflows = new HashSet<NewWorkflow>();

    public NewUser() {}

    public NewUser(String userName, String password, String firstName, String lastName, String middleInitial, String affiliation, String title, String email, String mailingAddress, String phoneNumber, String faxNumber, String researchFields, String highestDegree) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInitial = middleInitial;
        this.affiliation = affiliation;
        this.title = title;
        this.email = email;
        this.mailingAddress = mailingAddress;
        this.phoneNumber = phoneNumber;
        this.faxNumber = faxNumber;
        this.researchFields = researchFields;
        this.highestDegree = highestDegree;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getResearchFields() {
        return researchFields;
    }

    public void setResearchFields(String researchFields) {
        this.researchFields = researchFields;
    }

    public String getHighestDegree() {
        return highestDegree;
    }

    public void setHighestDegree(String highestDegree) {
        this.highestDegree = highestDegree;
    }

    public Set<NewWorkflow> getNewWorkflows() {
        return newWorkflows;
    }

    public void setNewWorkflows(Set<NewWorkflow> newWorkflows) {
        this.newWorkflows = newWorkflows;
    }

    public List<NewPost> getNewPosts() {
        return newPosts;
    }

    public void setNewPosts(List<NewPost> newPosts) {
        this.newPosts = newPosts;
    }

    public Set<NewGroup> getAdminGroups() {
        return adminGroups;
    }

    public void setAdminGroups(Set<NewGroup> adminGroups) {
        this.adminGroups = adminGroups;
    }

    public Set<NewGroup> getMemberGroups() {
        return memberGroups;
    }

    public void setMemberGroups(Set<NewGroup> memberGroups) {
        this.memberGroups = memberGroups;
    }

    public Set<NewUser> getFriends() {
        return friends;
    }

    public void setFriends(Set<NewUser> friends) {
        this.friends = friends;
    }

    public Set<NewUser> getTeammates() {
        return teammates;
    }

    public void setTeammates(Set<NewUser> teammates) {
        this.teammates = teammates;
    }

    public Set<NewUser> getSubscribeUsers() {
        return subscribeUsers;
    }

    public void setSubscribeUsers(Set<NewUser> subscribeUsers) {
        this.subscribeUsers = subscribeUsers;
    }

    public Set<NewUser> getSubscribeTeammates() {
        return subscribeTeammates;
    }

    public void setSubscribeTeammates(Set<NewUser> subscribeTeammates) {
        this.subscribeTeammates = subscribeTeammates;
    }

    public Set<NewGroup> getSubscribeGroups() {
        return subscribeGroups;
    }

    public void setSubscribeGroups(Set<NewGroup> subscribeGroups) {
        this.subscribeGroups = subscribeGroups;
    }

    public Set<NewWorkflow> getSubscribeWorkflows() {
        return subscribeWorkflows;
    }

    public void setSubscribeWorkflows(Set<NewWorkflow> subscribeWorkflows) {
        this.subscribeWorkflows = subscribeWorkflows;
    }

    public JsonObject toBasicJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("userId", this.id);
        jsonObject.addProperty("userName", this.userName);
        jsonObject.addProperty("password", this.password);
        jsonObject.addProperty("firstName", this.firstName);
        jsonObject.addProperty("lastName", this.lastName);
        jsonObject.addProperty("middleInitial", this.middleInitial);
        jsonObject.addProperty("affiliation", this.affiliation);
        jsonObject.addProperty("title", this.title);
        jsonObject.addProperty("email", this.email);
        jsonObject.addProperty("mailingAddress", this.mailingAddress);
        jsonObject.addProperty("phoneNumber", this.phoneNumber);
        jsonObject.addProperty("faxNumber", this.faxNumber);
        jsonObject.addProperty("researchFields", this.researchFields);
        jsonObject.addProperty("highestDegree", this.highestDegree);
        return jsonObject;
    }

    public JsonObject toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("userId", this.id);
        jsonObject.addProperty("userName", this.userName);
        jsonObject.addProperty("password", this.password);
        jsonObject.addProperty("firstName", this.firstName);
        jsonObject.addProperty("lastName", this.lastName);
        jsonObject.addProperty("middleInitial", this.middleInitial);
        jsonObject.addProperty("affiliation", this.affiliation);
        jsonObject.addProperty("title", this.title);
        jsonObject.addProperty("email", this.email);
        jsonObject.addProperty("mailingAddress", this.mailingAddress);
        jsonObject.addProperty("phoneNumber", this.phoneNumber);
        jsonObject.addProperty("faxNumber", this.faxNumber);
        jsonObject.addProperty("researchFields", this.researchFields);
        jsonObject.addProperty("highestDegree", this.highestDegree);

        JsonArray jsonArrayWorkflows = new JsonArray();
        for (NewWorkflow newWorkflow : newWorkflows) {
            jsonArrayWorkflows.add(newWorkflow.toBasicJson());
        }
        jsonObject.add("workflows", jsonArrayWorkflows);

        JsonArray jsonArrayPosts = new JsonArray();
        for (NewPost newPost : newPosts) {
            jsonArrayPosts.add(newPost.toBasicJson());
        }
        jsonObject.add("posts", jsonArrayPosts);

        JsonArray jsonArrayAdminGroups = new JsonArray();
        for (NewGroup adminGroup : adminGroups) {
            jsonArrayAdminGroups.add(adminGroup.toBasicJson());
        }
        jsonObject.add("adminGroups", jsonArrayAdminGroups);

        JsonArray jsonArrayMemberGroups = new JsonArray();
        for (NewGroup memberGroup : memberGroups) {
            jsonArrayMemberGroups.add(memberGroup.toBasicJson());
        }
        jsonObject.add("memberGroups", jsonArrayMemberGroups);

        JsonArray jsonArrayFriends = new JsonArray();
        for (NewUser friend : friends) {
            jsonArrayFriends.add(friend.toBasicJson());
        }
        jsonObject.add("friends", jsonArrayFriends);

        JsonArray jsonArraySubscribeUsers = new JsonArray();
        for (NewUser subscribeUser : subscribeUsers) {
            jsonArraySubscribeUsers.add(subscribeUser.toBasicJson());
        }
        jsonObject.add("subscribeUsers", jsonArraySubscribeUsers);

        JsonArray jsonArraySubscribeGroups = new JsonArray();
        for (NewGroup subscribeGroup : subscribeGroups) {
            jsonArraySubscribeGroups.add(subscribeGroup.toBasicJson());
        }
        jsonObject.add("subscribeGroups", jsonArraySubscribeGroups);

        JsonArray jsonArraySubscribeWorkflows = new JsonArray();
        for (NewWorkflow subscribeWorkflow : subscribeWorkflows) {
            jsonArraySubscribeWorkflows.add(subscribeWorkflow.toBasicJson());
        }
        jsonObject.add("subscribeWorkflows", jsonArraySubscribeWorkflows);

        return jsonObject;
    }
}
