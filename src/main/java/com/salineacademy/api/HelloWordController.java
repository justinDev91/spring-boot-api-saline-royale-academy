package com.salineacademy.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordController {

	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

}