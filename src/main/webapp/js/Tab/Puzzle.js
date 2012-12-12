var board = new Array();
var emptyIdX = "3";
var emptyIdY = "3";
var puzzleBoardId = createPuzzleBoard();

$(document).ready(function() {

	puzGetBoard();
});

function puzGetBoard() {

	$.get("PuzzleGetBoard.html", function(response) {

		board = response;
		for ( var i = 0; i < puzzleBoardId.length; i++) {
			for ( var j = 0; j < puzzleBoardId[i].length; j++) {
				puzzleBoardId[i][j] = board[(j + 1 + (4 * (i))) - 1];
			}
		}

		puzzleBoardId[3][3] = 0;

		for ( var i = 0; i < puzzleBoardId.length; i++) {
			for ( var j = 0; j < puzzleBoardId[i].length; j++) {
				if (i != 3 || j != 3)
					$('#PX' + i + 'PY' + j + '> img').attr(
							'src',
							'images/Tab/puzzle/number_'
									+ board[(j + 1 + (4 * (i))) - 1] + '.png');
			}
		}

		$('#PX3PY3').css('background-image', 'url()');

	});
}

function makeMove(id) {

	var xCoord = puzParseX(id);
	var yCoord = puzParseY(id);

	if ((parseInt(xCoord) + 1 == emptyIdX && yCoord == emptyIdY)
			|| (parseInt(xCoord) - 1 == emptyIdX && yCoord == emptyIdY)
			|| (parseInt(yCoord) + 1 == emptyIdY && xCoord == emptyIdX)
			|| (parseInt(yCoord) - 1 == emptyIdY && xCoord == emptyIdX)) {

		$('#' + id).css('background-image', 'url()');
		$('#' + id + '> img').attr('src', '');
		$('#PX' + emptyIdX + 'PY' + emptyIdY + '> img').attr(
				'src',
				'images/Tab/puzzle/number_' + puzzleBoardId[xCoord][yCoord]
						+ '.png');
		$('#PX' + emptyIdX + 'PY' + emptyIdY).css(
				'background-image',
				'url(http://' + location.hostname + ':' + location.port
						+ '/School/images/Tab/puzzle/number_background.png)');

		var temp = puzzleBoardId[emptyIdX][emptyIdY];
		puzzleBoardId[emptyIdX][emptyIdY] = puzzleBoardId[xCoord][yCoord];
		puzzleBoardId[xCoord][yCoord] = temp;

		emptyIdX = xCoord;
		emptyIdY = yCoord;

		if (isEndOfGame()) {
			alert("YOU WIN");
			tabGoTo(homeLink);
		}

	}

}

function isEndOfGame() {

	for ( var i = 0; i < puzzleBoardId.length; i++) {
		for ( var j = 0; j < puzzleBoardId[i].length; j++) {
			if (i != 3 || j != 3) {
				if (puzzleBoardId[i][j] != (j + 1 + (4 * (i))))
					return false;
			}
		}
	}

	return true;

}

function createPuzzleBoard() {
	var board = new Array();
	for ( var i = 0; i < 4; i++) {
		board[i] = new Array();
		for ( var j = 0; j < 4; j++) {
			board[i][j] = 0;
		}
	}
	return board;
}

function puzParseX(strPoint) {

	var indexX = strPoint.indexOf('X');
	var indexY = strPoint.indexOf('Y');
	return strPoint.substring(indexX + 1, indexY - 1);
}

function puzParseY(strPoint) {

	var indexY = strPoint.indexOf('Y');
	return strPoint.substring(indexY + 1);
}
