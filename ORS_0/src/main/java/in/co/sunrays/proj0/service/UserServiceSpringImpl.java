package in.co.sunrays.proj0.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.sunrays.proj0.dao.RoleDAOInt;
import in.co.sunrays.proj0.dao.UserDAOInt;
import in.co.sunrays.proj0.dto.RoleDTO;
import in.co.sunrays.proj0.dto.UserDTO;
import in.co.sunrays.proj0.exception.ApplicationException;
import in.co.sunrays.proj0.exception.DuplicateRecordException;
import in.co.sunrays.proj0.util.EmailBuilder;

/**
 * User Service Spring Implementation
 * 
 * @author SessionFacade
 * @version 1.0 Copyright (c) SessionFacade
 */
@Service("userService")
public class UserServiceSpringImpl implements UserServiceInt{

	@Autowired
SessionFactory sessionFactory = null;
	
	@Autowired
	private UserDAOInt udao;
	
	@Autowired
	private RoleDAOInt rdao;
	
	@Autowired
	private JavaMailSenderImpl mailSender;
	
	public static Logger log = Logger.getLogger(UserServiceSpringImpl.class);
	
	public void setMailSender(JavaMailSenderImpl mailSender) {
		this.mailSender = mailSender;
	}

	public void setDao(UserDAOInt udao) {
		this.udao = udao;
	}

	/**
	 * Add a User
	 * 
	 * @param dto:
	 * 				Object of UserDTO
	 * @return pk:
	 * 				Primary Key
	 * 
	 * @throws DuplicateRecordException when UserId already exist.
	 */
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public long add(UserDTO dto) throws DuplicateRecordException {
		log.debug("UserServiceSpringImpl add method started");
		UserDTO existDto = udao.findByLogin(dto.getLogin());
		if(existDto!=null) {
			throw new DuplicateRecordException("Email Id already exist");
		}
		long pk = udao.add(dto);
		log.debug("UserServiceSpringImpl add method ended");
		return pk;
	}

	/**
	 * Register a User
	 * 
	 * @param dto:
	 * 				Object of UserDTO
	 * @return pk:
	 * 				Primary Key
	 * 
	 * @throws DuplicateRecordException when UserId already exist.
	 */
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public long registerUser(UserDTO dto) throws DuplicateRecordException {
		log.debug("UserServiceSpringImpl registerUser method started");
		long pk  = add(dto);
		
		/*
		 * HashMap<String,String> map=new HashMap<String,String>();
		 * map.put("login",dto.getLogin()); map.put("password",dto.getPassword());
		 * 
		 * String message = EmailBuilder.getUserRegistrationMessage(map);
		 * 
		 * MimeMessage msg = mailSender.createMimeMessage(); try { MimeMessageHelper
		 * helper = new MimeMessageHelper(msg); helper.setTo(dto.getLogin()); helper.
		 * setSubject("Registration is successful for ORS Project SUNRAYS Technologies."
		 * ); helper.setText(message, true); mailSender.send(msg);
		 * }catch(MessagingException e) { e.printStackTrace(); }
		 */		
		log.debug("UserServiceSpringImpl registerUser method ended");
		return pk;
	}

	/**
	 * Update a User
	 * 
	 * @param dto:
	 * 				Object of UserDTO
	 * 
	 * @throws DuplicateRecordException when UserId already exist.
	 */
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void update(UserDTO dto) throws DuplicateRecordException {
		log.debug("UserServiceSpringImpl update method started");
		UserDTO existDto = udao.findByLogin(dto.getLogin());
		if(existDto!=null && existDto.getId()!=dto.getId()) {
			throw new DuplicateRecordException("Login Id already exist");
		}
		udao.update(dto);
		log.debug("UserServiceSpringImpl update method ended");
	}

	/**
	 * Delete a User
	 * 
	 * @param id:
	 * 				Primary Key
	 */
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void delete(long id) {
		log.debug("UserServiceSpringImpl delete method started");
		UserDTO dto = udao.findByPK(id);
		udao.delete(dto);
		log.debug("UserServiceSpringImpl delete method ended");
	}

	/**
	 * Find User by Login
	 * 
	 * @param login:
	 * 				Login Id of User
	 * @return dto:
	 * 				Object of UserDTO
	 */
	@Transactional(readOnly=true)
	public UserDTO findByLogin(String login) {
		log.debug("UserServiceSpringImpl findByLogin method started");
		UserDTO dto = udao.findByLogin(login);
		log.debug("UserServiceSpringImpl findByLogin method ended");
		return dto;
	}

	/**
	 * Find User by PK
	 * 
	 * @param pk:	
	 * 				Primary Key
	 * @return dto:
	 * 				Object of UserDTO
	 */
	@Transactional(readOnly=true)
	public UserDTO findByPK(long pk) {
		log.debug("UserServiceSpringImpl findByPK method started");
		UserDTO dto = udao.findByPK(pk);
		log.debug("UserServiceSpringImpl findByPK method ended");
		return dto;
	}

	/**
	 * Search user with pagination
	 * 
	 * @param dto:
	 * 				Object of UserDTO
	 * @param pageNo:
	 * 					PageNo
	 * @param pageSize:
	 * 					PageeSize
	 * @return list:
	 * 				List of User
	 */
	@Transactional(readOnly=true)
	public List search(UserDTO dto, int pageNo, int pageSize) {
		log.debug("UserServiceSpringImpl search method started");
		List list = udao.search(dto, pageNo, pageSize);
		log.debug("UserServiceSpringImpl search method ended");
		return list;
	}

