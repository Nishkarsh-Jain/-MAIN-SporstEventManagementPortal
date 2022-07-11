package com.participation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import com.participation.entity.Participation;


@SpringBootApplication
@EnableFeignClients

public class ParticipatioMicroserviceApplication {

	public static void main(String[] args) {
		 SpringApplication.run(ParticipatioMicroserviceApplication.class, args);

	}

	@Bean
	public Participation participation() {
		return new Participation();

	}

}
