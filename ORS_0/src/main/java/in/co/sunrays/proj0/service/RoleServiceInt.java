package in.co.sunrays.proj0.service;

import java.util.List;

import in.co.sunrays.proj0.dto.RoleDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;

/**
 * Role Service interface.
 * 
 * @author SessionFacade
 * @version 1.0 Copyright (c) SessionFacade
 */
public interface RoleServiceInt {

	/**
	 * Add a Role
	 * 
	 * @param dto:
	 * 				Object of RoleDTO
	 * @return pk:
	 * 				Primary Key
	 * 
	 * @throws DuplicateRecordException when Role name already exist.
	 */
	public long add(RoleDTO dto)throws DuplicateRecordException;
	
	/**
	 * Update a Role
	 * 
	 * @param dto:
	 * 				Object of RoleDTO
	 * 
	 * @throws DuplicateRecordException when Role name already exist.
	 */
	public void update(RoleDTO dto)throws DuplicateRecordException;
	
	/**
	 * Delete a Role
	 * 
	 * @param id:
	 * 				Primary Key
	 */
	public void delete(long id);
	
	/**
	 * Find Role by Name
	 * 
	 * @param roleName:
	 * 					Role Name
	 * @return dto:
	 * 					Object of RoleDTO
	 */
	public RoleDTO findByName(String roleName);
	
	/**
	 * Find Role by PK
	 * 
	 * @param pk:
	 * 				Primary Key
	 * @return dto:
	 * 				Object of RoleDTO
	 */
	public RoleDTO findByPK(long pk);
	
	/**
	 * Search Role with pagination
	 * 
	 * @param dto:
	 * 				Object of RoleDTO
	 * @param pageNo:
	 * 					PageNo
	 * @param pageSize:
	 * 					PageSize
	 * @return list:
	 * 					List of Role
	 */
	public List search(RoleDTO dto, int pageNo, int pageSize);
	
	/**
	 * Search Role
	 * 
	 * @param dto:
	 * 				Object of RoleDTO
	 * @return list:
	 * 					List of Role
	 */
	public List search(RoleDTO dto);
}
