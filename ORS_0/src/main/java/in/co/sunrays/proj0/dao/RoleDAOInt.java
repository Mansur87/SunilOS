package in.co.sunrays.proj0.dao;

import java.util.List;

import in.co.sunrays.proj0.dto.RoleDTO;

/**
 * 
 * Role DAO interface.
 * 
 * @author SessionFacade
 * @version 1.0 Copyright (c) SessionFacade
 */
public interface RoleDAOInt {

	/**
	 * Add a Role
	 * 
	 * @param dto:
	 * 				Object of RoleDTO
	 * @return pk:
	 * 				Primary Key
	 */
	public long add(RoleDTO dto);
	
	/**
	 * Update a Role
	 * 
	 * @param dto:
	 * 				Object of RoleDTO
	 */
	public void update(RoleDTO dto);
	
	/**
	 * Delete a Role
	 * 
	 * @param dto:
	 * 				Object of RoleDTO
	 */
	public void delete(RoleDTO dto);
	
	/**
	 * Find role by name
	 * 
	 * @param roleName:
	 * 					RoleName
	 * @return dto:
	 * 				Object of RoleDTO
	 */
	public RoleDTO findByName(String roleName);
	
	/**
	 * Find role by PK
	 * 
	 * @param pk:
	 * 				Primary Key
	 * @return dto:
	 * 				Object of RoleDTO
	 */
	public RoleDTO findByPK(long pk);
	
	/**
	 * Search role with pagination
	 * 
	 * @param dto:
	 * 				Object of RoleDTO
	 * @param pageNo:
	 * 					PageNo
	 * @param pageSize:
	 * 					PageSize
	 * @return list:
	 * 				List of Role
	 */
	public List search(RoleDTO dto, int pageNo, int pageSize);
	
	/**
	 * Search role
	 * 
	 * @param dto:
	 * 				Object of RoleDTO
	 * @return list:
	 * 				Object of RoleDTO
	 */
	public List search(RoleDTO dto);
}
