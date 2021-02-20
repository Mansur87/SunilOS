package in.co.sunrays.proj0.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * TimeTable POJO class. It is persistent object.
 * 
 * @author SessionFacade
 * @version 1.0 Copyright (c) SessionFacade
 *
 */
@Entity
@Table(name="ST_TIMETABLE")
public class TimeTableDTO extends BaseDTO{

	/**
	 * SubjectID of TimeTable
	 */
	@Column(name="SUBJECT_ID")
	private long subjectId;
	
	/**
	 * SubjectName of TimeTable
	 */
	@Column(name="SUBJECT_NAME",length=50)
	private String subjectName;
	
	/**
	 * CourseID of TimeTable
	 */
	@Column(name="COURSE_ID")
	private long courseId;
	
	/**
	 * CourseName of TimeTable
	 */
	@Column(name="COURSE_NAME", length=50)
	private String courseName;
	
	/**
	 * ExamDate of TimeTable
	 */
	@Column(name="EXAM_DATE")
	private Date examDate;
	
	/**
	 * ExamTime of TimeTable
	 */
	@Column(name="EXAM_TIME",length=50)
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

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	public String getExamTime() {
		return examTime;
	}

	public void setExamTime(String examTime) {
		this.examTime = examTime;
	}

	public String getKey() {
		// TODO Auto-generated method stub
		return id+"";
	}

	public String getValue() {
		// TODO Auto-generated method stub
		return examDate+"";
	}
	
	
}
