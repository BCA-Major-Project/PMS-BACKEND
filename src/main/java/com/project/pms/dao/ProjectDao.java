package com.project.pms.dao;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.project.pms.model.Project;



public interface ProjectDao extends JpaRepository<Project,Integer>{
    @Query("SELECT * FROM project p WHERE p.uid = :searchValue ") // Repeat for each column
    Optional<Project> findByuid(@Param("searchValue") int searchValue);
}
