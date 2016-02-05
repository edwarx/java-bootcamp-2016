package com.globant.Topic6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		Site site = Site.getInstance();
		SpringApplication.run(App.class, args);
	}
}
