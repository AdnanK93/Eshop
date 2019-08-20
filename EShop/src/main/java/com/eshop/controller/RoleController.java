package com.eshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eshop.entity.Role;
import com.eshop.entity.User;
import com.eshop.service.RoleService;

@RestController
public class RoleController {
	@Autowired
	RoleService roleService;

	@GetMapping(value = "/role/{id}")
	public Role getRole(@PathVariable int id) {
		return roleService.getOne(id);
	}
	
	@GetMapping(value = "/role")
	public List<Role> getRoles(){
		return roleService.findAll();
	}
	@PostMapping(value = "/role/create-role")
	public Role saveRole(@RequestBody Role role) {
		roleService.save(role);
		return role;
	}
	@GetMapping(value = "/role/{id}/users")
	public List<User> getUsers(@PathVariable int id){
		return roleService.getUsers(id);
	}
}
