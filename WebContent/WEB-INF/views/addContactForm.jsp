<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link  href="<c:url value='/resources/css/bootstrap.min.css'/>" rel="stylesheet"></link>
<title>Insert title here</title>
</head>
<body>
<form:form action="save" modelAttribute="contact" style="background-color:gray;">
<table>
<tr>
<td>ContactName</td>
<td>:</td>
<td><form:input path="contactName"/>
<form:errors path="contactName" style="color:red;"></form:errors></td>
</tr>
<tr>
<td>PhoneNumber</td>
<td>:</td>
<td><form:input path="phoneNumber"/>
<form:errors path="phoneNumber" style="color:red;"></form:errors></td>
</tr>
<tr>
<td>EmailId</td>
<td>:</td>
<td><form:input path="emailId"/>
<form:errors path="emailId" style="color:red;"></form:errors></td>
</tr>
<tr>
<td>CityName</td>
<td>:</td>
<td><form:input path="cityName"/>
<form:errors path="cityName" style="color:red;"></form:errors></td>
</tr>
<tr>
<td>StateName</td>
<td>:</td>
<td><form:input path="stateName"/>
<form:errors path="stateName" style="color:red;"></form:errors></td>
</tr>
<tr>
<td>Pincode</td>
<td>:</td>
<td><form:input path="pincodeData"/>
<form:errors path="pincodeData" style="color:red;"></form:errors></td>
</tr>
<tr>
<td></td>
<td></td>
<td><input type="submit" value="AddContact"/></td>
</tr>
</table>
</form:form>
</body>
</html>
