package in.co.sunrays.proj0.exception;
/**
 * DatabaseException is propogated by DAO classes when an unhandled Database
 * exception occurred
 * 
 * @author SessionFacade
 * @version 1.0 Copyright (c) SessionFacade
 */
public class DatabaseException extends Exception{
public DatabaseException(String msg) {
	super(msg);
}
}
