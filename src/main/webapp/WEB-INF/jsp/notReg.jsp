<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script language="JavaScript" type="text/javascript" src="js/jquery.js" ></script>
	<script language="JavaScript" type="text/javascript" src="js/jquery.validate.js" ></script>
	<script language="JavaScript" type="text/javascript" src="js/messages.js" ></script>
	<title>Insert title here</title>
</head>
<body>
	<div>
		<h2>Your user name or password is incorrect.</h2>
		<br>
		<h2>Переробити: при вводі невірного логіну/паролю перехід на Login.jsp з повідомленням про невірний логін/пароль і пропозицією зареєструватись. </h2>
	</div>
	<form action="Login.html" method="post" id="myform">
		<input class="required" type="text">
		<input type="submit" value="Go" >
	</form>
	<script language="JavaScript" type="text/javascript">
		$(function () {$('#myform').validate();});
	</script>
</body>
</html>