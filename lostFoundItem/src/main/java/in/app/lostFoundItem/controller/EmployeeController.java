package in.app.lostFoundItem.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.app.lostFoundItem.entity.Address;
import in.app.lostFoundItem.entity.Employee;
import in.app.lostFoundItem.exception.EmployeeNotFoundException;
import in.app.lostFoundItem.exception.ItemNotFoundException;
import in.app.lostFoundItem.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	@Qualifier("EmployeeServiceImpl")
	private EmployeeService employeeService;

	@GetMapping()
	public List<Employee> findAllEmployee() {

		return employeeService.getAllEmployees();
	}

	@GetMapping("/find/employee")
	public Employee findEmployeeById(@RequestParam("empID") Long employeeId) {
		Employee emp = employeeService.getEmployeeById(employeeId);

		if (null == emp) {
			try {
				throw new EmployeeNotFoundException(" Employee not found");
			} catch (EmployeeNotFoundException e) {
				System.out.println("Employee not found");
			}
		}

		return emp;
	}

	@GetMapping("/find/employee/Name")
	public Employee findEmployeeByIdAndName(@RequestParam("empID") Long employeeId, @RequestParam() String name) {

		Employee emp = employeeService.getEmployeeByIdAndName(employeeId, name);
		if (null == emp) {
			try {
				throw new EmployeeNotFoundException(" Employee not found");
			} catch (EmployeeNotFoundException e) {
				System.out.println("Employee not found");
			}
		}

		return emp;
	}

	@GetMapping("/find/employee/namedQuery/ID")
	public Employee findEmployeeByNamedQueryId(@RequestParam("empID") Long employeeId) {

		Employee emp = employeeService.getEmployeeByIdByNamedQuery(employeeId);
		if (null == emp) {
			try {
				throw new EmployeeNotFoundException(" Employee not found");
			} catch (EmployeeNotFoundException e) {
				System.out.println("Employee not found");
			}
		}

		return emp;
	}

	@PostMapping
	public void saveEmployee( @RequestBody Employee emp) {

		employeeService.saveEmployee(emp);

	}

	@PutMapping
	public void updateEmployee(@RequestBody Employee emp, @RequestParam Long empId) throws EmployeeNotFoundException {
		Employee employee = employeeService.getEmployeeById(empId);
		if (null != employee) {
			convertEmployeeObject(employee, emp);

			employeeService.saveEmployee(employee);
		} else {
			throw new EmployeeNotFoundException("Employee not found");
		}

	}

	private void convertEmployeeObject(Employee dbObject, Employee requestObj) {
		dbObject.setEmployeeName(requestObj.getEmployeeName());
		dbObject.setSalary(requestObj.getSalary());
		for (Address a : requestObj.getAddList()) {
			dbObject.addAddress(a);
			a.setEmp(dbObject);
		}

	}

	@DeleteMapping
	public void delete(@RequestParam Long empId) throws EmployeeNotFoundException {
		Employee employee = employeeService.getEmployeeById(empId);
		if (null != employee) {
			employeeService.deleteEmployee(empId);
		} else {
			throw new EmployeeNotFoundException("Employee not found");
		}
	}

	@GetMapping("/All")
	public List<Employee> findAllEmployeeNamedQuery() {

		return employeeService.getAllEmployeesNamedQuery();
	}

	@GetMapping("/{empID}/Addresses/states")
	public List<Address> findAddressByState(@RequestParam String state, @PathVariable Long empID) {
		/*Employee employee = employeeService.getEmployeeById(empID);
		if (null != employee) {
			
		}*/
		return employeeService.getAddressState(state, empID);

	}

}
