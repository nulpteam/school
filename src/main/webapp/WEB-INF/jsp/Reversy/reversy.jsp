<!-- @author SergiyManko -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div  class="paperList" id="reversyMain">
<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/Reversy/Reversy_main.js" type="text/javascript"></script>
<script src="js/Reversy/Reversy_socket.js" type="text/javascript"></script>
	<div id="gameID" class="${ReversyGame.id}"></div>
	<div id="userName" class="${user.name}"></div>
	<div class="boards">
		<table class="reversy" cellspacing="0" cellpadding="0" border="0px">
			<tr >
				<td></td>
				<td>1</td>
				<td>2</td>
				<td>3</td>
				<td>4</td>
				<td>5</td>
				<td>6</td>
				<td>7</td>
				<td>8</td>
			</tr>
			<tr>
				<td>A</td>
				<td id="a1" class="board"></td>
				<td id="a2" class="board"></td>
				<td id="a3" class="board"></td>
				<td id="a4" class="board"></td>
				<td id="a5" class="board"></td>
				<td id="a6" class="board"></td>
				<td id="a7" class="board"></td>
				<td id="a8" class="board"></td>
			</tr>
			<tr>
				<td>B</td>
				<td id="b1" class="board"></td>
				<td id="b2" class="board"></td>
				<td id="b3" class="board"></td>
				<td id="b4" class="board"></td>
				<td id="b5" class="board"></td>
				<td id="b6" class="board"></td>
				<td id="b7" class="board"></td>
				<td id="b8" class="board"></td>
			</tr>
			<tr>
				<td>C</td>
				<td id="c1" class="board"></td>
				<td id="c2" class="board"></td>
				<td id="c3" class="board"></td>
				<td id="c4" class="board"></td>
				<td id="c5" class="board"></td>
				<td id="c6" class="board"></td>
				<td id="c7" class="board"></td>
				<td id="c8" class="board"></td>
			</tr>
			<tr>
				<td>D</td>
				<td id="d1" class="board"></td>
				<td id="d2" class="board"></td>
				<td id="d3" class="board"></td>
				<td id="d4" class="x"></td>
				<td id="d5" class="o"></td>
				<td id="d6" class="board"></td>
				<td id="d7" class="board"></td>
				<td id="d8" class="board"></td>
			</tr>
			<tr>
				<td>E</td>
				<td id="e1" class="board"></td>
				<td id="e2" class="board"></td>
				<td id="e3" class="board"></td>
				<td id="e4" class="o"></td>
				<td id="e5" class="x"></td>
				<td id="e6" class="board"></td>
				<td id="e7" class="board"></td>
				<td id="e8" class="board"></td>
			</tr>
			<tr>
				<td>F</td>
				<td id="f1" class="board"></td>
				<td id="f2" class="board"></td>
				<td id="f3" class="board"></td>
				<td id="f4" class="board"></td>
				<td id="f5" class="board"></td>
				<td id="f6" class="board"></td>
				<td id="f7" class="board"></td>
				<td id="f8" class="board"></td>
			</tr>
			<tr>
				<td>G</td>
				<td id="g1" class="board"></td>
				<td id="g2" class="board"></td>
				<td id="g3" class="board"></td>
				<td id="g4" class="board"></td>
				<td id="g5" class="board"></td>
				<td id="g6" class="board"></td>
				<td id="g7" class="board"></td>
				<td id="g8" class="board"></td>
			</tr>
			<tr>
				<td>H</td>
				<td id="h1" class="board"></td>
				<td id="h2" class="board"></td>
				<td id="h3" class="board"></td>
				<td id="h4" class="board"></td>
				<td id="h5" class="board"></td>
				<td id="h6" class="board"></td>
				<td id="h7" class="board"></td>
				<td id="h8" class="board"></td>
			</tr>
		</table>
<!-- 		<p> -->
<%-- 			${ReversyGame.id} --%>
<!-- 		</p> -->
<!-- 		<p> -->
<%-- 			${user.name} --%>
<!-- 		</p> -->
	</div>
</div>