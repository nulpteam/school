var wpSocket;

function waitClient() {
	$('#outText p').text(msgWaitPlayer);
	wpSocket = new WebSocket("ws://" + location.hostname + ":8088");
	wpSocket.onopen = function() {
		wpSocket.send(myId);
	};
	wpSocket.onmessage = function(event) {
		$.post('XOGameStarted.html', function() {
			wpSocket.close();
			goTo('XOGame.html');
		});
	};
}

function connect(id) {
	if (id != myId) {
		$.post("XOConnect.html", {
			serverID : id
		}, function(response) {
			if (response == true) {
				goTo('XOGame.html');
			} else {
				goTo('XOServerList.html');
			}
		});
	}
}

function waitPageHomeButton() {
	wpSocket.close();
	$.post('XOClear.html', function(response) {
		goTo('Menu.html');
	});
}

function waitPageRefreshButton() {
	wpSocket.close();
	$.post('XOClear.html', function(response) {
		goTo('CurrentPos.html');
	});
}

function waitPageBackButton() {
	wpSocket.close();
	$.post('XOClear.html', function(response) {
		goTo('XOMenu.html');
	});
}