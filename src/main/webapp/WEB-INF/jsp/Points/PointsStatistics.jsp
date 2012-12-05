<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div id="pointsStatistics" class="paperList">
	<script src="js/jquery.js" type="text/javascript"></script>

	<div class="title">
		<p align="center">${langPack['Pts_stat_title']}</p>
	</div>
	<div class="homeButton" onclick=homeButtonClick();></div>
	<div class="backButton" onclick=backButtonClick();></div>
	<div class="refreshButton" onclick=refreshButtonClick();></div>
	<table id="pts_statistics_table">
		<thead>
			<tr>
				<th class="ptsStNumber"></th>
				<th class="ptsStName">${langPack['XO_stat_name']}</th>
				<th class="ptsStWins">${langPack['XO_stat_wins']}</th>
				<th class="ptsStLosses">${langPack['XO_stat_losses']}</th>
				<th class="ptsStTotal">${langPack['XO_stat_total']}</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="player" items="${ptsStatList}" varStatus="number">
				<c:if test="${user.name == player.name}">
					<tr>
						<td class="iamNumber">${number.count}</td>
						<td class="iamTableTd">${player.name}</td>
						<td class="iamTableTd">${player.wins}</td>
						<td class="iamTableTd">${player.losses}</td>
						<td class="iamTableTd">${player.total}</td>
					</tr>
				</c:if>
				<c:if test="${user.name != player.name}">
					<tr>
						<td class="ptsStNumber">${number.count}</td>
						<td class="ptsStTableTd">${player.name}</td>
						<td class="ptsStTableTd">${player.wins}</td>
						<td class="ptsStTableTd">${player.losses}</td>
						<td class="ptsStTableTd">${player.total}</td>
					</tr>
				</c:if>
			</c:forEach>
			<c:if test="${myPos > 10}">
				<tr>
					<td class="ptsStNumber">...</td>
					<td class="ptsStTableTd">...</td>
					<td class="ptsStTableTd">...</td>
					<td class="ptsStTableTd">...</td>
					<td class="ptsStTableTd">...</td>
				</tr>
				<tr>
					<td class="iamNumber">${ptsMyPos}</td>
					<td class="iamTableTd">${ptsMyStats.name}</td>
					<td class="iamTableTd">${ptsMyStats.wins}</td>
					<td class="iamTableTd">${ptsMyStats.losses}</td>
					<td class="iamTableTd">${ptsMyStats.total}</td>
				</tr>
			</c:if>
		</tbody>
	</table>
</div>