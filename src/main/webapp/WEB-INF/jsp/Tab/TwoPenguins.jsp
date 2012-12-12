<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="flipper" class="display">
	<script src="js/Tab/TwoPenguins.js" type="text/javascript"></script>
	<script type="text/javascript"></script>
	<div id="penguins">
	<div id="penguinScore"><label>1000</label></div>
	
		<table id="penguinsTable" align="center" cellpadding="0"
			cellspacing="0">

			<c:forEach begin="0" end="3" step="1" varStatus="i">
				<tr>
					<c:forEach begin="0" end="2" step="1" varStatus="j">
						<td class="penguinCard" id="X${j.count-1}Y${i.count-1}"
							onClick=send(this)><img src="aa"></td>
					</c:forEach>
				</tr>
			</c:forEach>

		</table>
		<div id="penguinScoreMessage"><label></label></div>
	</div>
</div>