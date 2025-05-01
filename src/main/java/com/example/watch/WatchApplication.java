package com.example.watch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"com.watch", "com.watchApp"})
@EnableJpaRepositories(basePackages = {"com.watch.repository"})
@EntityScan(basePackages = {"com.watchApp.pojo"})
@SpringBootApplication
public class WatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(WatchApplication.class, args);
		
		System.out.println("Started....");
	}

}
