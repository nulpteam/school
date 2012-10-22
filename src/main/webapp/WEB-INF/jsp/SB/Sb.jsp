<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<c:forEach items="${sbGame.scripts}" var="script">
	<script src="<c:out value="${script}"/>" type="text/javascript"></script>
</c:forEach>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="css/SB.css" type="text/css" rel="stylesheet">

<title><c:out value="${sbGame.title}" /></title>
</head>
<body>
	<div class="content">
		<div class="caption">Морський бій</div>
		<div class="deco_sheep">
			<img alt="sheep" src="images/SB/sheep_deco.png">
		</div>
		<div class=clear></div>
		<div  class="ammo">
			<!-- Кораблі для розставляння на полі-->
			<div class="sheep_cont">
				<img id="sheep_4" class="V" src="images/SB/4.png" alt="4" ondblclick="rotate(this);"/>
					<div class="clear"></div>
				<img id="sheep_3"  class="H" src="images/SB/3.png" alt="3" ondblclick="rotate(this);"/>
					<div class="clear"></div>
				<img id="sheep_2"  class="H" src="images/SB/2.png" alt="2" ondblclick="rotate(this);"/>
					<div class="clear"></div>
				<img id="sheep_1" src="images/SB/1.png" alt="1"/>
					<div class="clear"></div>
			</div>
		</div>
		
		<div class="field1">
			<div class="h_markers">
				<div class="a">a</div>
				<div class="b">b</div>
				<div class="c">	c</div>
				<div class="d">d</div>
				<div class="e">	e</div>
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
								<td id="X<c:out value="${bobik.index}"/>_Y<c:out value="${chirik.index}"/>"></td>
							</c:forEach>
						</tr>
					</c:forEach>
				</table>
				
				
			</div>
		</div>
	</div>
<div class=debug>
<input type="button" value="GetM" onClick="getM();"/>
<input type="button" value="SendM" onClick="sendM();"/>
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