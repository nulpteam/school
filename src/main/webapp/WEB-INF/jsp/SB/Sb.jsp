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
		<div class="field1"></div>
		<div class="field2"></div>
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