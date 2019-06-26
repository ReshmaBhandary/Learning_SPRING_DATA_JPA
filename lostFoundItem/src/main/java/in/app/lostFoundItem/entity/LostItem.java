package in.app.lostFoundItem.entity;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LostItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer lostId;
	private String lostItemName;
	private String lostDesc;
	private String foundPlace;
	private BigInteger phoneNumber;
	private String name;

	public Integer getLostId() {
		return lostId;
	}

	public void setLostId(Integer lostId) {
		this.lostId = lostId;
	}

	public String getLostItemName() {
		return lostItemName;
	}

	public void setLostItemName(String lostItemName) {
		this.lostItemName = lostItemName;
	}

	public BigInteger getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(BigInteger phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLostDesc() {
		return lostDesc;
	}

	public void setLostDesc(String lostDesc) {
		this.lostDesc = lostDesc;
	}

	public String getFoundPlace() {
		return foundPlace;
	}

	public void setFoundPlace(String foundPlace) {
		this.foundPlace = foundPlace;
	}

	public LostItem() {
		super();
	}

	public LostItem(Integer lostId, String lostItemName, String lostDesc, String foundPlace, BigInteger phoneNumber,
			String name) {
		this.lostId = lostId;
		this.lostItemName = lostItemName;
		this.lostDesc = lostDesc;
		this.foundPlace = foundPlace;
		this.phoneNumber = phoneNumber;
		this.name = name;
	}

}
