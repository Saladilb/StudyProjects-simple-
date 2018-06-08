package ru.rostford.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String phoneNumber;
    private String email;

    @ManyToMany
    @JoinTable(name = "client_events",
            joinColumns = @JoinColumn(name = "clientId"),
            inverseJoinColumns = @JoinColumn(name = "eventId")
    )
    private List<Event> events = new ArrayList<>();

    public Client() {
    }

    public Client(String name, String phoneNumber, String email, List<Event> events) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
