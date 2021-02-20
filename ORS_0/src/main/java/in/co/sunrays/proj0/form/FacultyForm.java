package in.co.sunrays.proj0.form;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import in.co.sunrays.proj0.dto.BaseDTO;
import in.co.sunrays.proj0.dto.FacultyDTO;
import in.co.sunrays.proj0.util.Util;

/**
 * Contains Faculty form elements and their declarative input validations.
 * 
 * @author SessionFacade
 * @version 1.0 Copyright (c) SessionFacade
 */
public class FacultyForm extends BaseForm{
	
	/**
	 * Id OF Subject
	 *
	 */
	@Min(value=1,message="{Min.form.subjectId}")
	private long subjectId;
	

	/**
	 * Id OF FacultyCourse
	 *
	 */
	@Min(value=1,message="{Min.form.courseId}")
	private long courseId;
	/**
	 * Id OF College
	 *
	 */
	@Min(value=1,message="{Min.form.collegeId}")
	private long collegeId;
	/**
	 * SubjectName OF Faculty
	 *
	 */
	private String subjectName;
	/**
	 * CourseName Of Faculty
	 *
	 */
	
	private String courseName;
	/**
	 * Name Of College
	 *
	 */
	
	private String collegeName;
	/**
	 * Name Of Faculty First Name
	 *
	 */
	@NotEmpty
    @Custom(message = "{Custom.form.firstName}",regex = "[A-Za-z]+\\.?")

	private String firstName;
	/**
	 * Name Of Faculty Last Name
	 *
	 */
	@NotEmpty
	  @Custom(message = "{Custom.form.lastName}",regex = "^[a-zA-Z,.'-]+$")
	private String lastName;
	/**
	 * DOB Of Faculty
	 *
	 */
	@NotEmpty
	private String dob;
	/**
	 * MobileNo Of Faculty
	 *
	 */
	 @NotEmpty
	    @Custom(message = "{Custom.form.mobileno}",regex = "^[6-9]{1}[0-9]{9}$")
	private String mobileNo;
	/**
	 * EmailId Of Faculty
	 *
	 */
	 @Email
	 @NotEmpty
	private String emailId;
	/**
	 * Gender Of Faculty
	 *
	 */
	@NotEmpty
	private String gender;
	/**
	 * Password Of Faculty
	 *
	 */
	@NotEmpty
    /*@Custom(message = "{Custom.form.password}",regex = "^(?=.*[A-Za-z])(?=.*\\\\d)[A-Za-z\\\\d]{6,}$")*/

	private String password;
	/**
	 * Qualification Of Faculty
	 *
	 */
	@NotEmpty
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
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
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

	@Override
	public void populate(BaseDTO bDto) {
		FacultyDTO dto=(FacultyDTO) bDto;
		id=dto.getId();
		collegeId=dto.getCollegeId();
		collegeName=dto.getCollegeName();
		courseId=dto.getCourseId();
		courseName=dto.getCourseName();
		subjectId=dto.getSubjectId();
		subjectName=dto.getSubjectName();
		emailId=dto.getEmailId();
		firstName=dto.getFirstName();
		lastName=dto.getLastName();
		qualification=dto.getQualification();
		gender=dto.getGender();
		mobileNo=dto.getMobileNo();
		password=dto.getPassword();
		dob=Util.getDate(dto.getDob());
	    createdBy = dto.getCreatedBy();
	    modifiedBy = dto.getModifiedBy();
	        if (dto.getCreatedDatetime() != null) {
	            createdDatetime = dto.getCreatedDatetime().getTime();
	        }
	        if (dto.getModifiedDatetime() != null) {
	            modifiedDatetime = dto.getModifiedDatetime().getTime();
	        }
		
		
	}

	@Override
	public BaseDTO getDto() {
	FacultyDTO dto=new FacultyDTO();
	dto.setId(id);
	dto.setCollegeId(collegeId);
	dto.setCollegeName(collegeName);
	dto.setCourseId(courseId);
	dto.setCourseName(courseName);
	dto.setSubjectId(subjectId);
	dto.setSubjectName(subjectName);
	
	   if(dob!=""){
	        dto.setDob(Util.getDate(dob));
	        }
	dto.setEmailId(emailId);
	
	dto.setFirstName(firstName);
	dto.setLastName(lastName);
	dto.setGender(gender);
	dto.setMobileNo(mobileNo);
	dto.setPassword(password);
	dto.setQualification(qualification);
	   dto.setCreatedBy(createdBy);
       dto.setModifiedBy(modifiedBy);
       dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
       dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
	
		return dto;
	}

}
