package in.co.sunrays.proj0.form;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import in.co.sunrays.proj0.dto.BaseDTO;
import in.co.sunrays.proj0.dto.UserDTO;
import in.co.sunrays.proj0.util.Util;

/**
 * Contains MyProfile form elements and their declarative input validations.
 * 
 * @author SessionFacade
 * @version 1.0 Copyright (c) SessionFacade 
 */
public class MyProfileForm extends BaseForm{
	
	/**
	 * firstName of MyProfileForm
	 */
	    @NotEmpty
	    private String firstName;
	    /**
		 * lastName of MyProfileForm
		 */
	    @NotEmpty
	    private String lastName;
	    /**
		 * login of MyProfileForm
		 */
	    @NotEmpty
	    private String login;
	    /**
		 * gender of MyProfileForm
		 */
	    @NotEmpty
	    private String gender;
	    /**
		 * mobileNo of MyProfileForm
		 */
	    @NotEmpty
	    @Pattern(regexp = "\\d{10}", message = "{Pattern.form.phoneNo}")
	    private String mobileNo;
	    /**
		 * dob of MyProfileForm
		 */
	    @NotEmpty
	    private String dob;
		
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
		public String getLogin() {
			return login;
		}
		public void setLogin(String login) {
			this.login = login;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getMobileNo() {
			return mobileNo;
		}
		public void setMobileNo(String mobileNo) {
			this.mobileNo = mobileNo;
		}
		public String getDob() {
			return dob;
		}
		public void setDob(String dob) {
			this.dob = dob;
		}

	    @Override
	    public BaseDTO getDto() {
	        UserDTO dto = new UserDTO();
	        dto.setId(id);
	        dto.setFirstName(firstName);
	        dto.setLastName(lastName);
	        dto.setLogin(login);
	        dto.setDob(Util.getDate(dob));
	        dto.setMobileNo(mobileNo);
	        dto.setGender(gender);
	      
	        return dto;
	    }

	    @Override
	    public void populate(BaseDTO bDto) {
	        UserDTO dto = (UserDTO) bDto;
	        id = dto.getId();
	        firstName = dto.getFirstName();
	        lastName = dto.getLastName();
	        login = dto.getLogin();
	        dob = Util.getDate(dto.getDob());
	        mobileNo = dto.getMobileNo();
	        gender = dto.getGender();
	        
	        super.populate(bDto);
	    }

}
