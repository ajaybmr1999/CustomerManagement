<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Registration Page</title>
</head>
<body>
	<form action="regCustomer" method="post" >
		Name: <input type="text" name="tbName" id="tbName">
		<br>
		
		Email: <input type="email" name="tbEmail" id="tbEmail">
		<br>
		
		Mobile: <input type="tel" name="tbMobile" id="tbMobile">
		<br>
		
		Password: <input type="password" name="tbPass" id="tbPass">
		<br>
		
		State: <select name="ddlStates"> 
					<option>----select----</option>
					<option value="Karnataka">KA</option>
					<option value="Tamilnadu">TN</option>
					<option value="Andrapradesh">AP</option>
					<option value="Kerala">KE</option>
			   </select>
		<br>
		
		<input type="submit" value="Register">
	
	</form>
</body>
</html>