package in.co.sunrays.proj0.dao;

import java.util.List; 

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.sunrays.proj0.dto.SubjectDTO;

/**
 *  Subject DAO interface.
 * 
 * @author SessionFacade
 * @version 1.0 Copyright (c) SessionFacade
 */
@Repository("subjectDAO")
public class SubjectDAOHibImpl implements SubjectDAOInt{
	
	@Autowired
	SessionFactory sessionFactory=null;
	
	public Logger log = Logger.getLogger(SubjectDAOHibImpl.class);

	/**
	 * Add a Subject
	 * 
	 * @param dto:
	 * 				Object of SubjectDTO
	 * @return pk:
	 * 				Primary Key
	 */
	public long add(SubjectDTO dto) {
		log.debug("SubjectDAOHibImpl add method started");
		long pk = (Long) sessionFactory.getCurrentSession().save(dto);
		log.debug("SubjectDAOHibImpl add method ended");
		return pk;
	}

	/**
	 * Update a Subject
	 * 
	 * @param dto:
	 * 				Object of SubjectDTO
	 */
	public void update(SubjectDTO dto) {
		log.debug("SubjectDAOHibImpl update method started");
		sessionFactory.getCurrentSession().merge(dto);
		log.debug("SubjectDAOHibImpl update method ended");
	}

	/**
	 * Delete a Subject
	 * 
	 * @param dto:
	 * 				Object of SubjectDTO
	 */
	public void delete(SubjectDTO dto) {
		log.debug("SubjectDAOHibImpl delete method started");
		sessionFactory.getCurrentSession().delete(dto);
		log.debug("SubjectDAOHibImpl delete method ended");
	}

	/**
	 * Find Subject By Name
	 * 
	 * @param name:
	 * 				Name of Subject
	 * @return dto:
	 * 				Object of SubjectDTO
	 */
	public SubjectDTO findByName(String name) {
		log.debug("SubjectDAOHibImpl findByName method started");
		SubjectDTO dto = null;
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(SubjectDTO.class);
		criteria.add(Restrictions.eq("subjectName", name));
		List list = criteria.list();
		if(list.size()>0) {
			dto = (SubjectDTO) list.get(0);
		}else {
			dto=null;
		}
		log.debug("SubjectDAOHibImpl findByName method ended");
		return dto;
	}

	/**
	 * Find Subject by PK
	 * 
	 * @param pk:
	 * 				Primary Key
	 * @return dto:
	 * 				Object of SubjectDTO
	 */
	public SubjectDTO findByPK(long pk) {
		log.debug("SubjectDAOHibImpl findByPK method started");
		SubjectDTO dto = (SubjectDTO) sessionFactory.openSession().get(SubjectDTO.class, pk);
		log.debug("SubjectDAOHibImpl findByPK method ended");
		return dto;
	}

	/**
	 * Search Subject
	 * 
	 * @param dto:
	 * 				Object of SubjectDTO
	 * @return list:
	 * 					List of Subject
	 */
	public List search(SubjectDTO dto) {
		return search(dto, 0, 0);
	}

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
	 * 				List of Subject
	 */
	public List search(SubjectDTO dto, int pageNo, int pageSize) {
		log.debug("SubjectDAOHibImpl search method started");
		List list = null;
		Criteria criteria = sessionFactory.openSession().createCriteria(SubjectDTO.class);
		if(dto!=null) {
			if(dto.getId()>0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if(dto.getCourseId()>0) {
				criteria.add(Restrictions.eqOrIsNull("courseId", dto.getCourseId()));
			}
			if(dto.getSubjectName()!=null && dto.getSubjectName().length()>0) {
				criteria.add(Restrictions.like("subjectName", dto.getSubjectName()+"%"));
			}
			if(dto.getCourseName()!=null && dto.getCourseName().length()>0) {
				criteria.add(Restrictions.like("courseName", dto.getCourseName()+"%"));
			}
			if(dto.getDescription()!=null && dto.getDescription().length()>0) {
				criteria.add(Restrictions.like("description", dto.getDescription()+"%"));
			}
		}
		if(pageSize>0) {
			pageNo=(pageNo-1)*pageSize;
			criteria.setFirstResult(pageNo);
			criteria.setMaxResults(pageSize);
		}
		list=criteria.list();
		log.debug("SubjectDAOHibImpl search method ended");
		return list;
	}

}
