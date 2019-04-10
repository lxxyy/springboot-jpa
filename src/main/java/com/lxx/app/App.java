package com.lxx.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SuppressWarnings("deprecation")
@ComponentScan(basePackages={"com.lxx.controller"})
@EnableJpaRepositories(basePackages={"com.lxx.repository"})
@EntityScan("com.lxx.entity")
@EnableAutoConfiguration
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
		
	}
}
