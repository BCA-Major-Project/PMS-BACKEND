package com.project.pms.UserServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.pms.UserDao.*;
import com.project.pms.user.*;

@Service
public class UserServiceImp implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public User addUser(User user) {
		userDao.save(user);
		return user;
	}

	@Override
	public List<User> getUsers() {
		return userDao.findAll();
	}

	@Override
	public User getUser(int userId) {
		
		return userDao.findById(userId).get();
	}

	@Override
	public User updateUser(User user) {
		userDao.save(user);
		return user;
	}
	
	
	
	

	@Override
	public User deleteUser(int userId) {
		User user=userDao.findById(userId).get();
		userDao.delete(user);
		return user;
	}
	
	

	
}
