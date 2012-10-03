<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h2>User with name <%= request.getAttribute("name")%> and password <%= request.getAttribute("pass")%></h2>
		<br>
		<h2>is not registered. Please register !!!</h2>
	</div>
</body>
</html>