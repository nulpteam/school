<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="SHORTCUT ICON" href="images/favicon.ico" type="image/x-icon"> 

<link href="css/Points/PointsGame.css" type="text/css" rel="stylesheet">

<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/Points/PointsGameWebSocket.js" type="text/javascript"></script>


<title>School Games</title>
</head>
<body>

	<div id="bg">
		<div id="player_label_1">
			<label></label>
		</div>
		<div id="player_label_2">
			<label></label>
		</div>
		<div id="game_table" userType="${ptsUserType}" gameId="${ptsGameId}">
			<table id="table" align="center" cellpadding="0" cellspacing="0">
				<c:forEach begin="0" end="25" step="1" varStatus="i">
					<tr>
						<c:forEach begin="0" end="21" step="1" varStatus="j">
							<td class="point" id="X${j.count-1}Y${i.count-1}" onClick=putPoint(this)>
								<img src="images/Points/square.png">
							</td>
						</c:forEach>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

</body>
</html>