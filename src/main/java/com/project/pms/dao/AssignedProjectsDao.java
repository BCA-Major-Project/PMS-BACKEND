package com.project.pms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.pms.model.AssignedProjects;
import com.project.pms.model.Project;
import com.project.pms.model.User;

public interface AssignedProjectsDao extends JpaRepository<AssignedProjects, Integer> {
    List<AssignedProjects> findByUser(User user);
    List<AssignedProjects> findByProject(Project project);

}
