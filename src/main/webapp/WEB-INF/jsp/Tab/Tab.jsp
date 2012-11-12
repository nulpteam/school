<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link href="css/Tab/Tab.css" type="text/css" rel="stylesheet">
<link href="css/Tab/Chat.css" type="text/css" rel="stylesheet">
<link href="css/Tab/Sudoku.css" type="text/css" rel="stylesheet">

<script src="js/Tab/Tab.js" type="text/javascript"></script>
<script type="text/javascript">
	var tabCurentPos = '${tabCurrentPos}';
	$(document).ready(function(){
		tabGoTo(tabCurentPos);
	});
</script>
<div id="tab">
	<div class="bar" onclick=tabHomeButton();></div>
</div>