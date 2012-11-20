<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div id="home" class="paperList">
	<script type="text/javascript">
		function BS() {
			window.location.href = "Sb.html";
		}
	
		function reversy() {
			window.location.href = "ReversyMenu.html";
		}
	
		function points() {
			window.location.href = "Points.html";
		}
	
		function infection() {
			window.location.href = "Infection.html";
		}
	</script>
	<div class="title">
		<p align="center">Welcome</p>
	</div>
	<div class="menu">
		<div class="button" onclick=goTo(xoLink);>
			<p class="buttonText">${langPack['XO_title']}</p>
		</div>
		<div class="button" onclick="goTo('Sb.html');">
			<p class="buttonText">${langPack['Battleship']}</p>
		</div>
		<div class="button" onclick=reversy();>
			<p class="buttonText">${langPack['Reversi']}</p>
		</div>
		<div class="button" onclick=points();>
			<p class="buttonText">${langPack['Points']}</p>
		</div>
		<div class="button" onclick="goTo('Infection.html');">
			<p class="buttonText">${langPack['Infection']}</p>
		</div>
		<div class="button" onclick=goTo(ppLink);>
			<p class="buttonText">${langPack['Cabinet']}</p>
		</div>
	</div>
</div>