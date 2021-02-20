package in.co.sunrays.proj0.dao;

import java.util.List;

import in.co.sunrays.proj0.dto.CourseDTO;

/**
 * Course DAO interface.
 * 
 * @author SessionFacade
 * @version 1.0 Copyright (c) SessionFacade
 */
public interface CourseDAOInt {

	/**
	 * Add a Course
	 * 
	 * @param dto:
	 * 				Object of CourseDTO
	 * @return pk:
	 * 				Primary Key
	 */
	public long add(CourseDTO dto);
	
	/**
	 * Update a Course
	 * 
	 * @param dto:
	 * 				Object of CourseDTO
	 */
	public void update(CourseDTO dto);
	
	/**
	 * Delete a Course
	 * 
	 * @param dto:
	 * 				Object of CourseDTO
	 */
	public void delete(CourseDTO dto);
	
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
	 * @param pk:
	 * 				Primary Key
	 * @return dto:
	 * 				Object of CourseDTO
	 */
	public CourseDTO findByPK(long pk);
	
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
	 * 				PageNo
	 * @param pageSize:
	 * 					PageSize
	 * @return list:
	 * 				List of Course
	 */
	public List search(CourseDTO dto, int pageNo, int pageSize);
}
