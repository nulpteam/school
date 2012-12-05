<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="SHORTCUT ICON" href="images/favicon.ico" type="image/x-icon"> 

<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/Infection/InfectionMenu.js" type="text/javascript"></script>
<title>Insert title here</title>
</head>
<body> -->
<div class="paperList">
	<script src="js/jquery.js" type="text/javascript"></script>
	<script src="js/Infection/InfectionMenu.js" type="text/javascript"></script>

	<div class="homeButton" onclick=PageHomeButton();></div>
	<div class="refreshButton" onclick=refreshButtonClick();></div>
    
    <div id="infection_title">${langPack['Infection']}</div>
     
	<div align="center" id="infConectList">
		<c:forEach var="game" items="${infGamesMap}" varStatus="i">
			<div class="button" id="${game.key}" onclick=connect(this.id);>
				<center>
					<div class="buttonText">
						${langPack['INF_server_name']}:
						<c:out value="${game.value.server.name}" />
					</div>
				</center>
			</div>
		</c:forEach>
	</div>
</div>