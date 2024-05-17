package com.project.pms.dao;

import java.util.List;

// import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.project.pms.model.*;

public interface CommentDao extends JpaRepository <Comment,Integer>{
    Comment findById(int cmnt_id);
    List<Comment> findByProject(Project project);

}
