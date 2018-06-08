package ru.demo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuliya.ditarova on 2017-07-30.
 */
@Entity
@Table(name = "level")
public class Level {
    @Id
    @GeneratedValue
    private long id;
    private String name;

    public Level() {
    }

    public Level(String name) {
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
