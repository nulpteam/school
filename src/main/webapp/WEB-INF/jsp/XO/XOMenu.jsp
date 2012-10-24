<%@page import="org.springframework.context.annotation.Import"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="epam.ph.sg.models.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/styles.css" type="text/css" rel="stylesheet">
<link href="css/XO.css" type="text/css" rel="stylesheet">
<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/XO/XOMenu.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		chatStart();
	});
</script>
<title><c:out value="${langPack['XO_title']}" /></title>
</head>
<body>
	<c:import url="../Chat.jsp"></c:import>

	<div class="paperList">
		<div class="title">
			<p align="center">
				<c:out value="${langPack['XO_title']}" />
			</p>
		</div>
		<div id="menu" align="center">
			<div class="button" onclick=createServer();>
				<p class="buttonText">
					<c:out value="${langPack['XO_button_create']}" />
				</p>
			</div>
			<div class="button" onclick=serverListPage();>
				<p class="buttonText">
					<c:out value="${langPack['XO_button_connect']}" />
				</p>
			</div>
		</div>
		<div id="rulles">
			<c:out value="${langPack['XO_rules']}" />
		</div>
	</div>
</body>
</html>