package pe.com.entelgy.examen.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import pe.com.entelgy.examen.client.APIConfiguration;
import pe.com.entelgy.examen.client.model.Personaje;
import pe.com.entelgy.examen.client.service.PersonajeService;
import pe.com.entelgy.examen.model.PersonajeRestructurado;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Service
public class PersonajeServiceImpl implements APIConfiguration {
	
	private PersonajeService personajeService;
	
	// Constructor
	public PersonajeServiceImpl() {
		Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
		
		this.personajeService = retrofit.create(PersonajeService.class);
	}

	// Consumo de servicio restful
	public List<PersonajeRestructurado> getPersonajes() {
		Call<List<Personaje>> retrofiCall = this.personajeService.getEmployees();
		List<PersonajeRestructurado> personajesV1 = null; // respuesta a devolver
		
		try {
			// Ejecutamos la llamada
			Response<List<Personaje>> response = retrofiCall.execute();
			
			// Verificamos si es exitosa la respuesta
			if(!response.isSuccessful()) {
				throw new IOException(response.errorBody() != null
                ? response.errorBody().string() : "Unknown error");
			}
			
			// Obtenemos respuesta de la llamada al http://dummy.restapiexample.com/....
			List<Personaje> personajes = response.body();
			
			// Preparamos para transformar la data de Employee a EmployeeV1
			 
			personajesV1	= personajes
					.stream()
					.map(e -> new PersonajeRestructurado(e.getSpecies(), e.getOriginPlanet(), e.getName()))
					.collect(Collectors.toList());
		} catch(IOException ex) {
			System.err.println(ex.getMessage());
		}
        
		return personajesV1;
	}

}
