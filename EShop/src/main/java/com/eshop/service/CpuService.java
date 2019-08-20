package com.eshop.service;

import java.util.List;

import com.eshop.entity.Cpu;

public interface CpuService {

	List<Cpu> getCpus();

	void save(Cpu cpu);

}
