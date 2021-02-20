<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1"><!-- use for responsive-->

		<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css"/>">
		<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
		<link rel="stylesheet" href="<c:url value="/resources/web-fonts-with-css/css/fontawesome.css"/>">
		<link rel="stylesheet" href="<c:url value="/resources/web-fonts-with-css/css/fa-solid.css"/>">
		<link rel="stylesheet" href="<c:url value="/resources/css/jquery-ui.css"/>">

		<script src="<c:url value="/resources/js/jquery-1.12.4.js"/>"></script>
		<script src="<c:url value="/resources/js/jquery-ui.js"/>"></script>	

		<style type="text/css">
		.no-drop {cursor: no-drop;}
		</style>
  
		<style type="text/css">
		body{
			background-image:url("<c:url value="/resources/img/ds.jpg"></c:url>");
    		background-position: center;
    		background-repeat: no-repeat;
    		background-size: cover;  
     		opacity: 0.9;
     	    background-attachment: fixed;
     	    color: #fff;
     	   background-color: rgba(0, 0, 0, 0.2);
     				
  			}
		.body1{
			background-image:url("<c:url value="/resources/img/ds.jpg"></c:url>");
    		background-position: center;
    		background-repeat: no-repeat;
    		background-size: cover;  
     		opacity: 0.9;
     			background-attachment: fixed;
     		color: #fff;
  		background-color: rgba(0, 0, 0, 0.2);
  		
  			}
  		</style>

		<title>ORSProject0</title>
	</head>
	
	<body>
		<div style="margin-bottom: 0px;"> 
			<tiles:insertAttribute name="header"></tiles:insertAttribute>
		</div>
		
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-2">
					<tiles:insertAttribute name="menu"></tiles:insertAttribute>
				</div>
				<div class="col-md-9" style="min-height: 526px; background-color: ;">
					<tiles:insertAttribute name="body"></tiles:insertAttribute>
				</div>
			</div>
		</div>
		
		<div style="clear: both; margin-top: 50px;">
			<tiles:insertAttribute name="footer"></tiles:insertAttribute>
		</div>
	</body>
</html>