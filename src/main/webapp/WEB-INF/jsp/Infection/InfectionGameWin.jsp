<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div class="paperList">

	<script src="js/jquery.js" type="text/javascript"></script>
	<script src="js/Infection/InfectionMenu.js" type="text/javascript"></script>

	<div class="homeButton" onclick=PageHomeButton();></div>
	<div class="refreshButton" onclick=refreshButtonClick();></div>
	
	
	<div id="winner_img"></div>
	<div id="congrat_message">${langPack['INF_user_won']}</div>
	
	<div class="exitButton" onclick=exitButton();></div>
	

</div>