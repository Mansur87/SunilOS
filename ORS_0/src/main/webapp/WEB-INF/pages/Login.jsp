<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
<%@page isELIgnored="false"%>
<div class="container-fluid" style="margin-top:;">

<!-- <div class="row justify-content-center"> --><!-- jumbotron use for bg-->
<div class="row">
<div class="col-md-2"> 
</div>
<div class="col-md-6 text-dark">

        <div class="modal-content" style="margin-top:60px;">
          
		  <div class="modal-header justify-content-center bg-dark">
            <h5 class="modal-title " id="ModalTitle">
              <s:message code="label.login"></s:message>
            </h5>
          </div>
          
        
		  <div class="modal-body">
                <div class="form-group">
                <h3 class="error justify-content-center  text-center "><font color="red">${error}</font></h3>
                <h3 class="success justify-content-center  text-center "><font color="green"> ${success}</font></h3>
                </div>     
			    <sf:form method="post" modelAttribute="form">
			    <sf:hidden path="uri" value="${uri}"/>
                <div class="form-group">
                <s:message code="label.enteremail" var="enteremail"/>
			    <sf:label path="emailId"><s:message code="label.email"/><s:message code="label.id"/></sf:label>
                <sf:input path="emailId" class="form-control" placeholder="${enteremail}" />
                <font color="red"><sf:errors path="emailId" cssClass="error"/></font>
                </div>
			    <div class="form-group">
			    <s:message code="label.enterpassword" var="enterpassword"/>
                <sf:label path="password"><s:message code="label.password"/></sf:label>
                <sf:password path="password" class="form-control"  placeholder="${enterpassword}"/>
                <font color="red"> <sf:errors path="password" cssClass="error"/></font> 
                </div>
			 
				<div class="row justify-content-center">
			    <div class="col-md-4">
			    <div class="form-group">
			    <button type="submit" class="btn btn-success btn-block" name="operation" value="SignIn">
			    <s:message code="label.login" />
			    </button>
			    </div></div>
               <div class="col-md-4">
			   <div class="form-group">
	
	          <button type="submit" class="btn btn-warning btn-block" name="operation" value="SignUp">
			  <s:message code="label.signup"/>
			  </button>
	          </div></div>
       
              </div>
                 </sf:form>
              <div class="form-group justify-content-center">
              <a class="text-secondary" href="<c:url value="/ForgetPassword"/>"><s:message code="label.pass"/> ? </a>&nbsp;&nbsp;
		      </div>   
		  
          </div>
         
        </div>
     </div>
</div>

</div>