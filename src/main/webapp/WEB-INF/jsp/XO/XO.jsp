<%@page import="org.springframework.context.annotation.Import"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="epam.ph.sg.models.User" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/XO.js" type="text/javascript"></script>
<script type="text/javascript">
function conectLink(){
	location.href = "XOServerList.html";
}
</script>
<title>School Games</title>
</head>
<body>
	<div>
		<h2>Хрестики нолики</h2>
		<button onclick=createServer();>Створити гру</button>
		<button onclick=conectLink();>Підключитись</button>
	</div>
</body>
</html>