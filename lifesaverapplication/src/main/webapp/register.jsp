<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

<title>Register</title>

<link rel="stylesheet" href="css/style.css">

</head>


<body>


	<div class="container">


		<h2>Create Account</h2>



		<form action="register" method="post">


			<input name="name" placeholder="Full Name"> <input
				name="email" placeholder="Email"> <input type="password"
				name="password" placeholder="Password"> <input name="phone"
				placeholder="Phone Number"> <select name="blood">


				<option>A+</option>
				<option>A-</option>
				<option>B+</option>
				<option>B-</option>
				<option>O+</option>
				<option>O-</option>
				<option>AB+</option>
				<option>AB-</option>


			</select> <input name="city" placeholder="City"> <input type="submit"
				value="Register">


		</form>


	</div>


</body>

</html>