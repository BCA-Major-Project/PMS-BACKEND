package com.project.pms.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int uid;
	private String name;
	private String email;
	private String phno;
	private String password;
	private String username;
	@JsonIgnore
	@Column(columnDefinition = "TINYINT(1) DEFAULT 0")

	private byte isOnline;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@JsonIgnore
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@JsonIgnore
    private List<Project> projects = new ArrayList<>();


	public User() {
		
	}
	public User(int uid, String name, String email, String phno, String password, String username, byte isOnline, List<Comment> comments, List<Project> projects) {
		super();
		this.uid = uid;
		this.name = name;
		this.email = email;
		this.phno = phno;
		this.password = password;
		this.username = username;
		this.isOnline = isOnline;
		this.comments = comments;
		this.projects = projects;
	}

	public int getId() {
		return uid;
	}
	public void setId(int uid) {
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

	@Override
	public String toString() {
		return "User [uid=" + uid + ", name=" + name + ", email=" + email + ", phno=" + phno + ", password=" + password + ", username=" + username +", isOnline=" + isOnline +" ]";
	}

}
