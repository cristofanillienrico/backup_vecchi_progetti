<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Verifica</title>
</head>
<body>
Inserisci il tuo nome:<br>
<form action="CheckEsistenzaServlet" method="post">
<input type="text" name="nomeInput">
<br>
<input type="text" name="cognomeInput">
<br>
<input type="submit" value="valoreSubmit">

</form>

</body>
</html>