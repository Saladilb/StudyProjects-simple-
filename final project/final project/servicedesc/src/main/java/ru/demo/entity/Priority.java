package ru.demo.entity;

import javax.persistence.*;

/**
 * Created by yuliya.ditarova on 2017-07-30.
 */
@Entity
@Table(name = "priority")
public class Priority {
    @Id
    @GeneratedValue
    private long id;
    private String name;



    public Priority() {
    }

    public Priority(String name) {
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


}
