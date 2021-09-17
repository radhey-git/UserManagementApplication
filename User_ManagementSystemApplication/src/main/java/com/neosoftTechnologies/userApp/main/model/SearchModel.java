package com.neosoftTechnologies.userApp.main.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SearchModel {
	private String firstName;
	private String lastName;
	private String pinCode;
}
