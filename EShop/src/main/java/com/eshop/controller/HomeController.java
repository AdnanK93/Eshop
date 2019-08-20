package com.eshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@GetMapping(value = "/home/hello")
	public String hell() {
		return "Hello. Welocme to page";
	}
	@GetMapping(value = "/hel")
	public String hel() {
		return "Hello!!!";
	}
	
}
