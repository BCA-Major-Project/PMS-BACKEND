package com.project.pms.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.pms.dao.ProjectDao;
import com.project.pms.model.Project;

@Service
public class ProjectServiceImp implements ProjectService{
    @Autowired
    private ProjectDao project_dao;

    @Override
    public Project addProject(Project project){
        return project_dao.save(project);
    }

    @Override
	public List<Project> getProjects() {
		return project_dao.findAll();
	}
    @Override
    public Optional<Project> getProjects(int uid) {
		return project_dao.findByuid(uid);
	}
    @Override
    public Optional<Project> getProjects(int uid, String type) {
        Optional<Project> projects = getProjects(uid);
        return projects;
	}
}
