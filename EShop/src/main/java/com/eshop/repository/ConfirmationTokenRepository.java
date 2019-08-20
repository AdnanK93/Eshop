package com.eshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eshop.entity.ConfirmationToken;

public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Integer>{
	ConfirmationToken findByConfirmationToken(String confirmationToken);
}
