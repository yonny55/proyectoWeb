package pe.com.entelgy.examen.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import pe.com.entelgy.examen.client.APIConfiguration;
import pe.com.entelgy.examen.client.model.Employee;
import pe.com.entelgy.examen.client.service.EmployeeInterface;
import pe.com.entelgy.examen.model.EmployeeV1;
import pe.com.entelgy.examen.service.dummy.DummyEmployees;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Service
public class EmployeeServiceImpl implements APIConfiguration {
	
	private EmployeeInterface employeeService;
	
	// Constructor
	public EmployeeServiceImpl() {
		Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
		
		this.employeeService = retrofit.create(EmployeeInterface.class);
	}

	// Consumo de servicio restful
	public List<EmployeeV1> getAllEmployeesV1() {
		Call<List<Employee>> retrofiCall = this.employeeService.getEmployees();
		List<EmployeeV1> employeesV1 = null; // respuesta a devolver
		
		try {
			// Ejecutamos la llamada
			Response<List<Employee>> response = retrofiCall.execute();
			
			// Verificamos si es exitosa la respuesta
			if(!response.isSuccessful()) {
				throw new IOException(response.errorBody() != null
                ? response.errorBody().string() : "Unknown error");
			}
			
			// Obtenemos respuesta de la llamada al http://dummy.restapiexample.com/....
			List<Employee> employees = response.body();
			
			// Preparamos para transformar la data de Employee a EmployeeV1
			employeesV1 
				= employees
					.stream()
					.map(e -> new EmployeeV1(e.getEmployee_id(), e.getEmployee_name()))
					.collect(Collectors.toList());
		} catch(IOException ex) {
			System.err.println(ex.getMessage());
			employeesV1 = DummyEmployees.getAllEmployeesV1();
		}
        
		return employeesV1;
	}

}
