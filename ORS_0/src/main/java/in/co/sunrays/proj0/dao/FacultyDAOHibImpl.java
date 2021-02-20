package in.co.sunrays.proj0.dao;

import java.util.List; 

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.sunrays.proj0.dto.FacultyDTO;

/**
 * Faculty DAO Hibernate Implementation
 * 
 * @author SessionFacade
 * @version 1.0 Copyright (c) SessionFacade
 */
@Repository("facultyDAO")
public class FacultyDAOHibImpl implements FacultyDAOInt{

	@Autowired
	SessionFactory sessionFactory  = null;
	
	public static Logger log = Logger.getLogger(FacultyDAOHibImpl.class);

	/**
	 * Add a Faculty
	 * 
	 * @param dto:
	 * 				Object of FacultyDTO
	 * @return pk:
	 * 				Primary Key
	 */
	public long add(FacultyDTO dto) {
		log.debug("FacultyDAOHibImpl add method started");
		long pk = (Long) sessionFactory.getCurrentSession().save(dto);
		log.debug("FacultyDAOHibImpl add method ended");
		return pk;
	}

	/**
	 * Update a Faculty
	 * 
	 * @param dto:
	 * 				Object of FacultyDTO
	 */
	public void update(FacultyDTO dto) {
		log.debug("FacultyDAOHibImpl update method started");
		sessionFactory.getCurrentSession().merge(dto);
		log.debug("FacultyDAOHibImpl update method ended");
	}

	/**
	 * Delete a Faculty
	 * 
	 * @param dto:
	 * 				Object of FacultyDTO
	 */
	public void delete(FacultyDTO dto) {
		log.debug("FacultyDAOHibImpl delete method started");
		sessionFactory.getCurrentSession().delete(dto);
		log.debug("FacultyDAOHibImpl delete method ended");
	}

	/**
	 * Find Faculty by Email
	 * 
	 * @param email:
	 * 				Email of Faculty
	 * @return dto:
	 * 				Object of FacultyDTO
	 */
	public FacultyDTO findByEmail(String email) {
		log.debug("FacultyDAOHibImpl findByEmail method started");
		FacultyDTO dto = null;
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(FacultyDTO.class);
		criteria.add(Restrictions.like("emailId", email));
		List list = criteria.list();
		if(list.size()>0) {
			dto=(FacultyDTO) list.get(0);
		}else {
			dto=null;
		}
		log.debug("FacultyDAOHibImpl findByEmail method ended");
		return dto;
	}

	/**
	 * Find faculty by PK
	 * 
	 * @param pk:
	 * 			Primary Key
	 * @return dto:
	 * 				Object of FacultyDTO
	 */
	public FacultyDTO findByPK(long pk) {
		log.debug("FacultyDAOHibImpl findByPK method started");
		FacultyDTO dto = (FacultyDTO) sessionFactory.getCurrentSession().get(FacultyDTO.class, pk);
		log.debug("FacultyDAOHibImpl findByPK method ended");
		return dto;
	}

	/**
	 * Search Faculty with pagination
	 * 
	 * @param dto:
	 * 				Object of FacultyDTO
	 * @param pageNo:
	 * 					PageNo
	 * @param pageSize:
	 * 					PageSize
	 * @return list:
	 * 				List of Faculty
	 */
	public List search(FacultyDTO dto, int pageNo, int pageSize) {
		log.debug("FacultyDAOHibImpl search method started");
		List list = null;
		Criteria criteria = sessionFactory.openSession().createCriteria(FacultyDTO.class);
		if(dto!=null) {
			if(dto.getId()>0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if(dto.getCollegeId()>0) {
				criteria.add(Restrictions.eq("collegeId", dto.getCollegeId()));
			}
			if(dto.getCollegeName()!=null && dto.getCollegeName().length()>0) {
				criteria.add(Restrictions.like("collegeName", dto.getCollegeName()+"%"));
			}
			if(dto.getCourseId()>0) {
				criteria.add(Restrictions.eq("courseId", dto.getCourseId()));
			}
			if(dto.getCourseName()!=null && dto.getCourseName().length()>0) {
				criteria.add(Restrictions.like("courseName", dto.getCourseName()+"%"));
			}
			if(dto.getSubjectId()>0) {
				criteria.add(Restrictions.eq("subjectId", dto.getSubjectId()));
			}
			if(dto.getSubjectName()!=null && dto.getSubjectName().length()>0) {
				criteria.add(Restrictions.like("subjectName", dto.getSubjectName()+"%"));
			}
			if(dto.getEmailId()!=null && dto.getEmailId().length()>0) {
				criteria.add(Restrictions.like("emailId", dto.getEmailId()+"%"));
			}
			if(dto.getFirstName()!=null && dto.getFirstName().length()>0) {
				criteria.add(Restrictions.like("firstName", dto.getFirstName()+"%"));
			}
			if(dto.getLastName()!=null && dto.getLastName().length()>0) {
				criteria.add(Restrictions.like("lastName", dto.getLastName()));
			}
		}
		if(pageSize>0) {
			pageNo = (pageNo-1)*pageSize;
			criteria.setFirstResult(pageNo);
			criteria.setMaxResults(pageSize);
		}
		list=criteria.list();
		log.debug("FacultyDAOHibImpl search method ended");
		return list;
	}

	/**
	 * Search Faculty
	 * 
	 * @param dto:
	 * 				Object of FacultyDTO
	 * @return list:
	 * 				List of Faculty
	 */
	public List search(FacultyDTO dto) {
		return search(dto, 0, 0);
	}
}
