var userType;
var gameId;
var socket = new WebSocket("ws://localhost:8086");
var waitForClient = true;
var board;
var x="0";
var y="0";
var msg;
var waitForClient = true;
var clientLock = false;
var serverLock = false;

$(document).ready(function() {
	userType = $('#infgame_table').attr('userType');
	gameId = $('#infgame_table').attr('gameId');
	board=createBoard();
	

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
	msg = JSON.parse(event.data);
	switch (msg.type) {

	case "clientConnect":
		$('#infplayer_label_1 > label').text(msg.serverName);
		$('#infplayer_label_2 > label').text(msg.clientName);
		$('#infscore_label_1 > label').text(msg.serverScore);
		$('#infscore_label_2 > label').text(msg.clientScore);
		refreshBoard(msg.board);
		drawBoard();
		waitForClient = false;
		clientLock = true;
		break;

	case "serverConnect":
		$('#infplayer_label_1 > label').text(msg.serverName);
		$('#infscore_label_1 > label').text(msg.serverScore);
		refreshBoard(msg.board);
		drawBoard();
		break;


	case "initialize":
	
		$('#infplayer_label_1 > label').text(msg.serverName);
		$('#infplayer_label_2 > label').text(msg.clientName);
		$('#infscore_label_1 > label').text(msg.serverScore);
		$('#infscore_label_2 > label').text(msg.clientScore);

		break;
	case "rightFirstMove":
		//alert("Right move");
        if (msg.moveType == "server"){
        	$('#X' + msg.xcoord + 'Y' + msg.ycoord + ' > img').attr('src',
			'images/Infection/red_hover_chip.png');
        }
        if (msg.moveType == "client"){
        	$('#X' + msg.xcoord + 'Y' + msg.ycoord + ' > img').attr('src',
			'images/Infection/blue_hover_chip.png');
        }
		break;
	case "wrongFirstMove":
		//alert("Wrong move");
		break;
	case "rightSecondMove":
				
		refreshBoard(msg.board);		
		drawBoard();
		
		$('#infscore_label_1 > label').text(msg.serverScore);
		$('#infscore_label_2 > label').text(msg.clientScore);
		
		if (msg.moveType == "server"){
			clientLock = false;
			serverLock = true;
		}
		if (msg.moveType == "client"){
			clientLock = true;
			serverLock = false;
		}
		break;
	case "wrongSecondMove":
		//alert("Wrong second move");
		break;
	case "serverWin":
		userType = $('#infgame_table').attr('userType');
		
		refreshBoard(msg.board);		
		drawBoard();
		
		$('#infscore_label_1 > label').text(msg.serverScore);
		$('#infscore_label_2 > label').text(msg.clientScore);
		
		if (userType == "server"){
			alert("You win");
		}else{
			alert("You Lose");
		}
		break;
	case "clientWin":
		userType = $('#infgame_table').attr('userType');
		
		refreshBoard(msg.board);		
		drawBoard();
		
		$('#infscore_label_1 > label').text(msg.serverScore);
		$('#infscore_label_2 > label').text(msg.clientScore);
		
		if (userType == "client"){
			alert("You win");
		}else{
			alert("You Lose");
		}
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

function drawBoard(){
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
		}
	}
}

function refreshBoard(matrix){
	for ( var i = 0; i <= 6; i++) {
		for ( var j = 0; j <= 6; j++) {
			board[i][j]=matrix[i][j];
		}
	}	
}

function firstMove(td) {
	userType = $('#infgame_table').attr('userType');
    if (userType == "server"){
		if ( serverLock == true ){
			alert ("Wait for your turn");
			return;
		}
	}
	
	if (userType == "client"){
		if ( clientLock == true ){
			alert ("Wait for your turn");
			return;
		}
	}
	
    if ( waitForClient == true ){
    	alert("Wait for a client");
    	return;
    }
	
	if (msg.type == "rightFirstMove" || msg.type == "wrongSecondMove"){
		x = parseX(td.id);
		y = parseY(td.id);
		var userType = $('#infgame_table').attr('userType');

		var move = {
				"type" : "secondmove",
				"userType" : userType,
				"gameId" : gameId,
				"xcoord": x,
				"ycoord": y,
				"moveType":userType
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
			"xcoord": x,
			"ycoord": y,
			"moveType":userType
	};
	socket.send(JSON.stringify(move));
}


