<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="SHORTCUT ICON" href="images/favicon.ico" type="image/x-icon">

<c:forEach items="${sbJSLoader.scripts}" var="script">
	<script src="<c:out value="${script}"/>" type="text/javascript"></script>
</c:forEach>
<title>Морський бій</title>
</head>
<body>
	<div style = "margin: 0px auto; height: 600px; width: 1000px;">
		<img alt="Sheep" src="images/SB/BS.gif" align="left">
		<img alt="Create Game" src="images/SB/BSCreate.jpg"  onclick="createSbGame();" align="left">
		<img alt="Connect Game" src="images/SB/BSConnect.jpg" onclick="connectSbGame();" align="top">
	</div>


	<input type="button" value="Створити гру" onclick="createSbGame();">
	<br>
	<input type="button" value="Підєднатись до гри"
		onclick="connectSbGame();">
	<br>
	<input type="button" value="Гра (debugOnly)"
		onclick="sbGame();">
</body>
</html>