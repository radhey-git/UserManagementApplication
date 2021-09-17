package com.neosoftTechnologies.userApp.main.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neosoftTechnologies.userApp.main.model.UserModel;
import com.neosoftTechnologies.userApp.main.service.UserService;

@WebMvcTest(value = UserRestContrloller.class)
public class TestUserRestContrloller {
	@MockBean
	private UserService service;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testSaveUser() throws Exception {
		when(service.saveData(ArgumentMatchers.any())).thenReturn(true);

		UserModel userModel = new UserModel("Nagpur", "India", "10/10/2020", "Radhey", "male", "Maharashtra",
				"r@gmail.com", "Garode", "9096852147", "445896", "10/10/2020");

		ObjectMapper mapper = new ObjectMapper();
		String userJSON = mapper.writeValueAsString(userModel);

		MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.post("/info/save")
																		 .contentType(MediaType.APPLICATION_JSON)
																		 .content(userJSON);

		ResultActions perform = mockMvc.perform(reqBuilder);

		MvcResult mvcResult = perform.andReturn();

		MockHttpServletResponse response = mvcResult.getResponse();

		int status = response.getStatus();

		assertEquals(201, status);
	}
	
	@Test
	public void testSearchUser() throws Exception {
		
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
		
		when(service.searchUser(ArgumentMatchers.anyString())).thenReturn(list);

		MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders
				.get("/info/search/{searchKey}",new String("445876"))
				.accept(MediaType.APPLICATION_JSON);
		
		mockMvcPerform(reqBuilder);
	}
	
	@Test
	public void testgetUser() throws Exception {
		
		UserModel userModel = new UserModel("Nagpur", "India", "10/10/2020", "Radhey", "male", "Maharashtra",
				"r@gmail.com", "Garode", "9096852147", "445896", "10/10/2020");
		
		when(service.getUser(ArgumentMatchers.anyInt())).thenReturn(userModel);

		MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders
				.get("/info/user/{userId}",new Integer(101))
				.accept(MediaType.APPLICATION_JSON);
		
		mockMvcPerform(reqBuilder);
	}
	
	@Test
	public void testEditUser() throws Exception {
		
		UserModel userModel = new UserModel("Nagpur", "India", "10/10/2020", "Radhey", "male", "Maharashtra",
				"r@gmail.com", "Garode", "9096852147", "445896", "10/10/2020");
		
		when(service.editUser(ArgumentMatchers.anyInt(),ArgumentMatchers.any())).thenReturn(userModel);

		ObjectMapper mapper = new ObjectMapper();
		String userJSON = mapper.writeValueAsString(userModel);
		
		MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders
				.put("/info/edit/{userId}",new Integer(101))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(userJSON);
		
		mockMvcPerform(reqBuilder);
	}
	
	@Test
	public void testDeleteUserById() throws Exception  {
		
		when(service.deleteUserById(ArgumentMatchers.anyInt())).thenReturn(true);

		ObjectMapper mapper = new ObjectMapper();
		String msgJSON = mapper.writeValueAsString("delete Successfull");
		
		MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders
				.delete("/info/delete/{userId}",new Integer(101))
				.contentType(MediaType.APPLICATION_JSON)
				.content(msgJSON);
		
		mockMvcPerform(reqBuilder);
	}
	
	@Test
	public void testSoftDeleteUserById() throws Exception  {
		
		when(service.deleteUserById(ArgumentMatchers.anyInt())).thenReturn(true);

		ObjectMapper mapper = new ObjectMapper();
		String msgJSON = mapper.writeValueAsString("Soft delete Successfull");
		
		MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders
				.delete("/info/delete/{userId}",new Integer(101))
				.contentType(MediaType.APPLICATION_JSON)
				.content(msgJSON);
		
		mockMvcPerform(reqBuilder);
	}
	
	@Test
	public void testsortUsersByDateOfBirth() throws Exception  {
		
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
		
		when(service.sortUserByDob()).thenReturn(list);

		MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders
				.get("/info/sortByDob")
				.accept(MediaType.APPLICATION_JSON);
		
		mockMvcPerform(reqBuilder);
	}
	
	@Test
	public void testsortUsersByDateOfJoining() throws Exception  {
		
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
		
		when(service.sortUserByDoj()).thenReturn(list);
		
		MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders
				.get("/info/sortByDob")
				.accept(MediaType.APPLICATION_JSON);
		
		mockMvcPerform(reqBuilder);
	}

	private void mockMvcPerform(MockHttpServletRequestBuilder reqBuilder) throws Exception {
		ResultActions perform = mockMvc.perform(reqBuilder);

		MvcResult mvcResult = perform.andReturn();

		MockHttpServletResponse response = mvcResult.getResponse();

		int status = response.getStatus();

		assertEquals(200, status);
	}
	
	
}
