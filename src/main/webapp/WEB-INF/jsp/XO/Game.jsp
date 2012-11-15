<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div id="xoGame" class="paperList">
	<script src="js/XO/XO.js" type="text/javascript"></script>
	<script src="js/XO/Lang_${lang}.js" type="text/javascript"></script>
	<script src="js/XO/Game.js" type="text/javascript"></script>
	<script type="text/javascript">
		var myId = "${user.id}";
	
		$(document).ready(function() {
			gameStart();
		});
	</script>

	<div class="homeButton" onmouseover=homeButtonOver(this);
		onmouseout=homeButtonOut(this); onclick=gameHomeButton();></div>
	<div class="backButton" onmouseover=backButtonOver(this);
		onmouseout=backButtonOut(this); onclick=gameBackButton();></div>
	<div class="refreshButton" onmouseover=refreshButtonOver(this);
		onmouseout=refreshButtonOut(this); onclick=gameRefreshButton();></div>

	<div id="myName" class="namespace" onclick=statShow(this.id);>
		<p>
			<c:out value="${user.name}" />
		</p>
	</div>
	<div id="opName" class="namespace" onclick=statShow(this.id);>
		<p>
			<c:out value="${oponent.name}" />
		</p>
	</div>
	<div id="myNameStat" class="playerStat" onclick=statHide(this.id);>
		<table>
			<tr>
				<td>${langPack['XO_stat_wins']}</td>
				<td><c:out value="${myStat.wins}" /></td>
			</tr>
			<tr>
				<td>${langPack['XO_stat_losses']}</td>
				<td><c:out value="${myStat.losses}" /></td>
			</tr>
			<tr>
				<td>${langPack['XO_stat_total']}</td>
				<td><c:out value="${myStat.total}" /></td>
			</tr>
		</table>
	</div>
	<div id="opNameStat" class="playerStat" onclick=statHide(this.id);>
		<table>
			<tr>
				<td>${langPack['XO_stat_wins']}</td>
				<td><c:out value="${opStat.wins}" /></td>
			</tr>
			<tr>
				<td>${langPack['XO_stat_losses']}</td>
				<td><c:out value="${opStat.losses}" /></td>
			</tr>
			<tr>
				<td>${langPack['XO_stat_total']}</td>
				<td><c:out value="${opStat.total}" /></td>
			</tr>
		</table>
	</div>
	<div id="tick"></div>
	<div id="timer"></div>
	<div id="outText" class="title">
		<p align="center"></p>
	</div>
	<div id="win">
		<img src="images/XO/win.png">
	</div>
	<div id="border"></div>
	<div id="field">
		<table id="table" align="center" cellpadding="0" cellspacing="0">
			<c:forEach var="lines" items="${xoGame.fields}" varStatus="i">
				<tr>
					<c:forEach var="box" items="${lines}" varStatus="j">
						<td><c:if test="${box.status == 0}">
								<img id="X${j.count-1}Y${i.count-1}" src="images/XO/0.png"
									onclick=put(this);>
							</c:if> <c:if test="${box.status == -1}">
								<img id="X${j.count-1}Y${i.count-1}" src="images/XO/X0.png"
									onclick=put(this);>
							</c:if> <c:if test="${box.status == -2}">
								<img id="X${j.count-1}Y${i.count-1}" src="images/XO/O0.png"
									onclick=put(this);>
							</c:if></td>
					</c:forEach>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>