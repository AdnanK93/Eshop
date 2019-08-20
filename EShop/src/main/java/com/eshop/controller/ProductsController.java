package com.eshop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.eshop.entity.Product;
import com.eshop.service.ProductsService;

@RestController
public class ProductsController {
	@Autowired
	private ProductsService productsService;
	@GetMapping(value = "/products")
	public List<Object> getProducts(){
		List<Object> products=new ArrayList<Object>();
		
		return productsService.getProducts();
	}
	@GetMapping(value = "/buyproduct/{id}")
	public Object buyProduct(@PathVariable int id) {
		return productsService.buyProduct(id);
	}
}
