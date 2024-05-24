package com.project.pms.services;

import java.util.List;

import com.project.pms.model.AssignedProjects;
import com.project.pms.model.Project;
import com.project.pms.model.User;

public interface AssignedProjectsService {

    List<AssignedProjects> assignUsersToProject(List<User> users, Project project);
    List<AssignedProjects> getAllProjects();
    List<AssignedProjects> getAssignedProjects(User user);

    List<AssignedProjects> getAssignedUsers(Project project);

}
