package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mingyangling on 11/18/15.
 */
@Entity
public class Btest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "atest", referencedColumnName = "id")
    private Atest atest;

    public Btest() {
    }

    public Btest(String name, Atest atest) {
        this.name = name;
        this.atest = atest;
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

    public Atest getAtest() {
        return atest;
    }

    public void setAtest(Atest atest) {
        this.atest = atest;
    }
}
