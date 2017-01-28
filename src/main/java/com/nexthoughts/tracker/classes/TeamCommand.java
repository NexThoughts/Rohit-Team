package com.nexthoughts.tracker.classes;

import com.nexthoughts.tracker.model.Team;
import com.nexthoughts.tracker.model.User;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class TeamCommand {

    private int id;
    private String name;
    private String uuid = UUID.randomUUID().toString();
//    private Set<User> users ;

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

/*    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }*/

    public TeamCommand(){}

    public TeamCommand(Team team){
        this.name = team.getName();
    }
}
