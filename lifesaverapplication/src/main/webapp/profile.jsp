<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.model.User"%>
<!DOCTYPE html>


<html>

<head>

<title>Profile</title>

<link rel="stylesheet" href="css/style.css">

</head>


<body>


	<div class="container">


		<h2>Update Profile</h2>


		<%
		User user = (User) session.getAttribute("user");
		%>



		<form action="updateProfile" method="post">


			<input type="text" name="name" value="<%=user.getName()%>"
				placeholder="Name"> <input type="text" name="phone"
				value="<%=user.getPhone()%>" placeholder="Phone"> <input
				type="text" name="blood" value="<%=user.getBloodGroup()%>"
				placeholder="Blood Group"> <input type="text" name="city"
				value="<%=user.getCity()%>" placeholder="City"> <input
				type="submit" value="Update Profile">


		</form>



		<a href="dashboard.jsp"> Back </a>



	</div>


</body>

</html>