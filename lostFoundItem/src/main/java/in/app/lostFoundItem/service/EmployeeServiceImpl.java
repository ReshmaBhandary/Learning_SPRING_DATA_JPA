package in.app.lostFoundItem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.app.lostFoundItem.entity.Address;
import in.app.lostFoundItem.entity.Employee;
import in.app.lostFoundItem.repository.AddressRepository;
import in.app.lostFoundItem.repository.EmployeeRepository;

@Service("EmployeeServiceImpl")
public class EmployeeServiceImpl implements EmployeeService{
	
	
	@Autowired
	private EmployeeRepository employeeRepository;

	
	@Autowired
	private AddressRepository addressRepository;

	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(Long id) {
		Optional<Employee> emp=employeeRepository.findById(id);
		if(emp.isPresent()) {
			return emp.get();
		}
		return null;
	}

	@Override
	public void saveEmployee(Employee emp) {
		employeeRepository.save(emp);
	}

	@Override
	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
		
	}
	public Employee getEmployeeByIdAndName(Long id,String name) {
		Employee emp=employeeRepository.findByEmployeeIDAndEmployeeName(id,name);
		return emp;
	}

	@Override
	public Employee getEmployeeByIdByNamedQuery(Long id) {
		return employeeRepository.getEmplID(id);
	}

	

	@Override
	public List<Employee> getAllEmployeesNamedQuery() {
		return employeeRepository.AllEmployees();
	}

	@Override
	public List<Address> getAddressState(String state,Long empID) {
		Optional<Employee> emp = employeeRepository.findById(empID);
		if(emp.isPresent()) {
			return addressRepository.findByState(emp.get(),state);
		}
		
		return null;
	}

}
