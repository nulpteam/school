<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><c:out value="${langPack['XO_title']}" /></title>

<link rel="SHORTCUT ICON" href="images/favicon.ico" type="image/x-icon">
<link href="css/XO/paperList.css" type="text/css" rel="stylesheet">
<link href="css/XO/style.css" type="text/css" rel="stylesheet">
<link href="css/XO/game.css" type="text/css" rel="stylesheet">

<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/XO/Menu.js" type="text/javascript"></script>
<script src="js/XO/Lang_${lang}.js" type="text/javascript"></script>
<script type="text/javascript">
	var curentPos = '${xoCurrentPos}';
	$(document).ready(function(){
		goTo(curentPos);
	});
</script>
</head>
<body>
	<div class="page">
		<c:import url="../Tab/Tab.jsp"></c:import>
	</div>
</body>
</html>