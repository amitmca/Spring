/*package com.cg.ssp.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.ssp.service.FriendService;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class FriendsManagementControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	FriendService friendService;
	
	String mockFriends ="{\"friends\" :	[\"amod@gmail.com\",\"amit@gmail.com\"]	}";
	
	@Test
	public void testCreateFriend() throws Exception {
		Mockito.when(friendService.checkExistance(Mockito.anyString(),Mockito.anyString(),1)).thenReturn(1);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/api/friends")
				.accept(MediaType.APPLICATION_JSON).content(mockFriends)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		Assert.assertEquals(HttpStatus.CREATED.value(), response.getStatus());
	
	}
	
}
*/