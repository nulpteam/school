var userType;
var gameId;
var socket;
var waitForClient = true;
var lock = false;

// TODO таски 1.замутити промальовку гри при рефреші
// 2.логіка самої гри!!!!!!!!!!!!!!
//

$(document).ready(
		function() {

			userType = $('#game_table').attr('userType');
			gameId = $('#game_table').attr('gameId');

			if (userType == "client")
				lock = true;

			socket = new WebSocket("ws://localhost:8082");
			socket.onopen = function() {

				console.log("open socket");
				var userInfo = {
					"type" : "userInfo",
					"userType" : userType,
					"gameId" : gameId
				};
				socket.send(JSON.stringify(userInfo));
			};

			socket.onmessage = function(event) {

				var msg = JSON.parse(event.data);

				switch (msg.type) {
				case "clientConnect":
					$('#player_label_1').text(msg.serverName);
					$('#player_label_2').text(msg.clientName);
					waitForClient = false;
					break;
				case "serverConnect":
					$('#player_label_1').text(msg.serverName);
					break;
				case "lastChanges":
					if (msg.userType == "server") {
						$('#' + msg.coords + ' > img').attr('src',
								'images/Points/point2.png');

					} else if (msg.userType == "client") {
						$('#' + msg.coords + ' > img').attr('src',
								'images/Points/point1.png');
					}
					if (msg.lock == true)
						lock = true;
					else
						lock = false;
					break;
				}
			};

			// waitingForClient = setInterval(waitForClient, 1000);
			// if ($('#div_table').attr('type') == "client") {
			// waitForFirstMove();
			// }

		});

function putPoint(td_point) {

	if (lock == true) {
		alert("not your move");
		return;
	}

	if (waitForClient == true) {
		
		alert("wait for client");
		
	} else {
		
		if (userType == "server") {
			$('#' + td_point.id + ' > img').attr('src',
					'images/Points/point1.png');
		} else {
			$('#' + td_point.id + ' > img').attr('src',
					'images/Points/point2.png');
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
