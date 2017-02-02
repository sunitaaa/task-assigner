package com.f1soft.task.assigner.response.dto;

/**
 *
 * @author sunita.joshi
 */
public class LoginResponseDTO {

    private Long userinfoid;
    private String name;
    private Character userRole;

    public Long getUserinfoid() {
        return userinfoid;
    }

    public void setUserinfoid(Long userinfoid) {
        this.userinfoid = userinfoid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getUserRole() {
        return userRole;
    }

    public void setUserRole(Character userRole) {
        this.userRole = userRole;
    }

}
