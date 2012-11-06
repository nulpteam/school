<%@page import="org.springframework.context.annotation.Import"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="epam.ph.sg.models.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="SHORTCUT ICON" href="images/favicon.ico" type="image/x-icon">
<link href="css/XO/XO.css" type="text/css" rel="stylesheet">

<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/XO/Menu.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		chatStart();
	});
</script>
<title><c:out value="${langPack['XO_title']}" /></title>
</head>
<body>
	<div class="page">
		<c:import url="../Tab/Tab.jsp"></c:import>

		<div class="paperList">
			<div class="title">
				<p align="center">
					Статистика
					<!-- !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
				</p>
			</div>
			<div class="homeButton" onmouseover=homeButtonOver(this);
				onmouseout=homeButtonOut(this); onclick=homeButtonClick();></div>
			<div id="statistics">
				<table>
					<thead>
						<tr>
							<th></th>
							<th>Name:</th>
							<th>Wins:</th>
							<th>Losses:</th>
							<th>Total:</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="player" items="${xoStatList}" varStatus="number">
							<c:if test="${user.name == player.name}">
								<tr>
									<td class="iam">${number.count}</td>
									<td class="iam">${player.name}</td>
									<td class="iam">${player.wins}</td>
									<td class="iam">${player.losses}</td>
									<td class="iam">${player.total}</td>
								</tr>
							</c:if>
							<c:if test="${user.name != player.name}">
								<tr>
									<td>${number.count}</td>
									<td>${player.name}</td>
									<td>${player.wins}</td>
									<td>${player.losses}</td>
									<td>${player.total}</td>
								</tr>
							</c:if>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>