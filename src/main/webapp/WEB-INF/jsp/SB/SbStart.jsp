<%@ page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <script src="js/jquery.js" type="text/javascript"></script> -->
<!-- <script src="js/SB/SbGameList.js" type="text/javascript"></script> -->
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
	<div id="ConnectionType" class="${connectionType}"></div>
	<div class="content">
		<div class="caption"><c:out value="${langPack['Sb_title']}" /></div>
		<div class="deco_sheep">
			<img alt="sheep" src="images/SB/sheep_deco.png">
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
					<img class="img01" src= {shee}/>
					<img class="img02"/>
					<img class="img03"/>
					<img class="img04"/>
					<img class="img05"/>
					<img class="img06"/>
					<img class="img07"/>
					<img class="img08"/>
					<img class="img09"/>
					<img class="img10"/>
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
<%-- 	<% --%>
<!-- // // 	 Enumeration<String> en = request.getAttributeNames(); -->
<!-- // // 	while (en.hasMoreElements()) -->
<!-- // // 	 {  -->
<!-- // // 		out.println(en.nextElement()); -->
<!-- // // 	} -->

<%-- 	 %>  --%>
</div>
</body>
</html>