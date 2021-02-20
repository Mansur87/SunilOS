package in.co.sunrays.proj0.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * welcome functionality Controller. Performs operation for open welcome page
 * @author SessionFacade
 * @version 1.0 Copyright (c) SessionFacade
 */
@Controller
@RequestMapping(value="/Welcome")
public class WelcomeCtl {
	
	/**
	 * To show welcome page
	 * 
	 * @param model:
	 * 				Object of Model Interface
	 * @return Welcome:
	 * 					View of Welcome Page
	 *
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String display( ModelMap model) {
	
		return "Welcome";
	}

}
