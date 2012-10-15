<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/XO.css" type="text/css" rel="stylesheet">
<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/XO.js" type="text/javascript"></script>
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<c:forEach var="server" items="${serverMap}" varStatus="i">
			<button id="${server.key}" onclick=connect(this.id);>Сервер Name: <c:out value="${server.value.game.server.name}"/></button>
		</c:forEach>
	</div>
</body>
</html>