package in.co.sunrays.proj0.controller;



import java.sql.Timestamp;
import java.util.Date;
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

import in.co.sunrays.proj0.dto.UserDTO;
import in.co.sunrays.proj0.exception.DuplicateRecordException;
import in.co.sunrays.proj0.form.ChangePasswordForm;
import in.co.sunrays.proj0.form.MyProfileForm;
import in.co.sunrays.proj0.form.UserForm;
import in.co.sunrays.proj0.service.RoleServiceInt;
import in.co.sunrays.proj0.service.UserServiceInt;
import in.co.sunrays.proj0.util.Util;

@Controller
@RequestMapping("/ctl/User")
public class UserCtl  extends BaseCtl{
	
private static Logger log=Logger.getLogger(UserCtl.class);

@Autowired
private UserServiceInt service;


@Autowired
private RoleServiceInt roleService;

@Autowired
private MessageSource messageSource;

@Override
public void preload(Model model) {
	List list = roleService.search(null);
	model.addAttribute("roleList", list);
	model.addAttribute("userList",service.search(null));
}


                               /* MY PROFILE VIEW*/

//Show Myprofile Data
@RequestMapping(value="/Myprofile",method=RequestMethod.GET)
public String displayProfile(@ModelAttribute("form") MyProfileForm form,HttpSession session,Model model,Locale locale){
	log.debug("UserCtl displayProfile method to display MyProfile started");
	UserDTO dto=(UserDTO) session.getAttribute("user");
	form.populate(dto);
	log.debug("UserCtl displayProfile method to display MyProfile started");
	return "Myprofile";
}


//Update MyProfile Data
@RequestMapping(value="/Myprofile", method=RequestMethod.POST)
public String submitProfile(@ModelAttribute("form") @Valid MyProfileForm form,Model model,Locale locale,BindingResult bindingResult,HttpSession session ){
	log.debug("UserCtl submitProfile method to submit MyProfile started");
	
	if(OP_SAVE.equalsIgnoreCase(form.getOperation())){
	if(bindingResult.hasErrors()){
		return "MyProfile";
		}
	UserDTO dto=service.findByPK(form.getId());
	dto.setFirstName(form.getFirstName());
	dto.setLastName(form.getLastName());
	dto.setDob(Util.getDate(form.getDob()));
	dto.setMobileNo(form.getMobileNo());
	dto.setGender(form.getGender());
	dto.setModifiedBy(form.getLogin());
	dto.setModifiedDatetime(new Timestamp(new Date().getTime()));
	session.setAttribute("user", dto);
	try{
		service.update(dto);
		String msg=messageSource.getMessage("message.success",null,locale);
		model.addAttribute("Update Message",msg);
	}catch(DuplicateRecordException e){
		String msg=messageSource.getMessage("error.loginid",null,locale);
		model.addAttribute("error",msg);
	}
	return "Myprofile";
	}
	if(OP_CHANGEPASSWORD.equalsIgnoreCase(form.getOperation())){
return "redirect:/ctl/User/ChangePassword";
	}
	log.debug("UserCtl submitProfile method to submit MyProfile ended");
	return "Myprofile";
}
                                         
