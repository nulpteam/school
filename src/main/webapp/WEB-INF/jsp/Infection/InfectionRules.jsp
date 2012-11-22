<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div class="paperList">

	<script src="js/jquery.js" type="text/javascript"></script>
	<script src="js/Infection/InfectionMenu.js" type="text/javascript"></script>
    
    <div id="infection_title">${langPack['INF_rules']}</div>
	<div class="homeButton" onclick=PageHomeButton();></div>
	<div class="refreshButton" onclick=refreshButtonClick();></div>
	
	<div id="inf_game_rules">${langPack['INF_rules_for_game']}</div>
	

</div>