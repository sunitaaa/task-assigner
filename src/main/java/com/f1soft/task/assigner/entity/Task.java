package com.f1soft.task.assigner.entity;

import java.io.Serializable;
import java.util.Date;
import javafx.scene.text.Text;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
//import org.joda.time.DateTime;

/**
 *
 * @author sunita.joshi
 */
@Entity
@Table(name = "task")
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long taskid;

    //Hibernate Mapping Many to one 
    @ManyToOne
    @JoinColumn(name = "featureid")
    private Feature featureid;

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    
     @ManyToOne
     @JoinColumn(name = "created_by_id")
     private UserInfo createdById;

    @Column(name = "task_name")
    private String taskName;

    @Column(name = "task_code")
    private String taskCode;

    @Column(name = "assign_to_id")
    private Long assignToId;

    @Column(name = "task_assign_from_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date taskAssignFromDate;

    @Column(name = "task_assign_to_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date taskAssignToDate;

    @Column(name = "status")
    private Character status;

    @Column(name = "name")
    private String name;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "title")
    private String title;

    @Column(name = "task_completed_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date taskCompleteDate;

    public Long getTaskid() {
        return taskid;
    }

    public void setTaskid(Long taskid) {
        this.taskid = taskid;
    }

    public Feature getFeatureid() {
        return featureid;
    }

    public void setFeatureid(Feature featureid) {
        this.featureid = featureid;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public UserInfo getCreatedById() {
        return createdById;
    }

    public void setCreatedById(UserInfo createdById) {
        this.createdById = createdById;
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

    public Long getAssignToId() {
        return assignToId;
    }

    public void setAssignToId(Long assignToId) {
        this.assignToId = assignToId;
    }

    public Date getTaskAssignFromDate() {
        return taskAssignFromDate;
    }

    public void setTaskAssignFromDate(Date taskAssignFromDate) {
        this.taskAssignFromDate = taskAssignFromDate;
    }

    public Date getTaskAssignToDate() {
        return taskAssignToDate;
    }

    public void setTaskAssignToDate(Date taskAssignToDate) {
        this.taskAssignToDate = taskAssignToDate;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getTaskCompleteDate() {
        return taskCompleteDate;
    }

    public void setTaskCompleteDate(Date taskCompleteDate) {
        this.taskCompleteDate = taskCompleteDate;
    }

    @Override
    public String toString() {
        return "Task{" + "taskid=" + taskid + ", featureid=" + featureid + ", createdDate=" + createdDate + ", createdById=" + createdById + ", taskName=" + taskName + ", taskCode=" + taskCode + ", assignToId=" + assignToId + ", taskAssignFromDate=" + taskAssignFromDate + ", taskAssignToDate=" + taskAssignToDate + ", status=" + status + ", name=" + name + ", description=" + description + ", title=" + title + ", taskCompleteDate=" + taskCompleteDate + '}';
    }

}
