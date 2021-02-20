<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@page isELIgnored="false"%>

<sf:form method="post" modelAttribute="form">

<div class="container-fluid" style="margin-bottom:20px; ">
<div class="row">
<div class="col-md-1"> 
</div>
<div class="col-md-8 text-dark">

        <div class="modal-content" style="">
          
		  <div class="modal-header justify-content-center bg-dark">
            <h5 class="modal-title " id="ModalTitle">
           <c:choose>
           <c:when test="${form.id==0}"><s:message code="label.addmarksheet" /></c:when>
           <c:otherwise><s:message code="label.updatemarksheet"></s:message></c:otherwise>
           </c:choose>    
            </h5>
          </div>
          
        
		  <div class="modal-body">
               
                <div class="form-group">
                <h3 class="error justify-content-center  text-center "><font color="red">${error}</font></h3>
                <h3 class="success justify-content-center  text-center "><font color="green"> ${success}</font></h3>
                </div>     
                
		       <div class="row">
		       
			  
			  <div class="col-md-12">
			  <div class="form-group">
		     	 <sf:hidden path="id" />
               	<sf:hidden path="createdBy"/>
				<sf:hidden path="modifiedBy"/>
				<sf:hidden path="createdDatetime" />
				<sf:hidden path="modifiedDatetime" />
		     	
		     	</div></div>
			  
			  <div class="col-md-6">
			  <div class="form-group">
			  <s:message code="label.enterrollno" var="enterrollno"></s:message>
			  <sf:label path="rollNo"><s:message code="label.rollNo" ></s:message> <font color="red">*</font></sf:label>
		      <sf:input path="rollNo" class="form-control" placeholder="${enterrollno}"/>
		      <font color="red"><sf:errors path="rollNo" cssClass="error"></sf:errors></font> 
		       </div></div>
			
			  
			  <div class="col-md-6">
			  <div class="form-group">
			  <s:message code="label.select" var="studentname" />
              <sf:label path="studentId"><s:message code="label.student"></s:message> <font color="red">*</font></sf:label>
              <sf:select path="studentId" class="form-control">
              <sf:option value="0" label="${studentname}" />
              <sf:options items="${marksheetList}" itemValue="id" itemLabel="firstName"/> 
              </sf:select>
              <font color="red"><sf:errors path="studentId" cssClass="error"></sf:errors></font>
			  </div></div> 
			  
			
				<div class="col-md-12">
			    <div class="form-group">
			    <s:message code="label.enterphysics" var="enterphysics"></s:message>
			     <sf:label path="physics"><s:message code="label.physics"></s:message> <font color="red">*</font></sf:label>
		         <sf:input path="physics" class="form-control" placeholder="${enterphysics}"/>
		        <font color="red">${errorphysics} <sf:errors path="physics" cssClass="error"></sf:errors> </font>
			    
			    </div></div>
				
               <div class="col-md-12">
			   <div class="form-group">
			   <s:message code="label.enterchemistry" var="enterchemistry"></s:message>
			  <sf:label path="chemistry"><s:message code="label.chemistry" ></s:message> <font color="red">*</font></sf:label>
		      <sf:input path="chemistry" class="form-control" placeholder="${enterchemistry}"/>
		      
		      <font color="red">${errorchemistry}<sf:errors path="chemistry" cssClass="error"></sf:errors> </font>
		       </div></div>
			   
               <div class="col-md-12">
			   <div class="form-group">
			   <s:message code="label.entermaths" var="entermaths"></s:message>
			   <sf:label path="maths"><s:message code="label.maths" ></s:message> <font color="red">*</font></sf:label>
		      <sf:input path="maths" class="form-control" placeholder="${entermaths}"/>
		      <c:set value="${errormath}" var="errormath"></c:set>
		      <font color="red">${errormath}<sf:errors path="maths" cssClass="error"></sf:errors></font> 
			   </div></div>
              
              
              
				</div>
			
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

</sf:form>      



     