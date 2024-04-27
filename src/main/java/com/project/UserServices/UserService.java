package com.project.UserServices;

import java.util.List;

import com.project.pms.user.*;

public interface UserService {

	public User addUser(User user);
	
	public List<User> getUsers();
	
	public User getUser(int userId);
	
	public User updateUser(User user);
	
	public User deleteUser(int userId);
	
}