package in.co.sunrays.proj0.service;

import java.util.List;

import in.co.sunrays.proj0.dto.MarksheetDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;

/**
 * Marksheet Service interface.
 * 
 * @author SessionFacade
 * @version 1.0 Copyright (c) SessionFacade
 */
public interface MarksheetServiceInt {

	/**
	 * Add a marksheet
	 * 
	 * @param dto:
	 * 				Object of MarksheetDTO
	 * @return pk:
	 * 				Primary Key
	 * 
	 * @throws DuplicateRecordException when RollNo already exist.
	 */
	public long add(MarksheetDTO dto)throws DuplicateRecordException;
	
	/**
	 * Update a marksheet
	 * 
	 * @param dto:
	 * 				Object of MarksheetDTO
	 * 
	 * @throws DuplicateRecordException when RollNo already exist.
	 */
	public void update(MarksheetDTO dto)throws DuplicateRecordException;
	
	/**
	 * Delete a marksheet
	 * 
	 * @param id:
	 * 				Primary Key
	 */
	public void delete(long id);
	
	/**
	 * Find marksheet by rollno
	 * 
	 * @param rollNo:
	 * 					RollNo of Student
	 * @return dto:
	 * 				Object of MarksheetDTO
	 */
	public MarksheetDTO findByRollNo(String rollNo);
	
	/**
	 * Find marksheet by PK
	 * 
	 * @param pk:
	 * 				Primary Key
	 * @return dto:
	 * 				Object of MarksheetDTO
	 */
	public MarksheetDTO findByPK(long pk);
	
	/**
	 * Search marksheet
	 * 
	 * @param dto:
	 * 				Object of MarksheetDTO
	 * @return list:
	 * 				List of MArksheet
	 */
	public List search(MarksheetDTO dto);
	
	/**
	 * Search marksheet with pagination
	 * 
	 * @param dto:
	 * 				Object of MarksheetDTO
	 * @param pageNo:
	 * 					PageNo
	 * @param pageSize:
	 * 					PageSize
	 * @return list:
	 * 				List of Marksheet
	 */
	public List search(MarksheetDTO dto, int pageNo, int pageSize);
	
	/**
	 * Get meritlist
	 * 
	 * @param pageNo:
	 * 					PageNo
	 * @param pageSize:
	 * 					PageSize
	 * @return list:
	 * 				Merit List
	 */
	public List getMeritList(int pageNo, int pageSize);
}
