package ru.demo.entity;

import javax.persistence.*;

/**
 * Created by yuliya.ditarova on 2017-07-30.
 */
@Entity
@Table(name = "incident")
public class Incident {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String createdate;

    @ManyToOne
    @JoinColumn(name = "order_from_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "admin_id", referencedColumnName = "id")
    private User admin;

    @ManyToOne
    @JoinColumn(name = "organization_id", referencedColumnName = "id")
    private Organization organization;

    @ManyToOne
    @JoinColumn(name = "priority_id", referencedColumnName = "id")
    private Priority priority;

   /* @OneToMany(mappedBy = "incident")
    private List<IncidentHistory> incidentHistory = new ArrayList<>();*/


    public Incident() {
    }

    public Incident(long id) {
        this.id = id;
    }

    public Incident(String title, String createdate) {
        this.title = title;
        this.createdate = createdate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

   /* public List<IncidentHistory> getIncidentHistory() {
        return incidentHistory;
    }

    public void setIncidentHistory(List<IncidentHistory> incidentHistory) {
        this.incidentHistory = incidentHistory;
    }*/
}
