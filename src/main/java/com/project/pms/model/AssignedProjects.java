package com.project.pms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class AssignedProjects {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int relnId;

    // @Column(name="user_id")
    @ManyToOne
    // @Column(columnDefinition = "INT")
    @JoinColumn(name = "uid")
    User user;

    // @Column(name="project_id")
    @ManyToOne
    // @Column(columnDefinition = "INT")
    @JoinColumn(name = "pid")
    Project project;

    @Override
    public String toString() {
        return "AssignedProjects [relnId=" + relnId + ", user=" + user + ", project=" + project + "]";
    }
    public AssignedProjects(){

    }
    public AssignedProjects(int relnId, User user, Project project) {
        this.relnId = relnId;
        this.user = user;
        this.project = project;
    }

    public int getRelnId() {
        return relnId;
    }

    public void setRelnId(int relnId) {
        this.relnId = relnId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    


}
