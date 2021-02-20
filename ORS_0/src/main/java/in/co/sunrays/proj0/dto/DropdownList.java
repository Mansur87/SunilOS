package in.co.sunrays.proj0.dto;
/**
 * DropdownList interface is implemented by Beans those are used to create drop
 * down list on HTML pages
 *
 * @author SessionFacade
 * @version 1.0 Copyright (c) SessionFacade
 *
 */
public interface DropdownList {
	/**
	 * Returns key of list element
	 *
	 * @return key
	 */
 public String getKey();
 /**
	 * Returns display text of list element
	 *
	 * @return value
	 */
 public String getValue();
}
