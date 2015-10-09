<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="styles/henkilot.css">
<title>Henkilöt</title>
</head>
<body>


<table>
<caption>Pizzat</caption>
<thead>
	<tr>
		<td>ID</td>
		<td>Nimi</td>
		<td>Hinta</td>
	</tr>
</thead>
<tbody>
<c:forEach items="${pizzat}" var="pizz">
	<tr>
		<td><c:out value="${pizz.id}"/></td>
		<td><c:out value="${pizz.nimi}"/></td>
		<td><c:out value="${pizz.hinta}"/></td>
	</tr>
</c:forEach>
</tbody>
</table>

</body>
</html>