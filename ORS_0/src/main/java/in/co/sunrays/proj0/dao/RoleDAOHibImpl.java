package in.co.sunrays.proj0.dao;

import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.sunrays.proj0.dto.RoleDTO;

/**
 * 
 * Role DAO HibernateImplementation
 * 
 * @author SessionFacade
 * @version 1.0 Copyright (c) SessionFacade
 */
@Repository("roleDAO")
public class RoleDAOHibImpl implements RoleDAOInt{
	public static Logger log = Logger.getLogger(RoleDAOHibImpl.class);
	
	@Autowired
	SessionFactory sessionFactory = null;
	
	/**
	 * Add a Role
	 * 
	 * @param dto:
	 * 				Object of RoleDTO
	 * @return pk:
	 * 				Primary Key
	 */
	public long add(RoleDTO dto) {
		log.debug("RoleDAOHibImpl add method started");
		long pk = (Long) sessionFactory.getCurrentSession().save(dto);
		log.debug("RoleDAOHibImpl add method ended");
		return pk;
	}

	/**
	 * Update a Role
	 * 
	 * @param dto:
	 * 				Object of RoleDTO
	 */
	public void update(RoleDTO dto) {
		log.debug("RoleDAOHibImpl update method started");
		sessionFactory.getCurrentSession().merge(dto);
		log.debug("RoleDAOHibImpl update method ended");
	}

	/**
	 * Delete a Role
	 * 
	 * @param dto:
	 * 				Object of RoleDTO
	 */
	public void delete(RoleDTO dto) {
		log.debug("RoleDAOHibImpl delete method started");
		sessionFactory.getCurrentSession().delete(dto);
		log.debug("RoleDAOHibImpl delete method ended");
	}

	/**
	 * Find role by name
	 * 
	 * @param roleName:
	 * 					Role Name
	 * @return dto:
	 * 				Object of RoleDTO
	 */
	public RoleDTO findByName(String roleName) {
		log.debug("RoleDAOHibImpl findByName method started");
		RoleDTO dto = null;
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(RoleDTO.class);
		criteria.add(Restrictions.eq("roleName", roleName));
		List list = criteria.list();
		if(list.size()>0) {
			dto = (RoleDTO) list.get(0);
		}else {
			dto=null;
		}
		log.debug("RoleDAOHibImpl findByName method ended");
		return dto;
	}

	/**
	 * Find role by PK
	 * 
	 * @param pk:
	 * 				Primary Key
	 * @return dto:
	 * 				Object of RoleDTO
	 */
	public RoleDTO findByPK(long pk) {
		log.debug("RoleDAOHibImpl findByPK method started");
		RoleDTO dto = (RoleDTO) sessionFactory.getCurrentSession().get(RoleDTO.class, pk);
		log.debug("RoleDAOHibImpl findByPK method ended");
		return dto;
	}

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
	public List search(RoleDTO dto, int pageNo, int pageSize) {
		log.debug("RoleDAOHibImpl search method started");
		List list = null;
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(RoleDTO.class);
		if(dto!=null) {
			if(dto.getId()>0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if(dto.getRoleName()!=null && dto.getRoleName().length()>0) {
				criteria.add(Restrictions.like("roleName", dto.getRoleName()+"%"));
			}
			if(dto.getRoleDescription()!=null && dto.getRoleDescription().length()>0) {
				criteria.add(Restrictions.like("roleDescription", dto.getRoleDescription()+"%"));
			}
		}
		if(pageSize>0) {
			pageNo=pageNo-1*pageSize;
			criteria.setFirstResult(pageNo);
			criteria.setMaxResults(pageSize);
		}
		list=criteria.list();
		log.debug("RoleDAOHibImpl search method ended");
		return list;
	}

	/**
	 * Search role
	 * 
	 * @param dto:
	 * 				Object of RoleDTO
	 * @return list:
	 * 				List of Role
	 */
	public List search(RoleDTO dto) {
		return search(dto, 0, 0);
	}

}
