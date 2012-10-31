<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/Login.js" type="text/javascript"></script>
<script language="JavaScript" type="text/javascript"
	src="js/jquery.validate.js"></script>
<script language="JavaScript" type="text/javascript"
	src="js/messages_<c:out value="${lang}"/>.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>School Games</title>
<link href="css/menu.css" type="text/css" rel="stylesheet">
<link href="css/styles.css" type="text/css" rel="stylesheet">
</head>
<body>

	<div id="bg">

		<div id="reg_title">
			<b><c:out value="${langPack['Register_page_title']}" /></b>
		</div>
		<div id="reg_title2">
			<b><c:out value="${langPack['Register_page_title2']}" /></b>
		</div>
		<div id="regform">

			
			<form action="Reg.html" method="POST" id="myform">
				<p id="name_text">
					<b><c:out value="${langPack['Name']}" /></b>
				</p>
				<div id="name_area_div">
					<input id="name_area_input" class="input_areas required"
						type="text" name="user_name" maxlength="25" size="15">
				</div>
				<p id="pass_text">
					<b><c:out value="${langPack['Password']}" /></b>
				</p>
				<div id="pass_area_div">
					<input id="pass_area_input" class="input_areas required"
						type="password" name="password" maxlength="20" size="15">
				</div>
				<div>
					<input id="login_button" class="button" type="submit" value="<c:out value="${langPack['Ready']}"/>">				
				</div>

			</form>

		</div>
		<div id="dialog_text">
			<p></p>
		</div>
		<div id="language_bar">
			<img id="ua" src="images/flag_ua.png" name="ua"onclick=language(this);>
		    <img id="ru" src="images/flag_ru.png" name="ru" onclick=language(this);>
		    <img id="us" src="images/flag_us.png" name="us" onclick=language(this);>
		</div>
		<!div>
		<!img id="splats" src="images/splats.png">
		<!/div>
	</div>
	<script language="JavaScript" type="text/javascript">
		$(function () {$('#myform').validate();});
	</script>
</body>
</html>