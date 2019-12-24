<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>login below</h2>
	
	<form action="login" method="post">
		
		user name : <input type="text" name="userName"><br>
		password : <input type="text" name="password"><br> <input
				type="submit" value="login">
	</form>
		<div style="color: red"> ${ msg }</div>

	<a href="registerUser">Register Now !!</a>

</body>
</html>