package com.project.pms.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.pms.dao.ProjectDao;
import com.project.pms.model.Project;
import com.project.pms.model.User;

@Service
public class ProjectServiceImp implements ProjectService{
    @Autowired
    private ProjectDao project_dao;

    @Override
    public Project addProject(Project project){
        return project_dao.save(project);
    }
    
    @Override
	public Project deleteProject(int id) {
		Project project=project_dao.findById(id).get();
		project_dao.delete(project);
		return project;
	}
    @Override
	public Project updateProject(Project project) {
		project_dao.save(project);
		return project;
	}
	@Override
	public Project getProject(int pid){
		return project_dao.findById(pid).get();
	}
    @Override
	public List<Project> getProjects() {
		return project_dao.findAll();
	}
    @Override
    public List<Project> getProjects(User user) {
		return project_dao.findByUser(user);
	}
    @Override
    public List<Project> getProjects(String category) {
		return project_dao.findByCategory(category);
	}
}
