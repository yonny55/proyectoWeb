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

import pe.com.entelgy.examen.ExamenPersonajeApplication;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ExamenPersonajeApplication.class)
@TestInstance(Lifecycle.PER_CLASS)
public class PersonajeApiTests {

	//POST http://localhost:8080/api/v1/personajes
	private static final String baseUrl = "http://localhost:8080/api/v1";

	@Autowired
	private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;

	@BeforeAll
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void getPersonajes() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(baseUrl + "/personajes")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expected = "{\n" + 
				"   \"data\":[\n" + 
				"      {\n" + 
				"         \"species\":\"unknown\",\n" + 
				"         \"originPlanet\":\"Unknown\",\n" + 
				"         \"name\":\"Frieza\"\n" + 
				"      },\n" + 
				"      {\n" + 
				"         \"species\":\"Saiyan\",\n" + 
				"         \"originPlanet\":\"Vegeta\",\n" + 
				"         \"name\":\"Goku\"\n" + 
				"      },\n" + 
				"      {\n" + 
				"         \"species\":\"Saiyan\",\n" + 
				"         \"originPlanet\":\"Vegeta\",\n" + 
				"         \"name\":\"Vegeta\"\n" + 
				"      },\n" + 
				"      {\n" + 
				"         \"species\":\"Saiyan\",\n" + 
				"         \"originPlanet\":\"Earth\",\n" + 
				"         \"name\":\"Gohan\"\n" + 
				"      },\n" + 
				"      {\n" + 
				"         \"species\":\"Android\",\n" + 
				"         \"originPlanet\":\"Earth\",\n" + 
				"         \"name\":\"Android16\"\n" + 
				"      },\n" + 
				"      {\n" + 
				"         \"species\":\"Namekian\",\n" + 
				"         \"originPlanet\":\"Namek\",\n" + 
				"         \"name\":\"Piccolo\"\n" + 
				"      },\n" + 
				"      {\n" + 
				"         \"species\":\"Majin\",\n" + 
				"         \"originPlanet\":\"Majin\",\n" + 
				"         \"name\":\"Fat_Majin_Buu\"\n" + 
				"      },\n" + 
				"      {\n" + 
				"         \"species\":\"Android\",\n" + 
				"         \"originPlanet\":\"Earth\",\n" + 
				"         \"name\":\"Cell\"\n" + 
				"      },\n" + 
				"      {\n" + 
				"         \"species\":\"Saiyan\",\n" + 
				"         \"originPlanet\":\"Vegeta\",\n" + 
				"         \"name\":\"Cunbar\"\n" + 
				"      },\n" + 
				"      {\n" + 
				"         \"species\":\"Saiyan\",\n" + 
				"         \"originPlanet\":\"Earth\",\n" + 
				"         \"name\":\"Goten\"\n" + 
				"      },\n" + 
				"      {\n" + 
				"         \"species\":\"Human\",\n" + 
				"         \"originPlanet\":\"Earth\",\n" + 
				"         \"name\":\"Krillin\"\n" + 
				"      },\n" + 
				"      {\n" + 
				"         \"species\":\"Human\",\n" + 
				"         \"originPlanet\":\"Earth\",\n" + 
				"         \"name\":\"Bulma\"\n" + 
				"      },\n" + 
				"      {\n" + 
				"         \"species\":\"Android\",\n" + 
				"         \"originPlanet\":\"Earth\",\n" + 
				"         \"name\":\"Android17\"\n" + 
				"      },\n" + 
				"      {\n" + 
				"         \"species\":\"Saiyan\",\n" + 
				"         \"originPlanet\":\"Vegeta\",\n" + 
				"         \"name\":\"Raditz\"\n" + 
				"      },\n" + 
				"      {\n" + 
				"         \"species\":\"Majin\",\n" + 
				"         \"originPlanet\":\"Majin\",\n" + 
				"         \"name\":\"Kid_Buu\"\n" + 
				"      },\n" + 
				"      {\n" + 
				"         \"species\":\"Saiyan\",\n" + 
				"         \"originPlanet\":\"Vegeta\",\n" + 
				"         \"name\":\"Gabriel\"\n" + 
				"      },\n" + 
				"      {\n" + 
				"         \"species\":\"unknown\",\n" + 
				"         \"originPlanet\":\"Earth\",\n" + 
				"         \"name\":\"Piculo_olo\"\n" + 
				"      },\n" + 
				"      {\n" + 
				"         \"species\":\"Saiyan\",\n" + 
				"         \"originPlanet\":\"Vegeta\",\n" + 
				"         \"name\":\"Broly\"\n" + 
				"      },\n" + 
				"      {\n" + 
				"         \"species\":\"Android\",\n" + 
				"         \"originPlanet\":\"Earth\",\n" + 
				"         \"name\":\"Android18\"\n" + 
				"      },\n" + 
				"      {\n" + 
				"         \"species\":\"Human\",\n" + 
				"         \"originPlanet\":\"Earth\",\n" + 
				"         \"name\":\"Chi-Chi\"\n" + 
				"      },\n" + 
				"      {\n" + 
				"         \"species\":\"Saiyan\",\n" + 
				"         \"originPlanet\":\"Vegeta\",\n" + 
				"         \"name\":\"goku\"\n" + 
				"      },\n" + 
				"      {\n" + 
				"         \"species\":\"Human\",\n" + 
				"         \"originPlanet\":\"Earth\",\n" + 
				"         \"name\":\"krilin\"\n" + 
				"      }\n" + 
				"   ]\n" + 
				"}";
		
		System.out.println(result.getResponse().getContentAsString());
		
		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);
	}
}
