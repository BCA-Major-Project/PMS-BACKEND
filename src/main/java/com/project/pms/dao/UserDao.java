package com.project.pms.UserDao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.pms.user.*;

public interface UserDao extends JpaRepository <User,Integer>{

}
