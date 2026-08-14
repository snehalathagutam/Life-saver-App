<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="java.util.ArrayList"%>
<%@ page import="com.model.BloodRequest"%>
<!DOCTYPE html>



<html>


<head>

<title>Blood Requests</title>

<link rel="stylesheet" href="css/style.css">

</head>



<body>


	<h1>Blood Requests</h1>




	<table>


		<tr>

			<th>Patient</th>
			<th>Blood Group</th>
			<th>Units</th>
			<th>Hospital</th>
			<th>City</th>
			<th>Status</th>

		</tr>



		<%
		ArrayList<BloodRequest> requests = (ArrayList<BloodRequest>) request.getAttribute("requests");

		for (BloodRequest br : requests)

		{
		%>



		<tr>


			<td><%=br.getPatientName()%></td>


			<td><%=br.getBloodGroup()%></td>


			<td><%=br.getUnits()%></td>


			<td><%=br.getHospital()%></td>


			<td><%=br.getCity()%></td>


			<td><%=br.getStatus()%></td>


		</tr>



		<%
		}
		%>


	</table>



	<a href="adminDashboard.jsp"> Back </a>



</body>


</html>