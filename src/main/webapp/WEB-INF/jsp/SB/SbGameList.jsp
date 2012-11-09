<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:forEach items="${sbJSLoader.scripts}" var="script">
	<script src="<c:out value="${script}"/>" type="text/javascript"></script>
</c:forEach>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><c:out value="${langPack['Sb_ConnectToGame']}"/></title>
</head>
<body>
	<div id="gameID" class="${Game.id}"></div>
	<div id="userName" class="${user.name}"></div>
	ТУТ Є СПИСОК ДОСТУПНИХ ІГР "МОРСЬКОГО БОЮ"!!
	<c:out value="${langPack['Sb_ExistsGames']}"/>
	<div>
	<c:forEach items="${serverMap}" var="server">
			<div>
				<input type="button" value="<c:out value="${server.value.server.player.name}"/>" onclick="connect(<c:out value="${server.key}"/>);">
			</div>
	</c:forEach>
	</div>					
</body>
</html>