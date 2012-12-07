var socket;

function waitClient() {
	$('#outText p').text(msgWaitPlayer);
	socket = new WebSocket("ws://" + location.hostname + ":8088");
	socket.onopen = function() {
		socket.send(myId);
	};
	socket.onmessage = function(event) {
		$.post('XOGameStarted.html', function() {
			goTo(gameLink);
		});
	};
}

function waitPageHomeButton() {
	socket.close();
	$.post('XOClear.html', function(response) {
		homeButtonClick();
	});
}

function waitPageBackButton() {
	socket.close();
	$.post('XOClear.html', function(response) {
		backButtonClick();
	});
}