<%@page import="org.springframework.context.annotation.Import"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="epam.ph.sg.models.User" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>School Games</title>
</head>
<body>
	<div>
		<h2>Welcome <c:out value="${user.name}"/>, you are logged in :)</h2>
		<h2>Тут в нас буде парта з іграми</h2>
		<a href="XO.html">Хрестики нолики</a>
		<a href="BS.html">Морський бій</a>
		<a href="Reversy.html">Реверсі</a>
		<a href="Points.html">Крапки</a>
	</div>
</body>
</html>