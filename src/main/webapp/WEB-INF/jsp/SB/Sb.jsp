<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/jquery.js" type="text/javascript"></script>

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
		<div class="ammo"></div>
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
			</div>
		</div>
	</div>




	<%-- <% --%>
	<!-- Enumeration<String> en = request.getAttributeNames(); -->
	<!-- while (en.hasMoreElements()) -->
	<!-- { -->
	<!-- 	out.println(en.nextElement()); -->
	<!-- } -->

	<!-- %> -->
</body>
</html>