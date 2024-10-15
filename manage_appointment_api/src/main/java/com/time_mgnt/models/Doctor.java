package com.time_mgnt.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="doctors")
@NoArgsConstructor
@Setter
@Getter
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="doctor_id")
	private Long id;
	@Column(name="doctor_name")
	private String doctorName;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="hospital_id")
	private Hospital hospital;
	@OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL,orphanRemoval = true)
	List<TimeAvailability> timeAvailabilityLst=new ArrayList<>();
}
