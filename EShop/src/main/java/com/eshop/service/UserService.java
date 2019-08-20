package com.eshop.service;

import java.util.List;

import com.eshop.entity.User;

public interface UserService {

	List<User> findAllUsers();

	void save(User user);

	User getById(int id);

	String confirmationToken(String confirmationToken);



}
