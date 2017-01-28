package com.nexthoughts.tracker.model;


import com.nexthoughts.tracker.classes.TeamCommand;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "team")
public class Team {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String uuid = UUID.randomUUID().toString();

/*    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<User> users = new HashSet<User>(0);*/

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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
/*
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }*/

    public Team(){

    }

    public Team(TeamCommand teamCommand){
        this.name = teamCommand.getName();
        this.uuid = teamCommand.getUuid();
//        this.users = teamCommand.getUsers();
    }

}
