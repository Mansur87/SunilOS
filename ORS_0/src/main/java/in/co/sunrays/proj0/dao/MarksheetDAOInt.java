package in.co.sunrays.proj0.dao;

import java.util.List; 

import in.co.sunrays.proj0.dto.MarksheetDTO;

/**
 * Marksheet DAO interface.
 * 
 * @author SessionFacade
 * @version 1.0 Copyright (c) SessionFacade
 */
public interface MarksheetDAOInt {

	/**
	 * Add a Marksheet
	 * 
	 * @param dto:
	 * 				Object of MarksheetDTO
	 * @return pk:
	 * 				Primary Key
	 */
	public long add(MarksheetDTO dto);
	
	/**
	 * Update a Marksheet
	 * 
	 * @param dto:
	 * 				Object of MarksheetDTO
	 */
	public void update(MarksheetDTO dto);
	
	/**
	 * Delete a Marksheet
	 * 
	 * @param dto:
	 * 				Object of MarksheetDTO
	 */
	public void delete(MarksheetDTO dto);
	
	/**
	 * Find Marksheet by RollNo
	 * 
	 * @param rollNo:
	 * 					RollNo of Student
	 * @return dto:
	 * 				Object of MarksheetDTO
	 */
	public MarksheetDTO findByRollNo(String rollNo);
	
	/**
	 * Find Marksheet by PK
	 * 
	 * @param pk:
	 * 				Primary Key
	 * @return dto:
	 * 				Object of MarksheetDTO
	 */
	public MarksheetDTO findByPK(long pk);
	
	/**
	 * Search Marksheet
	 * 
	 * @param dto:
	 * 				Object of MarksheetDTO
	 * @return list:
	 * 				List of Marksheet
	 */
	public List search(MarksheetDTO dto);
	
	/**
	 * Search Marksheet with pagination
	 * 
	 * @param dto:
	 * 				Object of MarksheetDTO
	 * @param pageNo:
	 * 					PageNo
	 * @param pageSize:
	 * 					PageSize
	 * @return list:
	 * 				List of Marksheeet
	 */
	public List search(MarksheetDTO dto, int pageNo, int pageSize);
	
	/**
	 * Gets MeritList
	 * 
	 * @param pageNo:
	 * 					PageNo
	 * @param pageSize:
	 * 					PageSize
	 * @return list:
	 * 				MeritList
	 */
	public List getMeritList(int pageNo,int pageSize);
}
