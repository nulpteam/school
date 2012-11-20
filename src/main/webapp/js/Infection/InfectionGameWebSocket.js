var userType;
var gameId;
var socket = new WebSocket("ws://localhost:8086");
var waitForClient = true;


$(document).ready(function() {
	userType = $('#infgame_table').attr('userType');
	gameId = $('#infgame_table').attr('gameId');

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
	//alert(event.data);
	var msg = JSON.parse(event.data);
    switch (msg.type) {

	case "clientConnect":
		$('#infplayer_label_1 > label').text(msg.serverName);
		$('#infplayer_label_2 > label').text(msg.clientName);
		$('#infscore_label_1 > label').text(msg.serverScore);
		$('#infscore_label_2 > label').text(msg.clientScore);
		waitForClient = false;
		break;

	case "serverConnect":
		$('#infplayer_label_1 > label').text(msg.serverName);
		$('#infscore_label_1 > label').text(msg.serverScore);
		break;


	case "initialize":

		if (userType == "server") {
			lock = msg.serverLock;
		} else if (userType == "client") {
			lock = msg.clientLock;
		}

		$('#infplayer_label_1 > label').text(msg.serverName);
		$('#infplayer_label_2 > label').text(msg.clientName);
		$('#infscore_label_1 > label').text(msg.serverScore);
		$('#infscore_label_2 > label').text(msg.clientScore);

		if ($('#infplayer_label_2 > label').text() != "") {
			waitForClient = false;
		}

		break;
		
	case "makechanges":
		if (msg.moveType=="server") {
			lock = msg.clientLock;
			lock = msg.serverLock;
			var fieldX = msg.xcoord;
			var fieldY = msg.ycoord;
			$('#' + X + fieldX + Y + fieldY + '> img').attr('src', "images/Infection/red_chip.png");
		} else if (msg.moveType=="client") {
			lock = msg.clientLock;
			lock = msg.serverLock;
			var fieldX = msg.xcoord;
			var fieldY = msg.ycoord;
			$('#' + X + fieldX + Y + fieldY + '> img').attr('src', "images/Infection/blue_chip.png");
		}
		break;
	}
    
    

};
