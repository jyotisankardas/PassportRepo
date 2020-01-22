<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#ff00ff">
	<h1 style="color: blue;text-align: center">Application Review Form</h1>
	<form:form action="handleConfirmBtn" method="post" modelAttribute="passportAppDtls">
	<form:hidden path="personId"/>
		<h3 style="color: #33ff00;text-align: center"><u>Person details:</u></h3>
		<table align="center">
		
			<tr>
				<td>First Name:</td>
				<td>${persondetails.firstName }</td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td>${persondetails.lastName }</td>
			</tr>
			<tr>
				<td>Email:</td>
				<td>${persondetails.email}</td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td>${persondetails.gender}</td>
			</tr>
			<tr>
				<td>DOB:</td>
				<td>${persondetails.dob}</td>
			</tr>
		</table>
		
		<h3 style="color: #33ff00;text-align: center"><u>Educational Details:</u></h3>
		<table align="center">
			<tr>
				<td>Highest Degree:</td>
				<td>${educationdetails.highestDegree }</td>
			</tr>
			<tr>
				<td>University:</td>
				<td>${educationdetails.univercity }</td>
			</tr>
			<tr>
				<td>Passed Out Year:</td>
				<td>${educationdetails.year }</td>
			</tr>
			<tr>
				<td><input type="submit" value="Confirm"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>