<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link href="css/Tab/Tab.css" type="text/css" rel="stylesheet">
<link href="css/Tab/Chat.css" type="text/css" rel="stylesheet">
<link href="css/Tab/Sudoku.css" type="text/css" rel="stylesheet">

<script src="js/Tab/Tab.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function(){
		tabGoTo('TabCurrentPos.html');
		tabClock();
	});
</script>
<div id="tab">
	<div id="bar">
		<div id="back" onclick=tabBackButton(); onmouseover=tabBackButtonOver(this); onmouseout=tabBackButtonOut(this);></div>
		<div id="clock"></div>
	</div>
</div>