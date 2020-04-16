<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login fehlgeschlagen</title>
</head>
<body>
<p> Anmeldung leider fehlgeschlagen! Benutzer 
<%
String usr = (String) request.getAttribute("benutzer");
out.println(usr);
%>
existiert nicht oder Passwort falsch eingegeben!
</p>

<p>Bitte geben Sie ihre Daten zur Registrierung an:</p>
<form method="post" action="register">
	username: 		<input type="text" name="user"><br>
	password: 	<input type="password" name="pwd"><br>
	<button type="submit">Senden</button>
</form>

</body>
</html>