package com.project.pms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.pms.model.*;

public interface CommentDao extends JpaRepository <Comment,Integer>{
    Comment findById(int cmnt_id);

}
