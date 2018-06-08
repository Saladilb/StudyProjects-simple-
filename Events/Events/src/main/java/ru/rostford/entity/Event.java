package ru.rostford.entity;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn
    private Manager manager;
    @ManyToMany(mappedBy = "events", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Client> clients;

    public Event() {
    }

    public Event(String name, Manager manager, List<Client> clients) {
        this.name = name;
        this.manager = manager;
        this.clients = clients;
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

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
