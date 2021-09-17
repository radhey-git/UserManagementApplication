package com.neosoftTechnologies.userApp.main.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "USER_ACCOUNTS")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	
	@Column(name = "ACTIVE_SW")
	private String activeSW;
	
	@Column(name = "CITY_NAME")
	private String cityName;
	
	@Column(name = "COUNTRY_NAME")
	private String countryName;
	
	@CreationTimestamp()
	@Column(name = "CREATED_DATE",updatable = false)
	private LocalDate createdDate;
	
	@JsonFormat(pattern = "dd/mm/yyyy")
	@Column(name = "DOB")
	private String dob;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "GENDER")
	private String gender;
	
	@Column(name = "STATE_NAME")
	private String stateName;
	
	@UpdateTimestamp()
	@Column(name = "UPDATED_DATE",insertable = false)
	private LocalDate updatedDate;
	
	@Column(name = "USER_EMAIL")
	private String userEmail;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "USER_PWD")
	private String userPwd;
	
	@Column(name = "USER_MOBILE")
	private String userMobile;
	
	@Column(name = "PINCODE")
	private String pinCode;
	
	@JsonFormat(pattern = "dd/mm/yyyy")
	@Column(name = "DOJ")
	private String doj;
	
}
