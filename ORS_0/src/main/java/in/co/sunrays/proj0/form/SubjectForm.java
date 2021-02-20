package in.co.sunrays.proj0.form;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

import in.co.sunrays.proj0.dto.BaseDTO;
import in.co.sunrays.proj0.dto.SubjectDTO;

/**
 * Contains Subject form elements and their declarative input validations.
 * 
 * @author SessionFacade
 * @version 1.0 Copyright (c) SessionFacade
 */
public class SubjectForm extends BaseForm{
	
	/**
	 * name of SubjectForm
	 */
		@NotEmpty
		private String subjectName;
		
	/**
	 * courseId of SubjectForm
	 */		
		@Min(value=1,message="{Min.form.courseId}")
		private long courseId;
		
	/**
	 * courseName of SubjectForm
	 */
	
		private String courseName;
		
	/**
	 * description of SubjectForm
	 */
		@NotEmpty
		private String description;

		

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

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		@Override
		public BaseDTO getDto() {
		SubjectDTO dto=new SubjectDTO();
		dto.setId(id);
		dto.setSubjectName(subjectName);
        dto.setCourseId(courseId);
        /*dto.setCourseName(courseName);*/
        dto.setDescription(description);
        dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
        dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
		
		return dto;
		}
		
		@Override
		public void populate(BaseDTO bDto) {
		SubjectDTO dto=(SubjectDTO) bDto;
		id=dto.getId();
		subjectName=dto.getSubjectName();
		courseId=dto.getCourseId();
		description=dto.getDescription();
		createdBy = dto.getCreatedBy();
	    modifiedBy = dto.getModifiedBy();
	    createdDatetime = dto.getCreatedDatetime().getTime();
	    modifiedDatetime = dto.getModifiedDatetime().getTime();
		}

}
