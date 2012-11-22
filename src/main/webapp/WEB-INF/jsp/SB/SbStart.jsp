<%@ page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- <html> -->
<!-- <head> -->
<%-- <c:forEach items="${sbJSLoader.scripts}" var="script"> --%>
<%-- 	<script src="<c:out value="${script}"/>" type="text/javascript"></script> --%>
<%-- </c:forEach> --%>


<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<!-- <link rel="SHORTCUT ICON" href="images/favicon.ico" type="image/x-icon">  -->
<!-- <link href="css/SB.css" type="text/css" rel="stylesheet"> -->

<%-- <title><c:out value="${langPack['Sb_title']}" /></title> --%>
<!-- </head> -->
<!-- <body> -->
	
	<div class="plbs paperList">
	<div id="gameID" class="${Game.id}"></div>
	<div id="userName" class="${user.name}"></div>
	<div id="ConnectionType" class="${ConnectionType}"></div>
	<div id="lock" class="${Game.nextMove}"></div>
	<div id="bothStarted" class="${Game.bothStarted}"></div>
	<c:forEach items="${sbJSLoader.scripts}" var="script">
		<script src="<c:out value="${script}"/>" type="text/javascript"></script>
	</c:forEach>
	<script src="js/SB/SbLang_${lang}.js" type="text/javascript"></script>
		<div class="caption"><c:out value="${langPack['Sb_title']}" /></div>
		<div class="deco_sheep">
			<img alt="sheep" src="images/SB/sheep_deco.png">
		</div>
<!-- 		<div class="SbMButtonsRight"> -->
				<div class="SbMButtonRightHome" onclick="goTo('Menu.html');"></div>
				<div class="sound">
					<img id="s_on" src="images/SB/s_on.png" onclick="chSound();"/>
				</div>
				<div class="SbMButtonRightStop" onclick="goTo2('SbStop.html','${ConnectionType}');"></div>
