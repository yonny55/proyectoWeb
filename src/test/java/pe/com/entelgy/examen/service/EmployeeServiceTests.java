package pe.com.entelgy.examen.service;

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

import pe.com.entelgy.examen.ExamenEmployeeApplication;
import pe.com.entelgy.examen.model.EmployeeV1;
import pe.com.entelgy.examen.service.impl.EmployeeServiceImpl;

// Refactorizable en abstract class
@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration(classes = { ExamenEmployeeApplication.class })

// Por clase
@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeServiceTests {
	
	@InjectMocks
	private EmployeeServiceImpl employeeService;

	@Test
	@Order(1)
	public void getEmployess() {
		List<EmployeeV1> employees = employeeService.getAllEmployeesV1();
		assertNotNull(employees);
	}
}
