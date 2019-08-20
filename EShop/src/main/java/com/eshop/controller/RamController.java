package com.eshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eshop.entity.Ram;
import com.eshop.service.RamService;

@RestController
@RequestMapping(value = "/ram")
public class RamController {
	@Autowired
	private RamService ramService;
	@GetMapping(value = "/getRam")
	public List<Ram> getRam(){
		return ramService.getRam();
	}
	@PostMapping(value = "/create-ram")
	public Ram createRam(@RequestBody Ram ram) {
		ramService.save(ram);
		return ram;
	}
}
