package in.co.sunrays.proj0.dao;

import java.util.List; 

import in.co.sunrays.proj0.dto.SubjectDTO;

/**
 *  Subject DAO interface.
 * 
 * @author SessionFacade
 * @version 1.0 Copyright (c) SessionFacade
 */
public interface SubjectDAOInt {
	
	/**
	 * Add a Subject
	 * 
	 * @param dto:
	 * 				Object of SubjectDTO
	 * @return pk:
	 * 				Primary Key
	 */
	public long add(SubjectDTO dto);
	
	/**
	 * Update a Subject
	 * 
	 * @param dto:
	 * 				Object of SubjectDTO
	 */
	public void update(SubjectDTO dto);
	
	/**
	 * Delete a Subject
	 * 
	 * @param dto:
	 * 				Object of SubjectDTO
	 */
	public void delete(SubjectDTO dto);
	
	/**
	 * Find Subject By Name
	 * 
	 * @param name:
	 * 				Name of Subject
	 * @return dto:
	 * 				Object of SubjectDTO
	 */
	public SubjectDTO findByName(String name);
	
	/**
	 * Find Subject by PK
	 * 
	 * @param pk:
	 * 				Primary Key
	 * @return dto:
	 * 				Object of SubjectDTO
	 */ 
	public SubjectDTO findByPK(long pk);
	
	/**
	 * Search Subject
	 * 
	 * @param dto:
	 * 				Object of SubjectDTO
	 * @return list:
	 * 				List of Subject
	 */
	public List search(SubjectDTO dto);
	
	/**
	 * Search Subject with pagination
	 * 
	 * @param dto:
	 * 				Object of SubjectDTO
	 * @param pageNo:
	 * 					PageNo
	 * @param pageSize:
	 * 					PageSize
	 * @return list:
	 * 				List of Student
	 */
	public List search(SubjectDTO dto, int pageNo, int pageSize);

}
