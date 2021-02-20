package in.co.sunrays.proj0.form;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

import in.co.sunrays.proj0.dto.BaseDTO;
import in.co.sunrays.proj0.dto.TimeTableDTO;
import in.co.sunrays.proj0.util.Util;

/**
 * Contains TimeTable form elements and their declarative input validations.
 * 
 * @author SessionFacade
 * @version 1.0 Copyright (c) SessionFacade
 * 
 */
public class TimeTableForm extends BaseForm{
	
	/**
	 * Subject of Time-Table
	 */
	@Min(value=1,message="{Min.form.subjectId}")
	private long subjectId;
	/**
	 * Subject Name of Time-Table
	 */
	
	private String subjectName;
	
	/**
	 * courseId of Time-Table
	 */
	@Min(value=1,message="{Min.form.courseId}")
	private long courseId;
	/**
	 * Course Name of Time-Table
	 */
	
	private String courseName;
	/**
	 * Exam Date of Time-Table
	 */
	@NotEmpty
	private String examDate;
	/**
	 * Exam Time of Time-Table
	 */
	@NotEmpty
	private String examTime;

	

	public long getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public long getCourseId() {
		return courseId;
	}
	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getExamDate() {
		return examDate;
	}
	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}
	public String getExamTime() {
		return examTime;
	}
	public void setExamTime(String examTime) {
		this.examTime = examTime;
	}
	
@Override
	public BaseDTO getDto() {
		TimeTableDTO dto=new TimeTableDTO();
		dto.setId(id);
		dto.setCourseId(courseId);
        dto.setCourseName(courseName);
        dto.setSubjectId(subjectId);
        dto.setSubjectName(subjectName);
		   if(examDate!=""){
			   dto.setExamDate(Util.getDate(examDate));
			 //  System.out.println("------------------------------"+examDate);
		        }
		dto.setExamTime(examTime);
		   dto.setCreatedBy(createdBy);
	       dto.setModifiedBy(modifiedBy);
	       dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
	       dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
		return dto;
	}



@Override
public void populate(BaseDTO bDto) {

	TimeTableDTO dto=(TimeTableDTO) bDto;
	id=dto.getId();
	courseId=dto.getCourseId();
	courseName=dto.getCourseName();
	subjectId=dto.getSubjectId();
	subjectName=dto.getSubjectName();
	examTime=dto.getExamTime();
	examDate=Util.getDate(dto.getExamDate()); 
			

	createdBy=dto.getCreatedBy();
   	modifiedBy=dto.getModifiedBy();
	  if (dto.getCreatedDatetime() != null) {
          createdDatetime = dto.getCreatedDatetime().getTime();
      }
      if (dto.getModifiedDatetime() != null) {
          modifiedDatetime = dto.getModifiedDatetime().getTime();
      }
	
}

}