													/*Change Password View*/

@RequestMapping(value="/ChangePassword",method=RequestMethod.GET)
public String displayChangePassword(@ModelAttribute("form") ChangePasswordForm form,Locale locale,HttpSession session,Model model){
	log.debug("UserCtl displayChangePassword method to display ChangePassword form started");
	log.debug("UserCtl displayChangePassword method to display ChangePassword form ended");
	return "ChangePassword";
}

@RequestMapping(value="/ChangePassword", method=RequestMethod.POST)
public String submitChangePassword(Locale locale, HttpSession session, @ModelAttribute("form") @Valid ChangePasswordForm form, BindingResult bindingResult, Model model) {
	log.debug("UserCtl submitChangePassword method to submit ChangePassword form started");
	if(OP_SAVE.equalsIgnoreCase(form.getOperation())) {
		if(bindingResult.hasErrors()) {
			return "ChangePassword";
		}
		
		boolean flag = false;
		UserDTO dto = (UserDTO) session.getAttribute("user");
		
		if(!form.getOldPassword().equals(form.getNewPassword())) {
			if(form.getConfirmPassword().equals(form.getNewPassword())) {
				try {
					flag=service.changePassword(dto.getId(), form.getOldPassword(), form.getNewPassword());
					if(flag) {
						String msg=messageSource.getMessage("message.success",null,locale);
						model.addAttribute("success",msg);
					}else {
						String msg=messageSource.getMessage("error.oldrightpassword",null,locale);
						model.addAttribute("error",msg);
					}
				}catch(DuplicateRecordException e) {
					
				}
			}else {
				String msg=messageSource.getMessage("error.newconpassword",null,locale);
				model.addAttribute("error",msg);
			}
		}else {
			String msg=messageSource.getMessage("error.oldnewpassword",null,locale);
			model.addAttribute("error",msg);
		}
	}
	if(OP_CANCEL.equalsIgnoreCase(form.getOperation())) {
		return "redirect:/ctl/User/Myprofile";
	}
	log.debug("UserCtl submitChangePassword method to submit ChangePassword form ended");
	return "ChangePassword";
}                                              
                                   


											/*  USER VIEW*/

//User Display View
@RequestMapping(value="/User",method=RequestMethod.GET)
public String displayUser(@RequestParam(required=false) Long id,@ModelAttribute("form") UserForm form,Model model,Locale locale){
	

	String enteremail=messageSource.getMessage("label.enteremail",null,locale);
	model.addAttribute("enteremail",enteremail);

	String enterpassword=messageSource.getMessage("label.enterpassword",null,locale);
	model.addAttribute("enterpassword",enterpassword);
	 
	String enterdob=messageSource.getMessage("label.enterdob",null,locale);
	model.addAttribute("enterdob",enterdob);
	 
	String enterfirstName=messageSource.getMessage("label.enterfname",null,locale);
	model.addAttribute("enterfirstName",enterfirstName);
	 
	String enterLastName=messageSource.getMessage("label.enterlname",null,locale);
	model.addAttribute("enterLastName",enterLastName);
	 
	String enterconPassword=messageSource.getMessage("label.entercpassword",null,locale);
	model.addAttribute("enterconPassword",enterconPassword);
	 
	String enterMobile=messageSource.getMessage("label.entermob",null,locale);
	model.addAttribute("enterMobile",enterMobile);  
	 
	String enterRoleName=messageSource.getMessage("label.select",null,locale);
	model.addAttribute("enterRoleName",enterRoleName);  
	 
	model.addAttribute("enterroleId",0);
	if(id!=null && id>0){
	UserDTO dto=service.findByPK(id);
	form.populate(dto);
	}
	log.debug("UserCtl displayUser method to display User form ended");
	return "User";
}




//User Submit Value
@RequestMapping(value="/User", method=RequestMethod.POST)
public String submitUser(@RequestParam String operation,@ModelAttribute("form") @Valid UserForm form,Model model,BindingResult bindingResult,Locale locale,HttpSession session){
	log.debug("Submitr User Start");
	
	String enteremail=messageSource.getMessage("label.enteremail",null,locale);
	model.addAttribute("enteremail",enteremail);

	String enterpassword=messageSource.getMessage("label.enterpassword",null,locale);
	model.addAttribute("enterpassword",enterpassword);
	 
	String enterdob=messageSource.getMessage("label.enterdob",null,locale);
	model.addAttribute("enterdob",enterdob);
	 
	String enterfirstName=messageSource.getMessage("label.enterfname",null,locale);
	model.addAttribute("enterfirstName",enterfirstName);
	 
	String enterLastName=messageSource.getMessage("label.enterlname",null,locale);
	model.addAttribute("enterLastName",enterLastName);
	 
	String enterconPassword=messageSource.getMessage("label.entercpassword",null,locale);
	model.addAttribute("enterconPassword",enterconPassword);
	 
	String enterMobile=messageSource.getMessage("label.entermob",null,locale);
	model.addAttribute("enterMobile",enterMobile);  
	 
	String enterRoleName=messageSource.getMessage("label.select",null,locale);
	model.addAttribute("enterRoleName",enterRoleName);  
	 
	model.addAttribute("enterroleId",0);
	
	UserDTO dto=(UserDTO) form.getDto();
	if(OP_SAVE.equalsIgnoreCase(form.getOperation())){
		if(bindingResult.hasErrors()){
			return "User";
		}
		if(!dto.getPassword().equals(dto.getRePassword())){
	String msg=	messageSource.getMessage("pattern.matchpass",null,locale);
	model.addAttribute("error1",msg);
	return "User";
		}
		try{
			if(dto.getId()>0){
				service.update(dto);
			String msg=messageSource.getMessage("message.updatesuccess",null, locale);
			model.addAttribute("success",msg);
			model.addAttribute("id",dto.getId());
			
			return "User";
			}
			else{
				UserDTO  userDto=(UserDTO) session.getAttribute("user");
				dto.setCreatedBy(dto.getLogin());
				dto.setModifiedBy(dto.getLogin());
				service.add(dto);
				String msg=messageSource.getMessage("message.success",null,locale);
				model.addAttribute("success",msg);
				return "User";
			}
			
		}catch(DuplicateRecordException e){
		String msg=	messageSource.getMessage("error.loginid",null,locale);
		model.addAttribute("error",msg);
		return "User";
		}
	}else if(OP_RESET.equalsIgnoreCase(form.getOperation())) {
		return "redirect:/ctl/User/User";
	}else if(OP_CANCEL.equalsIgnoreCase(form.getOperation())) {
		return "redirect:/ctl/User/Search";
	}
	log.debug("UserCtl submitUser method to submit User form ended");
	return "User";
}



