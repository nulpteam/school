<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="sudokuMenu" class="display">
	<script src="js/Tab/Sudoku.js" type="text/javascript"></script>
	<c:if test="${sudoku != null}">
		<button onclick=sudokuContinue();>Continue</button>
	</c:if>
	<button onclick=sudokuNewGame(1);>Easy</button>
	<button onclick=sudokuNewGame(2);>Normal</button>
	<button onclick=sudokuNewGame(3);>Hard</button>
</div>