package com.time_mgnt.services.serviceImpl;

import java.sql.Time;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.time_mgnt.exceptions.ResourceNotFoundException;
import com.time_mgnt.models.TimeAvailability;
import com.time_mgnt.payloads.DoctorHospitalDetailsDto;
import com.time_mgnt.payloads.TimeAvailabilityDto;
import com.time_mgnt.repositories.DoctorDetailsRepo;
import com.time_mgnt.repositories.TimeAvailabilityRepo;
import com.time_mgnt.services.DoctorDetailsService;

@Service
public class DoctorDetailsServiceImpl implements DoctorDetailsService {
	
	@Autowired
	private DoctorDetailsRepo doctorDetailsRepo;
	
	@Autowired
	private TimeAvailabilityRepo timeAvailabilityRepo;
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public List<DoctorHospitalDetailsDto> getDoctorDetails() {
		// TODO Auto-generated method stub
		return doctorDetailsRepo.getDoctorDetails();
	}

	@Override
	public List<TimeAvailabilityDto> getDoctoDetailsById(Long id) {
		List<TimeAvailability> timeAvailability=this.timeAvailabilityRepo.getDoctorDetailsById(id);
		List<TimeAvailabilityDto> timeAvailabilityDto = timeAvailability.stream().map(list -> this.timeAvailabilityTODto(list)).collect(Collectors.toList());
		 if (timeAvailability == null) {
	            throw new ResourceNotFoundException("Doctor","id",id);
	        }
		return timeAvailabilityDto;
	}

	@Override
	public int updateDoctorDetails(int days, Time startTime, Time endTime, Long id,Long timeId) {
		int result=this.timeAvailabilityRepo.updateDoctorDetails(days, startTime, endTime, id,timeId);
		return result;
	}
	
	@Override
	public int insertDoctorDetails(int days, Time startTime, Time endTime, int openStatus,Long id) {
		int result=this.timeAvailabilityRepo.insertDoctorDetails(days, startTime, endTime, openStatus,id);
		return result;
	}
	
	@Override
	public int checkExistsByDoctorIdAndDays(Long doctorId, int days) {
		int result=timeAvailabilityRepo.checkExistsByDoctorIdAndDays(doctorId, days);
		return result;
	}
	
	@Override
	public int deleteDoctorDetails(Long doctorId, Long timeId) {
		int result=timeAvailabilityRepo.deleteDoctorDetails(doctorId, timeId);
		return result;
	}
	
	public TimeAvailability dtoTOTimeAvailability(TimeAvailabilityDto timeAvailabilityDto) {
		TimeAvailability timeAvail= this.modelMapper.map(timeAvailabilityDto, TimeAvailability.class);
		return timeAvail;
	}
	
	public TimeAvailabilityDto timeAvailabilityTODto(TimeAvailability timeAvailability) {
		TimeAvailabilityDto timeAvailabilityDto=this.modelMapper.map(timeAvailability, TimeAvailabilityDto.class);
		return timeAvailabilityDto;
	}

}
