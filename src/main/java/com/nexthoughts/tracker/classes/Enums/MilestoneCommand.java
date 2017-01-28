package com.nexthoughts.tracker.classes.Enums;


import com.nexthoughts.tracker.model.Milestone;
import com.nexthoughts.tracker.model.User;

import java.util.Date;
import java.util.UUID;

public class MilestoneCommand {

    private int id;

    private String name;
    private User createdBy;
    private String startDate;
    private String endDate;
    private String uuid = UUID.randomUUID().toString();

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    private Date dateCreated = new Date();

    public MilestoneCommand() {

    }

    public MilestoneCommand(int id, String name, User createdBy, String startDate, String endDate, String uuid, Date dateCreated) {
        this.id = id;
        this.name = name;
        this.createdBy = createdBy;
        this.startDate = startDate;
        this.endDate = endDate;
        this.uuid = uuid;
        this.dateCreated = dateCreated;
    }

    public MilestoneCommand(Milestone milestone) {
        this.name = milestone.getName();
        this.startDate = milestone.getStartDate();
        this.endDate = milestone.getEndDate();
        this.createdBy = milestone.getCreatedBy();
        this.id = milestone.getId();
    }


}
