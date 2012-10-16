<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/styles.css" type="text/css" rel="stylesheet">
<link href="css/XO.css" type="text/css" rel="stylesheet">
<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/XO.js" type="text/javascript"></script>
<script type="text/javascript">
var serverName = "${xo.game.server.name}";
$(document).ready(function(){
	$('#opName').text(serverName);
	$('#outText').text('Чекайте на хід суперника');
	checker();
});
</script>
<title>Insert title here</title>
</head>
<body>
	<c:import url="Game.jsp"></c:import>
</body>
</html>