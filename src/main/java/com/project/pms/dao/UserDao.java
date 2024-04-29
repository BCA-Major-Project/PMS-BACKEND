package com.project.pms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.pms.model.*;

public interface UserDao extends JpaRepository <User,Integer>{

}
