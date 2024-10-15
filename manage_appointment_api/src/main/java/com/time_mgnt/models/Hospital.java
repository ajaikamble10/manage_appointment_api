package com.time_mgnt.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="hospitals")
@NoArgsConstructor
@Setter
@Getter
public class Hospital {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="hospital_id")
	private Long id;
	@Column(name="hospital_name")
	private String hospitalName;
	@Column(name="hospital_address")
	private String hospitalAddress;
	@OneToMany(mappedBy = "hospital",cascade = CascadeType.ALL,orphanRemoval = true)
	List<Doctor> doctorLst=new ArrayList<>();
}
