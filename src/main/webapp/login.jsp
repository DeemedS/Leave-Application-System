<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Leave Application</title>
<link rel="stylesheet" href="css/style.css">
</head>

<body style="margin-top:120px">
<style>
body {
  background-image: url('bg.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
}
</style>
<table align="center" bgcolor="#EBF4FA" width="40%" border="0" style="opacity:1;border-radius:50px;opacity:0.75">
<tr>
<th>
<h1 align="center" style="color:black;margin-top:50px">Leave Application Management System</h1>
  	<c:if test="${message != null}">     
	<p align="center" style="color:red"><i>${message}</i></p> 
	</c:if>
	
<form action="login" method="post">

<table align="center" bgcolor="#98AFC7" width="20%" border="2" cellspacing="4" style="margin-bottom:130px;margin-top:50px">

<tr>
	<th style="color:black">Username:</th>
	<th><input name="username" type="text" placeholder="Username"/></th>
</tr>

<tr>	
	<th style="color:black">Password:</th>
	<th><input name="password" type="password" placeholder="Password"/></th>
</tr>

<tr>
	<input name="action" type="text" value="login" hidden/>	
	<th colspan="2"><input type="submit" value="Submit" style="background-color:#3B3131; color:#98AFC7"/></th>
</tr>

</table>
</form>
</th>
</tr>
</table>

</body>
</html>