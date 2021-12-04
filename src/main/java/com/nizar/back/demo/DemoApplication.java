package com.nizar.back.demo;

import com.nizar.back.demo.dao.MyProductRepository;
import com.nizar.back.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	ProductService productService;

	@Autowired
	MyProductRepository productRepository;

	public static void main(String[] args) {
	SpringApplication.run(DemoApplication.class, args);

	}

}
