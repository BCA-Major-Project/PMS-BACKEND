package com.project.pms.services;

import java.util.List;

import com.project.pms.model.Project;
import com.project.pms.model.User;

public interface ProjectService {
    
    public Project addProject(Project project);
    
    public Project deleteProject(int uid);

    public Project updateProject(Project project);

    public List<Project> getProjects();

    public Project getProject(int pid);
    
    public List<Project> getProjects(User user);
    
    public List<Project> getProjects(String category);
}
