package in.co.sunrays.proj0.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Value;

/**
 * Student POJO class. It is persistent object.
 * 
 * @author SessionFacade
 * @version 1.0 Copyright (c) SessionFacade
 *
 */
@Entity
@Table(name="ST_STUDENT")
public class StudentDTO extends BaseDTO{

	/**
	 * CollegeId of Student
	 */
	@Column(name="COLLEGE_ID")
	private long collegeId;
	
	/**
	 * CollegeName of Student
	 */
	@Column(name="COLLEGE_NAME", length=100)
	private String collegeName;
	
	/**
	 * FirstName of Student
	 */
	@Column(name="FIRST_NAME", length=50)
	private String firstName;
	
	/**
	 * LastName of Student
	 */
	@Column(name="LAST_NAME", length=50)
	private String lastName;
	
	/**
	 * DateOfBirth of Student
	 */
	@Column(name="DOB")
	private Date dob;
	
	/**
	 * MobileNo of Student
	 */
	@Column(name="MOBILE_NO",length=15)
	private String mobileNo;
	
	/**
	 * EmailId of Student
	 */
	@Column(name="EMAIL_ID",length=50)
	private String email;

	
	private String name = firstName +" "+lastName;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(long collegeId) {
		this.collegeId = collegeId;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getKey() {
		return id+"";
	}

	public String getValue() {
		return firstName+" "+lastName;
	}
	
	
}
