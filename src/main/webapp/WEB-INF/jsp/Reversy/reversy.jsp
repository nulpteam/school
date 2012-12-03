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
	<div id="player1" class="${ReversyGame.player1.name}"></div>
	<div id="player2" class="${ReversyGame.player2.name}"></div>
	<div id="figure1" class="${ReversyGame.player1.figure}"></div>
	<div id="figure2" class="${ReversyGame.player2.figure}"></div>
	<div id="gameView1" class="${ReversyGame.player1.gameView}"></div>
	<div id="gameView2" class="${ReversyGame.player2.gameView}"></div>
	<div id="nextMove" class="${ReversyGame.playerNameToMove}"></div>
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
				<td id="a1" class="${ReversyGame.board.a1}"></td>
				<td id="a2" class="${ReversyGame.board.a2}"></td>
				<td id="a3" class="${ReversyGame.board.a3}"></td>
				<td id="a4" class="${ReversyGame.board.a4}"></td>
				<td id="a5" class="${ReversyGame.board.a5}"></td>
				<td id="a6" class="${ReversyGame.board.a6}"></td>
				<td id="a7" class="${ReversyGame.board.a7}"></td>
				<td id="a8" class="${ReversyGame.board.a8}"></td>
			</tr>
			<tr>
				<td>B</td>
				<td id="b1" class="${ReversyGame.board.b1}"></td>
				<td id="b2" class="${ReversyGame.board.b2}"></td>
				<td id="b3" class="${ReversyGame.board.b3}"></td>
				<td id="b4" class="${ReversyGame.board.b4}"></td>
				<td id="b5" class="${ReversyGame.board.b5}"></td>
				<td id="b6" class="${ReversyGame.board.b6}"></td>
				<td id="b7" class="${ReversyGame.board.b7}"></td>
				<td id="b8" class="${ReversyGame.board.b8}"></td>
			</tr>
			<tr>
				<td>C</td>
				<td id="c1" class="${ReversyGame.board.c1}"></td>
				<td id="c2" class="${ReversyGame.board.c2}"></td>
				<td id="c3" class="${ReversyGame.board.c3}"></td>
				<td id="c4" class="${ReversyGame.board.c4}"></td>
				<td id="c5" class="${ReversyGame.board.c5}"></td>
				<td id="c6" class="${ReversyGame.board.c6}"></td>
				<td id="c7" class="${ReversyGame.board.c7}"></td>
				<td id="c8" class="${ReversyGame.board.c8}"></td>
			</tr>
			<tr>
				<td>D</td>
				<td id="d1" class="${ReversyGame.board.d1}"></td>
				<td id="d2" class="${ReversyGame.board.d2}"></td>
				<td id="d3" class="${ReversyGame.board.d3}"></td>
				<td id="d4" class="${ReversyGame.board.d4}"></td>
				<td id="d5" class="${ReversyGame.board.d5}"></td>
				<td id="d6" class="${ReversyGame.board.d6}"></td>
				<td id="d7" class="${ReversyGame.board.d7}"></td>
				<td id="d8" class="${ReversyGame.board.d8}"></td>
			</tr>
			<tr>
				<td>E</td>
				<td id="e1" class="${ReversyGame.board.e1}"></td>
				<td id="e2" class="${ReversyGame.board.e2}"></td>
				<td id="e3" class="${ReversyGame.board.e3}"></td>
				<td id="e4" class="${ReversyGame.board.e4}"></td>
				<td id="e5" class="${ReversyGame.board.e5}"></td>
				<td id="e6" class="${ReversyGame.board.e6}"></td>
				<td id="e7" class="${ReversyGame.board.e7}"></td>
				<td id="e8" class="${ReversyGame.board.e8}"></td>
			</tr>
			<tr>
				<td>F</td>
				<td id="f1" class="${ReversyGame.board.f1}"></td>
				<td id="f2" class="${ReversyGame.board.f2}"></td>
				<td id="f3" class="${ReversyGame.board.f3}"></td>
				<td id="f4" class="${ReversyGame.board.f4}"></td>
				<td id="f5" class="${ReversyGame.board.f5}"></td>
				<td id="f6" class="${ReversyGame.board.f6}"></td>
				<td id="f7" class="${ReversyGame.board.f7}"></td>
				<td id="f8" class="${ReversyGame.board.f8}"></td>
			</tr>
			<tr>
				<td>G</td>
				<td id="g1" class="${ReversyGame.board.g1}"></td>
				<td id="g2" class="${ReversyGame.board.g2}"></td>
				<td id="g3" class="${ReversyGame.board.g3}"></td>
				<td id="g4" class="${ReversyGame.board.g4}"></td>
				<td id="g5" class="${ReversyGame.board.g5}"></td>
				<td id="g6" class="${ReversyGame.board.g6}"></td>
				<td id="g7" class="${ReversyGame.board.g7}"></td>
				<td id="g8" class="${ReversyGame.board.g8}"></td>
			</tr>
			<tr>
				<td>H</td>
				<td id="h1" class="${ReversyGame.board.h1}"></td>
				<td id="h2" class="${ReversyGame.board.h2}"></td>
				<td id="h3" class="${ReversyGame.board.h3}"></td>
				<td id="h4" class="${ReversyGame.board.h4}"></td>
				<td id="h5" class="${ReversyGame.board.h5}"></td>
				<td id="h6" class="${ReversyGame.board.h6}"></td>
				<td id="h7" class="${ReversyGame.board.h7}"></td>
				<td id="h8" class="${ReversyGame.board.h8}"></td>
			</tr>
		</table>
		<div class="results">
			<div class="player1">${ReversyGame.player1.name} (${ReversyGame.player1.figure}) <div class="player1count"></div></div>
			<div class="player2">${ReversyGame.player2.name} (${ReversyGame.player2.figure}) <div class="player2count"></div></div>
		</div>
	</div>
</div>