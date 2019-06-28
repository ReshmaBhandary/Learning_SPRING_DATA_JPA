package in.app.lostFoundItem.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
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

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@NamedQuery(name="Employee.AllEmployees" ,query="Select e from Employee e")
public class Employee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3441087101500964361L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="emp_ID")
	private Long employeeID;
	@Column(name="emp_name")
	private String employeeName;
	@Column(name="emp_salary")
	private Double salary;
	
	@OneToMany(mappedBy="emp",cascade=CascadeType.ALL)
	@JsonManagedReference
	private List<Address> addList=new ArrayList<>();
	
	
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
