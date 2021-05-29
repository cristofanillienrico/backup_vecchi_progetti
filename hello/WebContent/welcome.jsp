<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>welcome</title>
</head>
<body>
	Benvenuto
	<br><br>
	<form action="ControllaRispostaServlet" method="post">
		Inserisci la risposta:<input type="text" name="rispostaInput"><br><br>
		<input type="submit" value="tasto">
	</form>
</body>
</html>
