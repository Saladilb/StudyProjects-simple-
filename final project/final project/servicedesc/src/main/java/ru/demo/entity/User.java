package ru.demo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuliya.ditarova on 2017-07-30.
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private long id;
    private String surname;
    private String login;
    private String password;

    @ManyToOne
    @JoinColumn(name = "level_id", referencedColumnName = "id")
    private Level level;

    @ManyToOne
    @JoinColumn(name = "organization_id", referencedColumnName = "id")
    private Organization organization;

    public User() {
    }

    public User(String surname, String login, String password) {
        this.surname = surname;
        this.login = login;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}
