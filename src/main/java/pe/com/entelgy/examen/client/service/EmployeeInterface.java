package pe.com.entelgy.examen.client.service;

import java.util.List;

import pe.com.entelgy.examen.client.model.Employee;
import retrofit2.Call;
import retrofit2.http.GET;

public interface EmployeeInterface {

	@GET("api/v1/employees")
	Call<List<Employee>> getEmployees();
}
