package com.time_mgnt.controller;

import java.sql.Time;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.time_mgnt.exceptions.ResourceNotFoundException;
import com.time_mgnt.payloads.ApiResponse;
import com.time_mgnt.payloads.DoctorHospitalDetailsDto;
import com.time_mgnt.payloads.TimeAvailabilityDto;
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
	
	@GetMapping("/{doctorId}")
	public ResponseEntity<List<TimeAvailabilityDto>> getDoctorById(@PathVariable Long doctorId){
		return ResponseEntity.ok(this.doctorDetailsServ.getDoctoDetailsById(doctorId));
	}
	
	@PutMapping("/{doctorId}/{timeId}")
	public ResponseEntity<ApiResponse> updateDoctorDetails(@Validated @RequestBody TimeAvailabilityDto timeAvailabilityDto, @PathVariable Long doctorId, @PathVariable Long timeId){
		int days=timeAvailabilityDto.getDays();
		Time startTime=timeAvailabilityDto.getStartTime();
		Time endTime=timeAvailabilityDto.getEndTime();
		
		
		if (this.doctorDetailsServ.checkExistsByDoctorIdAndDays(doctorId, days) > 0) {
			return new ResponseEntity<ApiResponse>(new ApiResponse("Doctor Appointment is already existed.",false,doctorId),HttpStatus.OK);
		}else {
		try {
			int result=this.doctorDetailsServ.updateDoctorDetails(days, startTime, endTime, doctorId,timeId);
			if(result==1) {
				return new ResponseEntity<ApiResponse>(new ApiResponse("Updated Successfully.",true,doctorId),HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<ApiResponse>(new ApiResponse("Not Updated.",false,doctorId),HttpStatus.OK);
		}
		}
		return new ResponseEntity<ApiResponse>(new ApiResponse("Not Updated.",false,doctorId),HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<ApiResponse> insertDoctorDetails(@Validated @RequestBody List<TimeAvailabilityDto> timeAvailabilityDtos){
		
		Long doctorId = null;
		int result = 0;
		try {
			doctorId = (long) timeAvailabilityDtos.get(0).getDoctorId();
			this.doctorDetailsServ.deleteDoctorDetails(doctorId);
			for (int i = 0; i < timeAvailabilityDtos.size(); i++) {
				int days = timeAvailabilityDtos.get(i).getDays();
				Time startTime = timeAvailabilityDtos.get(i).getStartTime();
				Time endTime = timeAvailabilityDtos.get(i).getEndTime();
				int openStatus = timeAvailabilityDtos.get(i).getOpenStatus();
				doctorId = (long) timeAvailabilityDtos.get(i).getDoctorId();

				result = doctorDetailsServ.insertDoctorDetails(days, startTime, endTime, openStatus, doctorId);
			}
			if (result == 1) {
				return new ResponseEntity<ApiResponse>(new ApiResponse("Inserted Successfully.", true, doctorId),
						HttpStatus.OK);
			}
		} catch (Exception e) {
				return new ResponseEntity<ApiResponse>(new ApiResponse("Not Inserted.",false,doctorId),HttpStatus.OK);
			}
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("Not Inserted.",false,doctorId),HttpStatus.OK);
	}
	
	@DeleteMapping("/{doctorId}")
	public ResponseEntity<ApiResponse> deleteDoctorDetails(@PathVariable Long doctorId){
		try {
			int result=this.doctorDetailsServ.deleteDoctorDetails(doctorId);
			if(result==1) {
				return new ResponseEntity<ApiResponse>(new ApiResponse("Deleted Successfully.",true,doctorId),HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<ApiResponse>(new ApiResponse("Not Deleted.",false,doctorId),HttpStatus.OK);
		}
		return new ResponseEntity<ApiResponse>(new ApiResponse("Not Deleted.",false,doctorId),HttpStatus.OK);
	}
	
	
	@GetMapping("/weekDetails/{weekDays}")
	public ResponseEntity<List<DoctorHospitalDetailsDto>> getDoctorDetailsByWeek(@PathVariable List<String> weekDays){
		System.out.println("weekDays: "+weekDays);
			return ResponseEntity.ok(doctorDetailsServ.getDoctorDetailsByWeekDetails(weekDays));
	}
}
