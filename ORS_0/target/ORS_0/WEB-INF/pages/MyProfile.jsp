<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@page isELIgnored="false"%>

<div class="container-fluid" style="margin-bottom:20px; ">
<div class="row">
<!-- <div class="col"> 
</div> -->
<div class="col-md-1"></div>
<div class="col-md-8 text-dark">

        <div class="modal-content" style="">
          
		  <div class="modal-header justify-content-center bg-dark">
            <h5 class="modal-title " id="ModalTitle">
              <s:message code="label.myprofile" />
            </h5>
          </div>
          
        
		  <div class="modal-body">
                <div class="form-group">
                <h3 class="error justify-content-center  text-center "><font color="red">${error}</font></h3>
                <h3 class="success justify-content-center  text-center "><font color="green"> ${success}</font></h3>
                </div>     
                
			    <sf:form method="post" commandName="form">
			    
			  <%--   	<fieldset>
				<legend><s:message code="label.acci"/></legend><hr></hr></fieldset>
			    --%><div class="form-group">
                
               <sf:label path="login"><s:message code="label.email"/><s:message code="label.id"/> <font color="red">*</font></sf:label>
               <sf:input path="login" class="form-control" placeholder="${enteremail}" readonly="true"/>
               <font color="red"><sf:errors path="login" cssClass="error"></sf:errors></font> 
            
               </div>
               
  	<fieldset><legend><s:message code="label.peri"/></legend></fieldset>
			   
			   <div class="row">
			   <div class="col-md-6">
			   <div class="form-group">
			   
               <sf:hidden path="id" />
               	<sf:hidden path="createdBy"/>
				<sf:hidden path="modifiedBy"/>
				<sf:hidden path="createdDatetime" />
				<sf:hidden path="modifiedDatetime" />
				
				
               <sf:label path="firstName">
               <s:message code="label.firstName"/> <font color="red">*</font></sf:label>
               <sf:input path="firstName" class="form-control" placeholder="${enterfirstName}" />
               <font color="red"><sf:errors path="firstName" cssClass="error"></sf:errors></font> 
               
               </div></div>  
               <div class="col-md-6">
			   <div class="form-group">
			   
               <sf:label path="lastName"><s:message code="label.lastName"/> <font color="red">*</font></sf:label>
               <sf:input path="lastName" class="form-control" placeholder="${enterLastName}" />
               <font color="red"><sf:errors path="lastName" cssClass="error"></sf:errors></font> 
               
             
               </div></div>   
              
                </div>    
              
              
              
              <div class="row"><div class="col-md-6">
			    <div class="form-group">
			    
                <!-- <label for="sel1">Gender</label>
                 -->
               
               <sf:label path=""><s:message code="label.gender"/> <font color="red">*</font></sf:label><br>
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <%--  <sf:input path="" class="form-control"/> --%>
               <sf:radiobutton path="gender" value="Male" /><s:message code="label.male" /> 
               <sf:radiobutton path="gender" value="Female" /><s:message code="label.female" />
               
               
               <font color="red"><sf:errors path="gender" cssClass="error"></sf:errors></font> 
               
				</div>
				</div>
				<div class="col-md-6">
			    <div class="form-group">
			    
               <sf:label path="dob"><s:message code="label.dob"/> <font color="red">*</font></sf:label>			 
               <sf:input path="dob" class="form-control" name="dob" id="datepicker" readonly="readonly" placeholder="${enterdob}"/>
               <font color="red"><sf:errors path="dob" cssClass="error"></sf:errors></font> 
               </div>
				</div></div>
			
			   <div class="form-group">
               <sf:label path="mobileNo"><s:message code="label.mobileNo"/> <font color="red">*</font></sf:label>
               <sf:input path="mobileNo" class="form-control" placeholder="${enterMobile}"/>
               <font color="red"><sf:errors path="mobileNo" cssClass="error"></sf:errors></font> 
               </div>
				
			
			 
			  
			<%--   <div class="form-group">
              
               <sf:label path="password"><s:message code="label.password"/> <font color="red">*</font></sf:label>
               <sf:password path="password" class="form-control" placeholder="${enterpassword}"/>
               <font color="red"><sf:errors path="password" cssClass="error"></sf:errors></font> 
              </div>	
					
			   <div class="form-group"> 
               <sf:label path="rePassword"><s:message code="label.confirmPassword"/> <font color="red">*</font></sf:label>
               <sf:password path="rePassword" class="form-control" placeholder="${enterconPassword}"/>
               <font color="red">${error1}<sf:errors path="rePassword" cssClass="error"></sf:errors></font> 
               </div> --%>
			
			
			 
			  <div class="row justify-content-center">
			  <div class="col-md-0"></div>
			  <div class="col-md-3">
			  <div class="form-group">
			  <button type="submit" class="btn btn-success btn-block" name="operation" value="Save">
			  <s:message code="label.save"/>
			  </button> </div></div>
              
              
              <div class="col-md-3">
			  <button type="submit" class="btn btn-primary btn-block" name="operation" value="ChangePassword">
			  <s:message code="label.changepassword"/>
			  </button> </div>  
			 </div>
			 
     </sf:form>      
          </div>
         
        </div>
     
     
     </div>

</div>
</div>

<script>
		$(function() {
			$("#datepicker").datepicker({
				dateFormat : 'mm/dd/yy',
				defaultDate : "01/01/1982",
				changeMonth : true,
				changeYear : true,
				yearRange : '-35:-18' 
			});

		});
	</script>



     