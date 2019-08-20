package com.eshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshop.entity.Cpu;
import com.eshop.entity.GraphicCard;
import com.eshop.entity.Product;
import com.eshop.entity.Ram;
import com.eshop.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductRepository productDAO;
	@Override
	public void save(Cpu cpu) {
		Product product=new Product();
		product.setType(cpu.getClass().getSimpleName());
		product.setFrkey(cpu.getId());
		productDAO.save(product);
		
	}
	@Override
	public void save(Ram ram) {
		Product product=new Product();
		product.setType(ram.getClass().getSimpleName());
		product.setFrkey(ram.getId());
		productDAO.save(product);
		
	}
	@Override
	public void save(GraphicCard graphicCard) {
		Product product=new Product();
		product.setType(graphicCard.getClass().getSimpleName());
		product.setFrkey(graphicCard.getId());
		productDAO.save(product);
		
	}

}
