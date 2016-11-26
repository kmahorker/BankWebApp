<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Home</title>
</head>
<body>
	<h1 align="center">Welcome ${currentUser.name}!</h1>
	<br />
	<form action="Deposit">
		<center>
			<input type="submit" value="Deposit" />
		</center>
	</form>
	<br />
	<form action="Withdraw">
		<center>
			<input type="submit" value="Withdraw" />
		</center>
	</form>
	<br />
	<form action="BalanceEnquiry">
		<center>
			<input type="submit" value="Balance Enquiry" />
		</center>
	</form>
	<br />
	<form action="Welcome">
		<center>
			<input type="submit" value="Log out" />
		</center>
	</form>
</body>
</html>