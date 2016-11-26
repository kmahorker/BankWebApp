<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Failed</title>
</head>
<body>
	<h1 align="center">Login</h1>
	<p align=center style="color: red">Invalid Username/Password</p>
	<form action="LoginCheck" method="post">
		<table border="1" align="center">
			<tr>
				<td align=center width=200>Username</td>
				<td><input type="text" name="uname" /></td>
			</tr>
			<tr>
				<td align="center" width=200>Password</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<!--  <tr><td></td><td align = "center"><input type="submit" value = "Login"/></td></tr> -->
		</table>
		<br />
		<center>
			<input align="center" type="submit" value="Login" />
		</center>
	</form>

</body>
</html>