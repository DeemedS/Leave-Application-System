<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Leave</title>
</head>

<body bgcolor="#EBF4FA" style="margin-top:50px">
<style>
body {
  background-image: url('bg.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
}
</style>

<form action="applyleave" method="post">

<input type="text" name="id" hidden>
<table align="center" bgcolor="#EBF4FA" width="50%" border="0" style="opacity:1;border-radius:50px;opacity:0.75">
<tr>
<th>
	<h1 align="center"> Add Leave</h1>
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
		<td>Back Up Office:</td>
		<td align="center"><input type="text" name="bckoffice"  value="${leave.bckoffice}"></td>
		<td align="center"></td>
	</tr>

	<tr>
		<td>Reason:</td>
		<td align="center"><select name="reason" id="reason">
  		<option value="Vacation Leave" ${leave.reason == 'Vacation Leave' ? 'selected' : ''}>Vacation Leave</option>
  		<option value="Medical Leave" ${leave.reason == 'Medical Leave' ? 'selected' : ''}>Medical Leave</option>
  		<option value="Maternity Leave" ${leave.reason == 'Maternity Leave' ? 'selected' : ''}>Maternity Leave</option> 
  		</select></td>
		<td align="center"></td>
	</tr>

	<tr>
		<td>Officer on Leave</td>
		<td align="center"><input name="offleave"  value="${user.lname}, ${user.fname} ${user.mname}" ></td>
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
		<button type="submit" style="background-color:#3B3131; color:#98AFC7" onclick="return checkDate()">Add New Leave</button>
		<input type="button" style="background-color:#3B3131; color:#98AFC7" onclick="location.href='userpage';" value="Back"/>
		<input type="button" style="background-color:#3B3131; color:#98AFC7" onclick="location.href='userpage';" value="Close"/>
		</td>
	</tr>
</table>
<br><br>
</form>
</th>
</tr>
</table>

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
		    return false;
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
  
  else{
	  return true;
  }

  return false;
}

</script>

</body>
</html>