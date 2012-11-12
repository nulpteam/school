<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="SHORTCUT ICON" href="images/favicon.ico" type="image/x-icon">

<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/Infection/InfectionMenu.js" type="text/javascript"></script>
<script language="JavaScript" type="text/javascript"
	src="js/jquery.validate.js"></script>
<script language="JavaScript" type="text/javascript"
	src="js/messages_<c:out value="${lang}"/>.js"></script>

<title>School Games</title>
<link href="css/InfectionGame.css" type="text/css" rel="stylesheet">
<link href="css/styles.css" type="text/css" rel="stylesheet">
</head>
<body>
    <div id="body">
	<div id="bg">

		<div id="infection_title">
			<c:out value="${langPack['Infection']}" />
		</div>
		<div id="game_table">
			<table id="table" align="center" cellpadding="0" cellspacing="0">

				<c:forEach begin="0" end="6" step="1" varStatus="i">
					<tr>
						<c:forEach begin="0" end="6" step="1" varStatus="j">
							<td class="chip" id="X${j.count-1}Y${i.count-1}"
								onClick=lightFields(this)><img src=""></td>
						</c:forEach>
					</tr>
				</c:forEach>

			</table>
		</div>

	</div>
	</div>
</body>
</html>