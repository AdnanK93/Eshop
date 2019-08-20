package com.eshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eshop.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
