<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

<title>Blood Request</title>

<link rel="stylesheet" href="css/style.css">

</head>



<body>



	<div class="container">


		<h2>Request Blood</h2>



		<form action="bloodRequest" method="post">



			<input type="text" name="patient" placeholder="Patient Name">



			<input type="text" name="blood" placeholder="Blood Group"> <input
				type="number" name="units" placeholder="Required Units"> <input
				type="text" name="hospital" placeholder="Hospital Name"> <input
				type="text" name="city" placeholder="City"> <input
				type="submit" value="Submit Request">


		</form>


		<a href="dashboard.jsp"> Back </a>


	</div>



</body>

</html>