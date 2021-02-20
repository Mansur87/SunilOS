package in.co.sunrays.proj0.form;

import java.sql.Timestamp; 
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import in.co.sunrays.proj0.dto.BaseDTO;
import in.co.sunrays.proj0.dto.CollegeDTO;

/**
 * Contains College form elements and their declarative input validations.
 * 
 * @author SessionFacade
 * @version 1.0 Copyright (c) SessionFacade
 */
public class CollegeForm extends BaseForm{
	
	/**
	 * name of college
	 *
	 */	
    @NotEmpty
    private String name;
    /**
	 * address of college
	 *
	 */	
    @NotEmpty
    private String address;
    /**
	 * state of college
	 *
	 */	
    @NotEmpty
    private String state;
    /**
	 * city of college
	 *
	 */	
    @NotEmpty
    private String city;
    /**
	 * phoneNo of college
	 *
	 */	
    @NotNull
    @Custom(message = "{Custom.form.mobileno}",regex = "^[6-9]{1}[0-9]{9}$")
    private String phoneNo;
    /**
	 * message of college
	 *
	 */	
    private String message;

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Populate dto from form
     */
    @Override
    public BaseDTO getDto() {
        CollegeDTO dto = new CollegeDTO();
        dto.setId(id);
        dto.setName(name);
        dto.setAddress(address);
        dto.setCity(city);
        dto.setState(state);
        dto.setPhoneNo(phoneNo);
        dto.setCreatedBy(createdBy);
        dto.setModifiedBy(modifiedBy);
        dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
        dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
        return dto;
    }

    /**
     * Populate from from dto
     */
    @Override
    public void populate(BaseDTO bDto) {
        CollegeDTO dto = (CollegeDTO) bDto;
        id = dto.getId();
        name = dto.getName();
        address = dto.getAddress();
        city = dto.getCity();
        state = dto.getState();
        phoneNo = dto.getPhoneNo();
        createdBy = dto.getCreatedBy();
        modifiedBy = dto.getModifiedBy();
        createdDatetime = dto.getCreatedDatetime().getTime();
        modifiedDatetime = dto.getModifiedDatetime().getTime();
    }

}
