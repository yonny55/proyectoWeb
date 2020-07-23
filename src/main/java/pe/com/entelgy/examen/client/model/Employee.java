package pe.com.entelgy.examen.client.model;

public class Employee {
	private Integer employee_id;
	private String employee_name;
	
	public Employee() {}
	
	public Employee(Integer employee_id, String employee_name) {
		this.employee_id = employee_id;
		this.employee_name = employee_name;
	}

	public Integer getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
}
