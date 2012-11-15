var userType;
var gameId;
var socket = new WebSocket("ws://localhost:8082");
var waitForClient = true;
var lock = false;
var board;

// TODO таски 1.замутити промальовку гри при рефреші - промальовка контурів
//

$(document).ready(function() {

	board = createMatrix();

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
	// alert(event.data);
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

	case "lastChanges":
		if (msg.userType == "server") {
			$('#' + msg.coords + ' > img').attr('src',
					'images/Points/point2.png');
			lock = msg.serverLock;
			var x = parseX(msg.coords);
			var y = parseY(msg.coords);
			board[y][x] = 1;
		} else if (msg.userType == "client") {
			$('#' + msg.coords + ' > img').attr('src',
					'images/Points/point1.png');
			lock = msg.clientLock;
			var x = parseX(msg.coords);
			var y = parseY(msg.coords);
			board[y][x] = 2;
		}

		break;

	case "initialize":

		if (userType == "server") {
			lock = msg.serverLock;
		} else if (userType == "client") {
			lock = msg.clientLock;
		}

		for ( var i = 0; i < 26; i++) {
			board[i] = msg.matrix[i];
		}
		$('#player_label_1 > label').text(msg.serverName);
		$('#player_label_2 > label').text(msg.clientName);

		if ($('#player_label_2 > label').text() != "") {
			waitForClient = false;
		}

		putPoints();
		break;

	case "countur":
		console.log(msg);
		var pointMarked;

		if (msg.userType == "server") {
			pointMarked = 11;
		} else {
			pointMarked = 22;
		}

		var counturBoard = createMatrix();
		counturBoard = msg.matrix;
		var counturCoords = new Array();
		counturCoords = msg.lastCountur;

		paintCountur(counturCoords, pointMarked, counturBoard);

		break;
	}

};

function putPoints() {
	for ( var i = 0; i < 26; i++) {
		for ( var j = 0; j < 22; j++) {
			if (board[i][j] == 1) {
				$('#X' + j + 'Y' + i + ' > img').attr('src',
						'images/Points/point1.png');
			} else if (board[i][j] == 2) {
				$('#X' + j + 'Y' + i + ' > img').attr('src',
						'images/Points/point2.png');
			}
		}
	}

}

function createMatrix() {
	var board = new Array();
	for ( var i = 0; i < 26; i++) {
		board[i] = new Array();
		for ( var j = 0; j < 22; j++) {
			board[i][j] = 0;
		}
	}
	return board;
}

function putPoint(td_point) {

	if (lock == true) {
		alert("not your move");
		return;
	}
	console.log(waitForClient);
	if (waitForClient == true) {

		alert("wait for client");

	} else {

		var x = parseX(td_point.id);
		var y = parseY(td_point.id);
		console.log(board[y][x]);
		if (board[y][x] == 0) {
			if (userType == "server") {
				$('#' + td_point.id + ' > img').attr('src',
						'images/Points/point1.png');
				board[y][x] = 1;
			} else {
				$('#' + td_point.id + ' > img').attr('src',
						'images/Points/point2.png');
				board[y][x] = 2;
			}
			var coords = {
				"type" : "lastChanges",
				"userType" : userType,
				"gameId" : gameId,
				"coords" : td_point.id
			};
			var sendCoords = JSON.stringify(coords);
			socket.send(sendCoords);
			lock = true;

		} else
			alert("there is already a point there");

	}
}

function parseX(strPoint) {

	var indexY = strPoint.indexOf('Y');
	return strPoint.substring(1, indexY);
}

function parseY(strPoint) {

	var indexY = strPoint.indexOf('Y');
	return strPoint.substring(indexY + 1);
}

