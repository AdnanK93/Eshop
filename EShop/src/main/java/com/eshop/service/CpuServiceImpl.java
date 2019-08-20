package com.eshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshop.entity.Cpu;
import com.eshop.repository.CpuRepository;

@Service
public class CpuServiceImpl implements CpuService {
	@Autowired
	private CpuRepository cpuDAO;
	@Autowired
	private ProductService prodService;
	@Override
	public List<Cpu> getCpus() {

		return cpuDAO.findAll();
	}

	@Override
	public void save(Cpu cpu) {
		cpuDAO.save(cpu);
		prodService.save(cpu);
		
	}

}
