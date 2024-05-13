package com.project.pms.services;

import java.util.List;
import java.util.Optional;

import com.project.pms.model.Project;
import com.project.pms.model.User;

public interface ProjectService {
    
    public Project addProject(Project project);
    
    public Project deleteProject(int uid);

    public Project updateProject(Project project);

    public List<Project> getProjects();
    
    public Optional<Project> getProjects(int uid);

    public Optional<Project> getProjects(int uid, String type);
    
    
}
