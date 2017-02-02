package com.f1soft.task.assigner.entity;

import java.io.Serializable;
import java.util.Date;
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

/**
 *
 * @author sunita.joshi
 */
@Entity
@Table(name = "user_info")
public class UserInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userinfoid;
    
    @ManyToOne
    @JoinColumn(name = "assignToId")
    private Feature assignToId;
    
    
    @ManyToOne
    @JoinColumn(name = "createdById")
    private Feature createdById;
    

    @Column(name = "name")
    private String name;
    
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "user_role")
    private Character userRole;

    @Column(name = "mobileno")
    private String mobileno;

    @Column(name = "addeddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date addeddate;

    @Column(name = "status")
    private Character status;
    
    @Column(name="active")
    private Character active;
    
    @Column(name="admin_type")
    private Character adminType;
   
    @Column(name = "last_login_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLoginTime;

    public Long getUserinfoid() {
        return userinfoid;
    }

    public void setUserinfoid(Long userinfoid) {
        this.userinfoid = userinfoid;
    }

    public Feature getAssignToId() {
        return assignToId;
    }

    public void setAssignToId(Feature assignToId) {
        this.assignToId = assignToId;
    }

    public Feature getCreatedById() {
        return createdById;
    }

    public void setCreatedById(Feature createdById) {
        this.createdById = createdById;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Character getUserRole() {
        return userRole;
    }

    public void setUserRole(Character userRole) {
        this.userRole = userRole;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public Date getAddeddate() {
        return addeddate;
    }

    public void setAddeddate(Date addeddate) {
        this.addeddate = addeddate;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public Character getAdminType() {
        return adminType;
    }

    public void setAdminType(Character adminType) {
        this.adminType = adminType;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Override
    public String toString() {
        return "UserInfo{" + "userinfoid=" + userinfoid + ", assignToId=" + assignToId + ", createdById=" + createdById + ", name=" + name + ", email=" + email + ", password=" + password + ", userRole=" + userRole + ", mobileno=" + mobileno + ", addeddate=" + addeddate + ", status=" + status + ", active=" + active + ", adminType=" + adminType + ", lastLoginTime=" + lastLoginTime + '}';
    }
    

   }
