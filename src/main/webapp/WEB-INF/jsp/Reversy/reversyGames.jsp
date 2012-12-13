<!-- @author SergiyManko -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div  class="paperList" id="reversyGames">
<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/Reversy/Reversy_main.js" type="text/javascript"></script>
	<div class=reversyNavigation>
		<div class="reversyToHome" onclick="goTo('Menu.html');"></div>
		<div class="reversyToMenu" onclick="goTo('ReversyMenu.html');"></div>
		<div class="reversyToChamps" onclick="goTo('ReversyChamps.html');"></div>
	</div>
	<div class="reversy">
	<div class="ActiveServersList">
		<c:choose>
		 <c:when test="${ReversyGameList.size()>0}">
     		<c:out value="${langPack['Rev_ExistsGames']}"/>
     	 </c:when>
      	<c:otherwise>
			<c:out value="${langPack['Rev_NoGames']}"/>
		</c:otherwise>
	</c:choose>
	</div>
		<c:forEach items="${ReversyGameList}" var="game">
			<div class=reversyServer onclick="connectGame(<c:out value="${game.key}"/>);">
				<p>${game.value.player1.name}</p>
			</div>
		</c:forEach>
	</div>
</div>