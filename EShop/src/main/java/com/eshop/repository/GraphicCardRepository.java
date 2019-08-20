package com.eshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eshop.entity.GraphicCard;
@Repository
public interface GraphicCardRepository extends JpaRepository<GraphicCard, Integer>{
	
}
