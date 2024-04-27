package com.project.UserController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.pms.user.*;
import com.project.UserServices.*;
@RestController
@CrossOrigin
public class UserController {
@Autowired	
private UserService userService;
	
@PostMapping("/user")
public User addUser(@RequestBody User user)
{
	return this.userService.addUser(user);
}}