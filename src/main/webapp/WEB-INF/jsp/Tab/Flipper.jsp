<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="flipper" class="display">
	<script src="js/Tab/Flipper.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			getStatus();
		});
	</script>
	<div id="cont">
		<table id="field">
			<c:forEach var="line" items="${flipperGame.field}"
				varStatus="lineNumber">
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
	</div>
	<div id="newGame" class="flipperButton"
		onclick="tabGoTo('FlipperNewGame.html')">
		<p>${langPack['newGame']}</p>
	</div>
	<div id="reset" class="flipperButton"
		onclick="tabGoTo('FlipperResetLevel.html');">
		<p>${langPack['reset']}</p>
	</div>
</div>