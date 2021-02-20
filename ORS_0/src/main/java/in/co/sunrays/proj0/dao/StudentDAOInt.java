package in.co.sunrays.proj0.dao;

import java.util.List; 

import in.co.sunrays.proj0.dto.StudentDTO;

/**
 * 
 * Student DAO interface.
 * 
 * @author SessionFacade
 * @version 1.0 Copyright (c) SessionFacade
 */
public interface StudentDAOInt {

	/**
	 * Add a Student
	 * 
	 * @param dto:
	 * 				Object of StudentDTO
	 * @return pk:
	 * 				Primary Key
	 */
	public long add(StudentDTO dto);
	
	/**
	 * Update a Student
	 * 
	 * @param dto:
	 * 				Object of StudentDTO
	 */
	public void update(StudentDTO dto);
	
	/**
	 * Delete a Student
	 * 
	 * @param dto:
	 * 				Object of StudentDTO
	 */
	public void delete(StudentDTO dto);
	
	/**
	 * Find Student by Email
	 * 
	 * @param email:
	 * 				Email of Student
	 * @return dto:
	 * 				Object of StudentDTO
	 */
	public StudentDTO findByEmail(String email);
	
	/**
	 * Find Student by PK
	 * 
	 * @param pk:
	 * 				Primary Key
	 * @return dto:
	 * 				Object of StudentDTO
	 */
	public StudentDTO findByPK(long pk);
	
	/**
	 * Search Student with pagination
	 * 
	 * @param dto:
	 * 				Object of StudentDTO
	 * @param pageNo:
	 * 					PageNo
	 * @param pageSize:
	 * 					PageSize
	 * @return list:
	 * 				List of Student
	 */
	public List search(StudentDTO dto, int pageNo, int pageSize);
	
	/**
	 * Search Student 
	 * 
	 * @param dto:
	 * 				Object of StudentDTO
	 * @return list:
	 * 				List of Student
	 */
	public List search(StudentDTO dto);
}
