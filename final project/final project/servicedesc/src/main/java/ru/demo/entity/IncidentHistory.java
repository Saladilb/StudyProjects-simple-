package ru.demo.entity;

import javax.persistence.*;

/**
 * Created by yuliya.ditarova on 2017-07-30.
 */
@Entity
@Table(name = "incident_history")
public class IncidentHistory {
    @Id
    @GeneratedValue
    private long id;
    private String message;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
   // @JoinColumn(name = "incident_id", referencedColumnName = "id")
    private Incident incident;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public IncidentHistory() {
    }

    public IncidentHistory(String message) {
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Incident getIncident() {
        return incident;
    }

    public void setIncident(Incident incident) {
        this.incident = incident;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
