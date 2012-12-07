var lock = true;
var end = false;
var socket;

// Tick Position
var tickX1 = '210px';
var tickX2 = '460px';

function gameStart() {
	socket = new WebSocket("ws://" + location.hostname + ":8088");
	socket.onopen = function() {
		socket.send(myId);
	};
	socket.onmessage = function(event) {
		getStatus();
	};
	getStatus();
}

function put(img) {
	if (lock == true)
		return;
	$.post('XOPut.html', {
		xy : img.id
	}, function(resp) {
		if (resp == true) {
			timerStop();
			getStatus();
		}
	});
}

function getStatus() {
	$.post('XOGetStatus.html', function(status) {
		if (status.gameOver == true) {
			gameOver(status.winnerId);
		} else if (status.playerOut == true) {
			playerOut(status.winnerId);
		} else if (status.timeOut == true) {
			timeOut(status.winnerId);
		} else if (status.lastPlayer != myId) {
			myTurn();
		} else if (status.lastPlayer == myId) {
			opTurn();
		}
		setImg(status.lastBox);
	});
}

function gameOver(winnerId) {
	lock = true;
	end = true;
	if (winnerId == myId) {
		$('#xoGame #outText p').text(msgWin);
		$('#xoGame #win').show();
	} else {
		$('#xoGame #outText p').text(msgLose);
	}
}

function playerOut(winnerId) {
	lock = true;
	end = true;
	if (winnerId == myId) {
		$('#xoGame #outText p').text($('#xoGame #opName').text() + msgOut);
	} else {
		$('#xoGame #outText p').text(msgLose);
	}
}

function timeOut(winnerId) {
	lock = true;
	end = true;
	if (winnerId == myId) {
		$('#xoGame #outText p').text($('#xoGame #opName').text() + msgTime);
	} else {
		$('#xoGame #outText p').text(msgLose);
	}
}

function myTurn() {
	lock = false;
	timerStart();
	$('#xoGame #outText p').text(msgTurn);
	$('#xoGame #tick').animate({
		marginLeft : tickX1
	}, 500);
}

function opTurn() {
	lock = true;
	timerStop();
	$('#xoGame #outText p').text(msgWait);
	$('#xoGame #tick').animate({
		marginLeft : tickX2
	}, 500);
}

var timerInterval;
var timerTime = 15;
function timerStart() {
	timerInterval = setInterval(timer, 1000);
	function timer() {
		$('#xoGame #timer').text(timerTime);
		if (timerTime == 0) {
			timerStop();
			$('#xoGame #outText p').text(msgTime);
			lock = true;
			end = true;
		}
		timerTime -= 1;
	}
}

function timerStop() {
	clearInterval(timerInterval);
	$('#xoGame #timer').text('');
	timerTime = 15;
}

function setImg(box) {
	if (box == null)
		return;
	var id = "X" + box.x + "Y" + box.y;
	var img = document.getElementById(id);
	if (box.status == 0) {
		img.src = "images/XO/0.png";
	} else if (box.status == -1) {
		img.src = "images/XO/X" + getRandomInt(0, 4) + ".png";
	} else if (box.status == -2) {
		img.src = "images/XO/O" + getRandomInt(0, 4) + ".png";
	}
}

function getRandomInt(min, max) {
	return Math.floor(Math.random() * (max - min + 1)) + min;
}

function statShow(id) {
	$('#xoGame #outText').hide();
	$('#xoGame #' + id + 'Stat').show();
}

function statHide(id) {
	$('#xoGame #outText').show();
	$('#xoGame #' + id).hide();
}

function gameHomeButton() {
	if (end == true) {
		socket.close();
		clearInterval(timerInterval);
		$.post('XOClear.html', function(response) {
			homeButtonClick();
		});
	} else {
		var bool = confirm(msgExit);
		if (bool == true) {
			socket.close();
			clearInterval(timerInterval);
			$.post('XOPlayerOut.html', function(response) {
				homeButtonClick();
			});
		}
	}
}

function gameBackButton() {
	if (end == true) {
		socket.close();
		clearInterval(timerInterval);
		$.post('XOClear.html', function(response) {
			backButtonClick();
		});
	} else {
		var bool = confirm(msgExit);
		if (bool == true) {
			socket.close();
			clearInterval(timerInterval);
			$.post('XOPlayerOut.html', function(response) {
				backButtonClick();
			});
		}
	}
}

function gameRefreshButton() {
	socket.close();
	clearInterval(timerInterval);
	refreshButtonClick();
}