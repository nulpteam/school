<!-- @author SergiyManko -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="SHORTCUT ICON" href="images/favicon.ico" type="image/x-icon"> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/Reversy.css" type="text/css" rel="stylesheet">
<title>Reversy</title>
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
					<td id="a1" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a2" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a3" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a4" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a5" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a6" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a7" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="a8" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
				</tr>
				<tr>
					<td height="40" width="40" align="center">B</td>
					<td id="b1" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="b2" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="b3" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="b4" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="b5" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="b6" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="b7" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="b8" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
				</tr>
				<tr>
					<td height="40" width="40" align="center">C</td>
					<td id="c1" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="c2" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="c3" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="c4" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="c5" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="c6" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="c7" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="c8" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
				</tr>
				<tr>
					<td height="40" width="40" align="center">D</td>
					<td id="d1" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="d2" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="d3" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="d4" height="40" width="40" class="empty"><img src="images/Reversy/X.gif" height="40" width="40"></td>
					<td id="d5" height="40" width="40" class="empty"><img src="images/Reversy/O.gif" height="40" width="40"></td>
					<td id="d6" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="d7" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="d8" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
				</tr>
				<tr>
					<td height="40" width="40" align="center">E</td>
					<td id="e1" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="e2" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="e3" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="e4" height="40" width="40" class="empty"><img src="images/Reversy/O.gif" height="40" width="40"></td>
					<td id="e5" height="40" width="40" class="empty"><img src="images/Reversy/X.gif" height="40" width="40"></td>
					<td id="e6" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="e7" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="e8" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
				</tr>
				<tr>
					<td height="40" width="40" align="center">F</td>
					<td id="f1" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="f2" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="f3" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="f4" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="f5" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="f6" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="f7" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="f8" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
				</tr>
				<tr>
					<td height="40" width="40" align="center">G</td>
					<td id="g1" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="g2" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="g3" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="g4" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="g5" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="g6" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="g7" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="g8" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
				</tr>
				<tr>
					<td height="40" width="40" align="center">H</td>
					<td id="h1" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="h2" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="h3" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="h4" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="h5" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="h6" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="h7" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
					<td id="h8" height="40" width="40" class="empty"><img src="images/Reversy/empty.png" height="40" width="40"></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>