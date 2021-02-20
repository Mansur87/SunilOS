package in.co.sunrays.proj0.service;

import java.util.List;

import in.co.sunrays.proj0.dto.FacultyDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;

/**
 * Faculty Service interface.
 * 
 * @author SessionFacade
 * @version 1.0 Copyright (c) SessionFacade
 */
public interface FacultyServiceInt {

	/**
	 * Add a Faculty
	 * 
	 * @param dto:
	 * 				Object of FacultyDTO
	 * @return pk:
	 * 				Primary Key
	 * 
	 * @throws DuplicateRecordException when Faculty Email Id already exist.
	 */
	public long add(FacultyDTO dto)throws DuplicateRecordException;
	
	/**
	 * Update a Faculty
	 * 
	 * @param dto:
	 * 				Object of FacultyDTO
	 * 
	 * @throws DuplicateRecordException when Faculty Email Id already exist.
	 */
	public void update(FacultyDTO dto)throws DuplicateRecordException;
	
	/**
	 * Delete a Faculty
	 * 
	 * @param id:
	 * 				Primary Key
	 */
	public void delete(long id);
	
	/**
	 * Find faculty by email
	 * 
	 * @param email:
	 * 				Email of Faculty
	 * @return dto:
	 * 				Object of FacultyDTO
	 */
	public FacultyDTO findByEmail(String email);
	
	/**
	 * Find faculty by PK
	 * 
	 * @param pk:
	 * 				Primary Key
	 * @return dto:
	 * 				Object of FacultyDTO
	 */
	public FacultyDTO findByPK(long pk);
	
	/**
	 * Search faculty with pagination
	 * 
	 * @param dto:
	 * 				Object of FacultyDTO
	 * @param pageNo:
	 * 				PageNo
	 * @param pageSize:
	 * 					PageSize
	 * @return list:
	 * 				List of Faculty
	 */
	public List search(FacultyDTO dto, int pageNo, int pageSize);
	
	/**
	 * Search faculty
	 * 
	 * @param dto:
	 * 				Object of FacultyDTO
	 * @return list:
	 * 				List of Faculty
	 */
	public List search(FacultyDTO dto);
}
