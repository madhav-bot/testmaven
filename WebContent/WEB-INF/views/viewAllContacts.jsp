<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link  href="<c:url value='/resources/css/bootstrap.min.css'/>" rel="stylesheet"></link>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3 style="background-color: green;">Listed The Contact details</h3>
<table class="table table-bordered table-striped table-hover">
<tr>
<td>ContactName</td>
<td>PhoneNumber</td>
<td>EmailId</td>
<td>CityName</td>
<td>StateName</td>
<td>PinCode</td>
</tr>
<c:forEach var ="contact" items="${list}">
<tr>
<td>${contact.contactName}</td>
<td>${contact.phoneNumber}</td>
<td>${contact.emailId}</td>
<td>${contact.cityName}</td>
<td>${contact.stateName}</td>
<td>${contact.pincodeData}</td>
</tr>
</c:forEach>
</table>
<a href="index.jsp" style="background-color: silver;">BackToMainPage</a>
</body>
</html>