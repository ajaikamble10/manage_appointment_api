package com.time_mgnt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.time_mgnt.payloads.DoctorHospitalDetailsDto;
import com.time_mgnt.services.DoctorDetailsService;

@RestController
@RequestMapping("/doctors")
public class DoctorDetailsController {

	@Autowired
	private DoctorDetailsService doctorDetailsServ;

	@GetMapping
	public ResponseEntity<List<DoctorHospitalDetailsDto>> getDoctorDetails() {
		return ResponseEntity.ok(this.doctorDetailsServ.getDoctorDetails());

	}
}
