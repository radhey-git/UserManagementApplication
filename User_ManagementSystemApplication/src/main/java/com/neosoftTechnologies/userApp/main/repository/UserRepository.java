package com.neosoftTechnologies.userApp.main.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.neosoftTechnologies.userApp.main.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Serializable >{

	@Query(value = "select user from UserEntity user where user.firstName like %?1% "
			+ "or user.lastName like %?1% "
			+ "or user.pinCode like %?1%")
	public List<UserEntity> findAll(String searchKey);

}
