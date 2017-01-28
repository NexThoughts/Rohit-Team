package com.nexthoughts.tracker.model;

import com.nexthoughts.tracker.classes.LabelCommand;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "label")
public class Label {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    public Label(String name, String description, User createdBy) {
        this.name = name;
        this.description = description;
        this.createdBy = createdBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    private String description;

    private Date dateCreated = new Date();
    private String uuid = UUID.randomUUID().toString();

    @ManyToOne(fetch = FetchType.LAZY)
    private User createdBy;

    public Label(String name, User createdBy, String uuid) {
        this.name = name;
        this.createdBy = createdBy;
        this.uuid = uuid;
    }



    public Label() {
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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Label(LabelCommand labelCommand) {
        this.name = labelCommand.getName();
        this.createdBy = labelCommand.getCreatedBy();
        this.description = labelCommand.getDescription();
    }

    public Label updateLabel(Label label, LabelCommand labelCommand) {
        label.name = labelCommand.getName();
        label.description = labelCommand.getDescription();
        return label;
    }
}
