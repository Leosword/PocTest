package com.example.demo;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class DemoApplication {
	 @PostConstruct
     void started() {
       TimeZone.setDefault(TimeZone.getTimeZone("TimeZone"));
	 }

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
