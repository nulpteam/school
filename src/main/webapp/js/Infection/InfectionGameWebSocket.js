var userType;
var gameId;
var socket = new WebSocket("ws://" + location.hostname + ":8086");
var waitForClient = true;
var board;
var x = "0";
var y = "0";
var msg;
var waitForClient = true;
var clientLock = false;
var serverLock = false;
var userId;
$(document).ready(
		function() {

			userAgent = navigator.userAgent;
			//
			bsound = new Audio;
			ssound = new Audio;
			asound = new Audio;
			if (userAgent.indexOf("Chrome") != -1) {
				bsound.src = "sound/Infection/bell.mp3";
				ssound.src = "sound/Infection/select.mp3";
				asound.src = "sound/Infection/attack.mp3";
			}
			bsound.loop = false;
			ssound.loop = false;
			asound.loop = false;

			$(".chip").mouseover(
					function() {

						var x = parseX(this.id);
						var y = parseY(this.id);
						if (board[x][y] == 0) {
							$('#X' + x + 'Y' + y + ' > img').attr('src',
									'images/Infection/over_empty_cell.png');
						}
						if (board[x][y] == 1) {
							$('#X' + x + 'Y' + y + ' > img').attr('src',
									'images/Infection/over_red_chip.png');
						}
						if (board[x][y] == 2) {
							$('#X' + x + 'Y' + y + ' > img').attr('src',
									'images/Infection/over_blue_chip.png');
						}
						if (board[x][y] == 5) {
							$('#X' + x + 'Y' + y + ' > img').attr('src',
									'images/Infection/over_hover2_cell.png');
						}
					});

			$(".chip").mouseout(
					function() {

						var x = parseX(this.id);
						var y = parseY(this.id);
						if (board[x][y] == 0) {
							$('#X' + x + 'Y' + y + ' > img').attr('src',
									'images/Infection/empty_cell.png');
						}
						if (board[x][y] == 1) {
							$('#X' + x + 'Y' + y + ' > img').attr('src',
									'images/Infection/red_chip.png');
						}
						if (board[x][y] == 2) {
							$('#X' + x + 'Y' + y + ' > img').attr('src',
									'images/Infection/blue_chip.png');
						}
						if (board[x][y] == 5) {
							$('#X' + x + 'Y' + y + ' > img').attr('src',
									'images/Infection/hover2_cell.png');
						}
					});

			userType = $('#infgame_table').attr('userType');
			gameId = $('#infgame_table').attr('gameId');
			board = createBoard();

			socket.onopen = function() {

				console.log("open socket");
				//alert("Socket Open");
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
	// alert(event.data);
	msg = JSON.parse(event.data);
	switch (msg.type) {

	case "clientConnect":
		alert("clientconnect");
		userType = $('#infgame_table').attr('userType');
		$('#infplayer_label_1 > label').text(msg.serverName);
		$('#infplayer_label_2 > label').text(msg.clientName);
		$('#infscore_label_1 > label').text(msg.serverScore);
		$('#infscore_label_2 > label').text(msg.clientScore);
		refreshBoard(msg.board);
		drawBoard();
		waitForClient = false;
		clientLock = true;
		if (userType == "client") {
			$('#inf_message_place > img').attr('src',
					'images/Infection/sand_clock.gif');
		}
		if (userType == "server") {
			$('#inf_message_place > img').attr('src',
					'images/Infection/empty_sand_clock.png');
		}
		startbsound();
		break;

	case "serverConnect":
		$('#infplayer_label_1 > label').text(msg.serverName);
		$('#infscore_label_1 > label').text(msg.serverScore);
		refreshBoard(msg.board);
		drawBoard();
		if (userType == "server") {
			$('#inf_message_place > img').attr('src',
					'images/Infection/sand_clock.gif');
		}
		break;

	case "initialize":

		$('#infplayer_label_1 > label').text(msg.serverName);
		$('#infplayer_label_2 > label').text(msg.clientName);
		$('#infscore_label_1 > label').text(msg.serverScore);
		$('#infscore_label_2 > label').text(msg.clientScore);

		break;
	case "rightFirstMove":
		// alert("Right move");
		refreshBoard(msg.board);
		drawBoard();

		if (msg.moveType == "server") {
			$('#X' + msg.xcoord + 'Y' + msg.ycoord + ' > img').attr('src',
					'images/Infection/red_chip_eye_rotate.gif');
			board[msg.xcoord][msg.ycoord] = 6;
		}
		if (msg.moveType == "client") {
			$('#X' + msg.xcoord + 'Y' + msg.ycoord + ' > img').attr('src',
					'images/Infection/blue_chip_eye_rotate.gif');
			board[msg.xcoord][msg.ycoord] = 6;
		}
		startssound();
		break;
	case "wrongFirstMove":
		// alert("Wrong move");
		break;
	case "rightSecondMove":
		userType = $('#infgame_table').attr('userType');
		refreshBoard(msg.board);
		drawBoard();

		$('#infscore_label_1 > label').text(msg.serverScore);
		$('#infscore_label_2 > label').text(msg.clientScore);

		if (msg.moveType == "server") {
			clientLock = false;
			serverLock = true;
			if (userType == "client") {
				$('#inf_message_place > img').attr('src',
						'images/Infection/empty_sand_clock.png');
			}
			if (userType == "server") {
				$('#inf_message_place > img').attr('src',
						'images/Infection/sand_clock.gif');
			}

		}
		if (msg.moveType == "client") {
			clientLock = true;
			serverLock = false;
			if (userType == "server") {
				$('#inf_message_place > img').attr('src',
						'images/Infection/empty_sand_clock.png');
			}
			if (userType == "client") {
				$('#inf_message_place > img').attr('src',
						'images/Infection/sand_clock.gif');
			}
		}
		startssound();
		break;
	case "wrongSecondMove":
		// alert("Wrong second move");
		break;
	case "cancelFirstMove":
		refreshBoard(msg.board);
		drawBoard();
		break;
	case "serverWin":
		userType = $('#infgame_table').attr('userType');

		refreshBoard(msg.board);
		drawBoard();

		$('#infscore_label_1 > label').text(msg.serverScore);
		$('#infscore_label_2 > label').text(msg.clientScore);

		userId = $('#infgame_table').attr('userId');

		if (userType == "server") {
			var message = {
				"type" : "winner",
				"userId" : userId,
			};
			alert(message);
			socket.send(JSON.stringify(message));
			winnerPage();

		} else {
			var message = {
				"type" : "loser",
				"userId" : userId,
			};
			socket.send(JSON.stringify(message));
			looserPage();
		}

		break;

	case "clientWin":
		userType = $('#infgame_table').attr('userType');

		refreshBoard(msg.board);
		drawBoard();

		$('#infscore_label_1 > label').text(msg.serverScore);
		$('#infscore_label_2 > label').text(msg.clientScore);

		userId = $('#infgame_table').attr('userId');

		if (userType == "client") {
			var message = {
				"type" : "winner",
				"userId" : userId
			};

			socket.send(JSON.stringify(message));
			winnerPage();
		} else {
			var message = {
				"type" : "loser",
				"userId" : userId
			};
			socket.send(JSON.stringify(message));
			looserPage();
		}

		break;
	case "serverOut":
		$('#infplayer_label_1 > label').css("visibility", "hidden");
		$('#infscore_label_1 > label').css("visibility", "hidden");
		$("#inf_player_out").css("visibility", "visible");
		break;
	case "clientOut":
		$('#infplayer_label_2 > label').css("visibility", "hidden");
		$('#infscore_label_2 > label').css("visibility", "hidden");
		$("#inf_player_out").css("visibility", "visible");
		break;
	}

};

function createBoard() {
	var board = new Array();
	for ( var i = 0; i <= 6; i++) {
		board[i] = new Array();
		for ( var j = 0; j <= 6; j++) {
			board[i][j] = 0;
		}
	}
	return board;
}

function drawBoard() {
	for ( var i = 0; i <= 6; i++) {
		for ( var j = 0; j <= 6; j++) {
			if (board[i][j] == 1) {
				$('#X' + i + 'Y' + j + ' > img').attr('src',
						'images/Infection/red_chip.png');
			} else if (board[i][j] == 2) {
				$('#X' + i + 'Y' + j + ' > img').attr('src',
						'images/Infection/blue_chip.png');
			}
			if (board[i][j] == 0) {
				$('#X' + i + 'Y' + j + ' > img').attr('src',
						'images/Infection/empty_cell.png');
			}
			if (board[i][j] == 5) {
				$('#X' + i + 'Y' + j + ' > img').attr('src',
						'images/Infection/hover2_cell.png');
			}
		}
	}
}

function refreshBoard(matrix) {
	for ( var i = 0; i <= 6; i++) {
		for ( var j = 0; j <= 6; j++) {
			board[i][j] = matrix[i][j];
		}
	}
}

function firstMove(td) {
	userType = $('#infgame_table').attr('userType');
	if (userType == "server") {
		if (serverLock == true) {
			$('#inf_message_place > img').attr('src',
					'images/Infection/sand_clock.gif');
			return;
		}
	}

	if (userType == "client") {
		if (clientLock == true) {
			$('#inf_message_place > img').attr('src',
					'images/Infection/sand_clock.gif');
			return;
		}
	}

	if (waitForClient == true) {
		alert("Wait for a client");
		return;
	}

	if (msg.type == "rightFirstMove" || msg.type == "wrongSecondMove") {
		x = parseX(td.id);
		y = parseY(td.id);

		var userType = $('#infgame_table').attr('userType');

		var move = {
			"type" : "secondmove",
			"userType" : userType,
			"gameId" : gameId,
			"xcoord" : x,
			"ycoord" : y,
			"moveType" : userType
		};
		socket.send(JSON.stringify(move));
		return;
	}

	x = parseX(td.id);
	y = parseY(td.id);
	var userType = $('#infgame_table').attr('userType');

	var move = {
		"type" : "firstmove",
		"userType" : userType,
		"gameId" : gameId,
		"xcoord" : x,
		"ycoord" : y,
		"moveType" : userType
	};
	socket.send(JSON.stringify(move));
}

function winnerPage() {
	goTo('InfectionWin.html');
}

function looserPage() {
	goTo('InfectionLose.html');
}

function cleanLightFields() {
	for ( var i = 0; i <= 6; i++) {
		for ( var j = 0; j <= 6; j++) {
			if (board[i][j] == 5) {
				board[i][j] = 0;
			}
		}
	}
}

function startbsound() {
	bsound.volume = 0.9;
	bsound.play();
}

function startssound() {
	ssound.volume = 0.9;
	ssound.play();
}

function startasound() {
	asound.volume = 0.9;
	asound.play();
}

function exitButton() {
	userType = $('#infgame_table').attr('userType');

	if (userType == "client") {
		var endGame = {
			"type" : "clientOut",
			"userType" : userType,
			"gameId" : gameId
		};
		socket.send(JSON.stringify(endGame));
	}
	if (userType == "server") {
		var endGame = {
			"type" : "serverOut",
			"userType" : userType,
			"gameId" : gameId

		};
		socket.send(JSON.stringify(endGame));
	}

	goTo("InfectionGameExit.html");
}
