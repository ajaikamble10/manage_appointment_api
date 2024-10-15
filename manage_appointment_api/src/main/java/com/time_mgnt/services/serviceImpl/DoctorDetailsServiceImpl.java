package com.time_mgnt.services.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.time_mgnt.payloads.DoctorHospitalDetailsDto;
import com.time_mgnt.repositories.DoctorDetailsRepo;
import com.time_mgnt.services.DoctorDetailsService;

@Service
public class DoctorDetailsServiceImpl implements DoctorDetailsService {
	
	@Autowired
	private DoctorDetailsRepo doctorDetailsRepo;

	@Override
	public List<DoctorHospitalDetailsDto> getDoctorDetails() {
		// TODO Auto-generated method stub
		return doctorDetailsRepo.getDoctorDetails();
	}

}
