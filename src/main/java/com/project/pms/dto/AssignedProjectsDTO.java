package com.project.pms.dto;

import com.project.pms.model.Project;

public class AssignedProjectsDTO {
    private Project project;

    

    public AssignedProjectsDTO() {
    }

    public AssignedProjectsDTO(Project project) {
        this.project = project;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
