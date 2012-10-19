<%@page import="org.springframework.context.annotation.Import"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="epam.ph.sg.models.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/styles.css" type="text/css" rel="stylesheet">
<link href="css/XOMenu.css" type="text/css" rel="stylesheet">
<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/XO/XOMenu.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		chatStart();
	});
	function connectLink() {
		location.href = "XOServerList.html";
	}
</script>
<title>School Games</title>
</head>
<body>
	<c:import url="../Chat.jsp"></c:import>
	<div id="paperList">
		<h2 id="title" align="center">Хрестики нолики</h2>
		<div id="menu">
			<div onclick=createServer(); class="button">
				<p class="text">Створити гру</p>
			</div>
			<div onclick=connectLink(); class="button">
				<p class="text">Підключитись</p>
			</div>
		</div>
		<div id="rulles">Правила: Гравці по черзі ставлять на вільні
			квадрати поля свої фігури (хрестики або ноліки). Виграє той хто
			поставить рядом по вертикалі, горизонталі або діагоналі 5 своїх
			фігур.</div>
	</div>
</body>
</html>