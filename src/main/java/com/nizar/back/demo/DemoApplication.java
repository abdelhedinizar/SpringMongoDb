package com.nizar.back.demo;

import com.nizar.back.demo.dao.MyProductRepository;
import com.nizar.back.demo.entities.MyProduct;
import com.nizar.back.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.ApplicationPidFileWriter;

@SpringBootApplication
//@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
public class DemoApplication /*implements CommandLineRunner */{

	@Autowired
	ProductService productService;

	@Autowired
	MyProductRepository productRepository;

	//public static String test = "applicationref.pid";
	public static void main(String[] args) {
	/*	new SpringApplicationBuilder(DemoApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
				*/
		SpringApplication.run(DemoApplication.class, args);

	}


/*	@Override
	public void run(String... strings) throws Exception {
		productService.addProduct(new MyProduct(null,"Test2",400));
		System.out.println(productRepository.findAll());

	}
*/
}
