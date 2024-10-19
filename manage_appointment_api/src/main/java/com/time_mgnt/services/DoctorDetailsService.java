package com.time_mgnt.services;

import java.sql.Time;
import java.util.List;

import com.time_mgnt.payloads.DoctorHospitalDetailsDto;
import com.time_mgnt.payloads.TimeAvailabilityDto;

public interface DoctorDetailsService {
	
	List<DoctorHospitalDetailsDto> getDoctorDetails();
	List<DoctorHospitalDetailsDto> getDoctorDetailsByWeekDetails(List<String> ids);
	List<TimeAvailabilityDto> getDoctoDetailsById(Long id);
	int updateDoctorDetails(int days,Time startTime,Time endTime,Long id,Long timeId);
	int insertDoctorDetails(int days,Time startTime,Time endTime,int openStatus,Long id);
	int deleteDoctorDetails(Long doctorId);
	int checkExistsByDoctorIdAndDays(Long doctorId, int days);
	
}
