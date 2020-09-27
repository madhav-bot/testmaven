<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="view" modelAttribute="contact" style="background-color:gray;">
<table>
<tr>
<td>ContactName</td>
<td>:</td>
<td><form:input path="contactName"/></td>
</tr>
<tr>
<td></td>
<td></td>
<td><input type="submit" value="viewData"/></td>
</tr>
</table>
</form:form>
</body>
</html>
