package com.project.pms.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int pid;

    @ManyToOne
    @JoinColumn(name = "uid")
    private User user;

    private String name;

    private String details;

    private LocalDate dueDate;

    private String category;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
	@JsonIgnore
    private List<Comment> comment = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<AssignedProjects> assignedTo = new ArrayList<>();

    public static String format_pattern = "yyyy-MM-dd";

    public Project(){}

    public Project(int pid, User user, String name, String details, String dueDate, String category, List<AssignedProjects> assignedTo, List<Comment> comment) {

        super();
        this.pid = pid;
        this.user = user;
        this.name = name;
        this.details = details;
        this.dueDate = convertToDate(dueDate);
        this.category = category;
        this.assignedTo = assignedTo;
        this.comment = comment;

    }

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }

    public int getId() {
        return pid;
    }

    public void setId(int pid) {
        this.pid = pid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDueDate() {
        return dateToString(dueDate);
    }

    public void setDueDate(String dueDate) {
        this.dueDate = convertToDate(dueDate);
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    // Getters and setters for assignedUsers
    public  List<AssignedProjects> getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedUsers(List<AssignedProjects> assignedTo) {
        this.assignedTo = assignedTo;
    }

    public LocalDate convertToDate(String dueDateStr){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format_pattern);
        return LocalDate.parse(dueDateStr, formatter);
    }
    public String dateToString(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format_pattern);
        return date.format(formatter);
    }
    public String listToString(List<Integer> assignedToInt){
        return assignedToInt.stream().map(Object::toString).collect(Collectors.joining(","));
    }
    public List<Integer> stringToList(String commaSeparatedValues) {
        return Arrays.stream(commaSeparatedValues.split(",")).map(Integer::parseInt).collect(Collectors.toList());
    }
    @Override
    public String toString() {
        return "Project [id=" + pid + ", user=" + user + ", name=" + name + ", details=" + details + ", dueDate=" + dueDate + ", category=" + category + ", assignedTo=" + assignedTo +" ]";
    }

}
