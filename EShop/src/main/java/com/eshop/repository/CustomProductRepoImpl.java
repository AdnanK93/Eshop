package com.eshop.repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class CustomProductRepoImpl implements CustomProductRepo{
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Object findByTypeAndId(String type, int id) {
		TypedQuery<Object> query=entityManager.createQuery("Select o from " + type + " o where id=" + id,Object.class);
		
		return query.getSingleResult();
	}
	
}
