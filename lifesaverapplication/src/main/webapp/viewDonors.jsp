<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="com.model.User"%>
<!DOCTYPE html>
<%@ page import="java.util.ArrayList"%>



<html>


<head>

<title>View Donors</title>

<link rel="stylesheet" href="css/style.css">

</head>



<body>


	<h1>Registered Donors</h1>



	<table>


		<tr>

			<th>Name</th>
			<th>Email</th>
			<th>Phone</th>
			<th>Blood</th>
			<th>City</th>
			<th>Action</th>

		</tr>



		<%
		ArrayList<User> donors = (ArrayList<User>) request.getAttribute("donors");

		for (User u : donors)

		{
		%>



		<tr>


			<td><%=u.getName()%></td>



			<td><%=u.getEmail()%></td>



			<td><%=u.getPhone()%></td>



			<td><%=u.getBloodGroup()%></td>



			<td><%=u.getCity()%></td>



			<td><a href="deleteDonor?id=<%=u.getId()%>"> Delete </a></td>



		</tr>



		<%
		}
		%>


	</table>



	<a href="adminDashboard.jsp"> Back </a>



</body>


</html>