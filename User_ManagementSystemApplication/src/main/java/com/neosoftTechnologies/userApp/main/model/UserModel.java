package com.neosoftTechnologies.userApp.main.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserModel {
	private String cityName;
	private String countryName;
	private String dob;
	private String firstName;
	private String gender;
	private String stateName;
	private String userEmail;
	private String lastName;
	private String userMobile;
	private String pinCode;
	private String doj;
}
