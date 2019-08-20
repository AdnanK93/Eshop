package com.eshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eshop.entity.Ram;
@Repository
public interface RamRepository extends JpaRepository<Ram, Integer>{

}
