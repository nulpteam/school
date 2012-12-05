<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="SHORTCUT ICON" href="images/favicon.ico" type="image/x-icon">

<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/Infection/InfectionGame.js" type="text/javascript"></script>
<script src="js/Infection/InfectionGameWebSocket.js" type="text/javascript"></script>
<script language="JavaScript" type="text/javascript"
	src="js/jquery.validate.js"></script>
<script language="JavaScript" type="text/javascript"
	src="js/messages_<c:out value="${lang}"/>.js"></script>

<title>School Games</title>
<link href="css/InfectionGame.css" type="text/css" rel="stylesheet">
<link href="css/styles.css" type="text/css" rel="stylesheet">
</head>
<body> -->
<div class="paperList">
	<script src="js/jquery.js" type="text/javascript"></script>
	<script src="js/Infection/InfectionGame.js" type="text/javascript"></script>
	<script src="js/Infection/InfectionMenu.js" type="text/javascript"></script>
	<script src="js/Infection/InfectionGameWebSocket.js"
		type="text/javascript"></script>
	<script language="JavaScript" type="text/javascript"
		src="js/jquery.validate.js"></script>
	<script language="JavaScript" type="text/javascript"
		src="js/messages_<c:out value="${lang}"/>.js"></script>

	<div id="infbody">

		<div id="infplayer_label_1">
			<label></label>
		</div>
		<div id="infplayer_label_2">
			<label></label>
		</div>
		<div id="infscore_label_1">
			<label></label>
		</div>
		<div id="infscore_label_2">
			<label></label>
		</div>

		<div class="exitInGameButton" onclick=exitButton();></div>

		<div class="homeButton" onclick=PageHomeButton();></div>
		<div class="refreshButton" onclick=refreshButtonClick();></div>

		<div id="infection_title">
			<c:out value="${langPack['Infection']}" />
		</div>
		<div id="inf_message_place">
			<img src="">
		</div>

		<div id="inf_table_bg">
			<div id="infgame_table" userType="${infUserType}"
				gameId="${infGameId}" userId="${userId}">
				
				<table id="inftable" align="center" cellpadding="0" cellspacing="0">

					<c:forEach begin="0" end="6" step="1" varStatus="i">
						<tr>
							<c:forEach begin="0" end="6" step="1" varStatus="j">
								<td class="chip" id="X${j.count-1}Y${i.count-1}"
									onClick=firstMove(this)><img src=""></td>
							</c:forEach>
						</tr>
					</c:forEach>

				</table>
			</div>
		</div>
		
	</div>

</div>
