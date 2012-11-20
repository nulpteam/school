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
			alert('Game Over');
			lock = true;
		} else if (resp.nextLevel == true) {
			alert('next');
			tabGoTo("FlipNextLevel.html");
		}
	});
}

function flip(elem) {
	var line = parseInt(elem.id.charAt(0));
	var colum = parseInt(elem.id.charAt(1));
	change($('#flip #field #' + line + colum));
	change($('#flip #field #' + line + (colum - 1)));
	change($('#flip #field #' + line + (colum + 1)));
	change($('#flip #field #' + (line - 1) + colum));
	change($('#flip #field #' + (line + 1) + colum));
}

function change($elem) {
	if ($elem.attr('class') == 'white') {
		$elem.attr('class', 'black');
	} else {
		$elem.attr('class', 'white');
	}
}