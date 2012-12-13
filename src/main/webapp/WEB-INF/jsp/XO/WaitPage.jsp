<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div id="xoWaitPage" class="paperList">
	<script src="js/XO/Connections.js" type="text/javascript"></script>
	<script type="text/javascript">
		var myId = "${user.id}";
		$(document).ready(function(){
			waitClient();
		});
	</script>

	<div id="outText" class="title">
		<p align="center"></p>
	</div>
	<div class="homeButton" onclick="waitPageExit('Menu.html');"></div>
	<div class="backButton" onclick="waitPageExit('XOMenu.html');"></div>
	<div class="refreshButton" onclick="waitPageExit('CurrentPos.html');"></div>
	<div id="startButton" align="center">
		<div class="button" onclick=startButtonClick();>
			<p class="buttonText">Start Game</p>
		</div>
	</div>

	<div id="msg" class="title">
		<p align="center">${langPack['XO_WP_msg']}</p>
	</div>
</div>