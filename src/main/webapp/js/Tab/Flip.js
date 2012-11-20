var levelSound = new Audio;
levelSound.src = 'sound/Flip/levelComplete.wav';
var flipSound = new Audio;
flipSound.src = 'sound/Flip/flip.wav';
var gameOver = new Audio;
gameOver.src = 'sound/Flip/gameOver.wav';

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
	$.post("FlipStatus.html", function(resp) {
		if (resp.gameOver == true) {
			gameOver.play();
			lock = true;
			alert('Game Over');
		} else if (resp.nextLevel == true) {
			levelSound.play();
			tabGoTo("FlipNextLevel.html");
		}
	});
}

function flip(elem) {
	flipSound.play();
	var line = parseInt(elem.id.charAt(0));
	var colum = parseInt(elem.id.charAt(1));
	flipUI($('#flip #field #' + line + colum));
	flipUI($('#flip #field #' + line + (colum - 1)));
	flipUI($('#flip #field #' + line + (colum + 1)));
	flipUI($('#flip #field #' + (line - 1) + colum));
	flipUI($('#flip #field #' + (line + 1) + colum));
}

function flipUI($elem) {
	$elem.flip({
		direction : "rl",
		speed : 200,
		dontChangeColor : true,
	});
	if ($elem.attr('class') == 'white') {
		$elem.attr('class', 'black');
	} else {
		$elem.attr('class', 'white');
	}
}