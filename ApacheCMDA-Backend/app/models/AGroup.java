package models;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by ethan on 11/20/15.
 */
@Entity
public class AGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "aGroup")
    private Set<AUser> users;

    public AGroup() {}

    public AGroup(String name, Set<AUser> users) {
        this.name = name;
        this.users = users;
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

    public Set<AUser> getUsers() {
        return users;
    }

    public void setUsers(Set<AUser> users) {
        this.users = users;
    }

    public JsonObject toJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name", this.name);
        JsonArray jsonArrayAUser = new JsonArray();
        for (AUser aUser : getUsers()) {
            jsonArrayAUser.add(aUser.toJson());
        }
        jsonObject.add("users", jsonArrayAUser);
        return jsonObject;
    }

}