					/*USER LIST VIEW*/

//UserList Get Method
@RequestMapping(value="/Search",method=RequestMethod.GET)
public String display(@ModelAttribute("form") UserForm form,Model model){
	log.debug("UserCtl display method to display User List started");
model.addAttribute("list",service.search(null, form.getPageNo(), form.getPageSize()));
model.addAttribute("findList",service.search(null));
model.addAttribute("roleList",roleService.search(null,form.getPageNo(),form.getPageSize()));
log.debug("UserCtl display method to display User List ended");
return "UserList";
}


//UserList Post Method
public String submit(@RequestParam(required=false)  String operation,@ModelAttribute("form") UserForm form,Model model,BindingResult bindingresult,Locale locale){
	log.debug("UserCtl submit method to submit User List started");
	model.addAttribute("findList",service.search(null));
	int pageNo=form.getPageNo();
	if(OP_PREVIOUS.equalsIgnoreCase(form.getOperation())){
		pageNo--;
	}
	else if(OP_NEXT.equalsIgnoreCase(form.getOperation())){
     pageNo++;		
	}
	else if(OP_DELETE.equalsIgnoreCase(form.getOperation())){
		if(form.getChk_1()!=null){
			for(long id:form.getChk_1() ){
				service.delete(id);
			}
			String msg = messageSource.getMessage("message.deleterecord", null, locale);
			model.addAttribute("success", msg);
		}
			else{
			String msg=	messageSource.getMessage("message.atleastone",null,locale);
				model.addAttribute("error",msg);
			}
		}
		
	pageNo=(pageNo<1)?1:pageNo;
	form.setPageNo(pageNo);
	UserDTO dto=(UserDTO) form.getDto();
List list=	service.search(dto, form.getPageNo(), form.getPageSize());
	model.addAttribute("list",list);
	if(list.size()==0 && !OP_DELETE.equalsIgnoreCase(form.getOperation())){
		model.addAttribute("error", messageSource.getMessage("message.norecord", null, locale));
	}
	if(OP_RESET.equalsIgnoreCase(operation)){
    	return "redirect:/ctl/User/Search";
	}
	else if(OP_NEW.equalsIgnoreCase(operation)){
	    	return "redirect:/ctl/User/User";
		}
	log.debug("UserCtl submit method to submit User List ended");
	return "UserList";
}

}


