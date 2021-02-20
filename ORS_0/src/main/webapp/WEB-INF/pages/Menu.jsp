<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page isELIgnored="false" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<!DOCTYPE html>

<html>
	<head>
		<link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<style type="text/css"> 
			#mySidenav a {
				margin-top:95px;
				position: fixed;
				left:12px;   
				transition: 0.3s; 
    			padding: 10px;
     			width: 160px; 
    			text-decoration: none;
    			font-style:italic;
    			text-align:right;
    			color: white;
    			border-radius: 0 5px 5px 0;
				}

			#mySidenav a:hover {
    			left: 0;
    			}

			#mypro {top: 20px;background-color: #412b25;}
			#user {top: 70px; background-color: black;}
			#role {top: 120px; background-color:#412b25;}
			#college {top: 170px; background-color: black;}
			#student {top: 220px;background-color: #412b25;}
			#faculty {top: 270px;background-color: black;} 
			#course {top: 320px;background-color: #412b25;}
			#subject {top: 370px;background-color: black;}
			#marksheet {top: 420px; background-color:#412b25;}
			#timetable {top: 470px; background-color: black;}
		</style>

		<style type="text/css">
			@media (min-width: 200px) and (max-width: 1024px) {
			.dis{
				display:block; 
				display:none;
				text-decoration:none;  
				}
			}
		</style>
	</head>
	
	<body>
		<div id="mySidenav" class="sidenav dis">
			<c:if test="${not empty sessionScope.user && sessionScope.user.roleId==1}">
				<a href="<c:url value="/ctl/User/Myprofile"></c:url>" id="mypro" ><s:message	code="label.myprofile"/> <i class="fa fa-user-circle" aria-hidden="true"></i></a>
  				<a href="<c:url value="/ctl/User/Search"></c:url>" id="user" ><s:message	code="label.userlist"/> <i class="fa fa-list-alt"></i></a>
  				<a href="<c:url value="/ctl/Role/Search"></c:url>" id="role"><s:message	code="label.rolelist"/> <i class="fa fa-list-alt"></i></a>
  				<a href="<c:url value="/ctl/College/Search"></c:url>" id="college"><s:message	code="label.collegelist"/> <i class="fa fa-list-alt"></i></a>
  				<a href="<c:url value="/ctl/Student/Search"></c:url>" id="student"><s:message	code="label.studentlist"/> <i class="fa fa-list-alt"></i></a>
  				<a href="<c:url value="/ctl/Faculty/Search"></c:url>" id="faculty"><s:message	code="label.facultylist"/> <i class="fa fa-list-alt"></i></a>
  				<a href="<c:url value="/ctl/Course/Search"></c:url>" id="course"><s:message	code="label.courselist"/> <i class="fa fa-list-alt"></i></a>
  				<a href="<c:url value="/ctl/Subject/Search"></c:url>" id="subject"><s:message	code="label.subjectlist"/> <i class="fa fa-list-alt"></i></a>
  				<a href="<c:url value="/ctl/Marksheet/Search"></c:url>" id="marksheet"><s:message	code="label.marksheetlist"/> <i class="fa fa-list-alt"></i></a>
  				<a href="<c:url value="/ctl/TimeTable/Search"></c:url>" id="timetable"><s:message	code="label.timetablelist"/> <i class="fa fa-list-alt"></i></a>
			</c:if>
		</div>
	</body>
</html>