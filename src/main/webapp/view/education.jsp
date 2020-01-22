<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="cyan" >
	<h1 style="color:green;text-align:center">Educational Details Form</h1>
	<form:form action="handleEduNextBtn" method="post" modelAttribute="educationalDetails">
		<form:hidden path="personId"/> 
		<table align="center" border="5" rules="all" width="400" height="200" style="border-color: yellow">
			<tbody align="center">
			<tr>
				<td>Highest Degree</td>
				<td>
					<form:select path="highestDegree">
						<form:option value="">--select degree--</form:option>
						<form:options items="${degreeList}"/>
					</form:select>
				</td>
			</tr>
			<tr>
				<td>University</td>
				<td>
					<form:select path="univercity">
						<form:option value="">--select university--</form:option>
						<form:options items="${alluniversity}"/>
					</form:select>
				</td>
			</tr>
			<tr>
				<td>Passed Out Year</td>
				<td>
					<form:select path="year">
						<form:option value="">--select year--</form:option>
						<form:options items="${allYear}"/>
					</form:select>
				</td>
			</tr>
			<tr>
 				<td><a href="/?personId=${educationalDetails.personId}">Previous</a></td> 
				<td><input type="submit" value="Next"></td>
			</tr></tbody>
		</table>
	</form:form>
</body>
</html>