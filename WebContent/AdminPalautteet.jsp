<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<c:forEach items="${palautteet}" var="pal">
<table id="palaute">
				<thead>
					<tr>
						<td>ID: <c:out value="${pal.id}" /></td>
						<tr><td>PVM: <c:out value="${pal.pvm}" /></td>
						<tr><td>Nimi: <c:out value="${pal.nimi}" /></td>
						<tr><td>Sähköposti: <c:out value="${pal.sahkoposti}" /></td>
						<tr><td>Puh: <c:out value="${pal.palautepuh}" /></td>
						<tr><td>Viesti: <c:out value="${pal.viesti}" /></td>
						<tr><td><button name="pal_id" type="submit" value=${pal.id}>Poista</button></td>
					</tr>

				

</thead>
</table>
	</c:forEach>
	
	<form role="form" action="AdminPalauteServlet" method="get">
	<td><button type="submit"><b>Hae Palautteet</b></button></td>
	</form>


</body>
</html>