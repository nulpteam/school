<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Підєднатися до гри</title>
</head>
<body>
	ТУТ Є СПИСОК ДОСТУПНИХ ІГР "МОРСЬКОГО БОЮ"!!
	<div>
	<c:forEach items="${serverMap}" var="server">
			<div>
				<input type="button" value="<c:out value="${server.value.player1.name}"/>" onclick="connect(<c:out value="${server.key}"/>);">
			</div>
	</c:forEach>
	<b>Тут треба переробити!!!!! <br>При створенні гри, вона назавжди залишається в мапі створених ігор. (тому шо мапа статична).<br>
	Треба зробити так, щоб при закритті ігри або браузера в сесії мапа серерів обнулялась або видалалась або щоб вона не була статичною :-)<br> 
	Одним словом - в мапі запущених серверів мають бути тільки актуальні(запущені) сервера. </b>
	</div>					
</body>
</html>