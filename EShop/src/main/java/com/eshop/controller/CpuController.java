package com.eshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eshop.entity.Cpu;
import com.eshop.service.CpuService;
import com.eshop.service.ProductService;

@RestController
@RequestMapping(value = "/cpu")
public class CpuController {
	@Autowired
	private CpuService cpuService;
	@Autowired
	private ProductService prodService;
	@GetMapping(value = "/getCpus")
	public List<Cpu> getCpus(){
		return cpuService.getCpus();
	}
	@PostMapping(value = "/create-cpu")
	public Cpu createCpu(@RequestBody Cpu cpu) {
		cpuService.save(cpu);
		return cpu;
	}
}
