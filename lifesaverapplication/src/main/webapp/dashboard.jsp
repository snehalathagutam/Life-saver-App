<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.model.User"%>
<!DOCTYPE html>

<html>

<head>

<link rel="stylesheet" href="css/style.css">

</head>



<body>


	<div class="card">


		<%
		User user = (User) session.getAttribute("user");
		%>


		<div class="logo">🩸</div>


		<h2>
			Welcome
			<%=user.getName()%>
		</h2>



		<a href="profile.jsp"> Profile </a> <a href="search.jsp"> Search
			Donor </a> <a href="requestBlood.jsp"> Request Blood </a> <a
			href="logout"> Logout </a>



	</div>



</body>


</html>