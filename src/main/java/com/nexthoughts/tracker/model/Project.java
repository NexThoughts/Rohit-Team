package com.nexthoughts.tracker.model;

import com.nexthoughts.tracker.classes.ProjectCommand;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private User createdBy;

    private Date dateCreated = new Date();
    private String uuid = UUID.randomUUID().toString();

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

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Project() {

    }

    public Project(String name, User createdBy, String uuid) {
        this.name = name;
        this.createdBy = createdBy;
        this.uuid = uuid;
    }

    public Project(ProjectCommand projectCommand) {
        this.name = projectCommand.getName();
        this.createdBy = projectCommand.getCreatedBy();
    }

    public Project updateProject(Project project, ProjectCommand projectCommand) {
        project.name = projectCommand.getName();
        return project;
    }
}
