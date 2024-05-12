package com.project.pms.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.pms.dto.UserDTO;
import com.project.pms.model.User;
import com.project.pms.services.*;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@CrossOrigin
@RequestMapping("/pms")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/user")
	public User addUser(@RequestBody User user) {
		return this.userService.addUser(user);
	}

	@GetMapping("/users")
	public List<User> getUsers() {
		return this.userService.getUsers();
	}

	@GetMapping("/user/{email}")
	public User loginCheck(@PathVariable String email) {
		return this.userService.login(email);
	}

	@GetMapping("/userid")
	public List<UserDTO> getPublicUsers() {
		List<User> users = this.userService.getUsers();
		List<UserDTO> userDTOs = new ArrayList<>();
		for (User user : users) {
			UserDTO userDTO = new UserDTO();
			userDTO.setId(user.getId());
			userDTO.setUsername(user.getUsername());
			if (userDTOs == null) {
                userDTOs = new ArrayList<>();
            }
			userDTOs.add(userDTO);
		}
		return userDTOs;
	}

	public String getMethodName(@RequestParam String param) {
		return param;
	}

	@GetMapping("/users/{userId}")
	public User getUser(@PathVariable String userId) {
		return this.userService.getUser(Integer.parseInt(userId));
	}

	@PutMapping("/user")
	public User updateUser(@RequestBody User user) {
		return this.userService.updateUser(user);
	}

	@DeleteMapping("/user/{userId}")
	public User deleteUser(@PathVariable String userId) {
		return this.userService.deleteUser(Integer.parseInt(userId));
	}
}
