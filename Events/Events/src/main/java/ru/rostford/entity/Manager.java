package ru.rostford.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "manager")
public class Manager {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    @OneToMany(mappedBy = "manager", fetch = FetchType.EAGER)
    private List<Event> events;

    public Manager() {
    }

    public Manager(String name, List<Event> events) {
        this.name = name;
        this.events = events;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
