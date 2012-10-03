<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	function register() {
		alert("ghdfg");
		windows.location.href("login");
	}
	
	function language() {
		windows.location.href("language");
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/index.css" type="text/css" rel="stylesheet">
</head>
<body>
	<div id="bg">
		<div id="loginform">
			<div id="register">
				<img src="images/register.png" onclick="register()">
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
			<img id="language_ua" src="images/flag_ua.png" name="ua" onclick="register()">
			<img id="language_ru" src="images/flag_ru.png" name="ru" onclick="register()">
			<img id="language_us" src="images/flag_us.png" name="us" onclick="register()">
		</div>
		<div>
			<img id="splats" src="images/splats.png">
		</div>
	</div>
</body>
</html>