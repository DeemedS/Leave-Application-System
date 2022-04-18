<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
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
<form action="editleave" method="post" id="edit">

<input type="text" name="id" value="${leave.id}" hidden>
<table align="center" bgcolor="#EBF4FA" width="50%" border="0" style="opacity:1;border-radius:50px;opacity:0.75;margin-top:40px">
<tr>
<th>
	<h1 align="center"> Edit Leave </h1>	
	<h2 align="center">${user.lname}, ${user.fname} ${user.mname} (${user.uid})</h2>
	<c:if test="${add != null}">     
	<p align="center" style="color:red"><i>${add}</i></p> 
	</c:if>
	
	
<table align="center" bgcolor="#98AFC7" width="60%" border="2" cellspacing="2">
	<tr>
		<td >Leave From :</td>
		<td align="center"><input type="text" name="datefrom" value="${leave.datefrom}" id="datefrom"></td>
		<td align="center">dd/mm/yy</td>
	</tr>

	<tr>
		<td>Leave To:</td>
		<td align="center"><input type="text" name="dateto"  value="${leave.dateto}" id="dateto"></td>
		<td align="center">dd/mm/yy</td>
	</tr>

	<tr>
		<td>Back Up office:</td>
		<td align="center"><input type="text" name="bckoffice"  value="${leave.bckoffice}"></td>
		<td></td>
	</tr>

	<tr>
		<td>Reason:</td>
		<td align="center">
  		<select name="reason" id="reason">
  		<option value="Vacation Leave" ${leave.reason == 'Vacation Leave' ? 'selected' : ''}>Vacation Leave</option>
  		<option value="Medical Leave" ${leave.reason == 'Medical Leave' ? 'selected' : ''}>Medical Leave</option>
  		<option value="Maternity Leave" ${leave.reason == 'Maternity Leave' ? 'selected' : ''}>Maternity Leave</option> 
  		</select>
  		</td>
		<td></td>
	</tr>

	<tr>
		<td>Officer on Leave</td>
		<td align="center"><input type="text" name="offleave"  value="${leave.offleave}"></td>
		<td></td>
	</tr>

	<tr>
		<td height="100">Remarks: </td>
		<td align="center"><textarea id="remarks" name="remark" >${leave.remark}</textarea></td>
		<td></td>
	</tr>
</table>

<br><br>

<table align="center">
	<tr>
		<td>
		<input type="submit" value="Edit" onclick="return checkDate()" style="background-color:#3B3131; color:#98AFC7" />
		<input type="button" onclick="location.href='userpage';" value="Back" style="background-color:#3B3131; color:#98AFC7"/>
		<input type="button" onclick="location.href='userpage';" value="Close" style="background-color:#3B3131; color:#98AFC7"/>
		 </td>
	</tr>
</table><br><br>
</form>

<script>
var form = document.getElementById("edit");

if (form.elements.namedItem("datefrom").value === "" || form.elements.namedItem("dateto").value === "" || 
		form.elements.namedItem("bckoffice").value === "" || form.elements.namedItem("offleave").value === "" ||
		form.elements.namedItem("reason").value === "" || form.elements.namedItem("remark").value === "") {
    alert("Please fill out empty boxes");
    valid = false;
} else if (form.elements.namedItem("datefrom").value != "") {
    content: "✓";
color: green;
}
          
</script>

<script>
var date = document.getElementById('datefrom');

function checkValue(str, max) {
  if (str.charAt(0) !== '0' || str == '00') {
    var num = parseInt(str);
    if (isNaN(num) || num <= 0 || num > max) num = 1;
    str = num > parseInt(max.toString().charAt(0)) && num.toString().length == 1 ? '0' + num : num.toString();
  };
  return str;
};

date.addEventListener('input', function(e) {
  this.type = 'text';
  var input = this.value;
  if (/\D\/$/.test(input)) input = input.substr(0, input.length - 3);
  var values = input.split('/').map(function(v) {
    return v.replace(/\D/g, '')
  });
  if (values[1]) values[1] = checkValue(values[1], 12);
  if (values[0]) values[0] = checkValue(values[0], 31);
  var output = values.map(function(v, i) {
    return v.length == 2 && i < 2 ? v + '/' : v;
  });
  this.value = output.join('').substr(0, 14);
});

