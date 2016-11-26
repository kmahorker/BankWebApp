<!-- Unused... Was in progress... did not workout, intended to be a controller -->
<%@page
	import="org.innominds.intern.BankWebApp.Database.UserJdbcTemplate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<jsp:useBean id="formHandler"
	class="org.innominds.intern.BankWebApp.UserFormBean" scope="request">
	<jsp:setProperty name="formHandler" property="*" />
</jsp:useBean>
<% 
   if (formHandler.validate()) {
	   System.out.println("Name: " + formHandler.getName() + " username: " + formHandler.getUsername()); %>
<!-- 
	 //  ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	  // UserJdbcTemplate jdbc = (UserJdbcTemplate)context.getBean("UserJdbcTemplate");
	   jdbc.create(formHandler.getName(), formHandler.getUsername(), formHandler.getPassword(), Integer.parseInt(formHandler.getBalance()));
%> -->
<jsp:forward page="/Login" />
<%
   }  else {
	   System.out.println("Name: " + formHandler.getName() + " username: " + formHandler.getUsername());

%>
<jsp:forward page="/SignupRetry" />
<%
   }
%>