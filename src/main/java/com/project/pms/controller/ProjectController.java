package com.project.pms.controller;

import java.util.List;
import java.util.Optional;

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

import com.project.pms.model.Project;
import com.project.pms.model.User;
import com.project.pms.services.ProjectService;
import com.project.pms.services.UserService;




@CrossOrigin
@RestController
@RequestMapping("/pms")
public class ProjectController {
    @Autowired
    ProjectService project_service;
    @Autowired
    UserService obj;
    
    @PostMapping("/project")
    public Project addProject(@RequestBody Project project) {

        return this.project_service.addProject(project);
    }
    @GetMapping("/projects")
    public List<Project> getProjects() {
        return this.project_service.getProjects();
    }
    @GetMapping("/projects/{id}")
    public List<Project> getUserProjects(@PathVariable String id) {
        User user = obj.getUser(Integer.parseInt(id));
        // user.setId(Integer.parseInt(id));

        return this.project_service.getProjects(user);
    }
    @GetMapping("/projects_by_category/{category}")
    public List<Project> getUserProjectsByCategory(@PathVariable String category) {
        return this.project_service.getProjects(category);
    }
    
	@PutMapping("/projects")
	public Project updateProject(@RequestBody Project project) {
		return this.project_service.updateProject(project);
	}

    @DeleteMapping("/projects/{uid}")
	public Project deleteProject(@PathVariable String uid) {
		return this.project_service.deleteProject(Integer.parseInt(uid));
	}
}
