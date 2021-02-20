package in.co.sunrays.proj0.dao;

import java.util.List; 

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.sunrays.proj0.dto.MarksheetDTO;

/**
 * Marksheet DAO Hibernate Implementation
 * 
 * @author SessionFacade
 * @version 1.0 Copyright (c) SessionFacade
 */
@Repository("marksheetDAO")
public class MarksheetDAOHibImpl implements MarksheetDAOInt{

	@Autowired
	SessionFactory sessionFactory = null;
	
	public static Logger log = Logger.getLogger(MarksheetDAOHibImpl.class);
	
	/**
	 * Add a Marksheet
	 * 
	 * @param dto:
	 * 				Object of MarksheetDTO
	 * @return pk:
	 * 				Primary Key
	 */
	public long add(MarksheetDTO dto) {
		log.debug("MarksheetDAOHibImpl add method started");
		long pk = (Long) sessionFactory.getCurrentSession().save(dto);
		log.debug("MarksheetDAOHibImpl add method ended");
		return pk;
	}

	/**
	 * Update a Marksheet
	 * 
	 * @param dto:
	 * 				Object of MarksheetDTO
	 */
	public void update(MarksheetDTO dto) {
		log.debug("MarksheetDAOHibImpl update method started");
		sessionFactory.getCurrentSession().merge(dto);
		log.debug("MarksheetDAOHibImpl update method ended");
	}

	/**
	 * Delete a Marksheet
	 * 
	 * @param dto:
	 * 				Object of MarksheetDTO
	 */
	public void delete(MarksheetDTO dto) {
		log.debug("MarksheetDAOHibImpl delete method started");
		sessionFactory.getCurrentSession().delete(dto);
		log.debug("MarksheetDAOHibImpl delete method ended");
	}

	/**
	 * Find Marksheet by RollNo
	 * 
	 * @param rollNo:
	 * 				RollNo of Student
	 * @return dto:
	 * 				MarksheetDTO
	 */
	public MarksheetDTO findByRollNo(String rollNo) {
		log.debug("MarksheetDAOHibImpl findByRollNo method started");
		MarksheetDTO dto = null;
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(MarksheetDTO.class);
		criteria.add(Restrictions.eq("rollNo", rollNo));
		List list = criteria.list();
		if(list.size()>0) {
			dto=(MarksheetDTO) list.get(0);
		}else {
			dto=null;
		}
		log.debug("MarksheetDAOHibImpl add findByRollNo ended");
		return dto;
	}

	/**
	 * Find Marksheet by PK
	 * 
	 * @param pk:
	 * 				Primary Key
	 * @return dto:
	 * 				MarksheetDTO
	 */
	public MarksheetDTO findByPK(long pk) {
		log.debug("MarksheetDAOHibImpl findByPK method started");
		MarksheetDTO dto = (MarksheetDTO) sessionFactory.getCurrentSession().get(MarksheetDTO.class, pk);
		log.debug("MarksheetDAOHibImpl findByPK method ended");
		return dto;
	}

	/**
	 * Search Marksheet
	 * 
	 * @param dto:
	 * 				Object of MarksheetDTO
	 * @return list:
	 * 				List of Marksheet
	 */
	public List search(MarksheetDTO dto) {
		return search(dto, 0, 0);
	}

	/**
	 * Search Marksheet with pagination
	 * 
	 * @param dto:
	 * 				Object of MarksheetDTO
	 * @param pageNo:
	 * 					PageNo
	 * @param pageSize:
	 * 					PageSize
	 * @return list:
	 * 					List of Marksheet
	 */
	public List search(MarksheetDTO dto, int pageNo, int pageSize) {
		log.debug("MarksheetDAOHibImpl search method started");
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(MarksheetDTO.class);
		if(dto!=null) {
			if(dto.getId()>0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if(dto.getStudentId()>0) {
				criteria.add(Restrictions.eq("studentId", dto.getStudentId()));
			}
			if(dto.getStudentName()!=null && dto.getStudentName().length()>0) {
				criteria.add(Restrictions.like("studentName", dto.getStudentName()+"%"));
			}
			if(dto.getRollNo()!=null && dto.getRollNo().length()>0) {
				criteria.add(Restrictions.like("rollNo", dto.getRollNo()+"%"));
			}
		}
		if(pageSize>0) {
			pageNo=(pageNo-1)*pageSize;
			criteria.setFirstResult(pageNo);
			criteria.setMaxResults(pageSize);
		}
		List list = criteria.list();
		log.debug("MarksheetDAOHibImpl search method ended");
		return list;
	}

	/**
	 * Gets MeritList
	 * 
	 * @param pageNo:
	 * 				PageNo
	 * @param pageSize:
	 * 					PageSize
	 * @return list:
	 * 				MeritList
	 */
	public List getMeritList(int pageNo, int pageSize) {
		log.debug("MarksheetDAOHibImpl getMeritList method started");
		List list = null;
		StringBuffer buffer = new StringBuffer("FROM MarksheetDTO where physics>=35 and chemistry>=35 and maths>=35 ORDER BY (physics + chemistry + maths) DESC");
		Query query = sessionFactory.getCurrentSession().createQuery(buffer.toString());
		if(pageSize>0) {
			pageNo=(pageNo-1)*pageSize;
			query.setFirstResult(pageNo);
			query.setMaxResults(pageSize);
		}
		list=query.list();
		log.debug("MarksheetDAOHibImpl getMeritList method ended");
		return list;
	}
	
}
