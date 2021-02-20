package in.co.sunrays.proj0.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.sunrays.proj0.dao.RoleDAOInt;
import in.co.sunrays.proj0.dto.RoleDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;

@Service("roleService")
public class RoleServiceSpringImpl implements RoleServiceInt{
	
	@Autowired
	private RoleDAOInt dao;
	
	public static Logger log = Logger.getLogger(RoleServiceSpringImpl.class);

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public long add(RoleDTO dto) throws DuplicateRecordException {
		log.debug("RoleServiceSpringImpl add method started");
		if(dao==null) {
			System.out.println("This is null...");
		}
		
		RoleDTO existDTO = dao.findByName(dto.getRoleName());
		
		if(existDTO!=null) {
			throw new DuplicateRecordException("Role name already exist");
		}
		long pk = dao.add(dto);
		log.debug("RoleServiceSpringImpl add method ended");
		return pk;
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void update(RoleDTO dto) throws DuplicateRecordException {
		log.debug("RoleServiceSpringImpl update method started");
		RoleDTO existDTO = dao.findByName(dto.getRoleName());
		if(existDTO!=null && existDTO.getId()!=dto.getId()) {
			throw new DuplicateRecordException("Role name already exist");
		}
		dao.update(dto);
		log.debug("RoleServiceSpringImpl update method ended");
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void delete(long id) {
		log.debug("RoleServiceSpringImpl delete method started");
		RoleDTO dto = dao.findByPK(id);
		dao.delete(dto);
		log.debug("RoleServiceSpringImpl delete method ended");
	}

	@Transactional(readOnly=true)
	public RoleDTO findByName(String roleName) {
		log.debug("RoleServiceSpringImpl findByName method started");
		RoleDTO dto = dao.findByName(roleName);
		log.debug("RoleServiceSpringImpl findByName method started");
		return dto;
	}

	@Transactional(readOnly=true)
	public RoleDTO findByPK(long pk) {
		log.debug("RoleServiceSpringImpl findByPK method started");
		RoleDTO dto = dao.findByPK(pk);
		log.debug("RoleServiceSpringImpl findByPK method ended");
		return dto;
	}

	@Transactional(readOnly=true)
	public List search(RoleDTO dto, int pageNo, int pageSize) {
		return dao.search(dto, pageNo, pageSize);
	}

	@Transactional(readOnly=true)
	public List search(RoleDTO dto) {
		return dao.search(dto);
	}

}
