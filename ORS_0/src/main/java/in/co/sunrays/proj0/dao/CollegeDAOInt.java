package in.co.sunrays.proj0.dao;

import java.util.List;

import in.co.sunrays.proj0.dto.CollegeDTO;

/**
 * College DAO interface.
 * 
 * @author SessionFacade
 * @version 1.0 Copyright (c) SessionFacade
 */
public interface CollegeDAOInt {

	/**
	 * Add a college
	 * 
	 * @param dto:
	 * 				Object of CollegeDTO
	 * @return pk:
	 * 				Primary Key
	 */
	public long add(CollegeDTO dto);
	
	/**
	 * Update a college
	 * 
	 * @param dto:
	 * 				Object of CollegeDTO
	 */
	public void update(CollegeDTO dto);
	
	/**
	 * Delete a college
	 * 
	 * @param dto:
	 * 				Object of CollegeDTO
	 */
	public void delete(CollegeDTO dto);
	
	/**
	 * Find college by name
	 * 
	 * @param name:
	 * 				Name of College
	 * @return dto:
	 * 				Object of CollegeDTO
	 */
	public CollegeDTO findByName(String name);
	
	/**
	 * Find college by PK
	 * 
	 * @param pk:
	 * 				Primary Key
	 * @return dto:
	 * 				Object of CollegeDTO
	 */
	public CollegeDTO findByPK(long pk);
	
	/**
	 * Search college
	 * 
	 * @param dto:
	 * 				Object of CollegeDTO
	 * @return list:
	 * 				List of College
	 */
	public List search(CollegeDTO dto);
	
	/**
	 * Search college with pagination
	 * 
	 * @param dto:
	 * 				Object of CollegeDTO
	 * @param pageNo:
	 * 				PageNo
	 * @param pageSize:
	 * 					PageSize
	 * @return list:
	 * 				List of College
	 */
	public List search(CollegeDTO dto, int pageNo, int pageSize);
}
