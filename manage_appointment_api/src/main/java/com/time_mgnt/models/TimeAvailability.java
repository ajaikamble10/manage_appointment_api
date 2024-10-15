package com.time_mgnt.models;

import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="time_availability")
@NoArgsConstructor
@Setter
@Getter
public class TimeAvailability {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="time_id")
	private Long timeId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="doctor_id")
	private Doctor doctor;
	@Column(name="days",columnDefinition = "TINYINT CHECK (days BETWEEN 1 AND 7)")
	private int days;
	@Column(name="open_status")
	private int openStatus;
	@Column(name="start_time") 
	private Time startTime; 
	@Column(name="end_time") 
	private Time endTime; 

}
