var chatLink = 'Chat.html';
var sudokuLink = 'SudokuMenu.html';
var homeLink = 'TabHome.html';
var chatInterval;

function tabGoTo(link) {
	$.post(link, function(resp) {
		$('.display').remove();
		$('#tab').append(resp);
	});
}

function tabHomeButton() {
	if (chatInterval != null) {
		clearInterval(chatInterval);
	}
	tabGoTo(homeLink);
}