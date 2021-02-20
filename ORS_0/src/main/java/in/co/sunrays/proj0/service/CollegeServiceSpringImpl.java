package in.co.sunrays.proj0.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.sunrays.proj0.dao.CollegeDAOInt;
import in.co.sunrays.proj0.dto.CollegeDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;

@Service("collegeService")
public class CollegeServiceSpringImpl implements CollegeServiceInt{
	
	@Autowired
	private CollegeDAOInt dao;
	
	public static Logger log = Logger.getLogger(CollegeServiceSpringImpl.class);

	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public long add(CollegeDTO dto) throws DuplicateRecordException {
		log.debug("CollegeServiceSpringImpl add method started");
		CollegeDTO existDto = new CollegeDTO();
		existDto=dao.findByName(dto.getName());
		if(existDto!=null) {
			throw new DuplicateRecordException("College Name already exist");
		}
		long pk = dao.add(dto);
		log.debug("CollegeServiceSpringImpl add method ended");
		return pk;
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void update(CollegeDTO dto) throws DuplicateRecordException {
		log.debug("CollegeServiceSpringImpl update method started");
		CollegeDTO existDto = dao.findByName(dto.getName());
		if(existDto!=null && existDto.getId()!=dto.getId()) {
			throw new DuplicateRecordException("College Name already Exist");
		}
		dao.update(dto);
		log.debug("CollegeServiceSpringImpl update method ended");
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void delete(long id) {
		log.debug("CollegeServiceSpringImpl delete method started");
		CollegeDTO dto = dao.findByPK(id);
		dao.delete(dto);
		log.debug("CollegeServiceSpringImpl delete method ended");
	}

	@Transactional(readOnly=true)
	public CollegeDTO findByName(String name) {
		log.debug("CollegeServiceSpringImpl findByName method started");
		CollegeDTO dto = dao.findByName(name);
		log.debug("CollegeServiceSpringImpl findByName method ended");
		return dto;
	}

	@Transactional(readOnly=true)
	public CollegeDTO findByPK(long id) {
		log.debug("CollegeServiceSpringImpl findByPK method started");
		CollegeDTO dto = dao.findByPK(id);
		log.debug("CollegeServiceSpringImpl findByPK method ended");
		return dto;
	}

	@Transactional(readOnly=true)
	public List search(CollegeDTO dto) {
		log.debug("CollegeServiceSpringImpl search method started");
		List list  = dao.search(dto);
		log.debug("CollegeServiceSpringImpl search method ended");
		return list;
	}

	@Transactional(readOnly=true)
	public List search(CollegeDTO dto, int pageNo, int pageSize) {
		log.debug("CollegeServiceSpringImpl search method started");
		List list = dao.search(dto, pageNo, pageSize);
		log.debug("CollegeServiceSpringImpl search method ended");
		return list;
	}

}
