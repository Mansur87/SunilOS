package in.co.sunrays.proj0.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Cousre POJO class. It is persistent object.
 * 
 * @author SessionFacade
 * @version 1.0 Copyright (c) SessionFacade
 *
 */
@Entity
@Table(name="ST_COURSE")
public class CourseDTO extends BaseDTO{
	
	/**
	 * Name of course
	 */
	@Column(name="NAME", length=50)
	private String courseName;
	
	/**
	 * Duration of course
	 */
	@Column(name="DURATION",length=50)
	private String courseDuration;
	
	/**
	 * Description of course
	 */
	@Column(name="DESCRIPTION", length=50)
	private String courseDescription;

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(String courseDuration) {
		this.courseDuration = courseDuration;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public String getKey() {
		// TODO Auto-generated method stub
		return id+"";
	}

	public String getValue() {
		// TODO Auto-generated method stub
		return courseName;
	}
	
	

}
