package in.co.sunrays.proj0.service;

import java.util.List;

import in.co.sunrays.proj0.dto.CollegeDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;

/**
 * College Service interface.
 * @author SessionFacade
 * @version 1.0 Copyright (c) SessionFacade
 */
public interface CollegeServiceInt {
	
	/**
	 * Add a College
	 * 
	 * 
	 * @param dto:
	 * 				Object of CollegeDTO
	 * 
	 * @return pk:
	 * 				Primary Key 
	 * 
	 * @throws DuplicateRecordException when College name already exist.
	 */
	public long add(CollegeDTO dto)throws DuplicateRecordException;

	/**
	 * Update a College
	 * 
	 * @param dto:
	 * 				Object of CollegeDTO
	 * 
	 * @throws DuplicateRecordException when College name already exist.
	 */
	public void update(CollegeDTO dto)throws DuplicateRecordException;
	
	/**
	 * Delete College
	 * 
	 * @param id:
	 * 				Primary Key
	 */
	public void delete(long id);
	
	/**
	 * Find College by Name
	 * 
	 * @param name:
	 * 				Name of College
	 * @return dto:
	 * 				Object of CollegeDTO
	 */
	public CollegeDTO findByName(String name);
	
	/**
	 * Find College by PK
	 * 
	 * @param id:
	 * 				Primary Key
	 * @return dto:
	 * 				Object of CollegeDTO
	 */
	public CollegeDTO findByPK(long id);
	
	/**
	 * Search College
	 * 
	 * @param dto:
	 * 				Object of CollegeDTO
	 * @return list:
	 * 				List of College
	 */
	public List search(CollegeDTO dto);
	
	/**
	 * Search College with pagination
	 * 
	 * @param dto:
	 * 				Object of CollegeDTO
	 * @param pageNo:
	 * 					PageNo
	 * @param pageSize:
	 * 					PageSize
	 * @return list:
	 * 				List of College
	 */
	public List search(CollegeDTO dto, int pageNo, int pageSize);
}
