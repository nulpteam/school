<%@ page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:forEach items="${sbJSLoader.scripts}" var="script">
	<script src="<c:out value="${script}"/>" type="text/javascript"></script>
</c:forEach>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="SHORTCUT ICON" href="images/favicon.ico" type="image/x-icon"> 
<link href="css/SB.css" type="text/css" rel="stylesheet">

<title><c:out value="${langPack['Sb_title']}" /></title>
</head>
<body>
<div id="gameID" class="${Game.id}"></div>
	<div id="userName" class="${user.name}"></div>
	<div id="ConnectionType" class="${ConnectionType}"></div>
	<div class="content">
		<div class="caption"><c:out value="${langPack['Sb_title']}" /></div>
		<div class="deco_sheep">
			<img alt="sheep" src="images/SB/sheep_deco.png">
		</div>
		<div class="sound">
				<img id="s_on" src="images/SB/s_on.png" onclick="chSound();"/>
			</div>
		<div class=clear></div>
		
		<div class="field">
			<div class="h_markers">
				<div class="a">a</div>
				<div class="b">b</div>
				<div class="c">c</div>
				<div class="d">d</div>
				<div class="e">e</div>
				<div class="f">f</div>
				<div class="g">g</div>
				<div class="h">h</div>
				<div class="i">i</div>
				<div class="j">j</div>
			</div>
			<div class="v_markers">
				<div class="1">1</div>
				<div class="2">2</div>
				<div class="3">3</div>
				<div class="4">4</div>
				<div class="5">5</div>
				<div class="6">6</div>
				<div class="7">7</div>
				<div class="8">8</div>
				<div class="9">9</div>
				<div class="last10">10</div>
			</div>
				<div style="position: relative;top: -200px;left: 0px;height: 200px;width: 200px;">
					<img class="img01" src='${Sheeps.sheep01.img}' style="position: relative;top: ${Sheeps.sheep01.y}px;left: ${Sheeps.sheep01.x-205}px;"/>
				</div>
				<div style="position: relative;top: -400px;left: 0px;height: 200px;width: 200px;">
					<img class="img02" src='${Sheeps.sheep02.img}' style="position: relative;top: ${Sheeps.sheep02.y}px;left: ${Sheeps.sheep02.x-205}px;"/>
				</div>
				<div style="position: relative;top: -600px;left: 0px;height: 200px;width: 200px;">
					<img class="img03" src='${Sheeps.sheep03.img}' style="position: relative;top: ${Sheeps.sheep03.y}px;left: ${Sheeps.sheep03.x-205}px;"/>
				</div>
				<div style="position: relative;top: -800px;left: 0px;height: 200px;width: 200px;">
					<img class="img02" src='${Sheeps.sheep04.img}' style="position: relative;top: ${Sheeps.sheep04.y}px;left: ${Sheeps.sheep04.x-205}px;"/>
				</div>
				<div style="position: relative;top: -1000px;left: 0px;height: 200px;width: 200px;">
					<img class="img03" src='${Sheeps.sheep05.img}' style="position: relative;top: ${Sheeps.sheep05.y}px;left: ${Sheeps.sheep05.x-205}px;"/>
				</div>
				<div style="position: relative;top: -1200px;left: 0px;height: 200px;width: 200px;">
					<img class="img04" src='${Sheeps.sheep06.img}' style="position: relative;top: ${Sheeps.sheep06.y}px;left: ${Sheeps.sheep06.x-205}px;"/>
				</div>
				<div style="position: relative;top: -1400px;left: 0px;height: 200px;width: 200px;">
					<img class="img05" src='${Sheeps.sheep07.img}' style="position: relative;top: ${Sheeps.sheep07.y}px;left: ${Sheeps.sheep07.x-205}px;"/>
				</div>
				<div style="position: relative;top: -1600px;left: 0px;height: 200px;width: 200px;">
					<img class="img06" src='${Sheeps.sheep08.img}' style="position: relative;top: ${Sheeps.sheep08.y}px;left: ${Sheeps.sheep08.x-205}px;"/>
				</div>
				<div style="position: relative;top: -1800px;left: 0px;height: 200px;width: 200px;">
					<img class="img07" src='${Sheeps.sheep09.img}' style="position: relative;top: ${Sheeps.sheep09.y}px;left: ${Sheeps.sheep09.x-205}px;"/>
				</div>
				<div style="position: relative;top: -2000px;left: 0px;height: 200px;width: 200px;">
					<img class="img08" src='${Sheeps.sheep10.img}' style="position: relative;top: ${Sheeps.sheep10.y}px;left: ${Sheeps.sheep10.x-205}px;"/>
				</div>
			<div class="clear"></div>
		</div>
		
		<div class="field2start">
			<div class="h_markers">
				<div class="a">a</div>
				<div class="b">b</div>
				<div class="c">c</div>
				<div class="d">d</div>
				<div class="e">e</div>
				<div class="f">f</div>
				<div class="g">g</div>
				<div class="h">h</div>
				<div class="i">i</div>
				<div class="j">j</div>
			</div>
			<div class="v_markers">
				<div class="1">1</div>
				<div class="2">2</div>
				<div class="3">3</div>
				<div class="4">4</div>
				<div class="5">5</div>
				<div class="6">6</div>
				<div class="7">7</div>
				<div class="8">8</div>
				<div class="9">9</div>
				<div class="last10">10</div>
				
				
				<table id="table2" align="center" cellpadding="0" cellspacing="0">
					<c:forEach begin="0" end="9" step="1" varStatus="chirik">
						<tr>
							<c:forEach begin="0" end="9" step="1" varStatus="bobik">
								<td id="X<c:out value="${bobik.index}"/>_Y<c:out value="${chirik.index}"/>" class="firePoint" onclick="fire(this)"></td>
							</c:forEach>
						</tr>
					</c:forEach>
				</table>
				<div class="oponentName">
					Опонент: Імя, к-ть вцілілих кораблів, ...
				</div>
				
				
			</div>
		</div>
	</div>
<div class=debug>
<input type="button" value="GetM" onClick="getM();"/>
<input type="button" value="SendM" onClick="sendM();"/>
<input type="button" value="TestWebSocket" onClick="wtest('${Game.id}&My String');"/>
<input type="button" value="Test1" onClick="testWS();"/>

<div id="IH"></div>

</div>
</body>
</html>