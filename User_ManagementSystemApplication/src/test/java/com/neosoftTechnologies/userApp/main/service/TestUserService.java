package com.neosoftTechnologies.userApp.main.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import com.neosoftTechnologies.userApp.main.entity.UserEntity;
import com.neosoftTechnologies.userApp.main.model.UserModel;
import com.neosoftTechnologies.userApp.main.repository.UserRepository;
import com.neosoftTechnologies.userApp.main.utils.PwdUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserService {
	
	@InjectMocks
	UserServiceImpl userServiceImpl;
	
	@Mock
	UserRepository userRepo;
	
	private static String generateRandomPazzword(int length) {
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".charAt(random.nextInt("ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".length())));
		}
		return sb.toString();
	}

	@Test
	public void testSaveData() throws Exception {
		
		UserModel userModel = new UserModel("Nagpur", "India", "10/10/2020", "Radhey", "male", "Maharashtra",
				"r@gmail.com", "Garode", "9096852147", "445896", "10/10/2020");
		
		UserEntity user = new UserEntity();
		
		BeanUtils.copyProperties(userModel, user);
		String pazzword = generateRandomPazzword(6);
		String encryptPwd = PwdUtils.encryptPwd(pazzword);
		user.setUserId(101);
		user.setActiveSW("1");
		user.setUserPwd(encryptPwd);
		user.setUpdatedDate(LocalDate.now());
		user.setCreatedDate(LocalDate.now());
		
		when(userRepo.save(ArgumentMatchers.any())).thenReturn(user);
		
		UserModel userMod=new UserModel();
		
		BeanUtils.copyProperties(user, userMod);
		
		assertEquals(true,userServiceImpl.saveData(userModel));
		
	}
	
	@Test
	public void testSearchUser() throws Exception {
		
		List<UserEntity> userEntity =null;
		List<UserModel> userModel =null;
		
		UserModel userModel1 = new UserModel("Nagpur", "India", "10/10/2020", "Radhey", "male", "Maharashtra",
				"r@gmail.com", "Garode", "9096852147", "445896", "10/10/2020");
		UserModel userModel2 = new UserModel("Nagpur", "India", "10/10/2020", "Radhey", "male", "Maharashtra",
				"r@gmail.com", "Garode", "9096852147", "445896", "10/10/2020");
		UserModel userModel3 = new UserModel("Nagpur", "India", "10/10/2020", "Radhey", "male", "Maharashtra",
				"r@gmail.com", "Garode", "9096852147", "445896", "10/10/2020");
		List<UserModel> list=new ArrayList<>();
		list.add(userModel1);
		list.add(userModel2);
		list.add(userModel3);
		
		userEntity = new ArrayList<>();
		for (UserModel entity : list) {
			UserEntity model = new UserEntity();
			BeanUtils.copyProperties(entity, model);
			userEntity.add(model);
		}
		
		when(userRepo.findAll(ArgumentMatchers.anyString())).thenReturn(userEntity);
		
		userModel = new ArrayList<>();
		
		for (UserEntity entity : userEntity) {
			UserModel model = new UserModel();
			BeanUtils.copyProperties(entity, model);
			userModel.add(model);
		}
		assertEquals(userModel,userServiceImpl.searchUser("searchKey"));
	}
	
	@Test
	public void testSortUserByDob() throws Exception {
		List<UserEntity> userEntity =null;
		List<UserModel> userModel =null;
		
		UserModel userModel1 = new UserModel("Nagpur", "India", "10/10/2020", "Radhey", "male", "Maharashtra",
				"r@gmail.com", "Garode", "9096852147", "445896", "10/10/2020");
		UserModel userModel2 = new UserModel("Nagpur", "India", "10/10/2020", "Radhey", "male", "Maharashtra",
				"r@gmail.com", "Garode", "9096852147", "445896", "10/10/2020");
		UserModel userModel3 = new UserModel("Nagpur", "India", "10/10/2020", "Radhey", "male", "Maharashtra",
				"r@gmail.com", "Garode", "9096852147", "445896", "10/10/2020");
		List<UserModel> list=new ArrayList<>();
		list.add(userModel1);
		list.add(userModel2);
		list.add(userModel3);
		
		userEntity = new ArrayList<>();
		for (UserModel entity : list) {
			UserEntity model = new UserEntity();
			BeanUtils.copyProperties(entity, model);
			userEntity.add(model);
		}
		when(userRepo.findAll()).thenReturn(userEntity);
		userModel = new ArrayList<>();
		
		for (UserEntity entity : userEntity) {
			UserModel model = new UserModel();
			BeanUtils.copyProperties(entity, model);
			userModel.add(model);
		}
		assertEquals(userModel,userServiceImpl.sortUserByDob());
	}
	
	@Test
	public void testSortUserByDoj() throws Exception {
		List<UserEntity> userEntity =null;
		List<UserModel> userModel =null;
		
		UserModel userModel1 = new UserModel("Nagpur", "India", "10/10/2020", "Radhey", "male", "Maharashtra",
				"r@gmail.com", "Garode", "9096852147", "445896", "10/10/2020");
		UserModel userModel2 = new UserModel("Nagpur", "India", "10/10/2020", "Radhey", "male", "Maharashtra",
				"r@gmail.com", "Garode", "9096852147", "445896", "10/10/2020");
		UserModel userModel3 = new UserModel("Nagpur", "India", "10/10/2020", "Radhey", "male", "Maharashtra",
				"r@gmail.com", "Garode", "9096852147", "445896", "10/10/2020");
		List<UserModel> list=new ArrayList<>();
		list.add(userModel1);
		list.add(userModel2);
		list.add(userModel3);
		
		userEntity = new ArrayList<>();
		for (UserModel entity : list) {
			UserEntity model = new UserEntity();
			BeanUtils.copyProperties(entity, model);
			userEntity.add(model);
		}
		when(userRepo.findAll()).thenReturn(userEntity);
		userModel = new ArrayList<>();
		
		for (UserEntity entity : userEntity) {
			UserModel model = new UserModel();
			BeanUtils.copyProperties(entity, model);
			userModel.add(model);
		}
		assertEquals(userModel,userServiceImpl.sortUserByDoj());
	}
	
	
	
}
