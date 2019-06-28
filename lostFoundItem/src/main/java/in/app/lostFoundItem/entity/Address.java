package in.app.lostFoundItem.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Address implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8936896908875324102L;

	@Id
	@Column(name="address_Id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long addressID;
	
	@Column(name="Address_State")
	private String state;
	
	
	@Column(name="Address_district")
	private String district;
	
	
	@Column(name="pincode")
	private Integer pinCode;
	
	
	public String getState() {
		return state;
	}
	@ManyToOne()
	@JsonBackReference
	@JoinColumn(name="Employee_Id")
	private Employee emp;
	
	public void setState(String state) {
		this.state = state;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public Integer getPinCode() {
		return pinCode;
	}
	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}
	
	public Long getAddressID() {
		return addressID;
	}
	public void setAddressID(Long addressID) {
		this.addressID = addressID;
	}
	public Address() {
		super();
	}
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	

}
