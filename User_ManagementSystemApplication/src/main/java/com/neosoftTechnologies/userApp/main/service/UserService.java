package com.neosoftTechnologies.userApp.main.service;

import java.util.List;

import com.neosoftTechnologies.userApp.main.exception.UserManagementAppModuleException;
import com.neosoftTechnologies.userApp.main.model.UserModel;

public interface UserService {

	public boolean saveData(UserModel userModel) throws Exception;

	public List<UserModel> searchUser(String searchKey) throws UserManagementAppModuleException;

	public UserModel getUser(Integer userId) throws UserManagementAppModuleException;

	public UserModel editUser(Integer userId, UserModel userModel) throws UserManagementAppModuleException;

	public boolean deleteUserById(Integer userId);

	public boolean softDeleteUserById(Integer userId);

	public List<UserModel> sortUserByDob() throws UserManagementAppModuleException;

	public List<UserModel> sortUserByDoj() throws UserManagementAppModuleException;

}
