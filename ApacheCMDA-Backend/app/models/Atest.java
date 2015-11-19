package models;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by mingyangling on 11/18/15.
 */

@Entity
public class Atest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String content;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "atest")
    private Set<Btest> tests;
    public Atest() {
    }
    public Atest(String name, String content, Set<Btest> tests) {
        this.name = name;
        this.tests = tests;
        this.content=content;
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

    public Set<Btest> getTests() {
        return tests;
    }

    public void setTests(Set<Btest> tests) {
        this.tests = tests;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString(){
        return "id"+id+"\n"+"name"+name+"content"+content+"test"+tests;
    }
}
