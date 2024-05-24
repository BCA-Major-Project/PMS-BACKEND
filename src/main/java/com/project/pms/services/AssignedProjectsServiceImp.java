package com.project.pms.services;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.pms.dao.AssignedProjectsDao;
import com.project.pms.model.AssignedProjects;
import com.project.pms.model.Project;
import com.project.pms.model.User;

@Service
public class AssignedProjectsServiceImp implements AssignedProjectsService {
    @Autowired
    private AssignedProjectsDao assignedProjectsDao;

    @Override
    public List<AssignedProjects> assignUsersToProject(List<User> users, Project project) {
        List<AssignedProjects> assignedProjectsList = new ArrayList<>();
        for (User user : users) {
            AssignedProjects assignedProject = new AssignedProjects();
            assignedProject.setUser(user);
            assignedProject.setProject(project);
            AssignedProjects savedAssignedProject = assignedProjectsDao.save(assignedProject);
            assignedProjectsList.add(savedAssignedProject);
        }
        return assignedProjectsList;
    }

    @Override
    public List<AssignedProjects> getAllProjects(){
        return assignedProjectsDao.findAll();
    }
    
    @Override
    public List<AssignedProjects> getAssignedProjects(User userId) {
        return assignedProjectsDao.findByUser(userId);
    }

    @Override
    public List<AssignedProjects> getAssignedUsers(Project projectId) {
        return assignedProjectsDao.findByProject(projectId);
    }
}
