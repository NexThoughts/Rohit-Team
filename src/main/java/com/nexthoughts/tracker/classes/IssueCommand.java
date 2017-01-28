package com.nexthoughts.tracker.classes;


import com.nexthoughts.tracker.model.Issue;
import com.nexthoughts.tracker.model.User;

public class IssueCommand {
    private int id;

    private String title;
    private String description;


    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    private User createdBy;

    public IssueCommand(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }
    public IssueCommand(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public IssueCommand(){

    }

    public IssueCommand(Issue issue) {
        this.id = issue.getId();
        this.title = issue.getTitle();
        this.description = issue.getDescription();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
