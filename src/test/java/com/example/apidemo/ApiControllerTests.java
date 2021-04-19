package com.example.apidemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class ApiControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void validateApiTest_POST() throws Exception {
		MvcResult mvcResult = mockMvc.perform(post("/addData")
				.contentType("application/json")
				.content(ApiFixture.POST_DATA))
				.andExpect(status().isCreated()).andReturn();
		assertNotNull(mvcResult);
	}

	@Test
	void validateApiTest_GET() throws Exception {
		MvcResult mvcResult = mockMvc.perform(get("/getData/{id}", "1"))
				.andExpect(status().isCreated()).andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();
		String responseData = response.getContentAsString();
		assertNotNull(responseData);
	}
}
