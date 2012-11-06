<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="css/sudoku.css" type="text/css" rel="stylesheet">
<script src="js/sudoku.js" type="text/javascript"></script>
<div id="sudoku">
	<div id="field">
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
		<table cellpadding="0" cellspacing="0" rules="all">
			<c:forEach var="line" items="${sudoku.field}" varStatus="lineNumber">
				<tr>
					<c:forEach var="box" items="${line}" varStatus="columNumber">
						<td><div class="box"
								id="${lineNumber.count-1}${columNumber.count-1}"
								onclick=boxClick(this)>
								<c:if test="${box.value != 0}">
											${box.value}
										</c:if>
							</div></td>
					</c:forEach>
				</tr>
			</c:forEach>
		</table>
		<button onclick=newGame();>New game</button>
	</div>
</div>