package in.app.lostFoundItem.entity;

import java.math.BigInteger;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@NamedQuery(name="Employee.AllEmployees" ,query="Select e from Employee e")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="emp_ID")
	private Long employeeID;
	@Column(name="emp_name")
	private String employeeName;
	@Column(name="emp_salary")
	private Double salary;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="emp",fetch=FetchType.LAZY)
	private List<Address> addList=null;
	
	
	public List<Address> getAddList() {
		return addList;
	}
	public void addAddress(Address address) {
		this.addList.add(address);
	}
	public Long getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(Long employeeID) {
		this.employeeID = employeeID;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Employee() {
		super();
	}
	
	
	

}
