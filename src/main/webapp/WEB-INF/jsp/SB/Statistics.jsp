<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div id="xoStatistics" class="paperList">
	<div class="title">
		<p align="center">${langPack['XO_stat_title']}</p>
	</div>
	<div class="homeButton" onclick=homeButtonClick();></div>
	<div class="backButton" onclick="goTo('Sb.html');"></div>
	<table>
		<thead>
			<tr>
				<th class="number"></th>
				<th class="name">${langPack['XO_stat_name']}</th>
				<th class="wins">${langPack['XO_stat_wins']}</th>
				<th class="losses">${langPack['XO_stat_losses']}</th>
				<th class="total">${langPack['XO_stat_total']}</th>
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
						<td class="number">${number.count}</td>
						<td class="name">${player.name}</td>
						<td class="wins">${player.wins}</td>
						<td class="losses">${player.losses}</td>
						<td class="total">${player.total}</td>
					</tr>
				</c:if>
			</c:forEach>
			<c:if test="${myPos > 10}">
				<tr>
					<td class="number">...</td>
					<td class="name">...</td>
					<td class="wins">...</td>
					<td class="losses">...</td>
					<td class="total">...</td>
				</tr>
				<tr>
					<td class="iam">${myPos}</td>
					<td class="iam">${myStats.name}</td>
					<td class="iam">${myStats.wins}</td>
					<td class="iam">${myStats.losses}</td>
					<td class="iam">${myStats.total}</td>
				</tr>
			</c:if>
		</tbody>
	</table>
</div>