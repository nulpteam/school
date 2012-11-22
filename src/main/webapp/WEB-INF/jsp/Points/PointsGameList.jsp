<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--  <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="SHORTCUT ICON" href="images/favicon.ico" type="image/x-icon"> 


<title>Insert title here</title>
</head>
<body>-->
<div class="paperList">
<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/Points/PointsMenu.js" type="text/javascript"></script>
	<div align="center">
		<c:forEach var="game" items="${pointGamesMap}" varStatus="i">
			<button id="${game.key}" onclick=connect(this.id);>
					Server Name:<c:out value="${game.value.server.name}" />
			</button>
		</c:forEach>
	</div>
</div>