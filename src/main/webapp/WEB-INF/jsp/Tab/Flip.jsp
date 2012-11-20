<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="flip" class="display">
	<script src="js/Tab/Flip.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			getStatus();
		});
	</script>
	<table id="field">
		<c:forEach var="line" items="${flipGame.field}" varStatus="lineNumber">
			<tr>
				<c:forEach var="box" items="${line}" varStatus="columNumber">
					<td><c:if test="${box.value == 0}">
							<div id="${lineNumber.count-1}${columNumber.count-1}"
								class="white" onclick=send(this);></div>
						</c:if> <c:if test="${box.value == 1}">
							<div id="${lineNumber.count-1}${columNumber.count-1}"
								class="black" onclick=send(this);></div>
						</c:if></td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
	<button id="newGame" onclick="tabGoTo('FlipNewGame.html')">new game</button>
	<button id="reset" onclick="tabGoTo('FlipResetLevel.html');">reset</button>
</div>