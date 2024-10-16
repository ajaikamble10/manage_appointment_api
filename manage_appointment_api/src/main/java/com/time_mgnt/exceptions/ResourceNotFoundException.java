package com.time_mgnt.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class ResourceNotFoundException extends RuntimeException{

	public ResourceNotFoundException(String resourceName, String fieldName, Long fieldValue) {
		super(String.format("%s Not Found With %s:%s",resourceName,fieldName,fieldValue));
		
		this.resourceName=resourceName;
		this.fieldName=fieldName;
		this.fieldValue=fieldValue;
		
	}
	String resourceName;
	String fieldName;
	Long fieldValue;
}
