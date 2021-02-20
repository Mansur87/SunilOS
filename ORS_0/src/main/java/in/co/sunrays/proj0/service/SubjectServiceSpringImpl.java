package in.co.sunrays.proj0.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.sunrays.proj0.dao.SubjectDAOInt;
import in.co.sunrays.proj0.dto.CourseDTO;
import in.co.sunrays.proj0.dto.SubjectDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;

/**
 * Subject Service interface.
 * 
 * @author SessionFacade
 * @version 1.0 Copyright (c) SessionFacade
 */
@Service("subjectService")
public class SubjectServiceSpringImpl implements SubjectServiceInt{

	@Autowired
	private SubjectDAOInt dao;
	
	@Autowired
	CourseServiceInt courseService;
	
	public static Logger log = Logger.getLogger(SubjectServiceSpringImpl.class);

	/**
	 * Add a Subject
	 * 
	 * @param dto:
	 * 				Object of SubjectDTO
	 * @return pk:
	 * 				Primary Key
	 * 
	 * @throws DuplicateRecordException when Subject name already exist.
	 */
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public long add(SubjectDTO dto) throws DuplicateRecordException {
		log.debug("SubjectServiceSpringImpl add method started");
		SubjectDTO existDto = dao.findByName(dto.getSubjectName());
		if(existDto!=null) {
			throw new DuplicateRecordException("Subject name already exist");
		}
		CourseDTO courseDTO = courseService.findByPK(dto.getCourseId());
		dto.setCourseName(courseDTO.getCourseName());
		long pk = dao.add(dto);
		log.debug("SubjectServiceSpringImpl add method ended");
		return pk;
	}

	/**
	 * Update a Subject
	 * 
	 * @param dto:
	 * 				Object of SubjectDTO
	 * 
	 * @throws DuplicateRecordException when Subject name already exist.
	 */
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void update(SubjectDTO dto) throws DuplicateRecordException {
		log.debug("SubjectServiceSpringImpl update method started");
		SubjectDTO existDto = dao.findByName(dto.getSubjectName());
		if(existDto!=null && existDto.getId()!=dto.getId()) {
			throw new DuplicateRecordException("Subject name already exist");
		}
		CourseDTO courseDTO=courseService.findByPK(dto.getCourseId());
		dto.setCourseName(courseDTO.getCourseName());
		dao.update(dto);
		log.debug("SubjectServiceSpringImpl update method ended");
	}

	/**
	 * Delete a Subject
	 * 
	 * @param id:
	 * 				Primary Key
	 */
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void delete(long id) {
		log.debug("SubjectServiceSpringImpl delete method started");
		SubjectDTO dto = dao.findByPK(id);
		dao.delete(dto);
		log.debug("SubjectServiceSpringImpl delete method ended");
	}

	/**
	 * Find Subject by Name
	 * 
	 * @param name:
	 * 				Subject Name
	 * @return dto:
	 * 				Object of SubjectDTO
	 */
	@Transactional(readOnly=true)
	public SubjectDTO findByName(String name) {
		log.debug("SubjectServiceSpringImpl findByName method started");
		SubjectDTO dto = dao.findByName(name);
		log.debug("SubjectServiceSpringImpl findByName method ended");
		return dto;
	}

	/**
	 * Find Subject by PK
	 * 
	 * @param id:
	 * 				Primary Key
	 * @return dto:
	 * 				Object of SubjectDTO
	 */
	public SubjectDTO findByPK(long id) {
		log.debug("SubjectServiceSpringImpl findByPK method started");
		SubjectDTO dto = dao.findByPK(id);
		log.debug("SubjectServiceSpringImpl findByPK method ended");
		return dto;
	}

	/**
	 * Search Subject
	 * 
	 * @param dto:
	 * 				Object of SubjectDTO
	 * @return list:
	 * 				List of Subject
	 */
	public List search(SubjectDTO dto) {
		log.debug("SubjectServiceSpringImpl search method started");
		List list = dao.search(dto);
		log.debug("SubjectServiceSpringImpl search method ended");
		return list;
	}

	/**
	 * Search Subject with pagination
	 * 
	 * @param dto:
	 * 				Object of SubjectDTO
	 * @param pageNo:
	 * 					PageNo
	 * @param pageSize:
	 * 					PageSize
	 * @return:
	 * 			List of Subject
	 */
	public List search(SubjectDTO dto, int pageNo, int pageSize) {
		log.debug("SubjectServiceSpringImpl search method started");
		List list = dao.search(dto, pageNo, pageSize);
		log.debug("SubjectServiceSpringImpl search method ended");
		return list;
	}
}
