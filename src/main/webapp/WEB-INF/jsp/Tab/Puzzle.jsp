<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="puzzle" class="display">
	<script src="js/Tab/Puzzle.js" type="text/javascript"></script>
	<script src="js/jquery.js" type="text/javascript"></script>

	<div id="puzzle_game">
		<table id="puzzleTable" align="center" cellpadding="0" cellspacing="0">

			<c:forEach begin="0" end="3" step="1" varStatus="i">
				<tr>
					<c:forEach begin="0" end="3" step="1" varStatus="j">
						<td class="puzzleNumber" id="PX${j.count-1}PY${i.count-1}" onClick=makeMove(this.id);>
							<img src="">
						</td>
					</c:forEach>
				</tr>
			</c:forEach>

		</table>
		
		<div id="puz_winner">
			<img src="">
		</div>
	</div>
</div>