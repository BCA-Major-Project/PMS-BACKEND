package com.project.pms.services;

import java.util.List;

import com.project.pms.model.Comment;
import com.project.pms.model.Project;

public interface CommentService {
    
    public Comment addComment(Comment comment);
    
    public Comment getComment(int cmnt_id);
    public List<Comment> getComments();

    
    public List<Comment> getComments(Project project);

    public List<Comment> getComments(int cmnt_id, String type);
    
    
}
