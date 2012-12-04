<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="mineSweeper" class="display">
	<script src="js/Tab/MineSweeper.js" type="text/javascript"></script>
	<script type="text/javascript">
		var win = ${mineSweeper.status.win};
		var lose = ${mineSweeper.status.loose};
		$(document).ready(function() {
			msStart();
			if (win | lose) {
				locked = true;
			}
		});
	</script>
	<table id="msField" cellpadding="0" cellspacing="3">
		<c:forEach var="line" items="${mineSweeper.field}"
			varStatus="lineNumber">
			<tr>
				<c:forEach var="box" items="${line}" varStatus="columNumber">
					<td id="${lineNumber.count-1}${columNumber.count-1}"
						onclick="msPut(this);"><c:if test="${!box.visible}">
							<c:if test="${box.locked}">
								<div class="locked"></div>
							</c:if>
							<c:if test="${!box.locked}">
								<div class="unVisible"></div>
							</c:if>
						</c:if> <c:if test="${box.visible}">
							<c:if test="${box.mine}">
								<div class="mine"></div>
							</c:if>
							<c:if test="${!box.mine}">
								<div class="visible">
									<c:if test="${box.minesAround > 0}">${box.minesAround}</c:if>
								</div>
							</c:if>
						</c:if></td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
	<div class="msButton" onclick="tabGoTo('MSNewGame.html')"><p>${langPack['newGame']}</p></div>
</div>