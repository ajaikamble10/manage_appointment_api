package com.time_mgnt;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.time_mgnt.payloads.DoctorHospitalDetailsDto;
import com.time_mgnt.repositories.DoctorDetailsRepo;

@SpringBootApplication
public class ManageAppointment_api {

	public static void main(String[] args) {
	 
		ApplicationContext ctx= SpringApplication.run(ManageAppointment_api.class, args);
		DoctorDetailsRepo doctorDetailsRepo=ctx.getBean(DoctorDetailsRepo.class);
		
	}

}
