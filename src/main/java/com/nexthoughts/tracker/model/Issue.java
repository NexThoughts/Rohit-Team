package com.nexthoughts.tracker.model;

import com.nexthoughts.tracker.classes.IssueCommand;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
public class Issue {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private Date dateCreated = new Date();
    private String uuid = UUID.randomUUID().toString();

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private User createdBy;

    @ManyToOne(fetch = FetchType.LAZY)
    private Project project;

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }





    public Issue() {

    }

    public Issue(String description, String uuid, String title) {
        this.description = description;
        this.uuid = uuid;
        this.title = title;
    }

    public Issue(IssueCommand issueCommand) {
        this.description = issueCommand.getDescription();
        this.uuid = issueCommand.getTitle();
        this.title = issueCommand.getTitle();
        this.id = issueCommand.getId();
        this.createdBy = issueCommand.getCreatedBy();
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTitle() {

        return title;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public String getUuid() {
        return uuid;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Issue updateIssue(Issue issue, IssueCommand issueCommand) {
        issue.title = issueCommand.getTitle();
        issue.description = issueCommand.getDescription();
        return issue;
    }
}


