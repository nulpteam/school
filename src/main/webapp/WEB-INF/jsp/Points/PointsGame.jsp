<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	<div id="pts_body">
		<div id="pts_bg">
			<div id="pts_player1_score">
				<label>score :</label>
			</div>
			<div id="pts_player2_score">
				<label>score :</label>
			</div>
			<div id="pts_player_label_1">
				<img class="pts_player_div_elements" src="images/Points/server_point-2.png">
				<label class="pts_player_div_elements"></label>
			</div>
			<div id="pts_player_label_2">
				<img id="pts_player2_img" class="pts_player_div_elements" src="images/Points/client_point-1.png">
				<label class="pts_player_div_elements"></label>
			</div>

			<canvas id="pts_canvas" width="435" height="520"></canvas>

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

		</div>
	</div>
</div>
