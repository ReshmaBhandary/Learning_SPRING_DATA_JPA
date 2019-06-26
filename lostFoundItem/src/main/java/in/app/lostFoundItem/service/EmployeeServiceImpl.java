package in.app.lostFoundItem.service;

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
	public void saveEmployee(Employee e) {
		Employee e1=employeeRepository.save(e);
		System.out.println("******************************  "+e1.getAddList());
		/*List<Address> list=e.getAddList();
		for(Address a1:list) {
			a1.sete
		}*/
		
		
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
		Optional<Employee> empList = employeeRepository.findById(empID);
		if(empList.isPresent()) {
		Employee emp=	empList.get();
		return emp.getAddList();
	//	addressRepository.findByState(state);
		}
		return null;
	}

}
