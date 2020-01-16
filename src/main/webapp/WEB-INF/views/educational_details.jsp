<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>educational_details</title>
</head>
<body>
	<h3 style="color: navy;text-align: center;">PASSPORT REGISTRATION</h3>
	
	<form:form action="saveEduDtls" method="POST" modelAttribute="educationalDetails">
		<h3 style="color: navy">Educational Details</h3>
		
		<form:hidden path="pid"/>
		
		<table border="5" >
			<tr>
				<td>Highest Degree : </td>
				<td>
					<form:select path="highestDegree">
						<form:option value=" ">- select -</form:option>
						<form:options items="${degreeList}"/>
					</form:select>
				</td>
			</tr>
			<tr>
				<td>University : </td>
				<td>
					<form:select path="university"> 
						<form:option value=" ">- select -</form:option>
						<form:options items="${unvrList}"/>
					</form:select>
				</td>
			</tr>
			<tr>
				<td>Passout Year : </td>
				<td>
					<form:select path="passoutYear">
						<form:option value=" ">- select -</form:option>
						<form:options items="${yearList}"/>
					</form:select>
				</td>
			</tr>
			<tr>
				<td><a href="editPersonDtls?perId=${educationalDetails.pid}">Previous</a></td>
				<td><input type="submit" value="Next" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>