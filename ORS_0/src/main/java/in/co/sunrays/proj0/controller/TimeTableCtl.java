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

import in.co.sunrays.proj0.form.TimeTableForm;
import in.co.sunrays.proj0.service.CourseServiceInt;
import in.co.sunrays.proj0.service.SubjectServiceInt;
import in.co.sunrays.proj0.service.TimeTableServiceInt;

import in.co.sunrays.proj0.dto.TimeTableDTO;
import in.co.sunrays.proj0.dto.UserDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;

/**
 * TimeTable functionality Controller. Performs operation for add,update,delete and find list
 * @author SessionFacade
 * @version 1.0 Copyright (c) SessionFacade
 */
@Controller
@RequestMapping(value="/ctl/TimeTable")
public class TimeTableCtl extends BaseCtl{
	
	private static Logger log = Logger.getLogger(TimeTableCtl.class);
	
	@Autowired
	private TimeTableServiceInt service;
	
	@Autowired
	private CourseServiceInt courseService;
	
	@Autowired
	private SubjectServiceInt subjectService;
	
	@Autowired
	private MessageSource messageSource;
	
	@Override
	public void preload(Model model) {
		log.debug("TimeTableCtl preload method started");
		model.addAttribute("courseList",courseService.search(null));
    	model.addAttribute("subjectList",subjectService.search(null));
		log.debug("TimeTableCtl preload method ended");
	}
	
	/**
     * Displays TimeTable View
     * @param id:
     * 				Primary Key
     * @param form:
     * 				Object of TimeTableForm
     * @param model:
     * 				Object of Model Interface
     * @return TimeTable:
     * 					View of TimeTable Form
     */
	@RequestMapping(value="/TimeTable", method=RequestMethod.GET)
	public String display(@RequestParam(required=false) Long id, @ModelAttribute("form") TimeTableForm form, Model model) {
		log.debug("TimeTableCtl display method to display TimeTableForm started");
		if(id!=null && id>0) {
			form.populate(service.findByPK(id));
		}
		log.debug("TimeTableCtl display method to display TimeTableForm ended");
		return "TimeTable";
	}
	
	/**
     * Submit TimeTable View
     * 
     * @param operation:
     * 					Operation given By User
     * @param form:
     * 				Object of TimeTableForm
     * @param bindingResult:
     * 						Object of BindingResult
     * @param model:	
     * 				Object of Model Interface
     * @param locale:
     * 					Object of Locale
     * @param session:
     * 					Object of HttpSession
     * @return TimeTable:
     * 					View of TimeTable Form
     */
	@RequestMapping(value="/TimeTable", method=RequestMethod.POST)
	public String submit(@RequestParam String operation, @ModelAttribute("form") @Valid TimeTableForm form, BindingResult bindingResult, Model model, Locale locale, HttpSession session) {
		log.debug("TimeTableCtl submit method to submit TimeTableForm started");
		UserDTO userDto = (UserDTO) session.getAttribute("user"); 
	    TimeTableDTO dto=(TimeTableDTO) form.getDto();
	    if(OP_SAVE.equalsIgnoreCase(operation)) {
	    	if(bindingResult.hasErrors()) {
	    		return "TimeTable";
	    	}
	    	try {
	    		if(dto.getId()>0) {
	    			dto.setModifiedBy(userDto.getLogin());
	      			service.update(dto);
	      			String msg=messageSource.getMessage("message.updatesuccess",null,locale);
	  			    model.addAttribute("success",msg);
	  			    model.addAttribute("id",dto.getId());
	    		}else {
	    			dto.setCreatedBy(userDto.getLogin());
	      			dto.setModifiedBy(userDto.getLogin());
	      			service.add(dto);
	      			String msg=messageSource.getMessage("message.success",null,locale);
	      			model.addAttribute("success", msg);
	    		}
	    	}catch(DuplicateRecordException e) {
	    		String msg=messageSource.getMessage("error.record",null,locale);
	  		    model.addAttribute("error",e.getMessage()+""+msg);
	  		    return "TimeTable";
	    	}
	    }else if(OP_RESET.equalsIgnoreCase(operation)) {
	    	return "redirect:/ctl/TimeTable/TimeTable";
	    }else if(OP_CANCEL.equalsIgnoreCase(operation)) {
	    	return "redirect:/ctl/TimeTable/Search";
	    }
		log.debug("TimeTableCtl submit method to submit TimeTableForm ended");
		return "TimeTable";
	}
	
	/**
     * Displays TimeTableList View
     * 
     * @param form:
     * 				Object of TimeTableForm
     * @param model:
     * 				Object of Model Interface
     * @return TimeTableList:
     * 						View of TimeTableList
     */
	@RequestMapping(value="/Search",method=RequestMethod.GET)
	public String display(@ModelAttribute("form") TimeTableForm form, Model model) {
		log.debug("TimeTableCtl display method to display TimeTableList started");
		model.addAttribute("list",service.search(null, form.getPageNo(),form.getPageSize()));
        model.addAttribute("findList",service.search(null));
		log.debug("TimeTableCtl display method to display TimeTableList ended");
		return "TimeTableList";
	}
	
	/**
     * Submit TimeTableList View
     * 
     * @param operation:
     * 					Operation given by User
     * @param form:
     * 				Object of TimeTableForm
     * @param model:
     * 				Object of Model Interface
     * @param locale:
     * 				Object of Locale
     * @return TimeTable:
     * 						View of TimeTableList
     */
	@RequestMapping(value="/Search",method=RequestMethod.POST)
	public String submit(@RequestParam(required=false) String operation, @ModelAttribute("form") TimeTableForm form, Model model, Locale locale) {
		log.debug("TimeTableCtl submit method to submit TimeTableList started");
		model.addAttribute("findList",service.search(null));
		int pageNo=form.getPageNo();
		if(OP_PREVIOUS.equalsIgnoreCase(operation)) {
			pageNo--;
		}else if(OP_NEXT.equalsIgnoreCase(operation)) {
			pageNo++;
		}else if(OP_DELETE.equalsIgnoreCase(operation)) {
			if(form.getChk_1()!=null) {
				for(long id:form.getChk_1()){
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
	    TimeTableDTO dto=(TimeTableDTO) form.getDto();
	    List list=service.search(dto, pageNo, form.getPageSize());
	    model.addAttribute("list", list);
	    if(list.size()==0 && !OP_DELETE.equalsIgnoreCase(operation) ){
	    	model.addAttribute("error", messageSource.getMessage("message.norecord", null, locale));
	  	}
	    if(OP_RESET.equalsIgnoreCase(operation)){
	    	return "redirect:/ctl/TimeTable/Search";
	    }else if(OP_NEW.equalsIgnoreCase(operation)){
	    	return "redirect:/ctl/TimeTable/TimeTable";
	    }
		log.debug("TimeTableCtl submit method to submit TimeTableList ended");
		return "TimeTableList";
	}

}