date.addEventListener('blur', function(e) {
  this.type = 'text';
  var input = this.value;
  var values = input.split('/').map(function(v, i) {
    return v.replace(/\D/g, '')
  });
  var output = '';
  
  if (values.length == 3) {
    var year = values[2].length !== 4 ? parseInt(values[2]) + 2000 : parseInt(values[2]);
    var month = parseInt(values[0]) - 1;
    var day = parseInt(values[1]);
    var d = new Date(year, month, day);
    if (!isNaN(d)) {
      document.getElementById('result').innerText = d.toString();
      var dates = [d.getMonth() + 1, d.getDate(), d.getFullYear()];
      output = dates.map(function(v) {
        v = v.toString();
        return v.length == 1 ? '0' + v : v;
      }).join('/');
    };
  };
  this.value = output;
});

</script>
<script>
var date = document.getElementById('dateto');

function checkValue(str, max) {
  if (str.charAt(0) !== '0' || str == '00') {
    var num = parseInt(str);
    if (isNaN(num) || num <= 0 || num > max) num = 1;
    str = num > parseInt(max.toString().charAt(0)) && num.toString().length == 1 ? '0' + num : num.toString();
  };
  return str;
};

date.addEventListener('input', function(e) {
  this.type = 'text';
  var input = this.value;
  if (/\D\/$/.test(input)) input = input.substr(0, input.length - 3);
  var values = input.split('/').map(function(v) {
    return v.replace(/\D/g, '')
  });
  if (values[1]) values[1] = checkValue(values[1], 12);
  if (values[0]) values[0] = checkValue(values[0], 31);
  var output = values.map(function(v, i) {
    return v.length == 2 && i < 2 ? v + '/' : v;
  });
  this.value = output.join('').substr(0, 14);
});

date.addEventListener('blur', function(e) {
  this.type = 'text';
  var input = this.value;
  var values = input.split('/').map(function(v, i) {
    return v.replace(/\D/g, '')
  });
  var output = '';
  
  if (values.length == 3) {
    var year = values[2].length !== 4 ? parseInt(values[2]) + 2000 : parseInt(values[2]);
    var month = parseInt(values[0]) - 1;
    var day = parseInt(values[1]);
    var d = new Date(year, month, day);
    if (!isNaN(d)) {
      document.getElementById('result').innerText = d.toString();
      var dates = [d.getMonth() + 1, d.getDate(), d.getFullYear()];
      output = dates.map(function(v) {
        v = v.toString();
        return v.length == 1 ? '0' + v : v;
      }).join('/');
    };
  };
  this.value = output;
});

</script>
<script type="text/javascript">

function checkDate()
{

var date = document.getElementById('datefrom').value;
var date1 = document.getElementById('dateto').value;
var datefrom = new Date(date);
var dateto = new Date(date1);

var  re = /^(\d{1,2})\/(\d{1,2})\/(\d{4})$/;
var max = ((new Date()).getFullYear() + 1);
  
  if(date != '' && date1 != '') {
	  
	  if(datefrom > dateto){
		    alert('datefrom must not be greater than dateto.');
		}
	  	  
    if(regs = date.match(re)) {
      if(regs[1] < 1 || regs[1] > 31) {
        alert("Invalid value for day for datefrom: " + regs[1]);
        return false;
      }
      if(regs[2] < 1 || regs[2] > 12) {
        alert("Invalid value for month for datefrom: " + regs[2]);
        return false;
      }
      if(regs[3] < 1902 || regs[3] > max) {
        alert("Invalid value for year for datefrom: " + regs[3] + " - must be between 1902 and " + ((new Date()).getFullYear() + 1) );
        return false;
      }
    }
    
    if(regss = date1.match(re)) {
        if(regss[1] < 1 || regss[1] > 31) {
          alert("Invalid value for day for dateto: " + regss[1]);
          return false;
        }
        if(regss[2] < 1 || regss[2] > 12) {
          alert("Invalid value for month for dateto: " + regss[2]);
          return false;
        }
        if(regss[3] < 1902 || regss[3] > max) {
          alert("Invalid value for year for dateto: " + regss[3] + " - must be between 1902 and " + ((new Date()).getFullYear() + 1) );
          return false;
        }
      } 
    
    else {
      alert("Invalid date format: " + date1);
      return false;
    }
  }
  
  if (date == '' || date1 == ''){
	  alert("please fill up dates.");
	  return false;
  }

  else {
	  return true;
	  }
  
  return false;
}

</script>

</th>
</tr>
</table>
</body>
</html>