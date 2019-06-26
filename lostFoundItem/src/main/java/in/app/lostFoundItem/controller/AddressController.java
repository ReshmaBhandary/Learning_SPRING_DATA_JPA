package in.app.lostFoundItem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.app.lostFoundItem.entity.Address;
import in.app.lostFoundItem.service.EmployeeService;

@RestController
public class AddressController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees/{empId}/address")
	public List<Address> getAddressById(@PathVariable("empId") Long employeeId,@RequestParam Long adressId) {

		return null;
	}
	
	
	

}
