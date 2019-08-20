package com.eshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshop.entity.Product;
import com.eshop.repository.CustomProductRepo;
import com.eshop.repository.ProductRepository;

@Service
public class ProductsServiceImpl implements ProductsService{
	@Autowired
	private CpuService cpuService;
	@Autowired
	private GraphicaCardService gcService;
	@Autowired
	private RamService ramService;
	@Autowired
	private ProductRepository productDAO;
	@Autowired
	private CustomProductRepo customDAO;
	@Override
	public List<Object> getProducts() {
		List<Object> products=new ArrayList<Object>();
		products.addAll(gcService.getCards());
		products.addAll(cpuService.getCpus());
		products.addAll(ramService.getRam());
		return products;
	}
	@Override
	public Object buyProduct(int id) {
		Product product=productDAO.getOne(id);
		return customDAO.findByTypeAndId(product.getType(), product.getFrkey());
	}

}
