<!-- @author SergiyManko -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/Reversy.css" type="text/css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<div class="game">
		<div class="field">
			<table cellspacing="0" cellpadding="0" border="0px">
				<tr >
					<td height="40" width="40" align="center"></td>
					<td height="40" width="40" align="center">1</td>
					<td height="40" width="40" align="center">2</td>
					<td height="40" width="40" align="center">3</td>
					<td height="40" width="40" align="center">4</td>
					<td height="40" width="40" align="center">5</td>
					<td height="40" width="40" align="center">6</td>
					<td height="40" width="40" align="center">7</td>
					<td height="40" width="40" align="center">8</td>
				</tr>
				<tr>
					<td height="40" width="40" align="center">A</td>
					<td id="a1" height="40" width="40" image="empty"><img src="images/Reversy/X.gif" height="40" width="40"></td>
					<td id="a2" height="40" width="40" image="empty"><img src="images/Reversy/O.gif" height="40" width="40"></td>
					<td id="a3" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a4" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a5" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a6" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a7" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a8" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
				</tr>
				<tr>
					<td height="40" width="40" align="center">B</td>
					<td id="a1" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a2" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a3" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a4" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a5" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a6" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a7" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a8" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
				</tr>
				<tr>
					<td height="40" width="40" align="center">C</td>
					<td id="a1" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a2" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a3" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a4" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a5" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a6" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a7" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a8" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
				</tr>
				<tr>
					<td height="40" width="40" align="center">D</td>
					<td id="a1" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a2" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a3" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a4" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a5" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a6" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a7" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a8" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
				</tr>
				<tr>
					<td height="40" width="40" align="center">E</td>
					<td id="a1" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a2" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a3" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a4" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a5" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a6" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a7" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a8" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
				</tr>
				<tr>
					<td height="40" width="40" align="center">F</td>
					<td id="a1" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a2" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a3" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a4" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a5" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a6" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a7" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a8" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
				</tr>
				<tr>
					<td height="40" width="40" align="center">G</td>
					<td id="a1" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a2" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a3" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a4" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a5" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a6" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a7" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a8" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
				</tr>
				<tr>
					<td height="40" width="40" align="center">H</td>
					<td id="a1" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a2" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a3" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a4" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a5" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a6" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a7" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a8" height="40" width="40" image="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>