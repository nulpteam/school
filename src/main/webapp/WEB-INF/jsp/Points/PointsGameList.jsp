<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/Points/PointsMenu.js" type="text/javascript"></script>
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<c:forEach var="game" items="${pointGames}" varStatus="i">
			<button id="${game.id}" onclick=connect(this.id);>
					Server Name:<c:out value="${game.id}" />
			</button>
		</c:forEach>
	</div>
</body>
</html>