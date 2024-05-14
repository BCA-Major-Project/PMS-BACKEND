package com.project.pms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int cmnt_id;
    private String comment;
    private LocalDateTime insertionTime;

    public static final String formatPattern = "yyyy-MM-dd HH:mm";

    // Default constructor for JPA
    public Comment() {}

    public Comment(int cmnt_id, String comment, String insertionTime) {
        this.cmnt_id = cmnt_id;
        this.comment = comment;
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