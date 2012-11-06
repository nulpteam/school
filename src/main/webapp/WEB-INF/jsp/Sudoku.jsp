<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/sudoku.css" type="text/css" rel="stylesheet">
<script src="js/jquery.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function(){
	getFailed();
});

function divClick(id) {
	var value = prompt();
	$.post("SudokuPut.html", {
		id : id,
		value : value
	}, function(resp) {
		if (resp) {
			$('#sudoku #'+id).text(value);
			getFailed();
		}
	});
}

function getFailed() {
	$.post("SudokuGetFailed.html", function(resp) {
		$('#sudoku .box').css({
			color: "black"
		});
		for ( var i = 0; i < resp.length; i++) {
			var id = "" + resp[i].line + resp[i].colum;
			$('#sudoku #'+id).css({
				color: "red"
			});
		}
	});
}
</script>
</head>
<body>
	<div class="page">
		<div id="sudoku">
			<table cellpadding="0" cellspacing="0">
				<c:forEach var="line" items="${sudoku.field}" varStatus="lineNumber">
					<tr>
						<c:forEach var="box" items="${line}" varStatus="columNumber">
							<td><div class="box"
									id="${lineNumber.count-1}${columNumber.count-1}"
									onclick=divClick(this.id)>
									<c:if test="${box.value != 0}">${box.value}</c:if>
								</div></td>
						</c:forEach>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>