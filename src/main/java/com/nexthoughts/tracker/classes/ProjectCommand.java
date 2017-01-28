package com.nexthoughts.tracker.classes;


import com.nexthoughts.tracker.model.Project;
import com.nexthoughts.tracker.model.User;

import java.util.Date;

public class ProjectCommand {
    private int id;

    User createdBy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    String name;

    public ProjectCommand() {

    }

    public ProjectCommand(String name, User createdBy) {
        this.name = name;
        this.createdBy = createdBy;
    }

    public ProjectCommand(Project project) {
        this.id = project.getId();
        this.name = project.getName();
        this.createdBy = project.getCreatedBy();
    }

}
