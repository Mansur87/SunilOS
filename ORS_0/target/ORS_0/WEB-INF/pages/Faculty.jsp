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
           <c:when test="${form.id==0}"><s:message code="label.addfaculty" /></c:when>
           <c:otherwise><s:message code="label.updatefaculty"></s:message></c:otherwise>
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
		     	
		     	
		     	<s:message code="label.select" var="Collegename"/>
			   <sf:label path="collegeId"><s:message code="label.college"/> <font color="red">*</font></sf:label>
              
               <sf:select path="collegeId" Class="form-control">    
                
                <sf:option value="0" label="${Collegename}" />
                
                <sf:options items="${collegeList}" itemValue="id" itemLabel="name"/>
               
               </sf:select>
               <font color="red">${errorCollege}<sf:errors path="collegeId" cssClass="error"></sf:errors></font> 
            
			  </div></div>
			  
			  <div class="col-md-12">
			  <div class="form-group">
			  <s:message code="label.select" var="coursename"></s:message>
			  <sf:label path="courseId"><s:message code="label.course"></s:message> <font color="red">*</font></sf:label>
              <sf:select path="courseId" class="form-control">
              <sf:option value="0" label="${coursename}"></sf:option>
              <sf:options items="${courseList}" itemValue="id" itemLabel="courseName"/>
              </sf:select>
              <font color="red"><sf:errors path="courseId" cssClass="error"></sf:errors></font>
			  </div></div>
			  <!-- couseName is use in courseDTO -->
			  
			  <div class="col-md-12">
			  <div class="form-group">
			  <s:message code="label.select" var="subjectname"></s:message>
              <sf:label path="subjectId"><s:message code="label.subject"></s:message> <font color="red">*</font></sf:label>
              <sf:select path="subjectId" class="form-control">
              <sf:option value="0" label="${subjectname}"></sf:option>
              <sf:options items="${subjectList}" itemValue="id" itemLabel="subjectName"/> 
              </sf:select>
              <font color="red"><sf:errors path="subjectId" cssClass="error"></sf:errors></font>
			  </div></div> 
			  
			  
			   <div class="col-md-6">
			   <div class="form-group">
			   <s:message code="label.enterfname" var="enterfirstName"></s:message>
               <sf:label path="firstName">
               <s:message code="label.firstName"/> <font color="red">*</font></sf:label>
               <sf:input path="firstName" class="form-control" placeholder="${enterfirstName}" />
               <font color="red"><sf:errors path="firstName" cssClass="error"></sf:errors></font> 
               
               </div></div>  
               
               <div class="col-md-6">
			   <div class="form-group">
			   <s:message code="label.enterlname" var="enterLastName"></s:message>
               <sf:label path="lastName"><s:message code="label.lastName"/> <font color="red">*</font></sf:label>
               <sf:input path="lastName" class="form-control" placeholder="${enterLastName}" />
               <font color="red"><sf:errors path="lastName" cssClass="error"></sf:errors></font> 
               
               
               </div></div>   
               
               <div class="col-md-6">
			  <div class="form-group">
			   <s:message code="label.enterqualification" var="qualification"></s:message>
			   <sf:label path="qualification"><s:message code="label.qualification"/><s:message code="label.id"/> <font color="red">*</font></sf:label>
               <sf:input path="qualification" class="form-control" placeholder="${qualification}"/>
               <font color="red"><sf:errors path="qualification" cssClass="error"></sf:errors></font> 
              
			  </div></div>
              
              
               <div class="col-md-6">
			  <div class="form-group">
			  
			   <sf:label path="gender"><s:message code="label.gender"/> <font color="red">*</font></sf:label><br>
               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               <sf:radiobutton path="gender" value="Male" /><s:message code="label.male" /> 
               <sf:radiobutton path="gender" value="Female" /><s:message code="label.female" /> <br>
               <font color="red"><sf:errors path="gender" cssClass="error"></sf:errors></font> 
               
			  </div></div>
              
              
           
				<div class="col-md-6">
			    <div class="form-group">
			   <s:message code="label.enterdob" var="enterdob"></s:message> 
               <sf:label path="dob"><s:message code="label.dob"/> <font color="red">*</font></sf:label>			 
               <sf:input path="dob" class="form-control" name="dob" id="datepicker" readonly="readonly" placeholder="${enterdob}"/>
               <font color="red"><sf:errors path="dob" cssClass="error"></sf:errors></font> 
               </div>
				</div>
				
				<div class="col-md-6">
				 <div class="form-group">
				 <s:message code="label.entermob" var="enterMobile"></s:message>
               <sf:label path="mobileNo"><s:message code="label.mobileNo"/> <font color="red">*</font></sf:label>
               <sf:input path="mobileNo" class="form-control" placeholder="${enterMobile}"/>
               <font color="red"><sf:errors path="mobileNo" cssClass="error"></sf:errors></font> 
               </div></div>
              
               <div class="col-md-6">
			  <div class="form-group">
			   <s:message code="label.enteremail" var="enteremail"></s:message>
			   <sf:label path="emailId"><s:message code="label.email"/><s:message code="label.id"/> <font color="red">*</font></sf:label>
              <c:choose>
              <c:when test="${form.id==0}">  
               <sf:input path="emailId" class="form-control" placeholder="${enteremail}"/>
              </c:when>
              <c:otherwise>
               <sf:input path="emailId" class="form-control" placeholder="${enteremail}" readonly="true"/>
              </c:otherwise>
              </c:choose>  
              
               
               <font color="red"><sf:errors path="emailId" cssClass="error"></sf:errors></font> 
              
			  </div></div>
                 <div class="col-md-6">
              <div class="form-group">
               <s:message code="label.enterpassword" var="enterpassword"></s:message>
               <sf:label path="password"><s:message code="label.password"/> <font color="red">*</font></sf:label>
               
               <sf:input path="password" type="password" class="form-control" placeholder="${enterpassword}"/>
               
               <font color="red"><sf:errors path="password" cssClass="error"></sf:errors></font> 
              </div>
              </div>
              
              
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



     