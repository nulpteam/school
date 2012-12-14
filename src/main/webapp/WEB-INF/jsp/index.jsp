<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SchoolGames</title>

<link rel="SHORTCUT ICON" href="images/favicon.ico" type="image/x-icon">
<link href="css/paperList.css" type="text/css" rel="stylesheet">
<link href="css/Login.css" type="text/css" rel="stylesheet">
<link href="css/Reversy.css" type="text/css" rel="stylesheet">
<link href="css/XO/xoStyle.css" type="text/css" rel="stylesheet">
<link href="css/XO/xoGame.css" type="text/css" rel="stylesheet">
<link href="css/Personal/personal.css" type="text/css" rel="stylesheet">
<link href="css/SB.css" type="text/css" rel="stylesheet">
<link href="css/Personal/jquery-ui-datepicker.css" type="text/css"
	rel="stylesheet">
<link href="css/InfectionGame.css" type="text/css" rel="stylesheet">
<link href="css/Points/PointsGame.css" type="text/css" rel="stylesheet">

<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/Lang/Lang_${lang}.js" type="text/javascript"></script>
<script src="js/index.js" type="text/javascript"></script>
<script type="text/javascript" src="js/WebSocket/swfobject.js"></script>
<script type="text/javascript" src="js/WebSocket/web_socket.js"></script>
</head>
<body>
	<div id="lang_bar">
		<img id="ua" src="images/flag_ua.png" class="flag" onclick="changeLanguage(this);"/>
		<img id="ru" src="images/flag_ru.png" class="flag" onclick="changeLanguage(this);"/>
		<img id="us" src="images/flag_en.png" class="flag" onclick="changeLanguage(this);"/>
	</div>
	<div class="page">
		<c:import url="Tab/Tab.jsp"></c:import>
		<div class="paperList"></div>
	</div>
</body>
</html>