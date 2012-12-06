<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--  <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="SHORTCUT ICON" href="images/favicon.ico" type="image/x-icon">

<link href="css/Points/PointsGame.css" type="text/css" rel="stylesheet">

<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/Points/PointsGameWebSocket.js" type="text/javascript"></script>


<title>School Games</title>
</head>
<body>-->
<div class="paperList">
	<script src="js/jquery.js" type="text/javascript"></script>
	<script src="js/Points/PointsGameWebSocket.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/SB/swfobject.js"></script>
	<script type="text/javascript" src="js/SB/web_socket.js"></script>

	<div id="pts_body">
		<div id="pts_bg">
			<div id="waiting_for_client">
				<label>${langPack['Pts_waiting']}</label>
			</div>
			<div id="pts_player1_score">
				<label>${langPack['Pts_score']}</label>
				<label id="pts_score1"></label>
			</div>
			<div id="pts_player2_score">
				<label>${langPack['Pts_score']}</label>
				<label id="pts_score2"></label>
			</div>
			<div id="pts_player_label_1">
				<img class="pts_player_div_elements"
					src="images/Points/server_point-2.png"> <label
					class="pts_player_div_elements"></label>
			</div>
			<div id="pts_player_label_2">
				<img id="pts_player2_img" class="pts_player_div_elements"
					src="images/Points/client_point-1.png"> <label
					class="pts_player_div_elements"></label>
			</div>
			<div id="wait">
				<img src="images/Points/wait.gif">
			</div>

			<div id="pts_timer">
				<label id="pts_timer_title">Time:</label>
				<label id="pts_time"></label>
			</div>


			<canvas id="pts_canvas" width="435" height="520"></canvas>

			<canvas id="pts_canvas_last_points" width="435" height="520"></canvas>

			<div id="pts_game_table" userType="${ptsUserType}"
				gameId="${ptsGameId}">
				<table id="pts_table1" align="center" cellpadding="0"
					cellspacing="0">
					<c:forEach begin="0" end="18" step="1" varStatus="i">
						<tr>
							<c:forEach begin="0" end="19" step="1" varStatus="j">
								<td class="pts_point" id="X${j.count-1}Y${i.count-1}"
									onClick=putPoint(this)><img src="images/Points/square.png">
								</td>
							</c:forEach>
						</tr>
					</c:forEach>
				</table>
			</div>


			<div id="pts_surrender_div">
				<div id="pts_surrender_bg">
					<label id="pts_surrender_label">${langPack['Pts_surrender']}</label>
					<label id="pts_surrender_yes" class="pts_surrender_button"
						onClick="surrenderYes()">${langPack['Pts_yes']}</label> <label
						id="pts_surrender_no" class="pts_surrender_button"
						onClick="surrenderNo()">${langPack['Pts_no']}</label>
				</div>
			</div>

			<div class="homeButton" onclick="goToMenu()"></div>
			<div class="refreshButton" onclick="goTo('PointsGame.html')"></div>
			<div class="surrenderButton" onClick="surrender()"></div>
		</div>
	</div>
</div>
