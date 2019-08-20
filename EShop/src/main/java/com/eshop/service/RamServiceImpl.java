package com.eshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshop.entity.Ram;
import com.eshop.repository.RamRepository;

@Service
public class RamServiceImpl implements RamService {
	@Autowired
	private RamRepository ramDAO;
	@Autowired
	private ProductService productService;
	@Override
	public List<Ram> getRam() {
		return ramDAO.findAll();
	}
	@Override
	public void save(Ram ram) {
		ramDAO.save(ram);
		productService.save(ram);
	}

}
