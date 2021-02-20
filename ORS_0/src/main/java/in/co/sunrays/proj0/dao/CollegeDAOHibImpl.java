package in.co.sunrays.proj0.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.sunrays.proj0.dto.CollegeDTO;

/**
 * College DAO Hibernate Implementation
 * 
 * @author SessionFacade
 * @version 1.0 Copyright (c) SessionFacade
 */
@Repository("collegeDAO")
public class CollegeDAOHibImpl implements CollegeDAOInt{
	
	@Autowired
	SessionFactory sessionFactory = null;
	public static Logger log = Logger.getLogger(CollegeDAOHibImpl.class); 

	/**
	 * Add a college
	 * 
	 * @param dto:
	 * 				Object of CollegeDTO
	 * @return pk:
	 * 				Primary Key
	 */
	public long add(CollegeDTO dto) {
		log.debug("CollegeDAOHibImpl add method started");
		long pk = (Long) sessionFactory.getCurrentSession().save(dto);
		log.debug("CollegeDAOHibImpl add method ended");
		return pk;
	}

	/**
	 * Update a college
	 * 
	 * @param dto:
	 * 				Object of CollegeDTO
	 */
	public void update(CollegeDTO dto) {
		log.debug("CollegeDAOHibImpl update method started");
		sessionFactory.getCurrentSession().merge(dto);
		log.debug("CollegeDAOHibImpl update method ended");
	}

	/**
	 * Delete a college
	 * 
	 * @param dto:
	 * 				Object of CollegeDTO
	 */
	public void delete(CollegeDTO dto) {
		log.debug("CollegeDAOHibImpl delete method started");
		sessionFactory.getCurrentSession().delete(dto);
		log.debug("CollegeDAOHibImpl delete method ended");
	}

	/**
	 * Find college by name
	 * 
	 * @param name:
	 * 				Name of College
	 * @return dto:
	 * 				Object of CollegeDTO
	 */
	public CollegeDTO findByName(String name) {
		log.debug("CollegeDAOHibImpl findByName method started");
		CollegeDTO dto = null;
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(CollegeDTO.class);
		criteria.add(Restrictions.eq("name", name));
		List list = criteria.list();
		if(list.size()>0) {
			dto=(CollegeDTO) list.get(0);
		}else {
			dto=null;
		}
		log.debug("CollegeDAOHibImpl findByName method ended");
		return dto;
	}

	/**
	 * Find college by PK
	 * 
	 * @param pk:
	 * 				Primary Key
	 * @return dto:
	 * 				Object of CollegeDTO
	 */
	public CollegeDTO findByPK(long pk) {
		log.debug("CollegeDAOHibImpl findByPK method started");
		CollegeDTO dto = (CollegeDTO) sessionFactory.getCurrentSession().get(CollegeDTO.class, pk);
		log.debug("CollegeDAOHibImpl findByPK method ended");
		return dto;
	}

	/**
	 * Search college
	 * 
	 * @param dto:
	 * 				Object of CollegeDTO
	 * @return list:
	 * 				List of College
	 */
	public List search(CollegeDTO dto) {
		return search(dto, 0, 0);
	}

	/**
	 * Search college with pagination
	 * 
	 * @param dto:
	 * 				Object of CollegeDTO
	 * @param pageNo:
	 * 				PageNo
	 * @param pageSize:
	 * 					PageSize
	 * @return:
	 * 			List of College
	 */
	public List search(CollegeDTO dto, int pageNo, int pageSize) {
		log.debug("CollegeDAOHibImpl search method started");
		List list = null;
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(CollegeDTO.class);
		if(dto!=null) {
			if(dto.getId()>0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if(dto.getName()!=null && dto.getName().length()>0) {
				criteria.add(Restrictions.like("name", dto.getName()+"%"));
			}
			if(dto.getAddress()!=null && dto.getAddress().length()>0) {
				criteria.add(Restrictions.like("address", dto.getAddress()+"%"));
			}
			if(dto.getCity()!=null && dto.getCity().length()>0) {
				criteria.add(Restrictions.like("city", dto.getCity()+"%"));
			}
			if(dto.getState()!=null && dto.getState().length()>0) {
				criteria.add(Restrictions.like("state", dto.getState()+"%"));
			}
		}
		if(pageSize>0) {
			pageNo=(pageNo-1)*pageSize;
			criteria.setFirstResult(pageNo);
			criteria.setMaxResults(pageSize);
		}
		list=criteria.list();
		log.debug("CollegeDAOHibImpl search method ended");
		return list;
	}

}
