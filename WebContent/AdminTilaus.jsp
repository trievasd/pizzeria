<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AurinkoPizza</title>
<link href="css/business-casual.css" rel="stylesheet" type="text/css">
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
</head>
<div class="box">
<body>

<form role="form" action="AdminTilaus" method="get">
	<td><button type="submit"><b>Hae Tilaukset</b></button></td>
	</form>


<c:forEach items="${tilaukset}" var="til">
<table id="tilaus">
				<thead>
					<tr>
						<td>ID:</td>
						<td>PVM:</td>
						<td>Etunimi:</td>
						<td>Sukunimi:</td>
						<td>Hinta:</td>
						<td>PuhelinNro:</td>
						<td>Tilauksen osoite:</td>
						<td>Postinro:</td>
						<td>Postitoimipaikka:</td>
						
						
						<form role="form" action="AdminTilaus" method="post">
						<td><button name="tilaus_id" type="submit" value=${til.id}>Näytä tilaus</button></td>
						</form>
						
					</tr>

				

</thead>
<tbody>

<td><c:out value="${til.id}" /></td>
<td><c:out value="${til.tilauspvm}"/></td>
<td><c:out value="${til.etunimi}" /></td>
<td><c:out value="${til.sukunimi}" /></td>
<td><c:out value="${til.hintasumma}" /></td>
<td><c:out value="${til.puhnro}" /></td>
<td><c:out value="${til.tilausos}"/></td>
<td><c:out value="${til.postinro}"/></td>
<td><c:out value="${til.postitmp}"/></td>




</tbody>
</table>
	</c:forEach>
	
	<c:forEach items="${tilausrivit}" var="tilriv">
<table id="palaute">
				<thead>
					<tr>
						<td>ID:</td>
						<td>TilausID:</td>
						<td>Pizza:</td>
						<td>Määrä:</td>
						<td>Hinta:</td>

						
					</tr>

				

</thead>
<tbody>

<td><c:out value="${tilriv.id}" /></td>
<td><c:out value="${tilriv.tilaus_id}"/></td>
<td><c:out value="${tilriv.pizza}" /></td>
<td><c:out value="${tilriv.maara}" /></td>
<td><c:out value="${tilriv.rivihinta}" /></td>



</tbody>
</table>
	</c:forEach>
	

</body>
</div>
</html>