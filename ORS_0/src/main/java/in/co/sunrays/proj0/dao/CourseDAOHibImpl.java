package in.co.sunrays.proj0.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.sunrays.proj0.dto.CourseDTO;

/**
 * Course DAO Hibernate Implementation
 * 
 * @author SessionFacade
 * @version 1.0 Copyright (c) SessionFacade
 */
@Repository("courseDAO")
public class CourseDAOHibImpl implements CourseDAOInt{
	
	@Autowired
	SessionFactory sessionFactory = null;
	
	public static Logger log = Logger.getLogger(CourseDAOHibImpl.class);

	/**
	 * Add a Course
	 * 
	 * @param dto:
	 * 				Object of CourseDTO
	 * @return pk:
	 * 				Primary Key
	 */
	public long add(CourseDTO dto) {
		log.debug("CourseDAOHibImpl add method started");
		long pk = (Long) sessionFactory.getCurrentSession().save(dto);
		log.debug("CourseDAOHibImpl add method ended");
		return pk;
	}

	/**
	 * Update a Course
	 * 
	 * @param dto:
	 * 				Object of CourseDTO
	 */
	public void update(CourseDTO dto) {
		log.debug("CourseDAOHibImpl update method started");
		sessionFactory.getCurrentSession().merge(dto);
		log.debug("CourseDAOHibImpl update method ended");
	}

	/**
	 * Delete a Course
	 * 
	 * @param dto:
	 * 				Object of CourseDTO
	 */
	public void delete(CourseDTO dto) {
		log.debug("CourseDAOHibImpl delete method started");
		sessionFactory.getCurrentSession().delete(dto);
		log.debug("CourseDAOHibImpl delete method ended");
	}

	/**
	 * Find Course by Name
	 * 
	 * @param name:
	 * 				Name of Course
	 * @return dto:
	 * 				Object of CourseDTO
	 */
	public CourseDTO findByName(String name) {
		log.debug("CourseDAOHibImpl findByName method started");
		CourseDTO dto = null;
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(CourseDTO.class);
		criteria.add(Restrictions.eq("courseName", name));
		List list = criteria.list();
		if(list.size()>0) {
			dto=(CourseDTO) list.get(0);
		}else {
			dto=null;
		}
		log.debug("CourseDAOHibImpl findByName method ended");
		return dto;
	}

	/**
	 * Find Course by PK
	 * 
	 * @param pk:
	 * 			Primary Key
	 * @return dto:
	 * 				Object of CourseDTO
	 */
	public CourseDTO findByPK(long pk) {
		log.debug("CourseDAOHibImpl findByPK method started");
		CourseDTO dto = (CourseDTO) sessionFactory.getCurrentSession().get(CourseDTO.class, pk);
		log.debug("CourseDAOHibImpl findByPK method ended");
		return dto;
	}

	/**
	 * Search Course
	 * 
	 * @param dto:
	 * 				Object of CourseDTO
	 * @return list:
	 * 				List of Course
	 */
	public List search(CourseDTO dto) {
		return search(dto, 0, 0);
	}

	/**
	 * Search Course with pagination
	 * 
	 * @param dto:
	 * 				Object of CourseDTO
	 * @param pageNo:
	 * 					PageNO
	 * @param pageSize:
	 * 					PageSize
	 * @return list:
	 * 				List of Course
	 */
	public List search(CourseDTO dto, int pageNo, int pageSize) {
		log.debug("CourseDAOHibImpl search method started");
		List list = null;
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(CourseDTO.class);
		if(dto!=null) {
			if(dto.getId()>0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if(dto.getCourseName()!=null && dto.getCourseName().length()>0) {
				criteria.add(Restrictions.like("courseName", dto.getCourseName()+"%"));
			}
			if(dto.getCourseDescription()!=null && dto.getCourseDescription().length()>0) {
				criteria.add(Restrictions.like("courseDescription", dto.getCourseDescription()+"%"));
			}
			if(dto.getCourseDuration()!=null && dto.getCourseDuration().length()>0) {
				criteria.add(Restrictions.like("courseDuration", dto.getCourseDuration()+"%"));
			}
		}
		if(pageSize>0) {
			pageNo=(pageNo-1)*pageSize;
			criteria.setFirstResult(pageNo);
			criteria.setMaxResults(pageNo);
		}
		list = criteria.list();
		log.debug("CourseDAOHibImpl search method ended");
		return list;
	}

}
