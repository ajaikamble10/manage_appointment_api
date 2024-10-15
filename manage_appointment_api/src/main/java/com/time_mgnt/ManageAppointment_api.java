package com.time_mgnt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ManageAppointment_api {

	public static void main(String[] args) {
	 
		ApplicationContext ctx= SpringApplication.run(ManageAppointment_api.class, args);
		
	}

}
