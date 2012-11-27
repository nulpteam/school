<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div id="home" class="paperList">
	<div class="title">
		<p align="center">${langPack['Welcome']}, ${user.name}</p>
	</div>
	<div class="menu">
		<div class="button" onclick="goTo('XOMenu.html');">
			<p class="buttonText">${langPack['XO_title']}</p>
		</div>
		<div class="button" onclick="goTo('Sb.html');">
			<p class="buttonText">${langPack['Battleship']}</p>
		</div>
		<div class="button" onclick="goTo('ReversyMenu.html');">
			<p class="buttonText">${langPack['Reversi']}</p>
		</div>
		<div class="button" onclick="goTo('Points.html')">
			<p class="buttonText">${langPack['Points']}</p>
		</div>
		<div class="button" onclick="goTo('Infection.html');">
			<p class="buttonText">${langPack['Infection']}</p>
		</div>
		<div class="button" onclick="goTo('PersonalPage.html');">
			<p class="buttonText">${langPack['Cabinet']}</p>
		</div>
		<div class="button" onclick="location.href = 'Logout.html';">
			<p class="buttonText">${langPack['Logout']}</p>
		</div>
<!-- 		<button onclick="location.href = 'Logout.html';">logout</button> -->
	</div>
</div>
