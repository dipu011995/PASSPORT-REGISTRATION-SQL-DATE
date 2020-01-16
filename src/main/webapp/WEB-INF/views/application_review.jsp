<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>application_review</title>
</head>
<body>
	<h1 style="color: lime;text-align: center;">PASSPORT REGISTRATION</h1>
	<form:form action="savePssportDetails" method="POST"
		modelAttribute="passportDetails">
		<h3 style="color: navy">Application Review</h3>
		
		<form:hidden path="pid"/>
		
		<table border="5">
			<tr>
				<td>FIRST NAME :</td>
				<td><form:input path="fname" /></td>
			</tr>
			<tr>
				<td>LAST NAME :</td>
				<td><form:input path="lname" /></td>
			</tr>
			<tr>
				<td>EMAIL ID :</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>DOB :</td>
				<td><form:input path="dob" /></td>
			</tr>
			<tr>
				<td>GENDER :</td>
				<td><form:input path="gender" /></td>
			</tr>
			<tr>
				<td>ADHAR NO :</td>
				<td><form:input path="adharNo" /></td>
			</tr>
			<tr>
				<td>Highest Degree :</td>
				<td><form:input path="highestDegree" /></td>
			</tr>
			<tr>
				<td>University :</td>
				<td><form:input path="university" /></td>
			</tr>
			<tr>
				<td>Passout Year :</td>
				<td><form:input path="passoutYear" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Confirm" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>