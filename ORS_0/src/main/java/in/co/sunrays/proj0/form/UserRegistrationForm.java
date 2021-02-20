package in.co.sunrays.proj0.form;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import in.co.sunrays.proj0.dto.BaseDTO;

import in.co.sunrays.proj0.dto.UserDTO;
import in.co.sunrays.proj0.util.Util;

/**
 * Contains User Registration form elements and their declarative input
 * validations.
 * @author SessionFacade
 * @version 1.0 Copyright (c) SessionFacade
 * 
 */
public class UserRegistrationForm extends BaseForm{
	
	@NotEmpty
	@Custom(message = "{Custom.form.firstName}",regex = "[A-Za-z]+\\.?")
    private String firstName;
    /**
     * Last Name of User
     */
    @NotEmpty
    @Custom(message = "{Custom.form.lastName}",regex = "^[a-zA-Z,.'-]+$")
    private String lastName;

    @Email
    @NotEmpty
    private String login;
    /**
     * Password of User
     */
    @NotEmpty
    /*@Custom(message = "{Custom.form.password}",regex = "^(?=.*[A-Za-z])(?=.*\\\\d)[A-Za-z\\\\d]{6,}$")*/
    private String password;

    /**
     * Date of Birth of User
     */
    @NotEmpty
    private String dob;

    /**
     * MobielNo of User
     */
    @NotEmpty
    @Custom(message = "{Custom.form.mobileno}",regex = "^[6-9]{1}[0-9]{9}$")
    private String mobileNo;

    /**
     * Gender of User
     */
    @NotEmpty
    private String gender;

    @NotEmpty
    private String rePassword;
    public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public BaseDTO getDto() {
        UserDTO dto = new UserDTO();

        dto.setId(id);
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        dto.setLogin(login);
        dto.setPassword(password);
        dto.setDob(Util.getDate(dob));
        dto.setMobileNo(mobileNo);
        dto.setGender(gender);
        dto.setRePassword(rePassword);
        return dto;
    }
    
    @Override
    public void populate(BaseDTO bDto) {
        UserDTO dto = (UserDTO) bDto;
        id = dto.getId();
        firstName = dto.getFirstName();
        lastName = dto.getLastName();
        login = dto.getLogin();
        password = dto.getPassword();
        dob = Util.getDate(dto.getDob());
        mobileNo = dto.getMobileNo();
        gender = dto.getGender();
        rePassword=dto.getRePassword();
    }

}
