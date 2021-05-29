<%@page import="it.prova.riconoscimento.model.Persona"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>IRisposta giusta</title>
</head>
<body>
giuuuusta
<% Persona personaInPagina=(Persona)request.getAttribute("persona_attribute"); %>
Il tuo nome è <%= personaInPagina.getNome() %>
Il tuo Cognome è <%= personaInPagina.getCognome() %>

</body>
</html>