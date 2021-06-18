package com.tutorialspoint.demo1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

	@Value("${spring.application.name:default_application_name}")
	public String name;


	@RequestMapping(value = "/index1")
	public String index() {
		return "index1";
	}

	@RequestMapping("/view-products")
	public String viewProducts() {
		return "view-products";
	}

	@RequestMapping("/add-products")
	public String addProducts() {
		return "add-products";
	}

	@RequestMapping("/locale")
	public String locale() {
		return "locale";
	}

	@RequestMapping(value = "/hello")
	public String hello(@RequestParam(value = "id", defaultValue = "id1") String id) {
		System.out.println("Hello World , application.name = " + name + " id=" + id);
		return "locale";
	}



}