<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update New Leads</title>
</head>
<body>
	<h2>Update Leads</h2>
	<form action="updateOneLead" method="post">
		<pre>
			<input type="hidden" name="id" value="${leads.id}"/>
			First Name : <input type="text" name="firstName" value="${leads.firstName}"/>
			Last Name : <input type="text" name="lastName" value="${leads.lastName}"/>
			Email : <input type="email" name="email" value="${leads.email}"/>
			Mobile : <input type="number" name="mobile" value="${leads.mobile}"/>
			<input type="submit" value="save"/>
		</pre>
	</form>
</body>
</html>