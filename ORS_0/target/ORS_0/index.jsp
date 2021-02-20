<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title>ORSProject0</title>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<link href="https://fonts.googleapis.com/css?family=Pacifico" rel="stylesheet">
		
		  <link href="https://fonts.googleapis.com/css?family=Autour+One" rel="stylesheet">
		
		
		<style>
  			body{
			marign:0;
			padding:0;
			font-family: 'Varela Round', sans-serif;
			font-size: 16px;
			}
			
			.custom-nav{
			border:0px;
			-webkit-border-radius: 0px;
			-moz-border-radius: 0px;
			-ms-border-radius: 0px;
			-o-border-radius: 0px;
			border-radius: 0px;
			background-color: #fff!important;
			-webkit-box-shadow: 0 0 10px rgba(0,0,0,0.5);
			box-shadow: 0 0 10px rgba(0,0,0,0.5);
			}
  
			header{
			padding:125px 50px;
			background-blend-mode: overlay;
			}

			.banner-title{
			font-family:  'Autour One', cursive;
			font-weight: 1000;
			font-size: 50px;
			margin-top:50px;
			}
  
  			.bodys1 {
   			/* background: url(https://mdbootstrap.com/img/Photos/Others/images/93b.jpg) no-repeat center center fixed; */
   			background: url(resources/img/ds.jpg) no-repeat center center fixed;
    		background-color: rgba(0,0,0,0.1);
			background-blend-mode: overlay;
			color:#fff;
    		min-height:100%;
    		background-attachment: fixed;
    		background-repeat: no-repeat;
    		background-size: cover;
    		-moz-background-size: cover;
			} 
			 
		</style>
	</head>
	<body class="bodys1">
		<header>
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-md-12">
						<h1 class="banner-title text-center">
						<font color="white">Welcome</font><font color="white"> to the</font><font color="white"> ORS</font>
						</h1>
					</div>
				</div>
				
				<br>
				
				<div class="row justify-content-center mr-top">
					<div class="col-md-12 text-center">
						<img src="<c:url value="resources/img/customLogo.jpg"/>" class="img-fluid" title="Rays Technology"/>
					</div>
				</div>
				
				<br>
				
				<div class="row justify-content-center mr-top">
					<div class="col-md-12 text-center">
						<a href="<c:url value="/Welcome"/>" class="btn btn-lg btn-primary text-center" style="border-radius:15px" title="Click Here" >
						Online Result System
						</a>
					</div>
				</div>
			
			</div>
		</header>
	</body>
</html>