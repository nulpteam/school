<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div id="xoServerList" class="paperList">
	<script src="js/XO/Connections.js" type="text/javascript"></script>
	<script type="text/javascript">
		var myId = "${user.id}";
	</script>

	<div class="title">
		<p align="center">
			<c:out value="${langPack['XO_SL_title']}" />
		</p>
	</div>
	<div class="homeButton" onclick="goTo('Menu.html');"></div>
	<div class="backButton" onclick="goTo('XOMenu.html');"></div>
	<div class="refreshButton" onclick="goTo('CurrentPos.html');"></div>
	<div class="menu">
		<div id="list">
			<c:forEach var="server" items="${serverMap}" varStatus="i">
				<div class="button" id="${server.key}" onclick=connect(this.id);>
					<p class="buttonText">
						<c:out value="${server.value.game.server.name}" />
					</p>
				</div>
			</c:forEach>
		</div>
	</div>
</div>