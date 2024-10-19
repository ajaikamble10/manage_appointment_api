package com.time_mgnt;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.time_mgnt.payloads.DoctorHospitalDetailsDto;
import com.time_mgnt.repositories.DoctorDetailsRepo;
import com.time_mgnt.repositories.TimeAvailabilityRepo;

@SpringBootApplication
public class ManageAppointment_api {

	public static void main(String[] args) {
	 
		ApplicationContext ctx= SpringApplication.run(ManageAppointment_api.class, args);
		DoctorDetailsRepo doctorDetailsRepo=ctx.getBean(DoctorDetailsRepo.class);
		TimeAvailabilityRepo timeRepo=ctx.getBean(TimeAvailabilityRepo.class);
		
		List<String> days = Arrays.asList("2", "3");
		System.out.println("days: "+days);
		  List<DoctorHospitalDetailsDto>
		  list1=doctorDetailsRepo.getDoctorDetailsByWeekDetails(days);
		  list1.forEach(e->{
		  System.out.println(e.getDoctorName()+" "+e.getHospitalName()); });
		 
		
		
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	} 
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {

	    return new WebMvcConfigurer() {
	        @Override
	        public void addCorsMappings(CorsRegistry registry) {
	            registry.addMapping("/**")
	                    .allowedOrigins("*")
	                    .allowedMethods("GET", "POST", "PUT", "DELETE");
	        }
	    };
	}
}
