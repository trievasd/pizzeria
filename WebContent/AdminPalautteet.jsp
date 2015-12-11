<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AurinkoPizza</title>
<link href="css/business-casual.css" rel="stylesheet" type="text/css">
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
</head>
<div class="box">
<body>


<c:forEach items="${palautteet}" var="pal">

<table id="palaute">
				<thead>
					<tr>
						<td>ID:</td>
						<td>PVM:</td>
						<td>Nimi:</td>
						<td>Sähköposti:</td>
						<td>Puh:</td>
						<td>Viesti:</td>
						<td><button name="pal_id" type="submit" value=${pal.id}>Poista</button></td>
					</tr>

				

</thead>
<tbody>
<td><c:out value="${pal.id}" /></td>
<td><c:out value="${pal.pvm}" /></td>
<td><c:out value="${pal.nimi}" /></td>
<td><c:out value="${pal.sahkoposti}" /></td>
<td><c:out value="${pal.palautepuh}" /></td>
<td><c:out value="${pal.viesti}" /></td>

</tbody>
</table>

	</c:forEach>
	
	<form role="form" action="AdminPalaute" method="get">
	<td><button type="submit"><b>Hae Palautteet</b></button></td>
	</form>


</body>
</div>
</html>