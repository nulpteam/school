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
<title>Insert title here</title>
</head>
<body>
	<div id="back">
	<div><h2 id="text"></h2></div>
		<div id="XO">
			<table id="table" align="center" cellpadding="0" cellspacing="0">
				<c:forEach var="lines" items="${xo.fields}" varStatus="i">
					<tr>
						<c:forEach var="box" items="${lines}" varStatus="j">
							<td><c:if test="${box.status == 0}">
									<img id="X${j.count-1}Y${i.count-1}" src="images/XO/0.png"
										onclick=put(this);>
								</c:if> <c:if test="${box.status == -8}">
									<img id="X${j.count-1}Y${i.count-1}" src="images/XO/X.png"
										onclick=put(this);>
								</c:if> <c:if test="${box.status == -9}">
									<img id="X${j.count-1}Y${i.count-1}" src="images/XO/O.png"
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