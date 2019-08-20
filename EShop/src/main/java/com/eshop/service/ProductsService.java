package com.eshop.service;

import java.util.List;

import com.eshop.entity.Product;

public interface ProductsService {

	List<Object> getProducts();

	Object buyProduct(int id);

}