	/**
	 * Search user
	 * 
	 * @param dto:
	 * 				Object of UserDTO 
	 * @return list:
	 * 				List of User
	 */
	@Transactional(readOnly=true)
	public List search(UserDTO dto) {
		log.debug("UserServiceSpringImpl search method started");
		List list = udao.search(dto);
		log.debug("UserServiceSpringImpl search method ended");
		return list;
	}

	/**
	 * Change password of the user
	 * 
	 * @param id:
	 * 				Primary Key
	 * @param oldPassword:
	 * 						User Old Password
	 * @param newPassword:
	 * 						User new Password
	 * @return flag:
	 * 					A boolean value
	 * 
	 * @throws DuplicateRecordException when UserId already exist.
	 */
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public boolean changePassword(long id, String oldPassword, String newPassword) throws DuplicateRecordException {
		log.debug("UserServiceSpringImpl changePassword method started");
		UserDTO dto = findByPK(id);
		if(oldPassword.equals(dto.getPassword())) {
			dto.setPassword(newPassword);
			update(dto);
			
			HashMap<String,String> map=new HashMap<String,String>();
			map.put("login",dto.getLogin());
			map.put("password",dto.getPassword());
			map.put("firstName", dto.getFirstName());
			map.put("lastName", dto.getLastName());
			String message = EmailBuilder.getChangePasswordMessage(map);
			
			MimeMessage msg = mailSender.createMimeMessage();
			try {
				MimeMessageHelper helper = new MimeMessageHelper(msg);
				helper.setTo(dto.getLogin());
				helper.setSubject("Password is change successful for ORS Project SUNRAYS Technologies.");
				helper.setText(message, true);
				mailSender.send(msg);
			}catch(MessagingException e) {
				e.printStackTrace();
			}
			return true;
		}else {
			return false;
		}
	}

	/**
	 * User authentication
	 * 
	 * @param dto:
	 * 				Object of UserDTO
	 * @return dto:
	 * 				Object of UserDTO
	 */
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public UserDTO authenticate(String login,String password ) {
		log.debug("UserServiceSpringImpl authenticate method started");
		/*
		 * UserDTO existDto = udao.findByLogin(dto.getLogin()); UserDTO truedto = null;
		 * if(existDto!=null && existDto.getPassword().equals(dto.getPassword())) {
		 * existDto.setLastLogin(new Timestamp(new Date().getTime()));
		 * udao.update(existDto); truedto=existDto; }
		 */
		
		UserDTO dto = null;
		Query q = sessionFactory.openSession().createQuery("from UserDTO where login=? and password=?");
		q.setString(0, login);
		q.setString(1, password);
		List list = q.list();
		if (list.size() > 0) {
			dto = (UserDTO) list.get(0);
		} else {
			dto = null;
		}
		
		
		
		log.debug("UserServiceSpringImpl authenticate method ended");
		return dto;
	}

	/**
	 * Lock User for certain time duration
	 * 
	 * @param login:
	 * 					Loginid of User
	 * @return flag:
	 * 					A boolean value
	 */
	@Transactional(propagation=Propagation.REQUIRES_NEW, readOnly=false)
	public boolean lock(String login) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Reset password of the user with autogenerated password
	 * 
	 * @param login:
	 * 					Login Id of User
	 * @return flag:
	 * 					A boolean value
	 * 
	 * @throws ApplicationException when there is a logical error.
	 */
	@Transactional(propagation=Propagation.REQUIRES_NEW, readOnly=false)
	public boolean resetPassword(String login) throws ApplicationException {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Send the password of user to his email
	 * 
	 * @param login:
	 * 				User Login Id
	 * @return flag:
	 * 				A boolean value
	 * 
	 * @throws ApplicationException when there is a logical error.
	 */
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public boolean forgetPassword(String login) throws ApplicationException {
		log.debug("UserServiceSpringImpl forgetPassword method started");
		UserDTO dto = findByLogin(login);
		if(dto!=null) {
			HashMap<String,String> map=new HashMap<String,String>();
			map.put("login",dto.getLogin());
			map.put("password",dto.getPassword());
			map.put("firstName", dto.getFirstName());
			map.put("lastName", dto.getLastName());
			String message = EmailBuilder.getForgetPasswordMessage(map);
			
			MimeMessage msg = mailSender.createMimeMessage();
			try {
				MimeMessageHelper helper = new MimeMessageHelper(msg);
				helper.setTo(dto.getLogin());
				helper.setSubject("ForgetPassword is send successful for ORS Project SUNRAYS Technologies.");
				helper.setText(message,true);
				mailSender.send(msg);
			}catch(MessagingException e) {
				e.printStackTrace();
			}
			return true;
		}else {
			return false;
		}
	}

	/**
	 * Get user roles
	 * 
	 * @param dto:
	 * 				Object of UserDTO
	 * @return rdto:
	 * 				Object of RoleDTO
	 */
	@Transactional(readOnly=true)
	public RoleDTO getRole(UserDTO dto) {
		log.debug("UserServiceSpringImpl getRole method started");
		RoleDTO rdto = rdao.findByPK(dto.getRoleId());
		log.debug("UserServiceSpringImpl getRole method ended");
		return rdto;
	}

	/**
	 * Update User access
	 * 
	 * @param dto:
	 * 				Object of UserDTO
	 * @return dto:
	 * 				Object of UserDTO
	 */
	@Transactional(propagation=Propagation.REQUIRES_NEW, readOnly=false)
	public UserDTO updateAccess(UserDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
