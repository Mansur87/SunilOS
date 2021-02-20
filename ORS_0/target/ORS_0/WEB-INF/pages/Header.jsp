<!DOCTYPE html><!-- use for Html5-->
<!-- <html lang="en">use for Language -->
<head>
<title>ORSProject0</title>
<meta charset="utf-8">

<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> --%><!-- use for hindi/english-->
<meta http-equiv="X-UA-Compatible" content="IE-edge">
<meta name="viewport" content="width=device-width, initial-scale=1"><!-- use for responsive-->

<%@page import="in.co.sunrays.proj0.dto.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page isELIgnored="false"%>


<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">

  <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
 
  <style>
  body{
  
/* 	background: url(https://mdbootstrap.com/img/Photos/Others/images/93b.jpg) no-repeat center center fixed;
	background-color: rgba(0,0,0,0.2);
	background-blend-mode: overlay;
	color:#fff; */
/* 	padding:0px 0px;
	box-sizing: border-box; */
  }

#ModalTitle {
	margin: 0;
	font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto,
		"Helvetica Neue", Arial, sans-serif, "Apple Color Emoji",
		"Segoe UI Emoji", "Segoe UI Symbol";
	font-size: 2rem;
	font-weight: normal;
	line-height: .6;
	color:white;
	opacity: 0.8;
}

  label {
  display: inline-block;
  margin-bottom: .5rem; }
  
  @media (min-width: 576px) {
       
  }
  
  
    
  </style>
