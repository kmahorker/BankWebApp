<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New user account</title>
</head>
<body>

	<h1 align="center">Sign Up</h1>
	<h3 align="center">Please fill in the following form to create
		your account.</h3>
	<form action="SignupCheck" method="post">
		<table border="1" align=center width="500">
			<tr>
				<td width="250"><p align="center">Full Legal Name:</p></td>
				<td align="center"><input type="text" name="name"></td>
			</tr>
			<tr>
				<td width="250"><p align="center">Username:</p>
				<td align="center"><input type="text" name="username"></td>
			</tr>
			<tr>
				<td width="250"><p align="center">Password:</p></td>
				<td align="center"><input type="password" name="password"></td>
			</tr>
			<tr>
				<td width="250"><p align="center">Confirm Password:</p></td>
				<td align="center"><input type="password"
					name="confirmPassword"></td>
			</tr>
			<tr>
				<td width="250"><p align="center">Starting Balance:</p></td>
				<td align="center"><input type="text" name="balance"></td>
			</tr>
		</table>
		<table align=center width="500">
			<tr>
				<td width="250" align="right"><input type="reset" value="Reset"></td>
				<td align="left"><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>

</body>
</html>