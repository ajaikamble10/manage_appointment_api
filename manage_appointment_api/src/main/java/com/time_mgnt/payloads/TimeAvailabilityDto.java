package com.time_mgnt.payloads;

import java.sql.Time;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TimeAvailabilityDto {
	private long timeId;
	private int doctorId;
	private int openStatus;
	private int days;
	private Time startTime;
	private Time endTime;
}