</head>
 <header>

            <!--Navbar-->
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark  fixed-top " >
                <!-- style="margin-top:-20px; " -->
				<div class="container-fluid" >
                    <a class="navbar-brand" href="#">
                        <strong><font color="red">R</font>ays</strong>
                    </a>
					
					<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent-7" aria-controls="navbarSupportedContent-7"
                        aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span><!--Use for button-->
                    </button>
                    
					<div class="collapse navbar-collapse" id="navbarSupportedContent-7">
                        <!--mr for margin-->
						
						<ul class="navbar-nav mr-auto">
                        
						 <li class="nav-item active">
                               
								<a class="nav-link text-white bg-dark" href="<c:url value="/Welcome"/>">
                               <i class="fa fa-home fa-lg" aria-hidden="true"></i>
							   <span class="sr-only">(current)</span>
                                </a>
                            </li>
							            <c:if test="${not empty sessionScope.user}">
                            
         <c:if test="${sessionScope.user.roleId != 1}">
    <li class="nav-item dropdown">
       <a class="nav-link dropdown-toggle text-white bg-dark" href="#" id="navbardrop" data-toggle="dropdown">
        <s:message code="label.marksheet" />
      </a>
	  <!--bg color for dropdown-link-color -->
      <div class="dropdown-menu bg-dark">
	   <a class="dropdown-item text-white bg-dark" href="<c:url value="/ctl/Marksheet/GetMarksheet"/>"><s:message code="label.getmarkheet"/></a>
        <a class="dropdown-item text-white bg-dark" href="<c:url value="/ctl/Marksheet/MarksheetMeritList"/>"><s:message code="label.marksheetmeritlist"/></a>
        </div>
	  
    </li>     
         
          </c:if>
                            
			<c:if test="${sessionScope.user.roleId == 1}">
						<li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle text-white bg-dark" href="#" id="navbardrop" data-toggle="dropdown">
        <s:message code="label.user" />
      </a>
	  <!--bg color for dropdown-link-color -->
      <div class="dropdown-menu bg-dark">
        <a class="dropdown-item text-white bg-dark" href="<c:url value="/ctl/User/User"/>"><s:message code="label.adduser" /></a>
        <a class="dropdown-item text-white bg-dark" href="<c:url value="/ctl/User/Search"/>"><s:message code="label.userlist" /></a>
      </div>
	  </li>
	
	
	<li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle text-white bg-dark" href="#" id="navbardrop" data-toggle="dropdown">
         <s:message code="label.role" />
      </a>
	  <!--bg color for dropdown-link-color -->
      <div class="dropdown-menu bg-dark">
        <a class="dropdown-item text-white bg-dark" href="<c:url value="/ctl/Role/Role"/>"><s:message code="label.addrole" /></a>
        <a class="dropdown-item text-white bg-dark" href="<c:url value="/ctl/Role/Search"/>"><s:message code="label.rolelist" /></a>
      </div>  
    </li>
	
	
	<li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle text-white bg-dark" href="#" id="navbardrop" data-toggle="dropdown">
         <s:message code="label.college" />
      </a>
	  <!--bg color for dropdown-link-color -->
      <div class="dropdown-menu bg-dark">
        <a class="dropdown-item text-white bg-dark" href="<c:url value="/ctl/College/College"/>"><s:message code="label.addcollege" /></a>
        <a class="dropdown-item text-white bg-dark" href="<c:url value="/ctl/College/Search"/>"><s:message code="label.collegelist" /></a>
      </div>  
    </li>
	
	<li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle text-white bg-dark" href="#" id="navbardrop" data-toggle="dropdown">
         <s:message code="label.student" />
      </a>
	  <!--bg color for dropdown-link-color -->
      <div class="dropdown-menu bg-dark">
        <a class="dropdown-item text-white bg-dark" href="<c:url value="/ctl/Student/Student"/>"><s:message code="label.addstudent" /></a>
        <a class="dropdown-item text-white bg-dark" href="<c:url value="/ctl/Student/Search"/>"><s:message code="label.studentlist" /></a>
      </div>  
    </li>
	
	<li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle text-white bg-dark" href="#" id="navbardrop" data-toggle="dropdown">
         <s:message code="label.faculty" />
      </a>
	  <!--bg color for dropdown-link-color -->
      <div class="dropdown-menu bg-dark">
        <a class="dropdown-item text-white bg-dark" href="<c:url value="/ctl/Faculty/Faculty"/>"><s:message code="label.addfaculty" /></a>
        <a class="dropdown-item text-white bg-dark" href="<c:url value="/ctl/Faculty/Search"/>"><s:message code="label.facultylist" /></a>
      </div>  
    </li>
	
	<li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle text-white bg-dark" href="#" id="navbardrop" data-toggle="dropdown">
         <s:message code="label.course" />
      </a>

      <div class="dropdown-menu bg-dark">
        <a class="dropdown-item text-white bg-dark" href="<c:url value="/ctl/Course/Course"/>"><s:message code="label.course" /></a>
        <a class="dropdown-item text-white bg-dark" href="<c:url value="/ctl/Course/Search"/>"><s:message code="label.courselist" /></a>
      </div>  
    </li>
	
	
	
	<li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle text-white bg-dark" href="#" id="navbardrop" data-toggle="dropdown">
        <s:message code="label.subject" />
      </a>
	  <!--bg color for dropdown-link-color -->
      <div class="dropdown-menu bg-dark">
        <a class="dropdown-item text-white bg-dark" href="<c:url value="/ctl/Subject/Subject"/>"><s:message code="label.addsubject" /></a>
        <a class="dropdown-item text-white bg-dark" href="<c:url value="/ctl/Subject/Search"/>"><s:message code="label.subjectlist" /></a>
       
      </div>
	  
    </li>
  
	<li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle text-white bg-dark" href="#" id="navbardrop" data-toggle="dropdown">
        <s:message code="label.marksheet" />
      </a>
	  <!--bg color for dropdown-link-color -->
      <div class="dropdown-menu bg-dark">
        <a class="dropdown-item text-white bg-dark" href="<c:url value="/ctl/Marksheet/Marksheet"/>"><s:message code="label.addmarksheet"/></a>
        <a class="dropdown-item text-white bg-dark" href="<c:url value="/ctl/Marksheet/Search"/>"><s:message code="label.marksheetlist"/></a>
        <a class="dropdown-item text-white bg-dark" href="<c:url value="/ctl/Marksheet/GetMarksheet"/>"><s:message code="label.getmarkheet"/></a>
        <a class="dropdown-item text-white bg-dark" href="<c:url value="/ctl/Marksheet/MarksheetMeritList"/>"><s:message code="label.marksheetmeritlist"/></a>
       
      </div>
	  
    </li>
