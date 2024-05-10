package com.project.pms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.pms.model.Admin;

public interface AdminDao extends JpaRepository<Admin,String>{

    Admin findByAdmID(String admID);
}
