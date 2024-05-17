package com.project.pms.dto;

import java.util.List;

import com.project.pms.model.Project;
import com.project.pms.model.User;

public class ProjectUsersDTO {
    private Project project;
    private List<User> users;

    // Getters and Setters
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}