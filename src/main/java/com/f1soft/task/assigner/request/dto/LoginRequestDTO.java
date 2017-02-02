package com.f1soft.task.assigner.request.dto;

import java.io.Serializable;

/**
 *
 * @author sunita.joshi
 */
public class LoginRequestDTO implements Serializable {

    private String user;
    private String password;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
