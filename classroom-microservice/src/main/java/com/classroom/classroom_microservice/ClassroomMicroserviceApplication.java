package com.classroom.classroom_microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class ClassroomMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClassroomMicroserviceApplication.class, args);
	}

}
