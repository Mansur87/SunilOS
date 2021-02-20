package in.co.sunrays.proj0.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.sunrays.proj0.dao.MarksheetDAOInt;
import in.co.sunrays.proj0.dto.MarksheetDTO;
import in.co.sunrays.proj0.dto.StudentDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;

@Service("marksheetService")
public class MarksheetServiceSpringImpl implements MarksheetServiceInt{

	@Autowired
	private MarksheetDAOInt dao;
	
	@Autowired
	private StudentServiceInt studentService;
	
	public static Logger log = Logger.getLogger(MarksheetServiceSpringImpl.class);

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public long add(MarksheetDTO dto) throws DuplicateRecordException {
		log.debug("MarksheetServiceSpringImpl add method started");
		MarksheetDTO existDto = dao.findByRollNo(dto.getRollNo());
		if(existDto!=null) {
			throw new DuplicateRecordException("RollNo already exist");
		}
		StudentDTO studentDTO = studentService.findByPK(dto.getStudentId());
		dto.setStudentName(studentDTO.getFirstName()+" "+studentDTO.getLastName());
		long pk = dao.add(dto);
		log.debug("MarksheetServiceSpringImpl add method ended");
		return pk;
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void update(MarksheetDTO dto) throws DuplicateRecordException {
		log.debug("MarksheetServiceSpringImpl update method started");
		MarksheetDTO existDto = dao.findByRollNo(dto.getRollNo());
		if(existDto!=null && existDto.getId()!=dto.getId()) {
			throw new DuplicateRecordException("RollNo already exist");
		}
		StudentDTO studentDTO = studentService.findByPK(dto.getStudentId());
		dto.setStudentName(studentDTO.getFirstName()+" "+studentDTO.getLastName());
		dao.update(dto);
		log.debug("MarksheetServiceSpringImpl update method ended");
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void delete(long id) {
		log.debug("MarksheetServiceSpringImpl delete method started");
		MarksheetDTO dto = dao.findByPK(id);
		dao.delete(dto);
		log.debug("MarksheetServiceSpringImpl delete method ended");
	}

	@Transactional(readOnly=true)
	public MarksheetDTO findByRollNo(String rollNo) {
		log.debug("MarksheetServiceSpringImpl findByRollNo method started");
		MarksheetDTO dto = dao.findByRollNo(rollNo);
		log.debug("MarksheetServiceSpringImpl findByRollNo method ended");
		return dto;
	}

	@Transactional(readOnly=true)
	public MarksheetDTO findByPK(long pk) {
		log.debug("MarksheetServiceSpringImpl findByPK method started");
		MarksheetDTO dto = dao.findByPK(pk);
		log.debug("MarksheetServiceSpringImpl findByPK method ended");
		return dto;
	}

	@Transactional(readOnly=true)
	public List search(MarksheetDTO dto) {
		log.debug("MarksheetServiceSpringImpl search method started");
		List list = dao.search(dto);
		log.debug("MarksheetServiceSpringImpl search method ended");
		return list;
	}

	@Transactional(readOnly=true)
	public List search(MarksheetDTO dto, int pageNo, int pageSize) {
		log.debug("MarksheetServiceSpringImpl search method started");
		List list = dao.search(dto, pageNo, pageSize);
		log.debug("MarksheetServiceSpringImpl search method ended");
		return list;
	}

	@Transactional(readOnly=true)
	public List getMeritList(int pageNo, int pageSize) {
		log.debug("MarksheetServiceSpringImpl getMeritList method started");
		List list = dao.getMeritList(pageNo, pageSize);
		log.debug("MarksheetServiceSpringImpl getMeritList method ended");
		return list;
	}
}
