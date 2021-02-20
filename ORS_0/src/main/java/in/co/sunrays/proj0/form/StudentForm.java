package in.co.sunrays.proj0.form;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import in.co.sunrays.proj0.dto.BaseDTO;
import in.co.sunrays.proj0.dto.StudentDTO;
import in.co.sunrays.proj0.util.Util;

/**
 * Contains Student form elements and their declarative input validations.
 * 
 * @author SessionFacade
 * @version 1.0 Copyright (c) SessionFacade
 */
public class StudentForm extends BaseForm{
	
	/**
	 * firstname of StudentForm
	 */
	    @NotEmpty
	    @Custom(message = "{Custom.form.firstName}",regex = "[A-Za-z]+\\.?")
	    private String firstName;
	    /**
	     * lastname of StudentForm
	     */
	    @Custom(message = "{Custom.form.lastName}",regex = "^[a-zA-Z,.'-]+$")

	    @NotEmpty
	    private String lastName;
	    /**
	     * dob of StudentForm
	     */
	    @NotEmpty
	    private String dob;
	    /**
	     * name of StudentForm
	     */
	    private String name; 
	    /**
	     * mobileNo of StudentForm
	     */
		@NotEmpty
	    @Custom(message = "{Custom.form.mobileno}",regex = "^[6-9]{1}[0-9]{9}$")
	    private String mobileNo;
		/**
		 * email of StudentForm
		 */
	    @NotEmpty
	    @Email
	    private String email;
	    /**
	     * collegeName of StudentForm
	     */
	    private String collegeName;
	    /**
	     * collegeId of StudentForm
	     */
	    @Min(value=1,message="{Min.form.collegeId}")
	    private Long collegeId;

	    public Long getCollegeId() {
	        return collegeId;
	    }

	    public void setCollegeId(Long collegeId) {
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

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }
	    
	    
	    public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	     @Override
	    public BaseDTO getDto() {
	        StudentDTO dto = new StudentDTO();
	        dto.setId(id);
	        dto.setFirstName(firstName);
	        dto.setLastName(lastName);
	        if(dob!=""){
	            dto.setDob(Util.getDate(dob));
	            }
	        dto.setMobileNo(mobileNo);
	        dto.setEmail(email);
	        
	        dto.setCollegeId(collegeId);
	        dto.setName(firstName+" "+lastName);
	        dto.setCreatedBy(createdBy);
	        dto.setModifiedBy(modifiedBy);
	        dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
	        dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
	        
	        return dto;
	    }

	    @Override
	    public void populate(BaseDTO bDto) {
	        StudentDTO dto = (StudentDTO) bDto;
	        System.out.println("----------------------------s--");
	        id = dto.getId();
	        firstName = dto.getFirstName();
	        lastName = dto.getLastName();
	        dob = Util.getDate(dto.getDob());
	        mobileNo = dto.getMobileNo();
	        email = dto.getEmail();
	        collegeId = dto.getCollegeId();
	        name=dto.getName();
	        createdBy = dto.getCreatedBy();
	        modifiedBy = dto.getModifiedBy();
	        if (dto.getCreatedDatetime() != null) {
	            createdDatetime = dto.getCreatedDatetime().getTime();
	        }
	        if (dto.getModifiedDatetime() != null) {
	            modifiedDatetime = dto.getModifiedDatetime().getTime();
	        }
	        System.out.println("----------------------------e--");
	    }

}
