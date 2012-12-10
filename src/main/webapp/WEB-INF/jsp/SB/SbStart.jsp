<%@ page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<div class="plbs paperList">
	<div id="gameID" class="${Game.id}"></div>
	<div id="userName" class="${user.name}"></div>
	<div id="ConnectionType" class="${ConnectionType}"></div>
	<div id="lock" class="${Game.nextMove}"></div>
	<div id="bothStarted" class="${Game.bothStarted}"></div>
	<div id="mess" class="${mess}"></div>
<!-- 		<script type="text/javascript" src="js/SB/swfobject.js"></script> -->
<!--  	<script type="text/javascript" src="js/SB/web_socket.js"></script> -->
	<c:forEach items="${sbJSLoader.scripts}" var="script">
		<script src="<c:out value="${script}"/>" type="text/javascript"></script>
	</c:forEach>
	<script src="js/SB/SbLang_${lang}.js" type="text/javascript"></script>
		<div class="caption"><c:out value="${langPack['Sb_title']}" /></div>
		<div class="deco_sheep">
			<img alt="sheep" src="images/SB/sheep_deco.png">
		</div>
				<div class="SbMButtonRightHome" onclick="closeAndgoTo('Menu.html');"></div>
				<div class="sound">
					<img id="s_on" src="images/SB/s_on.png" onclick="chSound();"/>
				</div>
				<div class="SbMButtonRightStop" onclick="goTo2('SbStop.html','${ConnectionType}');"></div>
		
		<div class=clear></div>
		<div class=f1>
				<div style="position: relative;top: 4px;left: 32px;height: 200px;width: 200px;">
					<img src="${Sheeps.sheep01.img}" style="position: relative;top: ${Sheeps.sheep01.y}px;left: ${Sheeps.sheep01.x-205}px;"/>
				</div>
				<div style="position: relative;top: -196px;left: 32px;height: 200px;width: 200px;">
					<img src="${Sheeps.sheep02.img}" style="position: relative;top: ${Sheeps.sheep02.y}px;left: ${Sheeps.sheep02.x-205}px;"/>
				</div>
				<div style="position: relative;top: -396px;left: 32px;height: 200px;width: 200px;">
					<img src="${Sheeps.sheep03.img}" style="position: relative;top: ${Sheeps.sheep03.y}px;left: ${Sheeps.sheep03.x-205}px;"/>
				</div>
				<div style="position: relative;top: -596px;left: 32px;height: 200px;width: 200px;">
					<img src="${Sheeps.sheep04.img}" style="position: relative;top: ${Sheeps.sheep04.y}px;left: ${Sheeps.sheep04.x-205}px;"/>
				</div>
				<div style="position: relative;top: -796px;left: 32px;height: 200px;width: 200px;">
					<img src="${Sheeps.sheep05.img}" style="position: relative;top: ${Sheeps.sheep05.y}px;left: ${Sheeps.sheep05.x-205}px;"/>
				</div>
				<div style="position: relative;top: -996px;left: 32px;height: 200px;width: 200px;">
					<img src="${Sheeps.sheep06.img}" style="position: relative;top: ${Sheeps.sheep06.y}px;left: ${Sheeps.sheep06.x-205}px;"/>
				</div>
				<div style="position: relative;top: -1196px;left: 32px;height: 200px;width: 200px;">
					<img src="${Sheeps.sheep07.img}" style="position: relative;top: ${Sheeps.sheep07.y}px;left: ${Sheeps.sheep07.x-205}px;"/>
				</div>
				<div style="position: relative;top: -1396px;left: 32px;height: 200px;width: 200px;">
					<img src="${Sheeps.sheep08.img}" style="position: relative;top: ${Sheeps.sheep08.y}px;left: ${Sheeps.sheep08.x-205}px;"/>
				</div>
				<div style="position: relative;top: -1596px;left: 32px;height: 200px;width: 200px;">
					<img src="${Sheeps.sheep09.img}" style="position: relative;top: ${Sheeps.sheep09.y}px;left: ${Sheeps.sheep09.x-205}px;"/>
				</div>
				<div style="position: relative;top: -1796px;left: 32px;height: 200px;width: 200px;">
					<img src="${Sheeps.sheep10.img}" style="position: relative;top: ${Sheeps.sheep10.y}px;left: ${Sheeps.sheep10.x-205}px;"/>
				</div>
				<div id="shoots" style="position: relative;top: -2000px;left: -4px;height: 200px;width: 200px;">
					<table id="table1g" align="center" cellpadding="0" cellspacing="0">
						<tbody>
							<c:forEach begin="0" end="9" step="1" varStatus="chirik">
								<tr>
									<c:forEach begin="0" end="9" step="1" varStatus="bobik">
										<td id="<c:out value="${bobik.index}"/><c:out value="${chirik.index}"/>"></td>
									</c:forEach>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			<div class="clear"></div>
		</div>
		<div class="f2g">
				<table id="table2" align="center" cellpadding="0" cellspacing="0">
					<c:forEach begin="0" end="9" step="1" varStatus="chirik">
						<tr>
							<c:forEach begin="0" end="9" step="1" varStatus="bobik">
								<td id="X<c:out value="${bobik.index}"/>_Y<c:out value="${chirik.index}"/>" class="firePoint" onclick="fire(this)"></td>
							</c:forEach>
						</tr>
					</c:forEach>
				</table>
		</div>
		<div id="locker" style="top: -232px;right: -229px;height: 210px; width: 210px; position: relative; visibility: visible;">
			<img alt="BSRadar" src="images/SB/BSRadar.gif" height="200px" width="200px">
		</div>
</div>