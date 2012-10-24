<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/menu.js" type="text/javascript"></script>
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
	<h5 class="welcome_message">
		Welcome
		<c:out value="${user.name}" />
		, you are logged in :)
	</h5>
	<div id="bg_menu">
		<div id="gomoku_button" class="button" onclick=XO();>Play Gomoku</div>
		<div id="battleship_button" class="button" onclick=BS();>Play
			Battleship</div>
		<div id="reversi_button" class="button" onclick=reversi();>Play
			Reversi</div>
		<div id="points_button" class="button unselect" onclick=points();>Play
			Points</div>
		<div id="storerooom_button" class="button" onclick=storeRoom();>Storeroom</div>
		<div id="halloffame_button" class="button" onclick=hallOfFame();>
			Hall Of Fame</div>
	</div>


</body>
</html>