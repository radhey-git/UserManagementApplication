package com.neosoftTechnologies.userApp.main.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neosoftTechnologies.userApp.main.exception.FileMissingException;
import com.neosoftTechnologies.userApp.main.exception.UserManagementAppModuleException;
import com.neosoftTechnologies.userApp.main.model.UserModel;
import com.neosoftTechnologies.userApp.main.service.UserService;

@RestController
@RequestMapping("/info")
public class UserRestContrloller {

	private static Logger logger = LoggerFactory.getLogger(UserRestContrloller.class.getName());

	
	@Autowired
	private UserService service;

	/**
	 * @author Radhey
	 * @return string
	 **/
	@PostMapping(value = "/save", consumes = "application/json", produces = "applilication/json")
	public ResponseEntity<String> saveUser(@RequestBody UserModel userModel) throws Exception {
		boolean saveUser = service.saveData(userModel);
		if (saveUser) {
			return new ResponseEntity<>("Success", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Faild",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/search/{searchKey}")
	public ResponseEntity<List<UserModel>> searchUser(@PathVariable(value = "searchKey") String searchKey) {
		List<UserModel> userModel=null;
		try {
			userModel = service.searchUser(searchKey.trim());
		} catch (UserManagementAppModuleException e) {
			logger.error("Enter Valid Search Key {}",new FileMissingException(e.getMessage()),e);
		}
		return new ResponseEntity<>(userModel, HttpStatus.OK);
	}

	@GetMapping(value = "/user/{userId}")
	public ResponseEntity<UserModel> getUser(@PathVariable(value = "userId") Integer userId) {
		UserModel userModel=null;
		try {
			userModel = service.getUser(userId);
		} catch (UserManagementAppModuleException e) {
			logger.error("Enter Valid User Id {}",new FileMissingException(e.getMessage()),e);
		}
		return new ResponseEntity<>(userModel, HttpStatus.OK);
	}

	@PutMapping(value = "/edit/{userId}")
	public ResponseEntity<UserModel> editUser(@PathVariable(value = "userId") Integer userId,
			@RequestBody UserModel userModel) {
		UserModel userModelUpdated=null;
		try {
			userModelUpdated = service.editUser(userId, userModel);
		} catch (UserManagementAppModuleException e) {
			logger.error("Enter Valid User Id {}",new FileMissingException(e.getMessage()),e);
		}
		return new ResponseEntity<>(userModelUpdated, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<String> deleteUserById(@PathVariable(value = "userId") Integer userId)
	{
		boolean user = service.deleteUserById(userId);
		if(user) {
			return new ResponseEntity<>("User Deleted Successfully ",HttpStatus.OK);
		}
		return new ResponseEntity<>("User Not Found ",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@DeleteMapping("/softdelete/{userId}")
	public ResponseEntity<String> softDeleteUserById(@PathVariable Integer userId)
	{
		boolean user = service.softDeleteUserById(userId);
		if(user) {
			return new ResponseEntity<>("User Soft Deleted Successfully ",HttpStatus.OK);
		}
		return new ResponseEntity<>("User Not Found ",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/sortByDob")
	public ResponseEntity<List<UserModel>> sortUsersByDateOfBirth() {
		List<UserModel> sortByDob=null;
		try {
			sortByDob = service.sortUserByDob();
		} catch (UserManagementAppModuleException e) {
			logger.error("User Not Found",new FileMissingException(e.getMessage()),e);
		}
		return new ResponseEntity<>(sortByDob,HttpStatus.OK);
	}

	@GetMapping("/sortByDoj")
	public ResponseEntity<List<UserModel>> sortUsersByDateOfJoining() {
		List<UserModel> sortByDoj=null;
		try {
			sortByDoj = service.sortUserByDoj();
		} catch (UserManagementAppModuleException e) {
			logger.error("User Not Found",new FileMissingException(e.getMessage()),e);
		}
		return new ResponseEntity<>(sortByDoj,HttpStatus.OK);
	}
	
	

}
