package com.project.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.pms.model.Comment;
import com.project.pms.services.CommentService;




@CrossOrigin
@RestController
@RequestMapping("/pms")
public class CommentController {
    @Autowired
    CommentService comment_service;
    
    @PostMapping("/comment")
    public Comment addComment(@RequestBody Comment comment) {

        return this.comment_service.addComment(comment);
    }
    @GetMapping("/comments")
    public List<Comment> getComments() {
        return this.comment_service.getComments();
    }
    @GetMapping("/comments/{cmnt_id}")
    public List<Comment> getUserComments(@PathVariable String cmnt_id) {
        return this.comment_service.getComments(Integer.parseInt(cmnt_id));
    }
    @GetMapping("/comments/{cmnt_id}/{type}")
    public List<Comment> getUsercomments(@PathVariable String cmnt_id, @PathVariable String type) {
        return this.comment_service.getComments(Integer.parseInt(cmnt_id),type);
    }
    
	
}
