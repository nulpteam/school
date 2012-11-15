<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div id="xoWaitPage" class="paperList">
	<script src="js/XO/XO.js" type="text/javascript"></script>
	<script src="js/XO/Lang_${lang}.js" type="text/javascript"></script>
	<script src="js/XO/WaitPage.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			waitClient();
		});
	</script>
	
	<div id="outText" class="title">
		<p align="center"></p>
	</div>
	<div class="homeButton" onmouseover=homeButtonOver(this);
		onmouseout=homeButtonOut(this); onclick=waitPageHomeButton();></div>
	<div class="backButton" onmouseover=backButtonOver(this);
		onmouseout=backButtonOut(this); onclick=waitPageBackButton();></div>
	<div class="refreshButton" onmouseover=refreshButtonOver(this);
		onmouseout=refreshButtonOut(this); onclick=refreshButtonClick();></div>
	<div id="startButton" align="center">
		<div class="button" onclick=startButtonClick();>
			<p class="buttonText">Start Game</p>
		</div>
	</div>

	<div id="msg" class="title">
		<p align="center">${langPack['XO_WP_msg']}</p>
	</div>
</div>