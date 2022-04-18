<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Leave Details</title>
<link rel="stylesheet" href="css/styles.css">
</head>
<body bgcolor="#EBF4FA">
<style>
body {
  background-image: url('bg.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
}
</style>

<table align="center" bgcolor="#EBF4FA" width="80%" border="0" style="opacity:1;border-radius:50px;opacity:0.75;margin-top:40px">
<tr>
<th>
	<h1 align="center">Leave Details<h1>
	<h2 align="center">${user.lname}, ${user.fname} ${user.mname} (${user.uid})</h2>
	<p id="datetime" align="center"></p>
	<c:if test="${error != null}">     
	<p align="center" style="color:red"><i>${error}</i></p> 
	</c:if>
	<a href="logout">Logout</a>



<form action="selectleave" method="post" id="select">

	<table align="center" bgcolor="#98AFC7" width="80%" border="2" cellspacing="2">
	<tr>
		<td align="center">S/N</td>
		<td>   </td>
		<td align="center">Leave From</td>
		<td align="center">Leave To</td>
		<td align="center">No. of Days</td>
		<td align="center">Back Up Office</td>
		<td align="center">Reason</td>
		<td align="center">Remark</td>
	</tr>

	<c:forEach var="leave" items="${leave}">
	<tr>
		<td align="center"></td>
		<td align ="center"><input type="radio" name="id" value="${leave.id}" id="id">
		<input type="radio" name="id"  id="id" hidden></td>
		<td align="center"><input type="text" name="from" value="${leave.datefrom}" disabled></td>		
		<td align="center"><input type="text" name="to" value="${leave.dateto}" disabled></td>
		<td align="center">${leave.day}</td>
		<td align="center">${leave.bckoffice}</td>
		<td align="center">${leave.reason}</td>
		<td align="center">${leave.remark}</td>
	</tr>
	</c:forEach>  
		
	</table>
	
<br><br>

	<table align="center">
	<tr>
		<td>			
			<button type="submit" name="action" value="apply" style="background-color:#3B3131; color:#98AFC7" >Add Leave</button>
			<button type="submit" name="action" value="edit" onclick="return myFunction()" style="background-color:#3B3131; color:#98AFC7">Edit/Update Leave</button>
			<button type="submit" name="action" value="delete" onclick="return myFunction()" style="background-color:#3B3131; color:#98AFC7">Delete Leave</button>
		</td>
	</tr>
	</table><br><br>	

</th>
</tr>
</table>
</form>	
</body>

<script>
n =  new Date();
y = n.getFullYear();
m = n.getMonth() + 1;
d = n.getDate();

h = n.getHours();
q = n.getMinutes();
s = n.getSeconds();

document.getElementById("datetime").innerHTML = d + "/" + m + "/" + y + ", " + h + ":" + q + ":" + s;
</script>

<script>
function myFunction() {
	
	var form = document.getElementById("select");
	var error =  form.elements.namedItem("id").value;
	
	if (error == false) {
		alert("Please Select Leave");
	}
	
	if (error != "") {
		
		var agree=confirm("Are You Sure You Wish to Continue?");
		
		if (agree)
			 return true ;
			else
			 return false ;
			}
	
	return false
	}
	
	
</script>
</html>