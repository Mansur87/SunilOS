package in.co.sunrays.proj0.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.sunrays.proj0.dao.TimeTableDAOInt;
import in.co.sunrays.proj0.dto.CourseDTO;
import in.co.sunrays.proj0.dto.SubjectDTO;
import in.co.sunrays.proj0.dto.TimeTableDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;
import in.co.sunrays.proj0.util.Util;

/**
 * TimeTable Service interface.
 * 
 * @author SessionFacade
 * @version 1.0 Copyright (c) SessionFacade
 */
@Service("TimeTableService")
public class TimeTableServiceSpringImpl implements TimeTableServiceInt{
	
	@Autowired
	private TimeTableDAOInt dao;
	
	@Autowired
	private CourseServiceInt courseService;
	
	@Autowired
	private SubjectServiceInt subjectService;
	
	public static Logger log = Logger.getLogger(TimeTableServiceSpringImpl.class);

	/**
	 * Add a TimeTable
	 * 
	 * @param dto:
	 * 				Object of TimeTableDTO
	 * @return pk:
	 * 				Primary Key
	 * 
	 * @throws DuplicateRecordException when TimeTable already exist.
	 */
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public long add(TimeTableDTO dto) throws DuplicateRecordException {
		log.debug("TimeTableServiceSpringImpl add method started");
		CourseDTO courseDTO = courseService.findByPK(dto.getCourseId());
		dto.setCourseName(courseDTO.getCourseName());
		SubjectDTO subjectDTO = subjectService.findByPK(dto.getSubjectId());
		dto.setSubjectName(subjectDTO.getSubjectName());
		
		TimeTableDTO existByNameDto = dao.findByName(dto.getCourseName(), dto.getSubjectName());
		TimeTableDTO existByNameDateDto = dao.findByNameDate(dto.getCourseName(), dto.getExamDate());
		TimeTableDTO existByNameDateTimeDto = dao.findByNameDateTime(dto.getCourseName(), dto.getSubjectName(), dto.getExamDate(), dto.getExamTime());
		
		if(existByNameDto!=null) {
			throw new DuplicateRecordException("course:-"+dto.getCourseName()+" and subject:-"+dto.getSubjectName()+" already exist");
		}
		if(existByNameDateDto!=null) {
			throw new DuplicateRecordException("course:-"+dto.getCourseName()+" and exam date:-"+Util.getDate(dto.getExamDate())+" already exist");
		}
		if(existByNameDateTimeDto!=null) {
			throw new DuplicateRecordException("TimeTable already exist");
		}
		long pk = dao.add(dto);
		log.debug("TimeTableServiceSpringImpl add method ended");
		return pk;
	}

	/**
	 * Update a TimeTable
	 * 
	 * @param dto:
	 * 				Object of TimeTableDTO
	 * 
	 * @throws DuplicateRecordException when TimeTable already exist.
	 */
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void update(TimeTableDTO dto) throws DuplicateRecordException {
		log.debug("TimeTableServiceSpringImpl update method started");
		CourseDTO courseDTO = courseService.findByPK(dto.getCourseId());
		dto.setCourseName(courseDTO.getCourseName());
		SubjectDTO subjectDTO = subjectService.findByPK(dto.getSubjectId());
		dto.setSubjectName(subjectDTO.getSubjectName());
		
		TimeTableDTO existByNameDto = dao.findByName(dto.getCourseName(), dto.getSubjectName());
		TimeTableDTO existByNameDateDto = dao.findByNameDate(dto.getCourseName(), dto.getExamDate());
		TimeTableDTO existByNameDateTimeDto = dao.findByNameDateTime(dto.getCourseName(), dto.getSubjectName(), dto.getExamDate(), dto.getExamTime());
		
		if(existByNameDto!=null && existByNameDto.getId()!=dto.getId()) {
			throw new DuplicateRecordException("course:-"+dto.getCourseName()+" and subject:-"+dto.getSubjectName()+" already exist");
		}
		if(existByNameDateDto!=null && existByNameDateDto.getId()!=dto.getId()) {
			throw new DuplicateRecordException("course:-"+dto.getCourseName()+" and exam date:-"+Util.getDate(dto.getExamDate())+" already exist");
		}
		if(existByNameDateTimeDto!=null && existByNameDateTimeDto.getId()!=dto.getId()) {
			throw new DuplicateRecordException("TimeTable already exist");
		}
		dao.update(dto);
		log.debug("TimeTableServiceSpringImpl update method ended");
	}

	/**
	 * Delete a TimeTable
	 * 
	 * @param id:
	 * 				Primary Key
	 */
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void delete(long id) {
		log.debug("TimeTableServiceSpringImpl delete method started");
		TimeTableDTO dto = dao.findByPK(id);
		dao.delete(dto);
		log.debug("TimeTableServiceSpringImpl delete method ended");
	}

	/**
	 * Find TimeTable by PK
	 * 
	 * @param pk:
	 * 				Primary Key
	 * @return dto:
	 * 				Object of TimeTableDTO
	 */
	@Transactional(readOnly=true)
	public TimeTableDTO findByPK(long pk) {
		log.debug("TimeTableServiceSpringImpl findByPK method started");
		TimeTableDTO dto = dao.findByPK(pk);
		log.debug("TimeTableServiceSpringImpl findByPK method ended");
		return dto;
	}

	/**
	 * Search TimeTable
	 * 
	 * 
	 * @param dto:
	 * 				Object of TimeTableDTO
	 * @return list:
	 * 				List of TimeTable
	 */
	@Transactional(readOnly=true)
	public List search(TimeTableDTO dto) {
		log.debug("TimeTableServiceSpringImpl search method started");
		List list = dao.search(dto);
		log.debug("TimeTableServiceSpringImpl search method ended");
		return list;
	}

	/**
	 * Search TimeTable with pagination
	 * 
	 * @param dto:
	 * 				Object of TimeTableDTO
	 * @param pageNo:
	 * 					PageNo
	 * @param pageSize:
	 * 					PageSize
	 * @return list:
	 * 				List of TimeTable
	 */
	@Transactional(readOnly=true)
	public List search(TimeTableDTO dto, int pageNo, int pageSize) {
		log.debug("TimeTableServiceSpringImpl search method started");
		List list = dao.search(dto, pageNo, pageSize);
		log.debug("TimeTableServiceSpringImpl search method ended");
		return list;
	}

}
