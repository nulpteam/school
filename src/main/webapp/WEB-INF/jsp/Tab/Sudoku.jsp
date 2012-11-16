<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="sudoku" class="display">
	<script src="js/Tab/Sudoku.js" type="text/javascript"></script>
	<script type="text/javascript">
		var level = '${sudoku.level}';
		$(document).ready(function() {
			getFailed();
			$('#levelsBar #level' + level).css({color: 'white'});
		});
	</script>
	<table id="value">
		<tr>
			<td></td>
			<td><div onmouseover=valueOver(this); onmouseout=valueOut(this)
					onclick=valueClick(0)>0</div></td>
			<td></td>
		</tr>
		<tr>
			<td><div onmouseover=valueOver(this); onmouseout=valueOut(this)
					onclick=valueClick(1)>1</div></td>
			<td><div onmouseover=valueOver(this); onmouseout=valueOut(this)
					onclick=valueClick(2)>2</div></td>
			<td><div onmouseover=valueOver(this); onmouseout=valueOut(this)
					onclick=valueClick(3)>3</div></td>
		</tr>
		<tr>
			<td><div onmouseover=valueOver(this); onmouseout=valueOut(this)
					onclick=valueClick(4)>4</div></td>
			<td><div onmouseover=valueOver(this); onmouseout=valueOut(this)
					onclick=valueClick(5)>5</div></td>
			<td><div onmouseover=valueOver(this); onmouseout=valueOut(this)
					onclick=valueClick(6)>6</div></td>
		</tr>
		<tr>
			<td><div onmouseover=valueOver(this); onmouseout=valueOut(this)
					onclick=valueClick(7)>7</div></td>
			<td><div onmouseover=valueOver(this); onmouseout=valueOut(this)
					onclick=valueClick(8)>8</div></td>
			<td><div onmouseover=valueOver(this); onmouseout=valueOut(this)
					onclick=valueClick(9)>9</div></td>
		</tr>
	</table>
	<table id="field" onmouseout=fieldOut(); cellpadding="0"
		cellspacing="0">
		<c:forEach var="line" items="${sudoku.field}" varStatus="lineNumber">
			<tr>
				<c:forEach var="box" items="${line}" varStatus="columNumber">
					<td id="${lineNumber.count-1}${columNumber.count-1}"
						class="area${box.boxArea}" onmouseover=boxOver(this);><c:if
							test="${box.locked}">
							<div class="lockedBox"
								id="${lineNumber.count-1}${columNumber.count-1}"
								onclick=boxClick(this)>${box.value}</div>
						</c:if> <c:if test="${!box.locked}">
							<div class="unlockedBox"
								id="${lineNumber.count-1}${columNumber.count-1}"
								onclick=boxClick(this)>
								<c:if test="${box.value != 0}">
											${box.value}
										</c:if>
							</div>
						</c:if></td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
	<table id="levelsBar">
		<tr>
			<td id="level1" class="levelButton" onclick=sudokuNewGame(1);>${langPack['easy']}</td>
			<td id="level2" class="levelButton" onclick=sudokuNewGame(2);>${langPack['normal']}</td>
			<td id="level3" class="levelButton" onclick=sudokuNewGame(3);>${langPack['hard']}</td>
		</tr>
	</table>
</div>