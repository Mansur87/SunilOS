package in.co.sunrays.proj0.dao;

import java.util.List; 

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.sunrays.proj0.dto.StudentDTO;

/**
 * 
 * Student DAO Hibernate Implementation
 * 
 * @author SessionFacade
 * @version 1.0 Copyright (c) SessionFacade
 */
@Repository("studentDAO")
public class StudentDAOHibImpl implements StudentDAOInt{
	
	@Autowired
	SessionFactory sessionFactory = null;
	
	public static Logger log = Logger.getLogger(StudentDAOHibImpl.class);

	/**
	 * Add a Student
	 * 
	 * @param dto:
	 * 				Object of StudentDTO
	 * @return pk:
	 * 				Primary Key
	 */
	public long add(StudentDTO dto) {
		log.debug("StudentDAOHibImpl add method started");
		long pk = (Long) sessionFactory.getCurrentSession().save(dto);
		log.debug("StudentDAOHibImpl add method ended");
		return pk;
	}

	/**
	 * Update a Student
	 * 
	 * @param dto:
	 * 				Object of StudentDTO
	 */
	public void update(StudentDTO dto) {
		log.debug("StudentDAOHibImpl update method started");
		sessionFactory.getCurrentSession().merge(dto);
		log.debug("StudentDAOHibImpl update method ended");
	}

	/**
	 * Delete a Student
	 * 
	 * @param dto:
	 * 				Object of StudentDTO
	 */
	public void delete(StudentDTO dto) {
		log.debug("StudentDAOHibImpl delete method started");
		sessionFactory.getCurrentSession().delete(dto);
		log.debug("StudentDAOHibImpl delete method ended");
	}

	/**
	 * Find Student by Email
	 * 
	 * @param email:
	 * 				Email of Student
	 * @return dto:
	 * 				Object of StudentDTO
	 */
	public StudentDTO findByEmail(String email) {
		log.debug("StudentDAOHibImpl findByEmail method started");
		StudentDTO dto = null;
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(StudentDTO.class);
		criteria.add(Restrictions.eqOrIsNull("email", email));
		List list = criteria.list();
		if(list.size()>0) {
			dto=(StudentDTO) list.get(0);
		}else {
			dto=null;
		}
		log.debug("StudentDAOHibImpl findByEmail method ended");
		return dto;
	}

	/**
	 * Find Student by PK
	 * 
	 * @param pk:
	 * 				Primary Key
	 * @return dto:
	 * 				Object of StudentDTO
	 */
	public StudentDTO findByPK(long pk) {
		log.debug("StudentDAOHibImpl findByPK method started");
		StudentDTO dto = (StudentDTO) sessionFactory.getCurrentSession().get(StudentDTO.class, pk);
		log.debug("StudentDAOHibImpl findByPK method ended");
		return dto;
	}

	/**
	 * Search Student with pagination
	 * 
	 * @param dto:
	 * 				Object of StudentDTO
	 * @param pageNo:
	 * 				PageNo
	 * @param pageSize:
	 * 					PageSize
	 * @return list:
	 * 					List of Student
	 */
	public List search(StudentDTO dto, int pageNo, int pageSize) {
		log.debug("StudentDAOHibImpl search method started");
		List list = null;
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(StudentDTO.class);
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
			if(dto.getEmail()!=null && dto.getEmail().length()>0) {
				criteria.add(Restrictions.like("email", dto.getEmail()+"%"));
			}
			if(dto.getFirstName()!=null && dto.getFirstName().length()>0) {
				criteria.add(Restrictions.like("firstName", dto.getFirstName()+"%"));
			}
			if(dto.getLastName()!=null && dto.getLastName().length()>0) {
				criteria.add(Restrictions.like("lastName", dto.getLastName()+"%"));
			}
		}
		if(pageSize>0) {
			pageNo=(pageNo-1)*pageSize;
			criteria.setFirstResult(pageNo);
			criteria.setMaxResults(pageSize);
		}
		list=criteria.list();
		log.debug("StudentDAOHibImpl search method ended");
		return list;
	}

	/**
	 * Search Student 
	 * 
	 * @param dto:
	 * 				Object of StudentDTO
	 * @return list:
	 * 				List of Student
	 */
	public List search(StudentDTO dto) {
		return search(dto, 0, 0);
	}

}
