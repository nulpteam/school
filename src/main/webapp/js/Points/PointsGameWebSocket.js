var userType;
var gameId;
var socket;
var waitForClient = true;
var lock = false;
var board;
var x_length = 20;
var y_length = 19;
var isHomeMenuActive = false;
var isPointsMenuActive = false;
var serverScore = 0;
var clientScore = 0;
var ptstimerTime;
var moveTime;
var MINUTE = 60;

$(document)
		.ready(
				function() {

					socket = new WebSocket("ws://" + location.hostname
							+ ":8082");
					userType = $('#pts_game_table').attr('userType');
					gameId = $('#pts_game_table').attr('gameId');
					$('#pts_player2_img').css('visibility', 'hidden');

					$(".pts_point")
							.mouseover(
									function() {

										if (!lock) {
											var x = parseX(this.id);
											var y = parseY(this.id);
											if (board[y][x] == 0) {
												$('#' + this.id)
														.css(
																'background-image',
																"url(\'images/Points/point_hover_true.png\')");
											}
											if (board[y][x] == -1) {
												$('#' + this.id)
														.css(
																'background-image',
																"url(\'images/Points/point_hover_false.png\')");
											}
										}
									});

					$(".pts_point")
							.mouseout(
									function() {
										if (!lock) {
											var x = parseX(this.id);
											var y = parseY(this.id);
											if (board[y][x] == 0
													|| board[y][x] == -1) {
												$('#' + this.id)
														.css(
																'background-image',
																"url(\'images/Points/square.png\')");
											}
										}
									});

					board = createMatrix();

					if (userType == "client")
						lock = true;

					socket.onopen = function() {

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

					socket.onclose = function() {
						ptsTimerStop();
						
						console.log("socket.onclose");
					};

					socket.onmessage = function(event) {

						console.log(event.data);

						var msg = JSON.parse(event.data);

						switch (msg.type) {

						case "clientConnect":

							$('#pts_player_label_1 > label').text(
									msg.serverName);
							$('#pts_player_label_2 > label').text(
									msg.clientName);
							$('#pts_player2_img').css('visibility', 'visible');
							waitForClient = false;
							$('#waiting_for_client > label').css('visibility',
									"hidden");

							break;

						case "serverConnect":
							$('#pts_player_label_1 > label').text(
									msg.serverName);
							$('#pts_player_label_2 > label').text(
									msg.clientName);
							if (msg.clientName != "") {
								$('#pts_player2_img').css('visibility',
										'visible');
								waitForClient = false;
								$('#waiting_for_client > label').css(
										'visibility', "hidden");

							}
							if (msg.timer == true) {
								
								ptsTimerStart(MINUTE);
							}
							break;

						case "lastChanges":
							var x = parseX(msg.coords);
							var y = parseY(msg.coords);
							ptsTimerStart(MINUTE);
							if (msg.userType == "server") {
								$('#' + msg.coords + ' > img').attr('src',
										getRandomPoint("client"));
								lock = msg.serverLock;
								board[y][x] = 1;
							} else if (msg.userType == "client") {
								$('#' + msg.coords + ' > img').attr('src',
										getRandomPoint("server"));
								lock = msg.clientLock;
								board[y][x] = 2;
							}

							drawLastPointPointer(y, x);
							$('#wait > img').css('visibility', "hidden");

							break;

						case "initialize":

							var matrix = createMatrix();
							matrix = msg.matrix;

							if (userType == "server") {
								lock = msg.serverLock;
							} else if (userType == "client") {
								lock = msg.clientLock;
							}

							console.log(userType + msg.userTypeActiveMenu);
							if (userType == msg.userTypeActiveMenu) {
								isHomeMenuActive = msg.activeMainMenu;
								isPointsMenuActive = msg.activePointsMenu;
							}

							for ( var i = 0; i < y_length; i++) {

								for ( var j = 0; j < x_length; j++) {
									if (matrix[i][j] == -11
											|| matrix[i][j] == 11
											|| matrix[i][j] == 10)
										board[i][j] = 1;
									else if (matrix[i][j] == -12
											|| matrix[i][j] == 22
											|| matrix[i][j] == 20)
										board[i][j] = 2;
									else
										board[i][j] = matrix[i][j];
								}
							}
							$('#pts_player_label_1 > label').text(
									msg.serverName);
							$('#pts_player_label_2 > label').text(
									msg.clientName);

							

							serverScore = msg.serverScore;
							clientScore = msg.clientScore;

							$('#pts_score1').text(msg.serverScore);
							$('#pts_score2').text(msg.clientScore);

							if ($('#pts_player_label_2 > label').text() != "") {

								$('#pts_player2_img').css('visibility',
										'visible');
								waitForClient = false;
							} else {

								$('#waiting_for_client > label').css(
										'visibility', "visible");
							}

							if (isHomeMenuActive || isPointsMenuActive)
								$("#pts_surrender_div").css("visibility",
										"visible");

							if (lock) {
								$('#wait > img').css('visibility', "visible");
							} else {
								if ($('#pts_player_label_2 > label').text() != ""
										&& waitForClient == false)
									ptsTimerStart(msg.moveTime - 1);
							}
							
							putPoints();

							paintContour(msg.contoursServer, contourBoard,
									"server");
							paintContour(msg.contoursClient, contourBoard,
									"client");

							if (msg.lastY != -1)
								drawLastPointPointer(msg.lastY, msg.lastX);
							break;

						case "contour":
							console.log(msg);

							var usType = msg.userType;

							var contourBoard = createMatrix();
							contourBoard = msg.matrix;

							var contourCoords = createMatrix();
							contourCoords = msg.lastContours;
							initializeBoard(contourBoard);

							serverScore = msg.serverScore;
							clientScore = msg.clientScore;

							$('#pts_score1').text(msg.serverScore);
							$('#pts_score2').text(msg.clientScore);

							paintContour(contourCoords, contourBoard, usType);

							break;

						case "player_win":
							ptsTimerStop();
							socket.close();
							goTo('PointsEndGameWinner.html');
							break;

						case "player_loose":
							ptsTimerStop();
							socket.close();
							goTo('PointsEndGameLooser.html');
							break;
						}

					};

				});

function initializeBoard(matrix) {
	for ( var i = 0; i < matrix.length; i++) {

		for ( var j = 0; j < matrix[i].length; j++) {
			if (matrix[i][j] == 11 || matrix[i][j] == -11)
				board[i][j] = 1;
			else if (matrix[i][j] == 22 || matrix[i][j] == -12)
				board[i][j] = 2;
			else
				board[i][j] = matrix[i][j];
		}
	}
	console.log("BOARD!!!!!!!!!!!!!!!!!" + board);
}

function putPoints() {
	for ( var i = 0; i < y_length; i++) {
		for ( var j = 0; j < x_length; j++) {
			if (board[i][j] == 1) {
				$('#X' + j + 'Y' + i + ' > img').attr('src',
						getRandomPoint("server"));
			} else if (board[i][j] == 2) {
				$('#X' + j + 'Y' + i + ' > img').attr('src',
						getRandomPoint("client"));
			}
		}
	}

}

function createMatrix() {
	var board = new Array();
	for ( var i = 0; i < y_length; i++) {
		board[i] = new Array();
		for ( var j = 0; j < x_length; j++) {
			board[i][j] = 0;
		}
	}
	return board;
}

function putPoint(td_point) {

	if (lock == true) {
		// TODO
		return;
	}
	console.log(waitForClient);
	if (waitForClient == true) {

		return;
	} else {

		var x = parseX(td_point.id);
		var y = parseY(td_point.id);
		console.log(board[y][x]);
		ptsTimerStop();
		if (board[y][x] == 0) {
			if (userType == "server") {
				$('#' + td_point.id + ' > img').attr('src',
						getRandomPoint(userType));
				board[y][x] = 1;
			} else {
				$('#' + td_point.id + ' > img').attr('src',
						getRandomPoint(userType));
				board[y][x] = 2;
			}

			$('#wait > img').css('visibility', "visible");

			drawLastPointPointer(y, x);

			if (!isEndOfGame()) {
				var coords = {
					"type" : "lastChanges",
					"userType" : userType,
					"gameId" : gameId,
					"coords" : td_point.id
				};
				var sendCoords = JSON.stringify(coords);
				socket.send(sendCoords);
				lock = true;
			} else {

				if (isWinner()) {

					var player_result = {
						"type" : "player_win",
						"gameId" : gameId,
						"userType" : userType
					};

					socket.send(JSON.stringify(player_result));
					socket.close();
					goTo('PointsEndGameWinner.html');

				} else {

					var player_result = {
						"type" : "player_loose",
						"gameId" : gameId,
						"userType" : userType
					};

					socket.send(JSON.stringify(player_result));
					socket.close();
					goTo('PointsEndGameLooser.html');

				}

			}

		}

	}
}

function isWinner() {

	if (userType == "server") {
		if (serverScore > clientScore)
			return true;
		else
			return false;
	}

	else if (userType == "client") {
		if (clientScore > serverScore)
			return true;
		else
			return false;
	}

}

function isEndOfGame() {

	for ( var i = 0; i < y_length; i++) {
		for ( var j = 0; j < x_length; j++) {
			if (board[i][j] == 0)
				return false;
		}
	}

	return true;
}

function getRandomPoint(usType) {

	var random = Math.floor((Math.random() * 4) + 1);

	if (usType === "server") {

		return ('images/Points/server_point-' + random + '.png');
	} else {

		return ('images/Points/client_point-' + random + '.png');
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

function drawLastPointPointer(y, x) {

	var canvas = document.getElementById('pts_canvas_last_points');
	var ctx = canvas.getContext('2d');
	ctx.clearRect(0, 0, canvas.width, canvas.height);

	ctx.beginPath();
	ctx.arc(x * 21.6 + 11.5, y * 26.35 + 18, 14, 0, 2 * Math.PI, false);
	ctx.fillStyle = '#e0bc15';
	ctx.fill();
	ctx.lineWidth = 2;
	ctx.strokeStyle = '#b19822';
	ctx.stroke();
}

function paintContour(contoursCoords, pointsBoard, usType) {

	var contourCoords = createMatrix();
	contourCoords = contoursCoords;

	var c = document.getElementById("pts_canvas");
	var ctx = c.getContext("2d");

	ctx.lineWidth = 8;

	if (usType === "server") {
		ctx.strokeStyle = '#2f2d33';
		ctx.fillStyle = '#676767';
	} else {
		ctx.strokeStyle = '#3904ba';
		ctx.fillStyle = '#686fd2';
	}

	for ( var j = 0; j < contourCoords.length; j++) {
		ctx.beginPath();
		var coord = new Array();
		coord[0] = -1;
		coord[1] = -1;

		for ( var i = 0; i < contourCoords[j].length; i = i + 2) {

			if (coord[0] != -1) {
				ctx.lineTo(contourCoords[j][i + 1] * 21.6 + 13,
						contourCoords[j][i] * 26.35 + 16);

			} else {
				coord[0] = contourCoords[j][i] * 26.35 + 16;
				coord[1] = contourCoords[j][i + 1] * 21.6 + 13;
				ctx.moveTo(coord[1], coord[0]);
			}

		}
		ctx.lineTo(coord[1], coord[0]);
		ctx.closePath();
		ctx.fill();
		ctx.stroke();
	}
}

function goToMenu() {

	if (!waitForClient) {
		$("#pts_surrender_div").css("visibility", "visible");

		var surrender = {
			"type" : "surrender",
			"activeMainMenu" : true,
			"activePointsMenu" : false,
			"gameId" : gameId,
			"userType" : userType
		};

		socket.send(JSON.stringify(surrender));

		isHomeMenuActive = true;
		isPointsMenuActive = false;
	} else {

		ptsTimerStop();
		$.post("PointsClearPointsMenuSession.html", function(data) {
			socket.close();
			goTo('Menu.html');
		});

	}
}

function surrender() {

	if (!waitForClient) {
		$("#pts_surrender_div").css("visibility", "visible");

		var surrender = {
			"type" : "surrender",
			"activeMainMenu" : false,
			"activePointsMenu" : true,
			"gameId" : gameId,
			"userType" : userType
		};

		socket.send(JSON.stringify(surrender));

		isPointsMenuActive = true;
		isHomeMenuActive = false;
	} else {

		ptsTimerStop();
		$.post("PointsClearPointsGameSession.html", function(data) {
			socket.close();
			goTo('Points.html');
		});

	}
}

function surrenderYes() {

	var user_surrended = {
		"type" : "player_loose",
		"userType" : userType,
		"gameId" : gameId
	};

	socket.send(JSON.stringify(user_surrended));

	$.post("PointsGameExit.html", function(data) {
	});

	ptsTimerStop();

	if (isPointsMenuActive) {

		$.post("PointsClearPointsGameSession.html", function(data) {
			socket.close();
			goTo('Points.html');
		});

	} else {
		$.post("PointsClearPointsMenuSession.html", function(data) {
			socket.close();
			goTo('Menu.html');
		});
	}
}

function surrenderNo() {
	$("#pts_surrender_div").css("visibility", "hidden");
	isPointsMenuActive = false;
	isHomeMenuActive = false;

	var surrender = {
		"type" : "surrender",
		"activeMainMenu" : false,
		"activePointsMenu" : false,
		"gameId" : gameId,
		"userType" : userType
	};

	socket.send(JSON.stringify(surrender));
}

function ptsTimerStart(clockTime) {

	ptstimerTime = setInterval(pts_timer, 1000);
	moveTime = clockTime;

	function pts_timer() {

		$('#pts_time').text(moveTime);
		$('#pts_timer').css('visibility', 'visible');
		if (moveTime == 0) {
			ptsTimerStop();

			var user_lose = {
				"type" : "player_loose",
				"userType" : userType,
				"gameId" : gameId
			};

			socket.send(JSON.stringify(user_lose));

			socket.close();
			goTo('PointsEndGameLooser.html');
		}
		
		
		moveTime -= 1;
		
//		var time = {
//				"type" : "time",
//				"gameId" : gameId,
//				"moveTime" : moveTime 
//			};
//		socket.send(JSON.stringify(time));
	}

}

function ptsTimerStop() {
	clearInterval(ptstimerTime);
	$('#pts_timer').css('visibility', 'hidden');
//	var time = {
//			"type" : "time",
//			"gameId" : gameId,
//			"moveTime" : MINUTE 
//		};
//	socket.send(JSON.stringify(time));
}
