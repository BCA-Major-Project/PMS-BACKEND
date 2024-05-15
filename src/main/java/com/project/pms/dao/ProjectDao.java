package com.project.pms.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.project.pms.model.Project;
import com.project.pms.model.User;


import java.util.List;

public interface ProjectDao extends JpaRepository<Project, Integer> {
    List<Project> findByUser(User user);
    List<Project> findByCategory(String category);
}
