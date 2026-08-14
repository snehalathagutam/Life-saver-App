<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.model.User"%>
<!DOCTYPE html>
<%@ page import="java.util.ArrayList"%>



<html>

<head>

<title>Search Donor</title>

<link rel="stylesheet" href="css/style.css">

</head>



<body>


	<div class="container">


		<h2>Find Blood Donor</h2>



		<form action="searchDonor" method="post">


			<input type="text" name="blood" placeholder="Enter Blood Group">



			<input type="text" name="city" placeholder="Enter City"> <input
				type="submit" value="Search Donor">


		</form>


	</div>





	<%
	ArrayList<User> donors = (ArrayList<User>) request.getAttribute("donors");

	if (donors != null) {
	%>


	<h2>Available Donors</h2>



	<table>


		<tr>

			<th>Name</th>
			<th>Phone</th>
			<th>Blood</th>
			<th>City</th>

		</tr>



		<%
		for (User u : donors)

		{
		%>



		<tr>


			<td><%=u.getName()%></td>



			<td><%=u.getPhone()%></td>



			<td><%=u.getBloodGroup()%></td>



			<td><%=u.getCity()%></td>



		</tr>



		<%
		}
		%>


	</table>


	<%
	}
	%>



</body>

</html>