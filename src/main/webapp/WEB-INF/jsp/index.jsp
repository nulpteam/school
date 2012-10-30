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
		<div id="gomoku_button" class="button" onclick=XO();>
			<center>
				<c:out value="${langPack['Gomoku']}" />
			</center>
		</div>
		<div id="battleship_button" class="button" onclick=BS();>
			<center>
				<c:out value="${langPack['Battleship']}" />
			</center>
		</div>
		<div id="reversi_button" class="button" onclick=reversi();>
			<center>
				<c:out value="${langPack['Reversi']}" />
			</center>
		</div>
		<div id="points_button" class="button unselect" onclick=points();>
			<center>
				<c:out value="${langPack['Points']}" />
			</center>
		</div>
		<div id="infection_button" class="button unselect"
			onclick=infection();>
			<center>
				<c:out value="${langPack['Infection']}" />
			</center>
		</div>
		<div id="storerooom_button" class="button" onclick=cabinet();>
			<center>
				<c:out value="${langPack['Cabinet']}" />
			</center>
		</div>

	</div>


</body>
</html>