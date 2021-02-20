package in.co.sunrays.proj0.dao;

import java.util.List; 

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//import com.lowagie.text.PageSize;
import in.co.sunrays.proj0.dto.UserDTO;

/**
 * User DAO Hibernate Implementation
 * 
 * @author SessionFacade
 * @version 1.0 Copyright (c) SessionFacade
 */
@Repository("userDAO")
public class UserDAOHibImpl implements UserDAOInt{
	
	@Autowired
	SessionFactory sessionFactory = null;
	
	public static Logger log = Logger.getLogger(UserDAOHibImpl.class);

	/**
	 * Add a User
	 * 
	 * @param dto:
	 * 				Object of UserDTO
	 * @return pk:
	 * 				Primary Key
	 */
	public long add(UserDTO dto) {
		log.debug("UserDAOHibImpl add method started");
		long pk = (Long) sessionFactory.getCurrentSession().save(dto);
		log.debug("UserDAOHibImpl add method ended");
		return pk;
	}

	/**
	 * Update a User
	 * 
	 * @param dto:
	 * 				Object of UserDTO
	 */
	public void update(UserDTO dto) {
		log.debug("UserDAOHibImpl update method started");
		sessionFactory.getCurrentSession().merge(dto);
		log.debug("UserDAOHibImpl update method ended");
	}

	/**
	 * Delete a User
	 * 
	 * @param dto:
	 * 				Object of UserDTO
	 */
	public void delete(UserDTO dto) {
		log.debug("UserDAOHibImpl delete method started");
		sessionFactory.getCurrentSession().delete(dto);
		log.debug("UserDAOHibImpl delete method ended");
	}

	/**
	 * Find User by LoginId
	 * 
	 * @param login:
	 * 				User LoginId
	 * @return dto:
	 * 				Object of UserDTO
	 */
	public UserDTO findByLogin(String login) {
		log.debug("UserDAOHibImpl findByLogin method started");
		UserDTO dto = null;
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserDTO.class);
		criteria.add(Restrictions.eq("login", login));
		List list = criteria.list();
		if(list.size()>0) {
			dto=(UserDTO) list.get(0);
		}else {
			dto=null;
		}
		log.debug("UserDAOHibImpl findByLogin method ended");
		return dto;
	}

	/**
	 * Find User by PK
	 * 
	 * @param pk:
	 * 				Primary Key
	 * @return dto:
	 * 				Object of UserDTO
	 */
	public UserDTO findByPK(long pk) {
		log.debug("UserDAOHibImpl findByPK method started");
		UserDTO dto = (UserDTO) sessionFactory.getCurrentSession().get(UserDTO.class, pk);
		log.debug("UserDAOHibImpl findByPK method ended");
		return dto;
	}

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
	public List search(UserDTO dto, int pageNo, int pageSize) {
		log.debug("UserDAOHibImpl search method started");
		List list = null;
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserDTO.class);
		if(dto!=null) {
			if(dto.getId()>0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if(dto.getRoleId()>0) {
				criteria.add(Restrictions.eq("roleId", dto.getRoleId()));
			}
			if(dto.getLogin()!=null && dto.getLogin().length()>0) {
				criteria.add(Restrictions.like("login", dto.getLogin()+"%"));
			}
			if(dto.getFirstName()!=null && dto.getFirstName().length()>0) {
				criteria.add(Restrictions.like("firstName", dto.getFirstName()+"%"));
			}
			if(dto.getLastName()!=null && dto.getLastName().length()>0) {
				criteria.add(Restrictions.ilike("lastName", dto.getLastName()+"%"));
			}
		}
		if(pageSize>0) {
			pageNo=(pageNo-1)*pageSize;
			criteria.setFirstResult(pageNo);
			criteria.setMaxResults(pageSize);
		}
		list=criteria.list();
		log.debug("UserDAOHibImpl search method ended");
		return list;
	}

	/**
	 * Search User
	 * 
	 * @param dto:
	 * 				Object of UserDTO
	 * @return list:
	 * 				List of User
	 */
	public List search(UserDTO dto) {
		return search(dto,0,0);
	}

}
