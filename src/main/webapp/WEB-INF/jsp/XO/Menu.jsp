<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div id="xoMenu" class="paperList">
	<div class="title">
		<p align="center">
			<c:out value="${langPack['XO_title']}" />
		</p>
	</div>
	<div class="homeButton" onclick="goTo('Menu.html');"></div>
	<div class="refreshButton" onclick="goTo('CurrentPos.html');"></div>
	<div class="menu">
		<div class="button" onclick="goTo('XOCreate.html');">
			<p class="buttonText">
				<c:out value="${langPack['XO_button_create']}" />
			</p>
		</div>
		<div class="button" onclick="goTo('XOServerList.html');">
			<p class="buttonText">
				<c:out value="${langPack['XO_button_connect']}" />
			</p>
		</div>
		<div class="button" onclick="goTo('XOStatistics.html');">
			<p class="buttonText">${langPack['XO_stat_title']}</p>
		</div>
	</div>
	<div id="rulles">
		<c:out value="${langPack['XO_rules']}" />
	</div>
</div>