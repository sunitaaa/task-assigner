
package com.f1soft.task.assigner.request.dto;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author sunita.joshi
 */
public class UserInfoRequestDTO  implements Serializable{
    
    private String name;
    private Character status;
    private Date addedDate;
    private String email;
    private Date lastLoginTime;
    private String mobileNumber;
    private String password;
    private Character userRole;
    private Character active;

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

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
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

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }
    
    
    
    
}
