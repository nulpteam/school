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
<script src="js/XO/XOGame.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#outText').text('Чекайте');
		checker();
		chatStart();
	});
</script>
<title>Insert title here</title>
</head>
<body>
	<c:import url="../Chat.jsp"></c:import>
	
	<div class="paperList">
		<div id="myName" class="namespace">
			<p class="name">
				<c:out value="${user.name}" />
			</p>
		</div>
		<div id="opName" class="namespace">
			<p class="name" id="opNameText">
				<c:out value="${oponent.name}" />
			</p>
		</div>
		<div>
			<p id="outText" align="center" class="title">Хрестики нолики</p>
		</div>
		<div id="tick">
			<img src="images/XO/tick.png">
		</div>
		<div id="home" onclick=returnToMenu();>
			<img src="images/XO/home.png">
		</div>
		<div id="win">
			<img src="images/XO/win.png">
		</div>
		<div id="border">
			<img src="images/XO/border.png">
		</div>
		<div id="field">
			<table id="table" align="center" cellpadding="0" cellspacing="0">
				<c:forEach var="lines" items="${xo.fields}" varStatus="i">
					<tr>
						<c:forEach var="box" items="${lines}" varStatus="j">
							<td><c:if test="${box.status == 0}">
									<img id="X${j.count-1}Y${i.count-1}" src="images/XO/0.png"
										onclick=put(this);>
								</c:if> <c:if test="${box.status == -8}">
									<img id="X${j.count-1}Y${i.count-1}" src="images/XO/X0.png"
										onclick=put(this);>
								</c:if> <c:if test="${box.status == -9}">
									<img id="X${j.count-1}Y${i.count-1}" src="images/XO/O0.png"
										onclick=put(this);>
								</c:if></td>
						</c:forEach>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>