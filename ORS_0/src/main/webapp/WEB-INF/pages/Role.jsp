<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@page isELIgnored="false"%>
<br><br>


<sf:form method="post" modelAttribute="form">
<div class="container" style="margin-bottom:20px; ">
<div class="row">

<!-- <div class="col-md-2"></div> 
 --><div class="col-md-10 text-dark">

        <div class="modal-content" style="">
          
		  <div class="modal-header justify-content-center bg-dark">
            <h5 class="modal-title " id="ModalTitle">
           <c:choose>
           <c:when test="${form.id==0}"><s:message code="label.addrole" /></c:when>
           <c:otherwise><s:message code="label.updaterole"></s:message></c:otherwise>
           </c:choose>   
              
           
            </h5>
          </div>
          
        
		  <div class="modal-body">
                <div class="form-group">
                <h4 class="error justify-content-center  text-center "><font color="red">${error}</font></h4>
                <h4 class="success justify-content-center  text-center "><font color="green"> ${success}</font></h4>
                </div>     
                
		   
			   <div class="row">
			   </div>
			   <div class="form-group">
			   
                <sf:hidden path="id" />
               	<sf:hidden path="createdBy"/>
				<sf:hidden path="modifiedBy"/>
				<sf:hidden path="createdDatetime" />
				<sf:hidden path="modifiedDatetime" />
				
				<s:message code="label.enterrname" var="role1"/>
               <sf:label path="roleName">
               <s:message code="label.role"/> <font color="red">*</font></sf:label>
               <sf:input path="roleName" class="form-control " placeholder="${role1}" />
               <font color="red"><sf:errors path="roleName" cssClass="error"></sf:errors></font> 
               
               </div>  
               
			   <div class="form-group">
			   <s:message code="label.enterdescription" var="description"/>
               <sf:label path="roleDescription"><s:message code="label.description"/> <font color="red">*</font></sf:label>
               <sf:textarea path="roleDescription" class="form-control" placeholder="${description}" />
               <%-- <sf:input path="roleDescription" class="form-control" placeholder="" /> --%>
               <font color="red"><sf:errors path="roleDescription" cssClass="error"></sf:errors></font> 
               </div>   
              
              
          
			
			
			 
			  <div class="row justify-content-center">
			  <div class="col-md-0"></div>
			  <div class="col-md-3">
			  <div class="form-group">
			  <button type="submit" class="btn btn-success btn-block" name="operation" value="save">
			  <s:message code="label.save"/>
			  </button> </div></div>
              
              <c:choose>
              <c:when test="${form.id==0}">  
              <div class="col-md-3">
			  <div class="form-group">
			  <button type="submit" class="btn btn-danger btn-block" name="operation" value="reset">
			  <s:message code="label.reset"/>
			  </button> </div></div>  
			  </c:when>
              <c:otherwise>
                <div class="col-md-3">
			  <div class="form-group">
			  <button type="submit" class="btn btn-warning btn-block" name="operation" value="cancel">
			  <s:message code="label.cancel"/>
			  </button> </div></div>  

              </c:otherwise>
               </c:choose> 
			  
			 </div>
			 
     
          </div>
         
        </div>
     
     
     </div>

</div>
</div>
</sf:form>      





     