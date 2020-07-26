package pe.com.entelgy.examen.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.entelgy.examen.model.PersonajeRestructurado;
import pe.com.entelgy.examen.model.Respuesta;
import pe.com.entelgy.examen.service.impl.PersonajeServiceImpl;

@RestController
@RequestMapping(value = "api")
public class PersonajesApi {
	
	@Autowired
	private PersonajeServiceImpl personajeService;
	
	@PostMapping("v1/personajes")
	public ResponseEntity<Respuesta> personajesV1() {
		List<PersonajeRestructurado> lista = personajeService.getPersonajes();
		Respuesta respuesta = new Respuesta();
		respuesta.setData(lista);
		
		return new ResponseEntity<>(respuesta, HttpStatus.OK);
	}
}
