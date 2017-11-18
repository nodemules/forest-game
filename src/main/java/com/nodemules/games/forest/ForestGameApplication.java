package com.nodemules.games.forest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.nodemules.games.forest")
@SpringBootApplication
public class ForestGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForestGameApplication.class, args);
	}
}
