package in.co.sunrays.proj0.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.sunrays.proj0.dao.StudentDAOInt;
import in.co.sunrays.proj0.dto.CollegeDTO;
import in.co.sunrays.proj0.dto.StudentDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;

@Service("studentService")
public class StudentServiceSpringImpl implements StudentServiceInt{
	
	@Autowired
	private StudentDAOInt dao;
	
	@Autowired
	private CollegeServiceInt collegeService;
	
	public static Logger log = Logger.getLogger(StudentServiceSpringImpl.class);

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public long add(StudentDTO dto) throws DuplicateRecordException {
		log.debug("StudentServiceSpringImpl add method started");
		StudentDTO existDto = dao.findByEmail(dto.getEmail());
		if(existDto!=null) {
			throw new DuplicateRecordException("EmailId already exist");
		}
		CollegeDTO collegeDTO = collegeService.findByPK(dto.getCollegeId());
		dto.setCollegeName(collegeDTO.getName());
		long pk = dao.add(dto);
		log.debug("StudentServiceSpringImpl add method ended");
		return pk;
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void update(StudentDTO dto) throws DuplicateRecordException {
		log.debug("StudentServiceSpringImpl update method started");
		StudentDTO existDto = dao.findByEmail(dto.getEmail());
		if(existDto!=null && existDto.getId()!=dto.getId()) {
			throw new DuplicateRecordException("EmailId already exist");
		}
		CollegeDTO collegeDTO = collegeService.findByPK(dto.getCollegeId());
		dto.setCollegeName(collegeDTO.getName());
		dao.update(dto);
		log.debug("StudentServiceSpringImpl update method ended");
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void delete(long id) {
		log.debug("StudentServiceSpringImpl delete method started");
		StudentDTO dto = dao.findByPK(id);
		dao.delete(dto);
		log.debug("StudentServiceSpringImpl delete method ended");
	}

	@Transactional(readOnly=true)
	public StudentDTO findByEmail(String email) {
		log.debug("StudentServiceSpringImpl findByEmail method started");
		StudentDTO dto = dao.findByEmail(email);
		log.debug("StudentServiceSpringImpl findByEmail method ended");
		return dto;
	}

	@Transactional(readOnly=true)
	public StudentDTO findByPK(long pk) {
		log.debug("StudentServiceSpringImpl findByPK method started");
		StudentDTO dto = dao.findByPK(pk);
		log.debug("StudentServiceSpringImpl findByPK method ended");
		return dto;
	}

	@Transactional(readOnly=true)
	public List search(StudentDTO dto, int pageNo, int pageSize) {
		log.debug("StudentServiceSpringImpl search method started");
		List list = dao.search(dto, pageNo, pageSize);
		log.debug("StudentServiceSpringImpl search method ended");
		return list;
	}

	@Transactional(readOnly=true)
	public List search(StudentDTO dto) {
		log.debug("StudentServiceSpringImpl search method started");
		List list = dao.search(dto);
		log.debug("StudentServiceSpringImpl search method ended");
		return list;
	}

}
