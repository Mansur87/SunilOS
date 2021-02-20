package in.co.sunrays.proj0.form;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

import in.co.sunrays.proj0.dto.BaseDTO;
import in.co.sunrays.proj0.dto.MarksheetDTO;

/**
 * Contains Marksheet form elements and their declarative input validations.
 * 
 * @author SessionFacade
 * @version 1.0
 * 
 */
public class MarksheetForm extends BaseForm{
	
	/**
	 * ROLLNO of Marksheet
	 *
	 */
	@NotEmpty
	@Custom(message = "{Custom.form.rollno}",regex = "([0-9]{2,})+([A-Za-z]{2,})+([0-9]{2,})")
	private String rollNo;
	/**
	 * studentId of Marksheet
	 *
	 */
	@Min(value=1,message=("Min.form.studentId"))
	private long studentId;
	/**
	 * studentName of Marksheet
	 *
	 */
	
	private String studentName;
	/**
	 * mathsMarks of Marksheet
	 *
	 */
	
	@Min(0)
	@Max(100)
	
    private Integer maths;
	/**
	 * physicsMarks of Marksheet
	 *
	 */
	@Min(0)
	@Max(100)    
	private Integer physics;
	/**
	 * chemistryMarks of Marksheet
	 *
	 */
	@Min(0)
	@Max(100)    
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

	@Override
	public BaseDTO getDto() {
		MarksheetDTO dto=new MarksheetDTO();
		dto.setId(id);
		dto.setRollNo(rollNo);
		dto.setStudentId(studentId);
		dto.setStudentName(studentName);
		dto.setMaths(maths);
		dto.setChemistry(chemistry);
		dto.setPhysics(physics);
		 dto.setCreatedBy(createdBy);
	       dto.setModifiedBy(modifiedBy);
	       dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
	       dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
	
		return dto;
	}
	
	@Override
	public void populate(BaseDTO bDto) {
		MarksheetDTO dto=(MarksheetDTO) bDto;
		id=dto.getId();
		rollNo=dto.getRollNo();
		studentId=dto.getStudentId();
		studentName=dto.getStudentName();
		maths=dto.getMaths();
		chemistry=dto.getChemistry();
		physics=dto.getPhysics();
		
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
