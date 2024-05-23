package com.project.pms.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
// import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int uid;

	private String name;

	@Column(unique = true)
	private String email;

	private String phno;

	private String password;

	@Column(unique = true)
	private String username;
	
	@Lob
    @Column(name = "image", columnDefinition = "MEDIUMBLOB")
    private byte[] image;

	@JsonIgnore
	@Column(columnDefinition = "TINYINT(1) DEFAULT 0")
	private byte isOnline;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@JsonIgnore
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@JsonIgnore
    private List<Project> projects = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@JsonIgnore
    private List<AssignedProjects> assignedProjects = new ArrayList<>();

	@Override
	public String toString() {
		return "User [uid=" + uid + ", name=" + name + ", email=" + email + ", phno=" + phno + ", password=" + password
				+ ", username=" + username + ", image=" + Arrays.toString(image) + ", isOnline=" + isOnline
				+ ", comments=" + comments + ", projects=" + projects + ", assignedProjects=" + assignedProjects
				+ ", getUid()=" + getUid() + ", getName()=" + getName() + ", getEmail()=" + getEmail() + ", getPhno()="
				+ getPhno() + ", getPassword()=" + getPassword() + ", getUsername()=" + getUsername() + ", getImage()="
				+ Arrays.toString(getImage()) + ", getIsOnline()=" + getIsOnline() + ", getComments()=" + getComments()
				+ ", getProjects()=" + getProjects() + ", getAssignedProjects()=" + getAssignedProjects()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	public User(int uid, String name, String email, String phno, String password, String username, byte[] image,
			byte isOnline, List<Comment> comments, List<Project> projects, List<AssignedProjects> assignedProjects) {
		this.uid = uid;
		this.name = name;
		this.email = email;
		this.phno = phno;
		this.password = password;
		this.username = username;
		this.image = image;
		this.isOnline = isOnline;
		this.comments = comments;
		this.projects = projects;
		this.assignedProjects = assignedProjects;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public byte getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(byte isOnline) {
		this.isOnline = isOnline;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public List<AssignedProjects> getAssignedProjects() {
		return assignedProjects;
	}

	public void setAssignedProjects(List<AssignedProjects> assignedProjects) {
		this.assignedProjects = assignedProjects;
	}

	public User() {}

}
	