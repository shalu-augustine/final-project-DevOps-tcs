package com.tcs.final_project_tcs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class FinalProjectTcsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectTcsApplication.class, args);
	}
	
    @GetMapping("/")
    public String welcome() {
    	return "<h1>Welcome to Final project of DevOps<h1>";
    }
    
    @GetMapping("/about")
    public String aboutus() {
    	return "<h1>Welcome to our DevOps showcase!<h1>"
    			+ "<h2>Explore how we build, test, and deploy Java apps efficiently.<h2>";
}
}