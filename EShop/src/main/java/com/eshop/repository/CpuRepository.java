package com.eshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eshop.entity.Cpu;
@Repository
public interface CpuRepository extends JpaRepository<Cpu, Integer>{

}
