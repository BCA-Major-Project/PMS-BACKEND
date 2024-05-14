package com.project.pms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.pms.dao.CommentDao;
import com.project.pms.model.Comment;

@Service
public class CommentServiceImp implements CommentService {
    @Autowired
    private CommentDao commentDao;

    @Override
    public Comment addComment(Comment comment) {
        commentDao.save(comment);
        return comment;
    }

    @Override
    public List<Comment> getComments() {
        return commentDao.findAll();
    }

    @Override
    public Comment getComment(int cmnt_id) {
        return commentDao.findById(cmnt_id);
    }

    @Override
    public List<Comment> getComments(int cmnt_id) {
        throw new UnsupportedOperationException("Unimplemented method 'getComments'");
    }

    @Override
    public List<Comment> getComments(int cmnt_id, String type) {
        throw new UnsupportedOperationException("Unimplemented method 'getComments'");
    }

   
}