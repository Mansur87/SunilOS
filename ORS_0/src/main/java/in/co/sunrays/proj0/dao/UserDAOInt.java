package in.co.sunrays.proj0.dao;

import java.util.List; 

import in.co.sunrays.proj0.dto.UserDTO;

/**
 * User DAO interface.
 * 
 * @author SessionFacade
 * @version 1.0
 */
public interface UserDAOInt {

	/**
	 * Add a User
	 * 
	 * @param dto:
	 * 				Object of UserDTO
	 * @return pk:
	 * 				Primary Key
	 */
	public long add(UserDTO dto);
	
	/**
	 * Update a User
	 * 
	 * @param dto:
	 * 				Object of UserDTO
	 */
	public void update(UserDTO dto);
	
	/**
	 * Delete a User
	 * 
	 * @param dto:
	 * 				Object of UserDTO
	 */
	public void delete(UserDTO dto);
	
	/**
	 * Find User by LoginId
	 * 
	 * @param login:
	 * 				LoginId of User
	 * @return dto:
	 * 				Object of UserDTO
	 */
	public UserDTO findByLogin(String login);
	
	/**
	 * Find User by PK
	 * 
	 * @param pk:
	 * 				Primary Key
	 * @return dto:
	 * 				Object of UserDTO
	 */
	public UserDTO findByPK(long pk);
	
	/**
	 * Search User with pagination
	 * 
	 * @param dto:
	 * 				Object of UserDTO
	 * @param pageNo:
	 * 					PageNo
	 * @param pageSize:
	 * 					PageSize
	 * @return list:
	 * 				List of User
	 */
	public List search(UserDTO dto, int pageNo, int pageSize);
	
	/**
	 * Search User
	 * 
	 * @param dto:
	 * 				Object of UserDTO
	 * @return list:
	 * 					List of User
	 */
	public List search(UserDTO dto);
	
}
