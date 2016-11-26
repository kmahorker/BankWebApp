<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%request.getSession().getAttribute("currentUser"); %>
<title>Balance Enquiry</title>
</head>
<body>
	<h1 align="center">Current Balance</h1>
	<font size="4">
		<table align="center">
			<tr align="center">
				<td>Your Current Balance is: &#160;</td>
				<td>${currentUser.balance}</td>
			</tr>
		</table>
	</font>
	<form action="Home" method="get">
		<br />
		<center>
			<input type="submit" value="Return Home" />
		</center>
	</form>
</body>
</html>