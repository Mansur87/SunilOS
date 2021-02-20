package in.co.sunrays.proj0.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * It's parent abstract class of all ctl classes 
 * @author SessionFacade
 * @version 1.0 Copyright (c) SessionFacade
 */
public abstract class BaseCtl {
	
	/**
	 * Operation Constants
	 */
	protected static final String OP_SAVE = "Save";
    protected static final String OP_CHANGEPASSWORD = "ChangePassword";
    protected static final String OP_SEARCH = "Search";
    protected static final String OP_NEW = "New";
    protected static final String OP_DELETE = "Delete";
    protected static final String OP_CANCEL = "Cancel";
    protected static final String OP_RESET = "Reset";  
    protected static final String OP_ERROR = "Error";
    protected static final String OP_NEXT = "Next";
    protected static final String OP_PREVIOUS = "Previous";
    protected static final String OP_LOGOUT = "Logout";
    protected static final String OP_GO = "Go";
    protected static final String OP_GET = "Get";
    public static final String Physics = "Physics";
	public static final String Chemistry = "Chemistry";
	public static final String MATHS = "Maths";
	public static final int MAX_MARKS = 100;
	public static final int MIN_MARKS = 35;
	public static final int TOTAL_MARKS = MAX_MARKS * 3;
	
	/**
     * Loads preloaded data and stores in Model object.
     * @param model:
     * 				Object of Model Interface
     */
    @ModelAttribute
     public void preload(Model model){
    	System.out.println("this is preload method");
     }

}
