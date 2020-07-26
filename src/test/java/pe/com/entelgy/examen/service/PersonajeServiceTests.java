package pe.com.entelgy.examen.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import pe.com.entelgy.examen.ExamenPersonajeApplication;
import pe.com.entelgy.examen.model.PersonajeRestructurado;
import pe.com.entelgy.examen.service.impl.PersonajeServiceImpl;

// Refactorizable en abstract class
@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration(classes = { ExamenPersonajeApplication.class })

// Por clase
@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PersonajeServiceTests {
	
	@InjectMocks
	private PersonajeServiceImpl personajeService;

	@Test
	@Order(1)
	public void getPersonajes() {
		List<PersonajeRestructurado> personajes = personajeService.getPersonajes();
		
		assertNotNull(personajes);
		assertEquals(22, personajes.size());
	}
}
