package com.project.pms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.pms.services.AssignedProjectsService;
import com.project.pms.services.ProjectService;
import com.project.pms.services.UserService;
import com.project.pms.model.User;
import com.project.pms.dto.AssignedProjectsDTO;
import com.project.pms.dto.AssignedUsersDTO;
import com.project.pms.model.AssignedProjects;
import com.project.pms.model.Project;

@CrossOrigin
@RestController
@RequestMapping("/pms")
public class AssignedProjectsController {
    @Autowired
    AssignedProjectsService assigned_projects_service;
    @Autowired
    ProjectService project_service;
    @Autowired
    UserService user_service;

    @GetMapping("/user/{uid}/assigned_projects")
    public List<AssignedProjectsDTO> assignedProjects(@PathVariable("uid") String uid){
        User user = user_service.getUser(Integer.parseInt(uid));
        List<AssignedProjects> assigned_projects = this.assigned_projects_service.getAssignedProjects(user);
        List<AssignedProjectsDTO> assigned_projects_dto = new ArrayList<>();
        for (AssignedProjects project : assigned_projects){
            AssignedProjectsDTO assigned_project_dto = new AssignedProjectsDTO();
            assigned_project_dto.setProject(project.getProject());
            if (assigned_projects_dto == null) {
                assigned_projects_dto = new ArrayList<>();
            }
			assigned_projects_dto.add(assigned_project_dto);
        }
        return assigned_projects_dto;
    }

    @GetMapping("/user/assigned_projects/{uid}")
    public List<AssignedProjects> ap(@PathVariable("uid") String uid){
        User user = user_service.getUser(Integer.parseInt(uid));
        return this.assigned_projects_service.getAssignedProjects(user);
    }

    @GetMapping("/project/assigned_projects")
    public List<AssignedProjects> assigned(){
            return assigned_projects_service.getAllProjects();
    }
    @GetMapping("/project/{pid}/assigned_users")
    public List<AssignedUsersDTO> assignedUsers(@PathVariable("pid") String pid){
        Project project = project_service.getProject(Integer.parseInt(pid));
        List<AssignedProjects> assigned_projects = this.assigned_projects_service.getAssignedUsers(project);
        List<AssignedUsersDTO> assigned_users_dto = new ArrayList<>();
        for (AssignedProjects user : assigned_projects){
            AssignedUsersDTO assigned_user_dto = new AssignedUsersDTO();
            assigned_user_dto.setUser(user.getUser());
            if (assigned_users_dto == null) {
                assigned_users_dto = new ArrayList<>();
            }
			assigned_users_dto.add(assigned_user_dto);
        }
        return assigned_users_dto;
    }
}