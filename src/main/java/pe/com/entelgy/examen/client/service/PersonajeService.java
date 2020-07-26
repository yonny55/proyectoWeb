package pe.com.entelgy.examen.client.service;

import java.util.List;

import pe.com.entelgy.examen.client.model.Personaje;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PersonajeService {

	@GET("api/character")
	Call<List<Personaje>> getEmployees();
}
