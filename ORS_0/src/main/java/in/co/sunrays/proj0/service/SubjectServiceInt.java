package in.co.sunrays.proj0.service;

import java.util.List;

import in.co.sunrays.proj0.dto.StudentDTO;
import in.co.sunrays.proj0.dto.SubjectDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;

/**
 * Subject Service interface.
 * 
 * @author SessionFacade
 * @version 1.0 Copyright (c) SessionFacade
 */
public interface SubjectServiceInt {

	/**
	 * Add a Subject
	 * 
	 * @param dto:
	 * 				Object of SubjectDTO
	 * @return pk:
	 * 				Primary Key
	 * 
	 * @throws DuplicateRecordException when Subject name already exist.
	 */
	public long add(SubjectDTO dto)throws DuplicateRecordException;
	
	/**
	 * Update a Subject
	 * 
	 * @param dto:
	 * 				Object of SubjectDTO
	 * 
	 * @throws DuplicateRecordException when Subject name already exist.
	 */
	public void update(SubjectDTO dto)throws DuplicateRecordException;
	
	/**
	 * Delete a Subject
	 * 
	 * @param id:
	 * 				Primary Key
	 */
	public void delete(long id);
	
	/**
	 * Find Subject by Name
	 * 
	 * @param name:
	 * 				Subject Name
	 * @return dto:
	 * 				Object of SubjectDTO
	 */
	public SubjectDTO findByName(String name);
	
	/**
	 * Find Subject by PK
	 * 
	 * @param id:
	 * 				Primary Key
	 * @return dto:
	 * 				Object of SubjectDTO
	 */
	public SubjectDTO findByPK(long id);
	
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
	 * 					List of Subject
	 */
	public List search(SubjectDTO dto, int pageNo, int pageSize);
}
