package ru.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Created by yuliya.ditarova on 2017-07-30.
 */
@Entity
public class Organization {
    @Id
    @GeneratedValue
    private long id;
    private String name;

/*    @OneToOne(mappedBy = "organization")
    Incident incident;*/

    public Organization() {
    }

    public Organization(String name) {
        this.name = name;
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

/*    public Incident getIncident() {
        return incident;
    }

    public void setIncident(Incident incident) {
        this.incident = incident;
    }*/
}
