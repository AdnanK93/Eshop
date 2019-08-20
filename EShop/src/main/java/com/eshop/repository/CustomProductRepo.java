package com.eshop.repository;

import com.eshop.entity.Product;

public interface CustomProductRepo {
	Object findByTypeAndId(String type,int id);
}
