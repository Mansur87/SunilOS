package in.co.sunrays.proj0.exception;
/**
 * ApplicationException is propogated from Service classes when an business
 * logic exception occurered.
 * 
 * @author SessionFacade
 * @version 1.0 Copyright (c) SessionFacade
 *
 */
public class ApplicationException extends Exception{
	public ApplicationException(String msg)
	{
		super(msg);
		}
}
