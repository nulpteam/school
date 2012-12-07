var levelSound = new Audio;
levelSound.src = 'sound/Flipper/levelComplete.wav';
var flipSound = new Audio;
flipSound.src = 'sound/Flipper/flip.wav';
var gameOver = new Audio;
gameOver.src = 'sound/Flipper/gameOver.wav';

var lock = false;

function send(elem) {
	if (lock == true)
		return;
	$.post("Flip.html", {
		id : elem.id
	}, function(resp) {
		if (resp == true) {
			flip(elem);
			getStatus();
		}
	});
}

function getStatus() {
	$.post("FlipperStatus.html", function(resp) {
		if (resp.gameOver == true) {
			gameOver.play();
			alert('Game Over');
			lock = true;
		} else if (resp.nextLevel == true) {
			levelSound.play();
			tabGoTo("FlipperNextLevel.html");
		}
	});
}

function flip(elem) {
	flipSound.play();
	var line = parseInt(elem.id.charAt(0));
	var colum = parseInt(elem.id.charAt(1));
	flipUI($('#flipper #field #' + line + colum));
	flipUI($('#flipper #field #' + line + (colum - 1)));
	flipUI($('#flipper #field #' + line + (colum + 1)));
	flipUI($('#flipper #field #' + (line - 1) + colum));
	flipUI($('#flipper #field #' + (line + 1) + colum));
}

function flipUI($elem) {
	if ($elem.attr('class') == 'white') {
		$elem.attr('class', 'black');
	} else {
		$elem.attr('class', 'white');
	}
}