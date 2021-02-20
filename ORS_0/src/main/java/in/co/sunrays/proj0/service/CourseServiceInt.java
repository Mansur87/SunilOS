package in.co.sunrays.proj0.service;

import java.util.List;

import in.co.sunrays.proj0.dto.CourseDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;

/**
 * Course Service interface.
 * 
 * @author SessionFacade
 * @version 1.0 Copyright (c) SessionFacade
 */
public interface CourseServiceInt {

	/**
	 * Add a Course
	 * 
	 * @param dto:
	 * 				Object of CourseDTO
	 * @return pk:
	 * 				Primary Key
	 * 
	 * @throws DuplicateRecordException when Course name already exist.
	 */
	public long add(CourseDTO dto)throws DuplicateRecordException;
	
	/**
	 * Update a Course
	 * 
	 * @param dto:
	 * 				Object of CourseDTO
	 * 
	 * @throws DuplicateRecordException when Course name already exist.
	 */
	public void update(CourseDTO dto)throws DuplicateRecordException;
	
	/**
	 * Delete a Course
	 * 
	 * @param id:
	 * 				Primary Key
	 */
	public void delete(long id);
	
	/**
	 * Find Course by Name
	 * 
	 * @param name:
	 * 				Name of Course
	 * @return dto:
	 * 				Object of CourseDTO
	 */
	public CourseDTO findByName(String name);
	
	/**
	 * Find Course by PK
	 * 
	 * @param id:
	 * 				Primary Key
	 * @return dto:
	 * 				Object of CourseDTO
	 */
	public CourseDTO findByPK(long id);
	
	/**
	 * Search Course
	 * 
	 * @param dto:
	 * 				Object of CourseDTO
	 * @return list:
	 * 				List of Course
	 */
	public List search(CourseDTO dto);
	
	/**
	 * Search Course with pagination
	 * 
	 * @param dto:
	 * 				Object of CourseDTO
	 * @param pageNo:
	 * 					PageNo
	 * @param pageSize:
	 * 					PageSize
	 * @return list:
	 * 				List of Course
	 */
	public List search(CourseDTO dto, int pageNo, int pageSize);
}
