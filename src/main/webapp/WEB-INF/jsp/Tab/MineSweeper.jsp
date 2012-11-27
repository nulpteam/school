<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="mine" class="display">
	<script src="js/Tab/MineSweeper.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			msStart();
		});
	</script>
	<table id="msField">
		<c:forEach var="line" items="${mineSweeper.field}"
			varStatus="lineNumber">
			<tr>
				<c:forEach var="box" items="${line}" varStatus="columNumber">
					<td id="${lineNumber.count-1}${columNumber.count-1}"
						onclick="msPut(this);"><c:if test="${!box.visible}">
							<div class="unVisible"></div>
						</c:if> <c:if test="${box.visible}">
							<div class="visible">${box.minesAround}</div>
						</c:if></td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
	<button onclick="tabGoTo('MSNewGame.html')">new game</button>
</div>