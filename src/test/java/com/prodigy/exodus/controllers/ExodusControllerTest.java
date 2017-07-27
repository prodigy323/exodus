package com.prodigy.exodus.controllers;

import static org.mockito.Matchers.anyObject;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.ResourceUtils;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prodigy.exodus.models.ExodusResponse;
import com.prodigy.exodus.services.ExodusService;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class ExodusControllerTest {

	private MockMvc mockMvc;
	
	@MockBean
	private ExodusService exodusServiceMock;
	
	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setup() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		
		ObjectMapper mapper = new ObjectMapper();
        InputStream is = ExodusController.class.getResourceAsStream("/sampleResponse.json");
        ExodusResponse res = mapper.readValue(is, ExodusResponse.class);
        Mockito.when(exodusServiceMock.process(anyObject())).thenReturn(res);
        is.close();
	}
	
	@Test
	public void testPostBody() throws Exception {
        File requestData = ResourceUtils.getFile("classpath:samplePost.json");
        String requestContent = new String(Files.readAllBytes(requestData.toPath()));
        
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/api/foo")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(requestContent);

		mockMvc.perform(requestBuilder)
			.andExpect(status().isOk())
	        .andExpect(jsonPath("$.name").value("Tony Stark"))
	        .andExpect(jsonPath("$.codename").value("Ironman"));

		Mockito.verify(exodusServiceMock, Mockito.times(1)).process(anyObject());
	}

}
