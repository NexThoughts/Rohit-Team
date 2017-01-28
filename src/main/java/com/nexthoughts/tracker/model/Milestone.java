package com.nexthoughts.tracker.model;

import com.nexthoughts.tracker.classes.Enums.MilestoneCommand;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "milestone")
public class Milestone {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String startDate;
    private String endDate;
    private Date dateCreated = new Date();
    private Date lastUpdated;
    private String uuid = UUID.randomUUID().toString();

    @ManyToOne(fetch = FetchType.LAZY)
    private User createdBy;

    public Milestone() {
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


    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public Milestone(MilestoneCommand milestoneCommand) {
        this.name = milestoneCommand.getName();
        this.createdBy = milestoneCommand.getCreatedBy();
        this.startDate = milestoneCommand.getStartDate();
        this.endDate = milestoneCommand.getEndDate();
    }

    public Milestone updateMilestone(Milestone milestone, MilestoneCommand milestoneCommand) {
        milestone.name = milestoneCommand.getName();
        milestone.startDate = milestoneCommand.getStartDate();
        milestone.endDate = milestoneCommand.getEndDate();
        return milestone;
    }
}
