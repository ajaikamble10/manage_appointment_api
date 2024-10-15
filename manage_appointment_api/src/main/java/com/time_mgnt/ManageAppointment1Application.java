package com.time_mgnt;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ManageAppointment1Application {

	public static void main(String[] args) {
	 
		System.out.println("Welcome To Spring Boot.");
		ApplicationContext ctx= (ApplicationContext) SpringApplication.run(ManageAppointment1Application.class, args);
		
	}

}
