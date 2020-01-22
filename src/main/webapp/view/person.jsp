<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h1 style="color: #666600; text-align: center">WELCOME TO PASSPORT APPLICATION</h1>
<body background="unnamed.jpg">

<form:form action="/register" method="post" modelAttribute="beans">
	<table align="center" border="2" rules="all" width="600" height="300"
		style="background-image: ">
	<form:hidden path="personId" />
		<tr>
			<td><b>Person's FirstName::</b></td>
			<td ><form:input path="firstName" size="30"/></td>
		</tr>
		<tr>
			<td><b>Person's LastName::</b></td>
			<td ><form:input path="lastName" size="30"/></td>
		</tr>
		<tr>
			<td><b>Person's email id::</b></td>
			<td><form:input path="email" size="30"/></td>
		</tr>
		<tr>
			<td><b>Person's Date of birth::</b></td>
			<td ><form:input type="date" path="dob" pattern="MM-dd-yyyy" size="30"/></td>
		</tr>
		<tr>
			<td><b>Gender::</b></td>
			<td ><form:radiobutton path="gender" value="m" size="30"/>Male
				&nbsp;&nbsp; <form:radiobutton path="gender" value="f" />Femal</td>
		</tr>
		<tr>
			<td align="center"><input type="reset" value="reset"></td>
			<td align="center"><input type="submit" value="next"></td>
		</tr>



	</table>






</form:form>
</body>

