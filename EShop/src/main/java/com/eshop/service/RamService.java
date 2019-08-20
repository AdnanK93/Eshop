package com.eshop.service;

import java.util.List;

import com.eshop.entity.Ram;

public interface RamService {

	List<Ram> getRam();

	void save(Ram ram);

}
