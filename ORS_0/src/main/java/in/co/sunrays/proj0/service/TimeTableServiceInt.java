package in.co.sunrays.proj0.service;

import java.util.List;

import in.co.sunrays.proj0.dto.TimeTableDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;

/**
 * TimeTable Service interface.
 * 
 * @author SessionFacade
 * @version 1.0 Copyright (c) SessionFacade
 */
public interface TimeTableServiceInt {

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
	public long add(TimeTableDTO dto)throws DuplicateRecordException;
	
	/**
	 * Update a TimeTable
	 * 
	 * @param dto:
	 * 				Object of TimeTableDTO
	 * 
	 * @throws DuplicateRecordException when TimeTable already exist.
	 */
	public void update(TimeTableDTO dto)throws DuplicateRecordException;
	
	/**
	 * Delete a TimeTable
	 * 
	 * @param id:
	 * 				Primary Key
	 */
	public void delete(long id);
	
	/**
	 * Find TimeTable by PK
	 * 
	 * @param pk:
	 * 				Primary Key
	 * @return dto:
	 * 				Object of TimeTableDTO
	 */
	public TimeTableDTO findByPK(long pk);
	
	/**
	 * Search TimeTable
	 * 
	 * @param dto:
	 * 				Object of TimeTableDTO
	 * @return list:
	 * 				List of TimeTable
	 */
	public List search(TimeTableDTO dto);
	
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
	public List search(TimeTableDTO dto, int pageNo, int pageSize);
}
