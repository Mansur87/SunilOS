package in.co.sunrays.proj0.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.sunrays.proj0.dao.CourseDAOInt;
import in.co.sunrays.proj0.dto.CourseDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;

@Service("courseService")
public class CourseServiceSpringImpl implements CourseServiceInt{

	@Autowired
	private CourseDAOInt dao;
	
	public static Logger log = Logger.getLogger(CourseServiceSpringImpl.class);

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public long add(CourseDTO dto) throws DuplicateRecordException {
		log.debug("CourseServiceSpringImpl add method started");
		CourseDTO existDto = dao.findByName(dto.getCourseName());
		if(existDto!=null) {
			throw new DuplicateRecordException("Course name already exist");
		}
		long pk = dao.add(dto);
		log.debug("CourseServiceSpringImpl add method ended");
		return pk;
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void update(CourseDTO dto) throws DuplicateRecordException {
		log.debug("CourseServiceSpringImpl update method started");
		CourseDTO existDto = dao.findByName(dto.getCourseName());
		if(existDto!=null && existDto.getId()!=dto.getId()) {
			throw new DuplicateRecordException("Course name already exist");
		}
		dao.update(dto);
		log.debug("CourseServiceSpringImpl update method ended");
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void delete(long id) {
		log.debug("CourseServiceSpringImpl delete method started");
		CourseDTO dto = dao.findByPK(id);
		dao.delete(dto);
		log.debug("CourseServiceSpringImpl delete method ended");
	}

	@Transactional(readOnly=true)
	public CourseDTO findByName(String name) {
		log.debug("CourseServiceSpringImpl findByName method started");
		CourseDTO dto = dao.findByName(name);
		log.debug("CourseServiceSpringImpl findByName method ended");
		return dto;
	}

	@Transactional(readOnly=true)
	public CourseDTO findByPK(long id) {
		log.debug("CourseServiceSpringImpl findByPK method started");
		CourseDTO dto = dao.findByPK(id);
		log.debug("CourseServiceSpringImpl findByPK method ended");
		return dto;
	}

	@Transactional(readOnly=true)
	public List search(CourseDTO dto) {
		log.debug("CourseServiceSpringImpl search method started");
		List list = dao.search(dto);
		log.debug("CourseServiceSpringImpl search method ended");
		return list;
	}

	@Transactional(readOnly=true)
	public List search(CourseDTO dto, int pageNo, int pageSize) {
		log.debug("CourseServiceSpringImpl search method started");
		List list = dao.search(dto, pageNo, pageSize);
		log.debug("CourseServiceSpringImpl search method ended");
		return list;
	}
}
