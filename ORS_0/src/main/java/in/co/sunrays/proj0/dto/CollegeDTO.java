package in.co.sunrays.proj0.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * College POJO class. It is persistent object.
 * 
 * @author SessionFacade
 * @version 1.0 Copyright (c) SessionFacade
 *
 */
@Entity
@Table(name="ST_COLLEGE")
public class CollegeDTO extends BaseDTO{

	/**
	 * Name of College
	 *
	 */
	@Column(name="NAME", length=50)
	private String name;
	
	/**
	 * Address of College
	 *
	 */
	@Column(name="ADDRESS", length=50)
	private String address;
	
	/**
	 * State of College
	 *
	 */
	@Column(name="STATE", length=50)
	private String state;
	
	/**
	 * City of College
	 *
	 */
	@Column(name="CITY", length=50)
	private String city;
	
	/**
	 * phone No of College
	 *
	 */
	@Column(name="PHONENO", length=15)
	private String phoneNo;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getKey() {
		// TODO Auto-generated method stub
		return "";
	}

	public String getValue() {
		// TODO Auto-generated method stub
		return "";
	}
	
	
}
