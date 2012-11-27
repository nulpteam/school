<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--  <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="SHORTCUT ICON" href="images/favicon.ico" type="image/x-icon"> 


<title>Insert title here</title>
</head>
<body>-->
<div class="paperList">
	<div id="pts_bg_game_list">
		<script src="js/jquery.js" type="text/javascript"></script>
		<script src="js/Points/PointsMenu.js" type="text/javascript"></script>
		<div id="pts_servers_div">
			<c:forEach var="gameServer" items="${pointsGameServersMap}" varStatus="i">
			<div id="${gameServer.key}" class="pts_server_div" onclick=connect(this.id)>
				<img src="images/Points/server_point-2.png" id="${game.key}">
				<label id="pts_server_label"><c:out value="${gameServer.value}" /> </label>
			</div>
			</c:forEach>
		</div>

		<div class="homeButton" onclick="goTo('Menu.html')"></div>
		<div class="backButton" onClick="goTo('Points.html')"></div>
		<div class="refreshButton" onclick="goTo('PointsConnectList.html')"></div>
	</div>
</div>