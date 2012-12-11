var chatLink = 'Chat.html';
var sudokuLink = 'Sudoku.html';
var homeLink = 'TabHome.html';
var chatSocket;


function tabGoTo(link) {
	$('.display').remove();
	$('#tab').append('<div class="display">'
			+ '<img id="wait_response" src="images/Tab/load.gif"></div>');
	$.post(link, function(resp) {
		$('.display').remove();
		$('#tab').append(resp);
	});
}

function tabBackButton() {
	if(chatSocket != null) {
		chatSocket.close();
	}
	tabGoTo(homeLink);
}

function tabClock() {
	var date = new Date();
	var hh = timeFormat(date.getHours());
	var mm = timeFormat(date.getMinutes());
	$('#tab #bar #clock').text(hh + ' : ' + mm);
	setTimeout(tabClock, 60000);
}

function timeFormat(x) {
	if (x < 10) {
		x = "0" + x;
	}
	return x;
}