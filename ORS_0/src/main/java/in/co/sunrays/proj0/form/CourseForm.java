package in.co.sunrays.proj0.form;

import java.sql.Timestamp; 
import java.util.Date;

import javax.persistence.Column;

import org.hibernate.validator.constraints.NotEmpty;

import in.co.sunrays.proj0.dto.BaseDTO;
import in.co.sunrays.proj0.dto.CourseDTO;

/**
 * Contains Course form elements and their declarative input validations.
 * 
 * @author SessionFacade
 * @version 1.0 Copyright (c) SessionFacade
 */
public class CourseForm extends BaseForm{
	
	/**
	 * courseName of course
	 *
	 */	
	@NotEmpty
	@Column(name = "NAME", length = 50)
    private String courseName;
	/**
	 * courseDuration of course
	 *
	 */	
	@NotEmpty
    @Column(name = "DURATION", length = 70)
    private String courseDuration;
	/**
	 * coursedescription of course
	 *
	 */	
	@NotEmpty
    @Column(name = "DESCRIPTION", length = 70)
    private String courseDescription;

	public String getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(String courseDuration) {
		this.courseDuration = courseDuration;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	@Override
    public BaseDTO getDto() {
    	CourseDTO dto=new CourseDTO();
    	dto.setId(id);
    	dto.setCourseName(courseName);
    	dto.setCourseDuration(courseDuration);
        dto.setCourseDescription(courseDescription);
        dto.setCreatedBy(createdBy);
        dto.setModifiedBy(modifiedBy);
        dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
        dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
    	return dto;
    }

    @Override
    public void populate(BaseDTO bDto) {
       CourseDTO dto=(CourseDTO) bDto;
    	  id=dto.getId();
    	  courseName=dto.getCourseName();
    	  courseDuration=dto.getCourseDuration();
    	  courseDescription=dto.getCourseDescription();
    	  createdBy = dto.getCreatedBy();
          modifiedBy = dto.getModifiedBy();
          createdDatetime = dto.getCreatedDatetime().getTime();
          modifiedDatetime = dto.getModifiedDatetime().getTime();
    }

}
