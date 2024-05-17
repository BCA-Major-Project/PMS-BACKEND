package com.project.pms.services;

import java.util.List;

import com.project.pms.model.*;

public interface UserService {

	public User addUser(User user);
	
	public List<User> getUsers();
	
	public User getUser(int userId);
	
	public User updateUser(User user);
	
	public User deleteUser(int userId);

	public User login(String email);
	
	public User saveUser(User user);

	
}