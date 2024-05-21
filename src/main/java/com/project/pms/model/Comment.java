package com.project.pms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "user_comment")
public class Comment {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int cmnt_id;

    @Column(name = "comment", length=255, nullable = false)
    private String comment;
    
    @Column(name = "insertion_time")
    private LocalDateTime insertionTime;
    
    @ManyToOne
    @JoinColumn(name = "pid")
    private Project project;
    
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @ManyToOne
    @JoinColumn(name = "uid")
    private User user;
    
    public static final String formatPattern = "yyyy-MM-dd HH:mm:ss";

    // Default constructor for JPA
    public Comment() {}

    public Comment(String comment, User user, String insertionTime, Project project) {
        this.comment = comment;
        this.user = user;
        this.project = project;
        this.insertionTime = convertToDate(insertionTime);
    }

    public int getId() {
        return cmnt_id;
    }

    public void setId(int cmnt_id) {
        this.cmnt_id = cmnt_id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getInsertionTime() {
        return dateToString(insertionTime);
    }

    public void setInsertionTime(String insertionTime) {
        this.insertionTime = convertToDate(insertionTime);
    }

    private LocalDateTime convertToDate(String insertionTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatPattern);
        return LocalDateTime.parse(insertionTime, formatter);
    }

    private String dateToString(LocalDateTime insertionTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatPattern);
        return formatter.format(insertionTime);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "cmnt_id=" + cmnt_id +
                ", comment='" + comment + '\'' +
                ", insertionTime='" + dateToString(insertionTime) + '\'' +
                '}';
    }
}