package com.project.pms.model;

import java.util.List;

public class ProjectData {
    private Project project;
    private List<User> userList;

    // Getters and setters
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}