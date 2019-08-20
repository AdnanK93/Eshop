package com.eshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.eshop.models.UserPrincipal;
import com.eshop.repository.UserRepository;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {
	@Autowired
	UserRepository userDAO;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserPrincipal userPrincipal=new UserPrincipal(userDAO.findByUsernameIgnoreCase(username));
		return userPrincipal;
	}

}
