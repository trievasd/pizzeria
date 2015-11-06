<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 <%@ page import="java.util.List" %>
  <%@ page import="java.util.ArrayList" %>
  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pizzalista</title>
<link rel="stylesheet" type="text/css" href="css/styles.css"/>
</head>
<body>
<h1></h1>
<% 



%>


<div id="content">
    


<c:if test="${not empty param.added}">Pizzan lisäys onnistui</c:if>
<c:out value="${aloitusaika}" />
    
<form action="controller" method="post">
<table>
<tr><td>Id</td><td><input type="text" name="id"/></td></tr>
<tr><td>Nimi</td><td><input type="text" name="nimi"/></td></tr>
<tr><td>Hinta</td><td><input type="text" name="hinta"/></td></tr>

<tr><td>&nbsp;</td><td><button type="submit">Lähetä</button></td></tr>

</table>
</form>



<table>

<c:forEach items="${pizzalista}" var="p">

	<tr>
		<td class ="Sininen"> <FORM class ="Sininen" METHOD="LINK" ACTION="http://www.facebook.com"><INPUT class ="Sininen" TYPE="submit" VALUE="X"></FORM></td>
		<td class ="Sininen"> <c:out value="${p.id}" /> </td>
		<td class ="Sininen"> <c:out value="${p.nimi}" /></td>
	  	<td class ="Sininen"> <c:out value="${p.hinta}" /> &euro; </td>

	</tr>

</c:forEach>


 </table>






<a class ="Contharmaa" href="/PizzeriaAdmin/img/pizzeria_admin.png.png">Rautalankamalli</a>
</div>
</body>
</html>