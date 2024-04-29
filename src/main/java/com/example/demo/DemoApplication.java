package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.Controllers.HomeController;

@SpringBootApplication
public class DemoApplication  {

	@Autowired
	HomeController homeController;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	// @Override
    // public void run(String... args) throws Exception {
    //     // You can use this method to perform any actions at the application startup
    // }

}
