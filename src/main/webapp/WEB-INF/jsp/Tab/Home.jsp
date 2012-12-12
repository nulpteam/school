<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="menu" class="display">
	<div class="TabButton" id="TabChat" onclick=tabGoTo(chatLink)></div>
	<div class="TabButton" id="TabSudo" onclick=tabGoTo(sudokuLink)></div>
	<div class="TabButton" id="TabFlip" onclick="tabGoTo('FlipperGame.html')"></div>
	<div class="TabButton" id="TabBomb" onclick="tabGoTo('MSGame.html')"></div>
	<!-- <div class="TabButton" id="TabPenguins" onclick="tabGoTo('PenguinsGame.html')"></div> -->
<!-- 	<button onclick=tabGoTo(chatLink);>Chat</button> -->
<!-- 	<button onclick=tabGoTo(sudokuLink);>Sudoku</button> -->
<!-- 	<button onclick="tabGoTo('FlipperGame.html');">Flipper</button> -->
<!-- 	<button onclick="tabGoTo('MSGame.html');">saper</button> -->
<button onclick="tabGoTo('PenguinsGame.html');">twoPenguins</button>
</div>