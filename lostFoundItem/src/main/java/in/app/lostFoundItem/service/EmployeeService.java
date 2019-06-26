package in.app.lostFoundItem.service;

import java.util.List;

import in.app.lostFoundItem.entity.Address;
import in.app.lostFoundItem.entity.Employee;

public interface EmployeeService {
	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(Long id);
	public void saveEmployee(Employee e);
	public void deleteEmployee(Long id);
	public Employee getEmployeeByIdAndName(Long employeeID,String employeeName);
	public Employee getEmployeeByIdByNamedQuery(Long employeeId);
	public List<Employee> getAllEmployeesNamedQuery();
	public List<Address> getAddressState(String state,Long empID);
	

}
