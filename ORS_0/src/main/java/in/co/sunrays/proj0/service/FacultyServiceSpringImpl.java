package in.co.sunrays.proj0.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.sunrays.proj0.dao.FacultyDAOInt;
import in.co.sunrays.proj0.dto.CollegeDTO;
import in.co.sunrays.proj0.dto.CourseDTO;
import in.co.sunrays.proj0.dto.FacultyDTO;
import in.co.sunrays.proj0.dto.SubjectDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;

@Service("facultyService")
public class FacultyServiceSpringImpl implements FacultyServiceInt{

	@Autowired
	private FacultyDAOInt dao;
	
	@Autowired
	private CollegeServiceInt collegeService;
	
	@Autowired
	private CourseServiceInt courseService;
	
	@Autowired
	private SubjectServiceInt subjectService;
	
	public static Logger log = Logger.getLogger(FacultyServiceSpringImpl.class);

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public long add(FacultyDTO dto) throws DuplicateRecordException {
		log.debug("FacultyServiceSpringImpl add method started");
		FacultyDTO existDto = dao.findByEmail(dto.getEmailId());
		if(existDto!=null) {
			throw new DuplicateRecordException("EmailId already exist");
		}
		CollegeDTO collegeDTO = collegeService.findByPK(dto.getCollegeId());
		dto.setCollegeName(collegeDTO.getName());
		CourseDTO courseDTO = courseService.findByPK(dto.getCourseId());
		dto.setCourseName(courseDTO.getCourseName());
		SubjectDTO subjectDTO = subjectService.findByPK(dto.getSubjectId());
		dto.setSubjectName(subjectDTO.getSubjectName());
		long pk = dao.add(dto);
		log.debug("FacultyServiceSpringImpl add method ended");
		return pk;
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void update(FacultyDTO dto) throws DuplicateRecordException {
		log.debug("FacultyServiceSpringImpl update method started");
		FacultyDTO existDto = dao.findByEmail(dto.getEmailId());
		if(existDto!=null && existDto.getId()!=dto.getId()) {
			throw new DuplicateRecordException("EmailId already exist");
		}
		CollegeDTO collegeDTO = collegeService.findByPK(dto.getCollegeId());
		dto.setCollegeName(collegeDTO.getName());
		CourseDTO courseDTO = courseService.findByPK(dto.getCourseId());
		dto.setCourseName(courseDTO.getCourseName());
		SubjectDTO subjectDTO = subjectService.findByPK(dto.getSubjectId());
		dto.setSubjectName(subjectDTO.getSubjectName());
		dao.update(dto);
		log.debug("FacultyServiceSpringImpl update method ended");
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void delete(long id) {
		log.debug("FacultyServiceSpringImpl delete method started");
		FacultyDTO dto = dao.findByPK(id);
		dao.delete(dto);
		log.debug("FacultyServiceSpringImpl delete method ended");
	}

	@Transactional(readOnly=true)
	public FacultyDTO findByEmail(String email) {
		log.debug("FacultyServiceSpringImpl findByEmail method started");
		FacultyDTO dto = dao.findByEmail(email);
		log.debug("FacultyServiceSpringImpl findByEmail method ended");
		return dto;
	}

	@Transactional(readOnly=true)
	public FacultyDTO findByPK(long pk) {
		log.debug("FacultyServiceSpringImpl findByPK method started");
		FacultyDTO dto = dao.findByPK(pk);
		log.debug("FacultyServiceSpringImpl findByPK method ended");
		return dto;
	}

	public List search(FacultyDTO dto, int pageNo, int pageSize) {
		log.debug("FacultyServiceSpringImpl search method started");
		List list = dao.search(dto, pageNo, pageSize);
		log.debug("FacultyServiceSpringImpl search method ended");
		return list;
	}

	public List search(FacultyDTO dto) {
		log.debug("FacultyServiceSpringImpl search method started");
		List list = dao.search(dto);
		log.debug("FacultyServiceSpringImpl search method ended");
		return null;
	}
	
	
}
