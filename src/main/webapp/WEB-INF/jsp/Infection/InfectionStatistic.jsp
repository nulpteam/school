<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<div id="infStatistics" class="paperList">
	<script src="js/jquery.js" type="text/javascript"></script>
	<script src="js/Infection/InfectionMenu.js" type="text/javascript"></script>

	<div class="homeButton" onclick=PageHomeButton();></div>
	<div class="refreshButton" onclick=refreshButtonClick();></div>

	<div id="infection_title">
		<p align="center">${langPack['INF_statistics']}</p>
	</div>
	
		<table>
			<thead>
				<tr>
					<th class="number"></th>
					<th class="name">${langPack['INF_stat_name']}</th>
					<th class="wins">${langPack['INF_stat_wins']}</th>
					<th class="losses">${langPack['INF_stat_losses']}</th>
					<th class="total">${langPack['INF_stat_total']}</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="player" items="${infectionStatisticList}"
					varStatus="number">
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