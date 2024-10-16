package com.time_mgnt.repositories;

import java.sql.Time;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.time_mgnt.models.TimeAvailability;

import jakarta.transaction.Transactional;

public interface TimeAvailabilityRepo extends JpaRepository<TimeAvailability, Long> {

	@Query(value="select * from time_availability where doctor_id=?1",nativeQuery = true)
	public List<TimeAvailability> getDoctorDetailsById(Long id);
	
	@Transactional
	@Modifying
	@Query(value = "update time_availability set days=?1,start_time=?2,end_time=?3 where doctor_id=?4 and time_id=?5  ",nativeQuery = true)
	public int updateDoctorDetails(int days,Time startTime,Time endTime,Long id,Long timeId);
	
	@Transactional
	@Modifying
	@Query(value="insert into time_availability(days,start_time,end_time,open_status,doctor_id) values(?1,?2,?3,?4,?5)",nativeQuery = true)
	public int insertDoctorDetails(int days,Time startTime,Time endTime,int open_status,Long id);
	
	@Transactional
	@Modifying
	@Query(value="delete from time_availability where doctor_id=?1 and time_id=?2",nativeQuery = true)
	public int deleteDoctorDetails(Long doctorId,Long timeId);
	
	@Query(value="SELECT COUNT(*) FROM time_availability WHERE doctor_id = ?1 AND days = ?2",nativeQuery = true)
	public int checkExistsByDoctorIdAndDays(Long doctorId, int days);
	
	
}
