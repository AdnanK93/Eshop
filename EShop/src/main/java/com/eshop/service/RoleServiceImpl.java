package com.eshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshop.entity.Role;
import com.eshop.entity.User;
import com.eshop.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleRepository roleDAO;

	@Override
	public Role getOne(int id) {
		return roleDAO.getOne(id);
	}

	@Override
	public List<Role> findAll() {
		return roleDAO.findAll();
	}

	@Override
	public void save(Role role) {
		roleDAO.save(role);	
	}

	@Override
	public List<User> getUsers(int id) {
		return roleDAO.getOne(id).getUsers();
	}
	
}
