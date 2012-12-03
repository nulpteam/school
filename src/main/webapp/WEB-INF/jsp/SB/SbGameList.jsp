<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class=paperList>
	<script type="text/javascript" src="js/SB/swfobject.js"></script>
 	<script type="text/javascript" src="js/SB/web_socket.js"></script>
	<c:forEach items="${sbJSLoader.scripts}" var="script">
		<script src="<c:out value="${script}"/>" type="text/javascript"></script>
	</c:forEach>
	<div class="SbMButtonRightHome" onclick="goTo('Menu.html')"></div>
	<div class="backButton2" onclick="goTo('Sb.html');"></div>
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
			<div class=ctgame onclick="connect(<c:out value="${server.key}"/>)">
				<img alt="${server.value.server.player.name}" src="images/SB/BSButton.gif">
				<p>${server.value.server.player.name}</p>
			</div>
			</c:forEach>
	</div>
</div>				