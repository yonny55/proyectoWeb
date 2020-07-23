package pe.com.entelgy.examen.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import pe.com.entelgy.examen.ExamenEmployeeApplication;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ExamenEmployeeApplication.class)
@TestInstance(Lifecycle.PER_CLASS)
public class EmployeeApiTests {

	private static final String baseUrl = "http://localhost:8080/api/v1";

	@Autowired
	private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;

	@BeforeAll
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void getEmployees() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(baseUrl + "/employees")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expected = "[{\"id\":1,\"name\":\"Meluska Herrera\"},{\"id\":2,\"name\":\"Yonny Guerra\"},{\"id\":3,\"name\":\"Martiz Vizcarra\"},{\"id\":4,\"name\":\"Donald Trump\"}]";

		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
	}
}
