package in.app.lostFoundItem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.app.lostFoundItem.entity.Address;
import in.app.lostFoundItem.entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	Employee findByEmployeeIDAndEmployeeName(Long id,String employeeName);
	
	@Query("Select e from Employee e where e.employeeID=:employeeID")
	Employee getEmplID(@Param("employeeID") Long id);
	
	List<Employee> AllEmployees();
	
	//Address findByEmployeeIDandAddList_AddressID()
	

}
