var lock = true;
var end = false;
var checkerInterval;

// Tick Position
var tickX1 = '210px';
var tickX2 = '460px';

function gameStart() {
	getStatus();
}

function gameHomeButton() {
	if (end == true) {
		clearInterval(checkerInterval);
		$.post('XOClear.html', function(response) {
			homeButtonClick();
		});
	} else {
		var bool = confirm(msgExit);
		if (bool == true) {
			clearInterval(checkerInterval);
			$.post('XOPlayerOut.html', function(response) {
				homeButtonClick();
			});
		}
	}
}

function gameBackButton() {
	if (end == true) {
		clearInterval(checkerInterval);
		$.post('XOClear.html', function(response) {
			backButtonClick();
		});
	} else {
		var bool = confirm(msgExit);
		if (bool == true) {
			clearInterval(checkerInterval);
			$.post('XOPlayerOut.html', function(response) {
				backButtonClick();
			});
		}
	}
}

function gameRefreshButton() {
	alert("aaa");
	clearInterval(checkerInterval);
	refreshButtonClick();
}

function statShow(id) {
	$('#xoGame #outText').hide();
	$('#xoGame #' + id + 'Stat').show();
}

function statHide(id) {
	$('#xoGame #outText').show();
	$('#xoGame #' + id).hide();
}

function put(img) {
	if (lock == true)
		return;
	$.post('XOPut.html', {
		xy : img.id
	}, function(resp) {
		if (resp == true) {
			lock = true;
			getStatus();
		}
	});
}

function checker() {
	checkerInterval = setInterval(check, 1000);
	function check() {
		$.post('XOCheckChanges.html', function(resp) {
			if (resp == true) {
				clearInterval(checkerInterval);
				getStatus();
			}
		});
	}
}

function getStatus() {
	$.post('XOGetStatus.html', function(status) {
		setImg(status.lastBox);
		if (status.gameOver == true) {
			lock = true;
			end = true;
			if (status.winnerId == myId) {
				$('#xoGame #outText').text(msgWin);
				$('#xoGame #win').show();
			} else {
				$('#xoGame #outText').text(msgLose);
			}
		} else if (status.playerOut == true) {
			lock = true;
			end = true;
			if (status.outId == myId) {
				$('#xoGame #outText').text(msgLose);
			} else {
				$('#xoGame #outText')
						.text($('#xoGame #opName').text() + msgOut);
			}
		} else if (status.lastPlayer != myId) {
			lock = false;
			$('#xoGame #outText').text(msgTurn);
		} else if (status.lastPlayer == myId) {
			$('#xoGame #outText').text(msgWait);
			checker();
		}
	});
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