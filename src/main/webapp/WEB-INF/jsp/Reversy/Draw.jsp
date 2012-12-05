<!-- @author SergiyManko -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div  class="paperList" id="reversyMenu">
<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/Reversy/Reversy_main.js" type="text/javascript"></script>
	<div>
		<p align="center">${langPack['R_draw']}<br>
		${ReversyVinDefData.player1} - ${ReversyVinDefData.player2}<br>
		${ReversyVinDefData.count1} : ${ReversyVinDefData.count2}</p>
	</div>
	<div id="drawAnimation">
	</div>
	<div class=reversyNavigation id="end">
		<div class="reversyToHome" onclick="goTo('Menu.html');"></div>
		<div class="reversyToMenu" onclick="goTo('ReversyMenu.html');"></div>
		<div class="reversyToChamps" onclick="goTo('ReversyChamps.html');"></div>
	</div>
</div>