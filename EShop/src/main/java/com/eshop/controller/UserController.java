package com.eshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eshop.entity.Role;
import com.eshop.entity.User;
import com.eshop.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping(value = "/users")
	public List<User> getUsers() {
		return userService.findAllUsers();
	}
	
	@PostMapping(value = "/create-user")
	public User addUser(@RequestBody User user) {
		userService.save(user);
		return user;
	}
	@GetMapping(value = "/users/{id}")
	public User getUser(@PathVariable int id) {
		return userService.getById(id);
	}
	@GetMapping(value = "/users/{id}/roles")
	public List<Role> getRoles(@PathVariable int id){
		return userService.getById(id).getRoles();
	}
	@RequestMapping(value = "/users/confirm-account",method= {RequestMethod.GET, RequestMethod.POST})
	public String confirmAccount(@RequestParam("token")String confirmationToken) {
		return userService.confirmationToken(confirmationToken);
	}
}
