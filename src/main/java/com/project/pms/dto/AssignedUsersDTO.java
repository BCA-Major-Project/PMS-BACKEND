package com.project.pms.dto;

import com.project.pms.model.User;

public class AssignedUsersDTO {
    private User user;

    public AssignedUsersDTO(){}
    
    public AssignedUsersDTO(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
