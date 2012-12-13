<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="menu" class="display">
	<div class="TabButton" id="TabChat" onclick=tabGoTo(chatLink)></div>
	<div class="TabButton" id="TabSudo" onclick=tabGoTo(sudokuLink)></div>
	<div class="TabButton" id="TabFlipper" onclick="tabGoTo('FlipperGame.html')"></div>
	<div class="TabButton" id="TabBomb" onclick="tabGoTo('MSGame.html')"></div>
	<div class="TabButton" id="TabFlip" onclick="tabGoTo('PenguinsGame.html')"></div>
	<!-- <div class="TabButton" id="TabPenguins" onclick="tabGoTo('PenguinsGame.html')"></div> -->
	<div class="TabButton" id="Tab15-puzzle" onclick="tabGoTo('PuzzleGame.html')"></div>
	<div class="TabButton" id="HanoiGame" onclick="tabGoTo('Hanoi.html')"></div>
	<div class="TabButton" id="BrainGame" onclick="tabGoTo('Brain.html')"></div>
</div>
