package com.eshop.service;

import java.util.List;

import com.eshop.entity.Role;
import com.eshop.entity.User;

public interface RoleService {

	Role getOne(int id);

	List<Role> findAll();

	void save(Role role);

	List<User> getUsers(int id);

}
