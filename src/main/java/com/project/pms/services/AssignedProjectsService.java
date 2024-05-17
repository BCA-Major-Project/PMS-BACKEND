package com.project.pms.services;

import java.util.List;

import com.project.pms.model.AssignedProjects;
import com.project.pms.model.Project;
import com.project.pms.model.User;

public interface AssignedProjectsService {

    List<AssignedProjects> assignUsersToProject(List<User> users, Project project);

    List<Project> getAssignedProjects(int userId);

    List<User> getAssignedUsers(int projectId);

}
