package com.time_mgnt.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.time_mgnt.models.Doctor;
import com.time_mgnt.payloads.DoctorHospitalDetailsDto;

public interface DoctorDetailsRepo extends JpaRepository<Doctor, Long> {
	
	@Query(value="select ds.doctor_id,ds.doctor_name,hs.hospital_name,hs.hospital_address from doctors ds JOIN hospitals hs ON(ds.hospital_id=hs.hospital_id)", nativeQuery = true)
	public List<DoctorHospitalDetailsDto> getDoctorDetails();
}
