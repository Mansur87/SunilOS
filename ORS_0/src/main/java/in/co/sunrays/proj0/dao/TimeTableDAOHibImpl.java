package in.co.sunrays.proj0.dao;

import java.util.Date; 
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.sunrays.proj0.dto.TimeTableDTO;

/**
 *  Timetable DAO Hibernate Implementation
 * 
 * @author SessionFacade
 * @version 1.0 Copyright (c) SessionFacade
 */
@Repository("timetableDAO")
public class TimeTableDAOHibImpl implements TimeTableDAOInt{
	
	@Autowired
	SessionFactory sessionFactory = null;
	
	public static Logger log = Logger.getLogger(TimeTableDAOHibImpl.class);

	/**
	 * Add a TimeTable
	 * 
	 * @param dto:
	 * 				Object of TimeTableDTO
	 * @return pk:
	 * 				Primary Key
	 */
	public long add(TimeTableDTO dto) {
		log.debug("TimeTableDAOHibImpl add method started");
		long pk = (Long) sessionFactory.getCurrentSession().save(dto);
		log.debug("TimeTableDAOHibImpl add method ended");
		return pk;
	}

	/**
	 * Update a TimeTable
	 * 
	 * @param dto:
	 * 				Object of TimeTableDTO
	 */
	public void update(TimeTableDTO dto) {
		log.debug("TimeTableDAOHibImpl update method started");
		sessionFactory.getCurrentSession().merge(dto);
		log.debug("TimeTableDAOHibImpl update method ended");
	}

	/**
	 * Delete a TimeTable
	 * 
	 * @param dto:
	 * 				Object of TimeTableDTO
	 */
	public void delete(TimeTableDTO dto) {
		log.debug("TimeTableDAOHibImpl delete method started");
		sessionFactory.getCurrentSession().delete(dto);
		log.debug("TimeTableDAOHibImpl delete method ended");
	}

	/**
	 * Find TimeTable by PK
	 * 
	 * @param pk:
	 * 				Primary Key
	 * @return dto:
	 * 				Object of TimeTableDTO
	 */
	public TimeTableDTO findByPK(long pk) {
		log.debug("TimeTableDAOHibImpl findByPK method started");
		TimeTableDTO dto = (TimeTableDTO) sessionFactory.getCurrentSession().get(TimeTableDTO.class, pk);
		log.debug("TimeTableDAOHibImpl findByPK method ended");
		return dto;
	}

	/**
	 * Search TimeTable with pagination
	 * 
	 * @param dto:
	 * 				Object of TimeTableDTO
	 * @param pageNo:
	 * 					PageNo
	 * @param pageSize:
	 * 					PageSize
	 * @return list:
	 * 				List of TimeTable
	 */
	public List<TimeTableDTO> search(TimeTableDTO dto, int pageNo, int pageSize) {
		log.debug("TimeTableDAOHibImpl search method started");
		List list = null;
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TimeTableDTO.class);
		if(dto!=null) {
			if(dto.getId()>0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if(dto.getCourseId()>0) {
				criteria.add(Restrictions.eq("courseId", dto.getCourseId()));
			}
			if(dto.getCourseName()!=null && dto.getCourseName().length()>0) {
				criteria.add(Restrictions.like("courseName", dto.getCourseName()+"%"));
			}
			if(dto.getSubjectId()>0) {
				criteria.add(Restrictions.eqOrIsNull("subjectId", dto.getSubjectId()));
			}
			if(dto.getSubjectName()!=null && dto.getSubjectName().length()>0) {
				criteria.add(Restrictions.like("subjectName", dto.getSubjectName()+"%"));
			}
			if(dto.getExamDate()!=null && dto.getExamDate().getDate()>0) {
				criteria.add(Restrictions.eq("examDate", dto.getExamDate()));
			}
		}
		if(pageSize>0) {
			pageNo=(pageNo-1)*pageSize;
			criteria.setFirstResult(pageNo);
			criteria.setMaxResults(pageSize);
		}
		list=criteria.list();
		log.debug("TimeTableDAOHibImpl search method ended");
		return list;
	}

	/**
	 * Search TimeTable
	 * 
	 * @param dto:
	 * 				Object of TimeTableDTO
	 * @return list:
	 * 				List of TimeTable
	 */
	public List<TimeTableDTO> search(TimeTableDTO dto) {
		return search(dto, 0, 0);
	}

	/**
	 * Find TimeTable by CourseName,SubjectName,examDate,examTime
	 * 
	 * @param courseName:
	 * 					CourseName
	 * @param subjectName:
	 * 						SubjectName
	 * @param examDate:
	 * 					ExamDate
	 * @param examTime:
	 * 					ExamTime
	 * @return dto:
	 * 				Object of TimeTableDTO
	 */
	public TimeTableDTO findByNameDateTime(String courseName, String subjectName, Date examDate, String examTime) {
		log.debug("TimeTableDAOHibImpl findByNameDateTime method started");
		TimeTableDTO dto = null;
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TimeTableDTO.class);
		criteria.add(Restrictions.eq("courseName", courseName));
		criteria.add(Restrictions.eq("subjectName", subjectName));
		criteria.add(Restrictions.eq("examDate", examDate));
		criteria.add(Restrictions.eq("examTime", examTime));
		List list = criteria.list();
		if(list.size()>0) {
			dto=(TimeTableDTO) list.get(0);
		}else {
			dto=null;
		}
		log.debug("TimeTableDAOHibImpl findByNameDateTime method started");
		return dto;
	}

	/**
	 * Find TimeTable by CourseName and SubjectName
	 * 
	 * @param courseName:
	 * 						CourseName
	 * @param subjectName:
	 * 						SubjectName
	 * @return dto:
	 * 				Object of TimeTableDTO
	 */
	public TimeTableDTO findByName(String courseName, String subjectName) {
		log.debug("TimeTableDAOHibImpl findByName method started");
		TimeTableDTO dto = null;
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TimeTableDTO.class);
		criteria.add(Restrictions.eq("courseName", courseName));
		criteria.add(Restrictions.eq("subjectName", subjectName));
		List list = criteria.list();
		if(list.size()>0) {
			dto=(TimeTableDTO) list.get(0);
		}else {
			dto=null;
		}
		log.debug("TimeTableDAOHibImpl findByName method ended");
		return dto;
	}

	/**
	 * Find TimeTable by CourseName and ExamDate
	 * 
	 * @param courseName:
	 * 						CourseName
	 * @param examDate:
	 * 					ExamDate
	 * @return dto:
	 * 				Object of TimeTableDTO
	 */
	public TimeTableDTO findByNameDate(String courseName, Date examDate) {
		log.debug("TimeTableDAOHibImpl findByNameDate method started");
		TimeTableDTO dto = null;
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TimeTableDTO.class);
		criteria.add(Restrictions.eq("courseName", courseName));
		criteria.add(Restrictions.eq("examDate", examDate));
		List list = criteria.list();
		if(list.size()>0) {
			dto=(TimeTableDTO) list.get(0);
		}else {
			dto=null;
		}
		log.debug("TimeTableDAOHibImpl findByNameDate method ended");
		return dto;
	}

}
