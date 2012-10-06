<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/Login.js" type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>School Games</title>
<link href="css/login.css" type="text/css" rel="stylesheet">
<link href="css/styles.css" type="text/css" rel="stylesheet">
</head>
<body>
<div style="color:red">

	<%-- <c:out value="${user.name}" /> --%>
</div>
	<div id="bg">
		<div id="loginform">
			<div id="register" onclick=register();>
				<img src="images/register.png">
			</div>
			<form action="Login.html" method="POST">
				<p id="name_text">
					<label>User name:</label>
				</p>
				<p id="name_area">
					<input class="input_areas" type="text" name="user_name"
						maxlength="25" size="15" title="Enter username">
				</p>
				<p id="pass_text">
					<label>Password:</label>
				</p>
				<p id="pass_area">
					<input class="input_areas" type="password" name="password"
						maxlength="20" size="15" title="Enter password">
				</p>
				<div>
					<input class="button" type="submit" value="Enter">
				</div>
			</form>
		</div>
		<div id="dialog_text">
			<p>
	
			</p>
		</div>
		<div id="language_bar">
			<img id="UKR" src="images/flag_ua.png" name="ua" onclick=language(this);>
			<img id="RUS" src="images/flag_ru.png" name="ru" onclick=language(this);>
			<img id="USA" src="images/flag_us.png" name="us" onclick=language(this);>
		</div>
		<div>
			<img id="splats" src="images/splats.png">
		</div>
	</div>
</body>
</html>