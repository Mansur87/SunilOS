package in.co.sunrays.proj0.dao;

import java.util.List; 

import in.co.sunrays.proj0.dto.FacultyDTO;

/**
 * Faculty DAO interface.
 * 
 * @author SessionFacade
 * @version 1.0 copyright (C) SessionFacade
 */
public interface FacultyDAOInt {

	/**
	 * Add a Faculty
	 * 
	 * @param dto:
	 * 				Object of FacultyDTO
	 * @return pk:
	 * 				Primary Key
	 */
	public long add(FacultyDTO dto);
	
	/**
	 * Update a Faculty
	 * 
	 * @param dto:
	 * 				Object of FacultyDTO
	 */
	public void update(FacultyDTO dto);
	
	/**
	 * Delete a Faculty
	 * 
	 * @param dto:
	 * 				Object of FacultyDTO
	 */
	public void delete(FacultyDTO dto);
	
	/**
	 * Find Faculty by Email
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
	 * 				Object Of FacultyDTO
	 */
	public FacultyDTO findByPK(long pk);
	
	/**
	 * Search Faculty with pagination
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
	 * Search Faculty
	 * 
	 * @param dto:
	 * 				Object of FacultyDTO
	 * @return list:
	 * 				List of Faculty
	 */
	public List search(FacultyDTO dto);
}
