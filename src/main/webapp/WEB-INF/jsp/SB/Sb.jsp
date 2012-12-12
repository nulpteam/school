<%@ page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<div class="plbs paperList">
	<c:forEach items="${sbJSLoader.scripts}" var="script">
		<script src="<c:out value="${script}"/>" type="text/javascript"></script>
	</c:forEach>
	<div id="gameID" class="${Game.id}"></div>
	<div id="userName" class="${user.name}"></div>
	<div id="ConnectionType" class="${ConnectionType}"></div>
	<div id="lock" class="${Game.nextMove}"></div>
	<c:choose>
      <c:when test="${ConnectionType=='server'}">
      <div id="oponent" class="${Game.client.conn}"></div>
      </c:when>
      <c:otherwise>
      <div id="oponent" class="${Game.server.conn}"></div>
      </c:otherwise>
	</c:choose>
		<div class="caption"><c:out value="${langPack['Sb_title']}" /></div>
		<div class="deco_sheep">
			<img alt="sheep" src="images/SB/sheep_deco.png">
		</div>
				<div class=SbMButtonRightHome onclick="closeAndgoTo('Menu.html');"></div>
				<div class="sound">
					<img id="s_on" src="images/SB/s_on.png" onclick="chSound();"/>
				</div>
				<div class="SbMButtonRightStop" onclick="goTo2('SbStop.html','${ConnectionType}');"></div>
				<div class="BSGo" onClick="start('${ConnectionType}');" style="visibility: hidden;"></div>
		<div class=clear></div>
		<div  class="ammo">
			<!-- Кораблі для розставляння на полі-->
			<div class="sheep_cont">
				<img id="sheep_4" class="H" src="images/SB/04.png" alt="4" ondblclick="rotate(this);" />
					<div class="clear"></div>
				<img id="sheep_3"  class="H" src="images/SB/03.png" alt="3" ondblclick="rotate(this);" style="display:none;"/>
					<div class="clear"></div>
				<img id="sheep_2"  class="H" src="images/SB/02.png" alt="2" ondblclick="rotate(this);" style="display:none;"/>
					<div class="clear"></div>
				<img id="sheep_1" src="images/SB/01.png" alt="1" style="display:none;"/>
					<div class="clear"></div>
			</div>
			<div>
			</div>
			<div id="sp11" class="dn"></div>
			<div id="sp12" class="dn"></div>
			<div id="sp13" class="dn"></div>
			<div id="sp14" class="dn"></div>
			<div id="sp21" class="dn"></div>
			<div id="sp22" class="dn"></div>
			<div id="sp23" class="dn"></div>
			<div id="sp31" class="dn"></div>
			<div id="sp32" class="dn"></div>
			<div id="sp41" class="dn"></div>
		</div>
			<div class="f1">
				<table id="table1" align="center" cellpadding="0" cellspacing="0">
					<c:forEach begin="0" end="9" step="1" varStatus="chirik">
						<tr>
							<c:forEach begin="0" end="9" step="1" varStatus="bobik">
								<td id="X<c:out value="${bobik.index}"/>_Y<c:out value="${chirik.index}"/>"></td>
							</c:forEach>
						</tr>
					</c:forEach>
				</table>
				</div>
			<div class="clear"></div>
	<div class="f2"></div>
</div>