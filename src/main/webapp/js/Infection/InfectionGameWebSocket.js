var userType;
var gameId;
var socket = new WebSocket("ws://localhost:8086");
var waitForClient = true;


$(document).ready(function() {
	userType = $('#game_table').attr('userType');
	gameId = $('#game_table').attr('gameId');

	if (userType == "client")
		lock = true;

	socket.onopen = function() {

		console.log("open socket");

		var userInfo = {
				"type" : "userInfo",
				"userType" : userType,
				"gameId" : gameId
		};
		socket.send(JSON.stringify(userInfo));

		var initialize = {
				"type" : "initialize",
				"userType" : userType,
				"gameId" : gameId
		};
		socket.send(JSON.stringify(initialize));

	};

});

socket.onmessage = function(event) {

	console.log(event.data);
	alert(event.data);
	var msg = JSON.parse(event.data);

	switch (msg.type) {

	case "clientConnect":
		$('#player_label_1 > label').text(msg.serverName);
		$('#player_label_2 > label').text(msg.clientName);
		waitForClient = false;
		break;

	case "serverConnect":
		$('#player_label_1 > label').text(msg.serverName);
		break;


	case "initialize":

		if (userType == "server") {
			lock = msg.serverLock;
		} else if (userType == "client") {
			lock = msg.clientLock;
		}

		$('#player_label_1 > label').text(msg.serverName);
		$('#player_label_2 > label').text(msg.clientName);

		if ($('#player_label_2 > label').text() != "") {
			waitForClient = false;
		}

		break;
	}

};
