package in.co.sunrays.proj0.controller;

import java.util.List; 

import java.util.Locale;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.co.sunrays.proj0.dto.CourseDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;
import in.co.sunrays.proj0.form.CourseForm;
import in.co.sunrays.proj0.service.CourseServiceInt;

import in.co.sunrays.proj0.dto.UserDTO;

/**
 * Course functionality Controller. Performs operation for add,update,delete and find list
 * @author SessionFacade
 * @version 1.0 Copyright (c) SessionFacade
 */
@Controller
@RequestMapping(value="/ctl/Course")
public class CourseCtl extends BaseCtl{
	
	private static Logger log = Logger.getLogger(CourseCtl.class);
	
	@Autowired
	private CourseServiceInt service;
	
	/**
     * i18n Message source
     */
	@Autowired
	private MessageSource messageSource;
	
	
	
	@Override
	public void preload(Model model) {
		List list = service.search(null);
		model.addAttribute("courseList", list);
	}
	
	
	
	
	/**
     * Display Course view.
     * 
     * @param id:
     * 			Primary Key
     * @param form:
     * 				Object of CourseForm
     * @param model:
     * 				Object of Model Interface
     * @return Course:
     * 				View of Course Form
     */
	@RequestMapping(value="/Course",method=RequestMethod.GET)
	public String display(@RequestParam(required=false) Long id, @ModelAttribute("form") CourseForm form, Model model) {
		log.debug("CourseCtl display method to display CourseForm started");
		if(id!=null && id>0) {
			form.populate(service.findByPK(id));
		}
		log.debug("CourseCtl display method to display CourseForm ended");
		return "Course";
	}
	/**
     * Submit Course view.
     * @param session:
     * 					Object of HttpSession
     * @param bindingResult:
     * 						Object of BindingResult
     * @param locale:
     * 					Object of Locale
     * @param operation:
     * 					Operation given by User
     * @param form:
     * 				Object of CourseForm
     * @param model:
     * 				Object of Model Interface
     * @return Course:
     * 					View of Course Form
     */
	@RequestMapping(value="/Course",method=RequestMethod.POST)
	public String submit(@RequestParam String operation, Model model, Locale locale, @ModelAttribute("form") @Valid CourseForm form, BindingResult bindingResult, HttpSession session) {
		log.debug("CourseCtl submit method to submit CourseForm started");
		CourseDTO dto = (CourseDTO) form.getDto();
		if(OP_SAVE.equalsIgnoreCase(operation)) {
			if(bindingResult.hasErrors()) {
				return "Course";
			}
			try {
				if(dto.getId()>0) {
					service.update(dto);
	    			String msg=messageSource.getMessage("message.updatesuccess",null,locale);
				    model.addAttribute("success",msg);
				    model.addAttribute("id",dto.getId());
				    return "Course";
				}else {
					UserDTO userDto = (UserDTO) session.getAttribute("user");
					dto.setCreatedBy(userDto.getLogin());
					dto.setModifiedBy(userDto.getLogin());
					service.add(dto);
					String msg=messageSource.getMessage("message.success",null,locale);
					model.addAttribute("success",msg);
				}
			}catch(DuplicateRecordException e) {
				String msg=messageSource.getMessage("error.coursename",null,locale);
			    model.addAttribute("error",msg);
			    return "Course";
			}
		}else if(OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/Course/Course";
		}else if(OP_CANCEL.equalsIgnoreCase(operation)) {
			return "redirect:/ctl/Course/Search";
		}
		log.debug("CourseCtl submit method to submit CourseForm ended");
		return "Course";
	}

	/**
     * Display CourseList view.
     * 
     * @param form:
     * 				Object of CourseForm
     * @param model:
     * 				Object of Model Interface
     * @return CourseList:
     * 						View of CourseList
     */ 
	@RequestMapping(value="/Search",method=RequestMethod.GET)
	public String display(@ModelAttribute("form") CourseForm form, Model model) {
		log.debug("CourseCtl display method to display CourseList started");
		model.addAttribute("list",service.search(null, form.getPageNo(),form.getPageSize()));
		System.out.println(" Mansur");
		System.out.println(service.search(null, form.getPageNo(),form.getPageSize()));
        model.addAttribute("findList",service.search(null));
		log.debug("CourseCtl display method to display CourseList ended");
		return "CourseList";
	}
	
	/**
     * submit CourseList view.
     * @param locale:
     * 					Object of Locale
     * @param operation:
     * 					Operation given by User
     * @param form:
     * 				Object of CourseForm
     * @param model:
     * 				Object of Model Interface
     * @return CourseList:
     * 						View of CourseList
     */
	@RequestMapping(value="/Search",method=RequestMethod.POST)
	public String submit(@RequestParam(required=false) String operation, @ModelAttribute("form") CourseForm form, Model model, Locale locale) {
		log.debug("CourseCtl submit method to submit CourseList started");
		model.addAttribute("findList",service.search(null));
		int pageNo=form.getPageNo();
		if(OP_PREVIOUS.equalsIgnoreCase(operation)) {
			pageNo--;
		}else if(OP_NEXT.equalsIgnoreCase(operation)) {
			pageNo++;
		}else if(OP_DELETE.equalsIgnoreCase(operation)) {
			if(form.getChk_1()!=null) {
				for (long id : form.getChk_1()) {
					service.delete(id);
				}
				String msg = messageSource.getMessage("message.deleterecord", null, locale);
				model.addAttribute("success", msg);
			}else {
				String msg = messageSource.getMessage("message.atleastone", null, locale);
				model.addAttribute("error1", msg);
			}
		}
		pageNo=(pageNo<1)?1:pageNo;
        form.setPageNo(pageNo);
        CourseDTO dto=(CourseDTO) form.getDto();
        
        List list=service.search(dto, pageNo, form.getPageSize());
		model.addAttribute("list",list);
		
		if(list.size()==0 && !OP_DELETE.equalsIgnoreCase(operation)){
			model.addAttribute("error", messageSource.getMessage("message.norecord", null, locale));
		}
        
        if(OP_RESET.equalsIgnoreCase(operation)){
        	return "redirect:/ctl/Course/Search";
        }else if(OP_NEW.equalsIgnoreCase(operation)){
        	return "redirect:/ctl/Course/Course";
	    }
		log.debug("CourseCtl submit method to submit CourseList ended");
		return "CourseList";
	}
}
