<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer List</title>
<!-- Reference To Our CSS Style Sheet -->
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM-Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">

			<!-- Put New Button : Add Customer -->

			<input type="button" value="Add Customer"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>

			<!-- Table to Show The List Of Customer -->
			
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Update Action</th>
					<th>Delete Action</th>
				</tr>

				<!-- Loop Over Model Object and Print our Customer -->
				<c:forEach var="theCustomer" items="${customers}">
						
						<!-- Construct the URL For Each Customer -->
						<c:url var="updateurllink" value="/customer/showFormForUpdate">
							<c:param name="customerID"  value="${theCustomer.id}"></c:param>
						</c:url>
						
						<!-- Construct the URL For Each Customer -->
						<c:url var="deleteurllink" value="/customer/deleteCustomer">
							<c:param name="customerID"  value="${theCustomer.id}"></c:param>
						</c:url>
						
						
					<tr>
						<td>${theCustomer.firstName}</td>
						<td>${theCustomer.lastName}</td>
						<td>${theCustomer.email}</td>
						<td><a href="${updateurllink}">Update</a></td>
						<td><a href="${deleteurllink}">Delete</a></td>
					</tr>

				</c:forEach>

			</table>
		</div>
	</div>
</body>
</html>