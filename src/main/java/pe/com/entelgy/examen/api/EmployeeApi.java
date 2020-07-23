package pe.com.entelgy.examen.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.entelgy.examen.model.EmployeeV1;
import pe.com.entelgy.examen.service.impl.EmployeeServiceImpl;

@RestController
@RequestMapping(value = "api")
public class EmployeeApi {
	
	@Autowired
	private EmployeeServiceImpl employeeService;
	
	@GetMapping("v1/employees")
	public ResponseEntity<List<EmployeeV1>> employeesV1() {
		return new ResponseEntity<>(employeeService.getAllEmployeesV1(), HttpStatus.OK);
	}
}
