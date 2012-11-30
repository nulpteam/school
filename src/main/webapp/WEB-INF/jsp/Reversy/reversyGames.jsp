<!-- @author SergiyManko -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div  class="paperList" id="reversyGames">
<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/Reversy/Reversy_main.js" type="text/javascript"></script>
	<div class="reversy">
		<c:forEach items="${ReversyGameList}" var="game">
			<div class=game onclick="connectGame(<c:out value="${game.key}"/>);">
				<p>${game.value.player1.name}</p>
				<p>${game.value.id}</p>
			</div>
			</c:forEach>
	</div>
</div>