<!-- 		</div> -->
		
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
				<div style="position: relative;top: 0px;left: 0px;height: 200px;width: 200px;">
					<img src="${Sheeps.sheep01.img}" style="position: relative;top: ${Sheeps.sheep01.y}px;left: ${Sheeps.sheep01.x-205}px;"/>
				</div>
				<div style="position: relative;top: -200px;left: 0px;height: 200px;width: 200px;">
					<img src="${Sheeps.sheep02.img}" style="position: relative;top: ${Sheeps.sheep02.y}px;left: ${Sheeps.sheep02.x-205}px;"/>
				</div>
				<div style="position: relative;top: -400px;left: 0px;height: 200px;width: 200px;">
					<img src="${Sheeps.sheep03.img}" style="position: relative;top: ${Sheeps.sheep03.y}px;left: ${Sheeps.sheep03.x-205}px;"/>
				</div>
				<div style="position: relative;top: -600px;left: 0px;height: 200px;width: 200px;">
					<img src="${Sheeps.sheep04.img}" style="position: relative;top: ${Sheeps.sheep04.y}px;left: ${Sheeps.sheep04.x-205}px;"/>
				</div>
				<div style="position: relative;top: -800px;left: 0px;height: 200px;width: 200px;">
					<img src="${Sheeps.sheep05.img}" style="position: relative;top: ${Sheeps.sheep05.y}px;left: ${Sheeps.sheep05.x-205}px;"/>
				</div>
				<div style="position: relative;top: -1000px;left: 0px;height: 200px;width: 200px;">
					<img src="${Sheeps.sheep06.img}" style="position: relative;top: ${Sheeps.sheep06.y}px;left: ${Sheeps.sheep06.x-205}px;"/>
				</div>
				<div style="position: relative;top: -1200px;left: 0px;height: 200px;width: 200px;">
					<img src="${Sheeps.sheep07.img}" style="position: relative;top: ${Sheeps.sheep07.y}px;left: ${Sheeps.sheep07.x-205}px;"/>
				</div>
				<div style="position: relative;top: -1400px;left: 0px;height: 200px;width: 200px;">
					<img src="${Sheeps.sheep08.img}" style="position: relative;top: ${Sheeps.sheep08.y}px;left: ${Sheeps.sheep08.x-205}px;"/>
				</div>
				<div style="position: relative;top: -1600px;left: 0px;height: 200px;width: 200px;">
					<img src="${Sheeps.sheep09.img}" style="position: relative;top: ${Sheeps.sheep09.y}px;left: ${Sheeps.sheep09.x-205}px;"/>
				</div>
				<div style="position: relative;top: -1800px;left: 0px;height: 200px;width: 200px;">
					<img src="${Sheeps.sheep10.img}" style="position: relative;top: ${Sheeps.sheep10.y}px;left: ${Sheeps.sheep10.x-205}px;"/>
				</div>
				<div id="shoots" style="position: relative;top: -2000px;left: -4px;height: 200px;width: 200px;">
					<table id="table1" align="center" cellpadding="0" cellspacing="0">
						<tbody>
							<tr>
									<td id="00"></td>
									<td id="10"></td>
									<td id="20"></td>
									<td id="30"></td>
									<td id="40"></td>
									<td id="50"></td>
									<td id="60"></td>
									<td id="70"></td>
									<td id="80"></td>
									<td id="90"></td>
							</tr>
							<tr>
									<td id="01"></td>
									<td id="11"></td>
									<td id="21"></td>
									<td id="31"></td>
									<td id="41"></td>
									<td id="51"></td>
									<td id="61"></td>
									<td id="71"></td>
									<td id="81"></td>
									<td id="91"></td>
							</tr>
							<tr>
									<td id="02"></td>
									<td id="12"></td>
									<td id="22"></td>
									<td id="32"></td>
									<td id="42"></td>
									<td id="52"></td>
									<td id="62"></td>
									<td id="72"></td>
									<td id="82"></td>
									<td id="92"></td>
							</tr>
							<tr>
									<td id="03"></td>
									<td id="13"></td>
									<td id="23"></td>
									<td id="33"></td>
									<td id="43"></td>
									<td id="53"></td>
									<td id="63"></td>
									<td id="73"></td>
									<td id="83"></td>
									<td id="93"></td>
							</tr>
							<tr>
									<td id="04"></td>
									<td id="14"></td>
									<td id="24"></td>
									<td id="34"></td>
									<td id="44"></td>
									<td id="54"></td>
									<td id="64"></td>
									<td id="74"></td>
									<td id="84"></td>
									<td id="94"></td>
							</tr>
							<tr>
									<td id="05"></td>
									<td id="15"></td>
									<td id="25"></td>
									<td id="35"></td>
									<td id="45"></td>
									<td id="55"></td>
									<td id="65"></td>
									<td id="75"></td>
									<td id="85"></td>
									<td id="95"></td>
							</tr>
							<tr>
									<td id="06"></td>
									<td id="16"></td>
									<td id="26"></td>
									<td id="36"></td>
									<td id="46"></td>
									<td id="56"></td>
									<td id="66"></td>
									<td id="76"></td>
									<td id="86"></td>
									<td id="96"></td>
							</tr>
							<tr>
									<td id="07"></td>
									<td id="17"></td>
									<td id="27"></td>
									<td id="37"></td>
									<td id="47"></td>
									<td id="57"></td>
									<td id="67"></td>
									<td id="77"></td>
									<td id="87"></td>
									<td id="97"></td>
							</tr>
							<tr>
									<td id="08"></td>
									<td id="18"></td>
									<td id="28"></td>
									<td id="38"></td>
									<td id="48"></td>
									<td id="58"></td>
									<td id="68"></td>
									<td id="78"></td>
									<td id="88"></td>
									<td id="98"></td>
							</tr>
							<tr>
									<td id="09"></td>
									<td id="19"></td>
									<td id="29"></td>
									<td id="39"></td>
									<td id="49"></td>
									<td id="59"></td>
									<td id="69"></td>
									<td id="79"></td>
									<td id="89"></td>
									<td id="99"></td>
							</tr>
						</tbody>
					</table>
				</div>
			<div class="clear"></div>
		</div>
		
		<div class="field2">
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
<!-- 				<div class="oponentName"> -->
<!-- 					Опонент: Імя, к-ть вцілілих кораблів, ... -->
<!-- 				</div> -->
				
				
			</div>
			
			<div id="locker" style="height: 210px; width: 210px; position: absolute; visibility: visible;">
				<img alt="BSRadar" src="images/SB/BSRadar.gif" height="200px" width="200px">
			</div>
		</div>
	</div>
<div class=debug>
<!-- <input type="button" value="GetM" onClick="getM();"/> -->
<!-- <input type="button" value="SendM" onClick="sendM();"/> -->
<%-- <input type="button" value="TestWebSocket" onClick="wtest('${Game.id}&My String');"/> --%>
<!-- <input type="button" value="Test1" onClick="testWS();"/> -->
<%-- <input type="button" value="${ConnectionType}"/> --%>


</div>
<!-- </body> -->
<!-- </html> -->
