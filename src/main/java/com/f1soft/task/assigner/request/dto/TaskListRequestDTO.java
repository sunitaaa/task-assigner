
package com.f1soft.task.assigner.request.dto;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author sunita.joshi
 */
public class TaskListRequestDTO implements Serializable{
    private Long taskid;
    private Long userInfoId;
    private Long assignToId;
    private Long createdById;
    private String name;
    private Character status;
    private String taskName;
    private String taskCode;
    private String description;
    private Date createdDate;
    private Date taskAssignfromdate;
    private Date taskAssigntodate;
    private Date taskCompleteddate;
    private String title;
    private Long featureId;

    public Long getTaskid() {
        return taskid;
    }

    public void setTaskid(Long taskid) {
        this.taskid = taskid;
    }

    public Long getAssignToId() {
        return assignToId;
    }

    public void setAssignToId(Long assignToId) {
        this.assignToId = assignToId;
    }

    public Long getCreatedById() {
        return createdById;
    }

    public void setCreatedById(Long createdById) {
        this.createdById = createdById;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getTaskAssignfromdate() {
        return taskAssignfromdate;
    }

    public void setTaskAssignfromdate(Date taskAssignfromdate) {
        this.taskAssignfromdate = taskAssignfromdate;
    }

    public Date getTaskAssigntodate() {
        return taskAssigntodate;
    }

    public void setTaskAssigntodate(Date taskAssigntodate) {
        this.taskAssigntodate = taskAssigntodate;
    }

    public Date getTaskCompleteddate() {
        return taskCompleteddate;
    }

    public void setTaskCompleteddate(Date taskCompleteddate) {
        this.taskCompleteddate = taskCompleteddate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getFeatureId() {
        return featureId;
    }

    public void setFeatureId(Long featureId) {
        this.featureId = featureId;
    }     
    
}



