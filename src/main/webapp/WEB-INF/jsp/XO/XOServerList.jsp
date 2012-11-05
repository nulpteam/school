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
<script src="js/XO/XOMenu.js" type="text/javascript"></script>
<script src="js/XO/XOLang_<c:out value="${lang}"/>.js"
	type="text/javascript"></script>
<script type="text/javascript">
	var myID = "${user.id}";
	
	$(document).ready(function() {
		chatStart();
	});
</script>
<title><c:out value="${langPack['XO_title']}" /></title>
</head>
<body>
	<div class="page">
		<c:import url="../Tab/Tab.jsp"></c:import>

		<div class="paperList">
			<div class="title">
				<p align="center">
					<c:out value="${langPack['XO_SL_title']}" />
				</p>
			</div>
			<div id="home" onclick=returnToMenu();>
				<img src="images/XO/home.png">
			</div>
			<div id="menu" align="center">
				<c:forEach var="server" items="${serverMap}" varStatus="i">
					<div class="button" id="${server.key}" onclick=connect(this.id);>
						<p class="buttonText">
							<c:out value="${server.value.game.server.name}" />
						</p>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>