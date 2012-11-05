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
<link href="css/personalPage.css" type="text/css" rel="stylesheet">
<script src="js/personalPage.js" type="text/javascript"></script>
<title>Personal Page</title>
</head>
<body>
	<div class="page">
		<div class="paperList">
			<div class="title">
				<p align="center">Personal Page</p>
			</div>
			<form action="PersonalPage.html" method="POST">
				<div id="name">
					<p>
						<b><c:out value="${langPack['Name']}" /> <c:out value="${user.name}" /></b>
					</p>
					<input class="input_areas required" type="text" name="user_name">
				</div>
				<div id="pass">
					<p>
						<b><c:out value="${langPack['Password']}" /></b>
					</p>
					<input class="input_areas required" type="text" name="user_pass">
				</div>
				<div id="xoStat">
					<table>
						<tr><th>Name:</th><th>Wins:</th><th>Losses:</th><th>Total:</th></tr>
						<c:forEach var="player" items="${xoStat}" varStatus="i">
							<tr><th>${player.name}</th><th>${player.wins}</th><th>${player.losses}</th><th>${player.total}</th></tr>
						</c:forEach>
					</table>
				</div>
			</form>
		</div>
	</div>
</body>
</html>