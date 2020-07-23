package pe.com.entelgy.examen.service.dummy;

import java.util.ArrayList;
import java.util.List;

import pe.com.entelgy.examen.model.EmployeeV1;

public class DummyEmployees {

	public static List<EmployeeV1> getAllEmployeesV1() {
		List<EmployeeV1> employees = new ArrayList<>();
		employees.add(new EmployeeV1(1, "Meluska Herrera")) ;
		employees.add(new EmployeeV1(2, "Yonny Guerra")) ;
		employees.add(new EmployeeV1(3, "Martiz Vizcarra")) ;
		employees.add(new EmployeeV1(4, "Donald Trump")) ;
		
		return employees;
	}

}
