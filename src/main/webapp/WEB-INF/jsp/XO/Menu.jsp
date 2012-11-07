<%@page import="org.springframework.context.annotation.Import"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="epam.ph.sg.models.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><c:out value="${langPack['XO_title']}" /></title>

<link rel="SHORTCUT ICON" href="images/favicon.ico" type="image/x-icon">
<link href="css/XO/XO.css" type="text/css" rel="stylesheet">

<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/XO/Menu.js" type="text/javascript"></script>

<script type="text/javascript">
	$(document).ready(function() {
		chatStart();
	});
</script>
</head>
<body>
	<div class="page">
		<c:import url="../Tab/Tab.jsp"></c:import>

		<div class="paperList">
			<div class="title">
				<p align="center">
					<c:out value="${langPack['XO_title']}" />
				</p>
			</div>
			<div class="homeButton" onmouseover=homeButtonOver(this);
				onmouseout=homeButtonOut(this); onclick=homeButtonClick();></div>
			<div class="refreshButton" onmouseover=refreshButtonOver(this);
				onmouseout=refreshButtonOut(this); onclick=refreshButtonClick();></div>
			<div id="menu" align="center">
				<div class="button" onclick=createServerButton();>
					<p class="buttonText">
						<c:out value="${langPack['XO_button_create']}" />
					</p>
				</div>
				<div class="button" onclick=serverListButton();>
					<p class="buttonText">
						<c:out value="${langPack['XO_button_connect']}" />
					</p>
				</div>
				<div class="button" onclick=statisticsButton();>
					<p class="buttonText">${langPack['XO_stat_title']}</p>
				</div>
			</div>
			<div id="rulles">
				<c:out value="${langPack['XO_rules']}" />
			</div>
		</div>
	</div>
</body>
</html>