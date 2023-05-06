package com.project.entertainment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class EntertainmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(EntertainmentApplication.class, args);
	}

}
