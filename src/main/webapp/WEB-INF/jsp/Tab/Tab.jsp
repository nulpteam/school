<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="css/Tab/Tab.css" type="text/css" rel="stylesheet">
<script type="text/javascript">
	function chatButton() {
		$.post("Chat.html", function(resp){
			//var elem = $('.display');
			//elem.parentNode.removeChild(elem);
			$('#tab').html(resp);
			chatStart();
		});
	}
	function sudokuButton() {
		$.post("Sudoku.html", function(resp){
			$('#tab').html(resp);
		});
	}
</script>
<div id="tab">
	<div id="menu" class="display">
		<button onclick=chatButton();>Chat</button>
		<button onclick=sudokuButton();>Sudoku</button>
	</div>
</div>