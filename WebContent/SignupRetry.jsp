<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%
	request.getSession().getAttribute("formHandler");
%>
<html>
<head>
<style>
#error {
	padding: 0;
	margin: 0;
	font-size: 16px;
	color: red;
}
</style>
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
				<td>
					<table align="center">
						<tr>
							<td align="center"><input type="text" name="name"
								value=${formHandler.name }></td>

						</tr>
						<tr>
							<td><p id="error" align="center">${formHandler.getErrorMsg("name")}</p></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td width="250"><p align="center">Username:</p>
				<td>
					<table align="center">
						<tr>
							<td align="center"><input type="text" name="username"
								value=${formHandler.username }></td>

						</tr>
						<tr>
							<td><p id="error" align="center">${formHandler.getErrorMsg("username")}</p></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td width="250"><p align="center">Password:</p></td>
				<td>
					<table align="center">
						<tr>
							<td align="center"><input type="password" name="password"></td>

						</tr>
						<tr>
							<td><p id="error" align="center">${formHandler.getErrorMsg("password")}</p></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td width="250"><p align="center">Confirm Password:</p></td>
				<td>
					<table align="center">
						<tr>
							<td align="center"><input type="password"
								name="confirmPassword"></td>

						</tr>
						<tr>
							<td><p id="error" align="center">${formHandler.getErrorMsg("confirmPassword")}</p></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td width="250"><p align="center">Starting Balance:</p></td>
				<td>
					<table align="center">
						<tr>
							<td align="center"><input type="text" name="balance"
								value=${formHandler.balance }></td>

						</tr>
						<tr>
							<td><p id="error" align="center">${formHandler.getErrorMsg("balance")}</p></td>
						</tr>
					</table>
				</td>
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