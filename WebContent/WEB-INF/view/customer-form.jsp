<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CustomerAdd</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Save Customer</h3>
		
		<form:form action="saveCustomer" modelAttribute="customer" method="POST">
		
			<table>
				<tbody>
					<tr>
						<th>First Name:</th>
						<td>
							<form:input path="firstName" />
							<form:errors path="firstName" />
						</td>
					</tr>
					<tr>
						<th>Last Name:</th>
						<td>
							<form:input path="lastName" />
							<form:errors path="lastName" />
						</td>
					</tr>
					<tr>
						<th>Email:</th>
						<td>
							<form:input path="email" />
							<form:errors path="email" />
						</td>
					</tr>
					<tr>
						<th colspan="2"><input type="submit" value="ADD" /></th>
					</tr>
				</tbody>
			</table>
			
		</form:form>
		
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/customer/list">Back to list</a>
		</p>
	</div>
	
</body>
</html>