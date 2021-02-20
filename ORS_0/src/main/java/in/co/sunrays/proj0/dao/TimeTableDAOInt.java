package in.co.sunrays.proj0.dao;

import java.util.Date; 
import java.util.List;

import in.co.sunrays.proj0.dto.TimeTableDTO;

/**
 *  Timetable DAO interface.
 * 
 * @author SessionFacade
 * @version 1.0 Copyright (c) SessionFacade
 */
public interface TimeTableDAOInt {

	/**
	 * Add a TimeTable
	 * 
	 * @param dto:
	 * 				Object of TimeTableDTO
	 * @return pk:
	 * 				Primary Key
	 */
	public long add(TimeTableDTO dto);
	
	/**
	 * Update a TimeTable
	 * 
	 * @param dto:
	 * 				Object of TimeTableDTO
	 */
	public void update(TimeTableDTO dto);
	
	/**
	 * Delete a TimeTable
	 * 
	 * @param dto:
	 * 				Object of TimeTableDTO
	 */
	public void delete(TimeTableDTO dto);
	
	/**
	 * Find TimeTable by PK
	 * 
	 * @param pk:
	 * 			Primary Key
	 * @return dto:
	 * 				Object of TimeTableDTO
	 */
	public TimeTableDTO findByPK(long pk);
	
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
	 * 					List of TimeTable
	 */
	public List<TimeTableDTO> search(TimeTableDTO dto, int pageNo, int pageSize);
	
	/**
	 * Search TimeTable
	 * 
	 * @param dto:
	 * 				Object of TimeTableDTO
	 * @return list:
	 * 				List of TimeTable
	 */
	public List<TimeTableDTO> search(TimeTableDTO dto);
	
	/**
	 * Find TimeTable by CourseName,SubjectName,examDate,examTime
	 * 
	 * @param courseName:
	 * 						CourseName
	 * @param subjectName:
	 * 						SubjectName
	 * @param examDate:
	 * 						ExamDate
	 * @param examTime:
	 * 						ExamTime
	 * @return dto:
	 * 					Object of TimeTableDTO
	 */
	public TimeTableDTO findByNameDateTime(String courseName,String subjectName,Date examDate, String examTime);
	
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
	public TimeTableDTO findByName(String courseName, String subjectName);
	
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
	public TimeTableDTO findByNameDate(String courseName, Date examDate);
}
