package com.time_mgnt.services;

import java.util.List;

import com.time_mgnt.payloads.DoctorHospitalDetailsDto;

public interface DoctorDetailsService {
	
	List<DoctorHospitalDetailsDto> getDoctorDetails();
}
