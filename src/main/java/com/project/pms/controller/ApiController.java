package com.project.pms.controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.pms.model.User;
import com.project.pms.services.*;
@RestController
@CrossOrigin
public class ApiController {
	@Autowired	
	private UserService userService;
		
	@PostMapping("/user")
	public User addUser(@RequestBody User user)
	{
		return this.userService.addUser(user);
	}
	@GetMapping("/users")
	public List<User> getUsers(){
		return this.userService.getUsers();
	}
	@GetMapping("/user/{email}")
	public User loginCheck(@PathVariable String email){
		return this.userService.login(email);
	}
	@GetMapping("/users/{userId}")
	public User getUser(@PathVariable String userId)
	{
		return this.userService.getUser(Integer.parseInt(userId));
	}

	@PutMapping("/user")
	public User updateUser(@RequestBody User user)
	{
		return this.userService.updateUser(user);
	}

	@DeleteMapping("/user/{userId}")
	public User deleteUser(@PathVariable String userId)
	{
		return this.userService.deleteUser(Integer.parseInt(userId));
	}
}
