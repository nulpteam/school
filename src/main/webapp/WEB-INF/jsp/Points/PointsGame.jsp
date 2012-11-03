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
<script>
function paint() {
	setTimeout(realPaint, 2000);
}

function realPaint() {
	var c = document.getElementById("canvas");
	var ctx = c.getContext("2d");
	ctx.beginPath();
	ctx.arc(95, 50, 40, 0, 2 * Math.PI);
	ctx.stroke();
}
</script>


<title>School Games</title>
</head>
<body>

	<div id="bg">
		<div id="player_label_1"  onClick=paint()>
			<label></label>
		</div>
		<div id="player_label_2">
			<label></label>
		</div>

		<canvas id="canvas" width="435" height="520"
			style="border:1px solid #000000;"></canvas>

		<div id="game_table" userType="${ptsUserType}" gameId="${ptsGameId}">
			<table id="table1" align="center" cellpadding="0" cellspacing="0">
				<c:forEach begin="0" end="25" step="1" varStatus="i">
					<tr>
						<c:forEach begin="0" end="21" step="1" varStatus="j">
							<td class="point" id="X${j.count-1}Y${i.count-1}"
								onClick=putPoint(this)><img src="images/Points/square.png">
							</td>
						</c:forEach>
					</tr>
				</c:forEach>
			</table>
		</div>
		
	</div>

</body>
</html>