<li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle text-white bg-dark" href="#" id="navbardrop" data-toggle="dropdown">
        <s:message code="label.timetable" />
      </a>
	  <!--bg color for dropdown-link-color -->
      <div class="dropdown-menu bg-dark">
        <a class="dropdown-item text-white bg-dark" href="<c:url value="/ctl/TimeTable/TimeTable"/>"><s:message code="label.addtimetable"/></a>
        <a class="dropdown-item text-white bg-dark" href="<c:url value="/ctl/TimeTable/Search"/>"><s:message code="label.timetablelist"/></a>
      
      </div>
	  
    </li></c:if>
    </c:if>
                        </ul>
						
                        <ul class="navbar-nav mr-right">
		
		
						
						 <c:if test="${not empty sessionScope.user}">
  
 	<li class="nav-item dropdown">
    <a class="nav-link dropdown-toggle text-white bg-dark" href="#" id="navbardrop" data-toggle="dropdown">

<%-- <%=welcomeMsg %> --%>
<c:set var="name" value="${sessionScope.user.firstName}" />
<c:set var="role" value='${sessionScope["role"]}' /> 
<font size="comic sanse ms"><c:out value="Hi, ${name}(${role})"></c:out></font>


</a>
	  <!--bg color for dropdown-link-color -->
      <div class="dropdown-menu bg-secondary">
        <a class="dropdown-item text-white bg-dark" href="<c:url value="/ctl/User/Myprofile" />"><s:message code="label.myprofile" /></a>
        <a class="dropdown-item text-white bg-dark" href="<c:url value="/ctl/User/ChangePassword"/>"><s:message code="label.changepassword"/></a>
		
		<c:if test="${sessionScope.user.roleId == 1}">
		
		<a class="dropdown-item text-white bg-dark" href="<c:url value="/resources/doc/index.html" />" target="blank"><s:message code="label.javadoc"/></a>
        
        </c:if>
        
      <a class="dropdown-item text-white bg-dark" href="<c:url value="/Login"/>"><s:message code="label.logout" /> <i class="fas fa-sign-out-alt fa-lg"></i></a>
      </div>
	</li>	
 </c:if>
                      <c:if test="${empty sessionScope.user}">
						
						<li class="nav-item">
                                <a class="nav-link text-white bg-dark" href="<c:url value="/UserRegistration"/>"><s:message code="label.signup"/>
								<i class="fa fa-registered fa-lg"></i><!--
								<i class="fas fa-address-card fa-lg"></i>-->
								</a>
								
                            </li>
                        	
                        	
                        	
                        	<li class="nav-item">
                                <a class="nav-link text-white bg-dark"  href="<c:url value="/Login"/>"><s:message code="label.login"/>
								<i class="fas fa-sign-in-alt fa-lg"></i>
								<!--<i class="fas fa-sign-out-alt fa-lg"></i>-->
								</a>
                            </li>
                            
						
 
 
 <li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle text-white bg-dark" href="#"
				id="navbardrop" data-toggle="dropdown"><s:message code= "label.guest" ></s:message>
			</a> <!--bg color for dropdown-link-color -->
				<div class="dropdown-menu bg-secondary">
				
					<a class=" dropdown-item text-white bg-dark "
						href="<c:url value="/UserRegistration"/>"><s:message code="label.signup"/><i class="fas fa-user-plus"></i>   </a> <a
						class="dropdown-item text-white bg-dark "
						href="<c:url value="/Login"/>"><s:message code="label.login"/><i class="fas fa-sign-in-alt"></i> </a>

 
 
 
 
 
 
 
 
 
 
		</c:if>
 
			
	
						
						
		
						</ul>
						
						
                    </div>
                   
                </div>
 				
               
            </nav>
            
            <div style="padding-top:56px; margin-left:10px;" class="">
                <a href="?lang=en" style="color: silver; text-decoration:none; "><font color="wheat">&nbsp;<s:message code="label.English" /></font>
 				   </a> | <a href="?lang=hi" style="color: silver; text-decoration:none; "><font color="wheat">&nbsp;<s:message code="label.Hindi"/></font></a>
           </div>
</header>

<!--  <h1>Header.jsp</h1> -->
</html>