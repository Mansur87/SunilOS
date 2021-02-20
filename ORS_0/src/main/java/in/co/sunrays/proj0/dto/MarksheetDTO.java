package in.co.sunrays.proj0.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Marksheet POJO class. It is persistent object.
 * @author SessionFacade
 * @version 1.0 Copyright (c) SessionFacade
 */
@Entity
@Table(name="ST_MARKSHEET")
public class MarksheetDTO extends BaseDTO{

	/**
	 * Roll No of Marksheet
	 */
	@Column(name="ROLL_NO", length=50)
	private String rollNo;
	
	/**
	 * StudentId of Marksheet
	 */
	@Column(name="STUDENT_ID")
	private long studentId;
	
	/**
	 * StudentName of Marksheet
	 */
	@Column(name="STUDENT_NAME", length=50)
	private String studentName;
	
	/**
	 * Maths marks of Marksheet
	 */
	@Column(name="MATHS")
	private Integer maths;
	
	/**
	 * Physics marks of Marksheet
	 */
	@Column(name="PHYSICS")
	private Integer physics;
	
	/**
	 * Chemistry marks of Marksheet
	 */
	@Column(name="CHEMISTRY")
	private Integer chemistry;

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Integer getMaths() {
		return maths;
	}

	public void setMaths(Integer maths) {
		this.maths = maths;
	}

	public Integer getPhysics() {
		return physics;
	}

	public void setPhysics(Integer physics) {
		this.physics = physics;
	}

	public Integer getChemistry() {
		return chemistry;
	}

	public void setChemistry(Integer chemistry) {
		this.chemistry = chemistry;
	}

	public String getKey() {
		// TODO Auto-generated method stub
		return id+"";
	}

	public String getValue() {
		// TODO Auto-generated method stub
		return rollNo;
	}
	
}
