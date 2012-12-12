<!-- @author SergiyManko -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div  class="paperList" id="reversyMenu">
<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/Reversy/Reversy_main.js" type="text/javascript"></script>

	<div class=reversyNavigation>
		<div class="reversyToHome" onclick="goTo('Menu.html');"></div>
		<div class="reversyToMenu" onclick="goTo('ReversyMenu.html');"></div>
		<div class="reversyToChamps" onclick="goTo('ReversyChamps.html');"></div>
	</div>
	<div id="menuAnimation">
	</div>
	<div class=reversyGameMenu>
	
		<div class="reversyMButtons">
			<div class="reversyCreate"  onclick="create();"></div>
			<div class="revText">${langPack['Rev_Create']}</div>
		</div>
		
		<div class="reversyMButtons">
			<div class="reversyConnect"  onclick="goToList();"></div>
			<div class="revText">${langPack['Rev_Connect']}</div>
		</div>
		<div class="reversyMButtons">
			<div class="reversyRules"  onclick="goToRules();"></div>
			<div class="revText">${langPack['Rev_Rules']}</div>
		</div>
	
<!-- 		<div class="reversyCreate" onclick="create()"></div> -->
<!-- 		<div class="reversyConnect" onclick="goToList()"></div> -->
<!-- 		<div class="reversyRules" onclick="goToRules()"></div> -->
	</div>
</div>