function paintCountur(counturCoords, pointMarked, pointsBoard) {

	var ctrCoords = new Array();
	ctrCoords = counturCoords;

	var c = document.getElementById("canvas");
	var ctx = c.getContext("2d");
	ctx.lineWidth = 3;
	ctx.beginPath();

	var coord = new Array();
	coord[0] = -1;
	coord[1] = -1;

	for ( var i = 0; i < ctrCoords.length; i = i + 2) {
		console.log(counturCoords[i] + "-" + counturCoords[i + 1]);
		if (coord[0] != -1) {

			ctx.moveTo(coord[1], coord[0]);
			ctx
					.lineTo(counturCoords[i + 1] * 20 + 8,
							counturCoords[i] * 20 + 8);
			ctx.stroke();

		}
		coord[0] = counturCoords[i] * 20 + 8;
		coord[1] = counturCoords[i + 1] * 20 + 8;

	}

	var first_y = counturCoords[0];
	var first_x = counturCoords[1];

	markNeighborCoords(pointsBoard, first_y, first_x, first_y - 1, first_x - 1,
			pointMarked, ctx);
	markNeighborCoords(pointsBoard, first_y, first_x, first_y - 1, first_x,
			pointMarked, ctx);
	markNeighborCoords(pointsBoard, first_y, first_x, first_y - 1, first_x + 1,
			pointMarked, ctx);
	markNeighborCoords(pointsBoard, first_y, first_x, first_y, first_x + 1,
			pointMarked, ctx);
	markNeighborCoords(pointsBoard, first_y, first_x, first_y + 1, first_x + 1,
			pointMarked, ctx);
	markNeighborCoords(pointsBoard, first_y, first_x, first_y + 1, first_x,
			pointMarked, ctx);
	markNeighborCoords(pointsBoard, first_y, first_x, first_y + 1, first_x - 1,
			pointMarked, ctx);
	markNeighborCoords(pointsBoard, first_y, first_x, first_y, first_x - 1,
			pointMarked, ctx);
}

function markNeighborCoords(board, first_y, first_x, neighbor_y, neighbor_x,
		pointMarked, ctx) {

	if (board[neighbor_y][neighbor_x] == pointMarked) {

		ctx.moveTo(first_x * 20 + 8, first_y * 20 + 8);
		ctx.lineTo(neighbor_x * 20 + 8, neighbor_y * 20 + 8);
		ctx.stroke();
	}
}

// function waitForFirstMove() {
// changes = setInterval(getChanges, 1000);
// }
//
// function waitForClient() {
// $.get("WaitingForClient.html", function(response) {
// if (response == '') {
// $('#player_label_2 > label').text("WAITING");
// } else {
// $('#player_label_2 > label').text(response);
// clearInterval(waitingForClient);
// }
// });
// }
//
// function check() {
// $.get("PointCheck.html", function(lastChanges) {
//
// });
// }
// function put(td_point) {
//
// $.post("PointPut.html", {
// point_xy : td_point.id
// }, function(response) {
// if (response == 'server') {
// $('#' + td_point.id + ' > img').attr('src',
// 'images/Points/point1.png');
// } else {
// $('#' + td_point.id + ' > img').attr('src',
// 'images/Points/point2.png');
// }
// });
// console.log("waiting for changes");
// changes = setInterval(getChanges, 1000);
//
// }
//
// function getChanges() {
//
// $.get("PointsGetChanges.html", function(lastChanges) {
// if (lastChanges.coordsOfChanges != 'none') {
//
// if (lastChanges.userThatChanged == 'server') {
//
// $('#' + lastChanges.coordsOfChanges + ' > img').attr('src',
// 'images/Points/point1.png');
//
// } else {
//
// $('#' + lastChanges.coordsOfChanges + ' > img').attr('src',
// 'images/Points/point2.png');
//
// }
// clearInterval(changes);
// }
//
// });
//
// }
//
// function putPoint(td_point) {
//
// $.get("PointCheckMove.html", function(boolMove) {
// if (boolMove == false) {
// alert("not your move");
// } else {
// put(td_point);
// }
// });
//
// }
