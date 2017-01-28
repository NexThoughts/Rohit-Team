package com.nexthoughts.tracker.classes;


import com.nexthoughts.tracker.model.Label;
import com.nexthoughts.tracker.model.User;

public class LabelCommand {

    private int id;

    private String name;

    public LabelCommand() {

    }

    public LabelCommand(String name, User createdBy, String description) {
        this.name = name;
        this.createdBy = createdBy;
        this.description = description;
    }

    public LabelCommand(Label label) {
        this.name = label.getName();
        this.createdBy = label.getCreatedBy();
        this.description = label.getDescription();
        this.id = label.getId();
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    private User createdBy;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String description;

    public LabelCommand(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
