<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- <html> -->
<!-- <head> -->
<%-- <c:forEach items="${sbJSLoader.scripts}" var="script"> --%>
<%-- 	<script src="<c:out value="${script}"/>" type="text/javascript"></script> --%>
<%-- </c:forEach> --%>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<!-- <link rel="SHORTCUT ICON" href="images/favicon.ico" type="image/x-icon">  -->
<!-- <link href="css/SB.css" type="text/css" rel="stylesheet"> -->
<%-- <title><c:out value="${langPack['Sb_ConnectToGame']}"/></title> --%>
<!-- </head> -->
<!-- <body> -->
	
	<div class=paperList>
	<c:forEach items="${sbJSLoader.scripts}" var="script">
		<script src="<c:out value="${script}"/>" type="text/javascript"></script>
	</c:forEach>
	<div id="gameID" class="${Game.id}"></div>
	<div id="userName" class="${user.name}"></div>
	<div class="decoImg">
		<img class="jakir" alt="Sheep" src="images/SB/jakir.png">	
		<img class="shturval" alt="Sheep" src="images/SB/shturval.png">	
	</div>
	<div class="SbMSheep">
		<img alt="Sheep" src="images/SB/BS.gif">	
	</div>
	<div class="clear"></div>
	<div class="menuText">
	<c:choose>
		 <c:when test="${serverMap.size()>0}">
     		<c:out value="${langPack['Sb_ExistsGames']}"/>
     	 </c:when>
      	<c:otherwise>
			<c:out value="${langPack['Sb_NoGames']}"/>
		</c:otherwise>
	</c:choose>
	</div>
	<div class="ServersList"style="float: left; font-size: 20px;">		
			<c:forEach items="${serverMap}" var="server">
			<div class=ctgame onclick="connect(<c:out value="${server.key}"/>)";>
				<img alt="${server.value.server.player.name}" src="images/SB/BSButton.gif">
				<p>${server.value.server.player.name}</p>
			</div>
<%-- 				<div style="border-color: rgb(91, 47, 206); border-style: dotted; width: 100px; height: auto; border-width: 3px;" onclick="connect(<c:out value="${server.key}"/>);"> --%>
<%-- 					<input type="button" value="<c:out value="${server.value.server.player.name}"/>" onclick="connect(<c:out value="${server.key}"/>);"> --%>
<%-- 						<img alt="${server.value.server.player.name}" src="images/SB/BSButton.gif"> --%>
<%-- 						<p align="left">${server.value.server.player.name}	</p> --%>
<!-- 				</div> -->
			</c:forEach>
	</div>
	</div>				
<!-- </body> -->
<!-- </html> -->