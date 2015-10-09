<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lomake</title>
<link rel="stylesheet" type="text/css" href="styles/styles.css">
</head>
<body>
<h3>Mitkä ovat pizzan tiedot?</h3>
<form action="controller" method="post">
<table>
<tr><td>Id</td><td><input type="text" name="id"/></td></tr>
<tr><td>Nimi</td><td><input type="text" name="nimi"/></td></tr>
<tr><td>Hinta</td><td><input type="text" name="hinta"/></td></tr>

<tr><td>&nbsp;</td><td><button type="submit">Lähetä</button></td></tr>
</table>


</form>
</body>
</html>