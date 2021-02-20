package in.co.sunrays.proj0.service;

import java.util.List;

import in.co.sunrays.proj0.dto.StudentDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;

/**
 * Student Service Interface
 * 
 * @author SessionFacade
 * @version 1.0 Copyright (c) SessionFacade
 */
public interface StudentServiceInt {

	/**
	 * Add a student 
	 * 
	 * @param dto:
	 * 				Object of StudentDTO
	 * @return pk:
	 * 				Primary Key
	 * 
	 * @throws DuplicateRecordException when Student EmailId already exist.
	 */
	public long add(StudentDTO dto)throws DuplicateRecordException;
	
	/**
	 * Update a Student
	 * 
	 * @param dto:
	 * 				Object of StudentDTO
	 * 
	 * @throws DuplicateRecordException when Student EmailId already exist.
	 */
	public void update(StudentDTO dto)throws DuplicateRecordException;
	
	/**
	 * Delete a Student
	 * 
	 * @param id:
	 * 				Primary key
	 */
	public void delete(long id);
	
	/**
	 * Find Student by email
	 * 
	 * @param email:
	 * 				Email id of Student
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
	 * Search student with pagination
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
