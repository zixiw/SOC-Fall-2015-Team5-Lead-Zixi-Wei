package models;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Zixi Wei, Mingyang Ling, Zheng Lei, Sen Yue on 11/29/15.
 */
@Entity
public class NewGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long creatorId;                  // group creator's user id
    private String name;                     // group name, should be unique
    private boolean isPublic;                // group may be public or closed

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "adminGroups")
    private Set<NewUser> adminUsers = new HashSet<NewUser>();

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "memberGroups")
    private Set<NewUser> memberUsers = new HashSet<NewUser>();

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "subscribeGroups")
    private Set<NewUser> subscribedUsers = new HashSet<NewUser>();

    public NewGroup() {}

    public NewGroup(long creatorId, String name, boolean isPublic) {
        this.creatorId = creatorId;
        this.name = name;
        this.isPublic = isPublic;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(long creatorId) {
        this.creatorId = creatorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public Set<NewUser> getAdminUsers() {
        return adminUsers;
    }

    public void setAdminUsers(Set<NewUser> adminUsers) {
        this.adminUsers = adminUsers;
    }

    public Set<NewUser> getMemberUsers() {
        return memberUsers;
    }

    public void setMemberUsers(Set<NewUser> memberUsers) {
        this.memberUsers = memberUsers;
    }

    public Set<NewUser> getSubscribedUsers() {
        return subscribedUsers;
    }

    public void setSubscribedUsers(Set<NewUser> subscribedUsers) {
        this.subscribedUsers = subscribedUsers;
    }

    public JsonObject toBasicJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("groupId", this.id);
        jsonObject.addProperty("creatorId", this.creatorId);
        jsonObject.addProperty("name", this.name);
        jsonObject.addProperty("isPublic", this.isPublic);
        return jsonObject;
    }

    public JsonObject toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("groupId", this.id);
        jsonObject.addProperty("creatorId", this.creatorId);
        jsonObject.addProperty("name", this.name);
        jsonObject.addProperty("isPublic", this.isPublic);

        JsonArray jsonArrayAdminUsers = new JsonArray();
        for (NewUser adminUser : adminUsers) {
            jsonArrayAdminUsers.add(adminUser.toBasicJson());
        }
        jsonObject.add("adminUsers", jsonArrayAdminUsers);

        JsonArray jsonArrayMemberUsers = new JsonArray();
        for (NewUser memberUser : memberUsers) {
            jsonArrayMemberUsers.add(memberUser.toBasicJson());
        }
        jsonObject.add("memberUsers", jsonArrayMemberUsers);

        JsonArray jsonArraySubscribedUsers = new JsonArray();
        for (NewUser subscribedUser : subscribedUsers) {
            jsonArraySubscribedUsers.add(subscribedUser.toBasicJson());
        }
        jsonObject.add("subscribedUsers", jsonArraySubscribedUsers);

        return jsonObject;
    }
}
