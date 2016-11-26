<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%
	request.getSession().invalidate();
%>
<title>Welcome to our Bank</title>
</head>
<body>
	<%
		for (int i = 0; i < 5; i++) {
	%>
	<br />
	<%
		}
	%>
	<h1 align="center">Welcome to our Bank!</h1>
	<br />
	<form action="Login" method="post">
		<center>
			<input type="submit" value="Login" name="button">
		</center>
	</form>
	<br />
	<form action="Signup" method="post">
		<center>
			<input type="submit" value="Signup" name="button">
		</center>
	</form>
</body>
</html>