package in.co.sunrays.proj0.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Faculty POJO class. It is persistent object.
 * 
 * @author SessionFacade
 * @version 1.0 Copyright (c) SessionFacade
 *
 */
@Entity
@Table(name="ST_FACULTY")
public class FacultyDTO extends BaseDTO{

	/**
	 * ID of Faculty Subject
	 */
	@Column(name="SUBJECT_ID")
	private long subjectId;
	
	/**
	 * ID of Faculty Course
	 */
	@Column(name="COURSE_ID")
	private long courseId;
	
	/**
	 * ID of Faculty College
	 */
	@Column(name="COLLEGE_ID")
	private long collegeId;
	
	/**
	 * SubjectName of Faculty
	 */
	@Column(name="SUBJECT_NAME", length=50)
	private String subjectName;
	
	/**
	 * CourseName of Faculty
	 */
	@Column(name="COURSE_NAME", length=50)
	private String courseName;
	
	/**
	 * CollegeName of Faculty
	 */
	@Column(name="COLLEGE_NAME", length=50)
	private String collegeName;
	
	/**
	 * FirstName of Faculty
	 */
	@Column(name="FIRST_NAME", length=50)
	private String firstName;
	
	/**
	 * LastName of Faculty
	 */
	@Column(name="LAST_NAME", length=50)
	private String lastName;
	
	/**
	 * DOB of Faculty
	 */
	@Column(name="DOB")
	private Date dob;
	
	/**
	 * MobileNo of Faculty
	 */
	@Column(name="MOBILE_NO", length=15)
	private String mobileNo;
	
	/**
	 * EmailId of Faculty
	 */
	@Column(name="EMAIL_ID", length=50)
	private String emailId;
	
	/**
	 * Gender of Faculty
	 */
	@Column(name="GENDER", length=10)
	private String gender;
	
	/**
	 * Password of Faculty
	 */
	@Column(name="PASSWORD", length=50)
	private String password;
	
	/**
	 * Qualification of Faculty
	 */
	@Column(name="QUALIFICATION" ,length=50)
	private String qualification;

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public long getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(long collegeId) {
		this.collegeId = collegeId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getKey() {
		// TODO Auto-generated method stub
		return id+"";
	}

	public String getValue() {
		// TODO Auto-generated method stub
		return firstName+" "+lastName;
	}
	
	
}
