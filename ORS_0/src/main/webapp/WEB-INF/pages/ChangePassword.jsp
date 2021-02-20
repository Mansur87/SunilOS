<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@page isELIgnored="false"%>

<div class="container-fluid" style="margin-bottom:20px; ">
<div class="row">

<div class="col-md-2"></div> 
<div class="col-md-6 text-dark">

        <div class="modal-content" style="">
          
		  <div class="modal-header justify-content-center bg-dark">
            <h5 class="modal-title " id="ModalTitle">
              <s:message code="label.changepassword"></s:message>
            </h5>
          </div>
          
        
		        <div class="modal-body">
                <div class="form-group">
                <h3 class="error justify-content-center  text-center "><font color="red">${error}</font></h3>
                <h3 class="success justify-content-center  text-center "><font color="green"> ${success}</font></h3>
                </div>     
                
			    <sf:form method="post" commandName="form">      
                
                
                <div class="row">
				</div>
				<fieldset>
				<legend><s:message code="label.acci"/></legend><hr></hr></fieldset>
		        <s:message code="label.enteroldpassword" var="enterpassword"/>
		        <s:message code="label.enternewpassword" var="enternewpassword"/>		
		        <s:message code="label.enterconfirmpassword" var="enterconPassword"/>
			  
			  <div class="form-group">
              
               <sf:label path="oldPassword"><s:message code="label.oldPassword"/> <font color="red">*</font></sf:label>
               <sf:password path="oldPassword" class="form-control" placeholder="${enterpassword}"/>
               <font color="red"><sf:errors path="oldPassword" cssClass="error"></sf:errors></font> 
              </div>	
					
			  <div class="form-group">
               <sf:label path="newPassword"><s:message code="label.newPassword"/> <font color="red">*</font></sf:label>
               <sf:password path="newPassword" class="form-control" placeholder="${enternewpassword}"/>
               <font color="red"><sf:errors path="newPassword" cssClass="error"></sf:errors></font> 
              </div>			
					
			   <div class="form-group"> 
               <sf:label path="confirmPassword"><s:message code="label.repassword"/> <font color="red">*</font></sf:label>
               <sf:password path="confirmPassword" class="form-control" placeholder="${enterconPassword}"/>
               <font color="red">${error1}<sf:errors path="confirmPassword" cssClass="error"></sf:errors></font> 
               </div>
			
			
			 
			  <div class="row justify-content-center">
			  <div class="col-md-0"></div>
			  <div class="col-md-3">
			  <div class="form-group">
			  <button type="submit" class="btn btn-success btn-block" name="operation" value="Save">
			  <s:message code="label.save"/>
			  </button> </div></div>
              
              
              <div class="col-md-3">
			  <button type="submit" class="btn btn-danger btn-block" name="operation" value="cancel">
			  <s:message code="label.cancel"/>
			  </button> </div>  
			 </div>
			 
     </sf:form>      
          </div>
         
        </div>
     
     
     </div>

</div>
</div>





     