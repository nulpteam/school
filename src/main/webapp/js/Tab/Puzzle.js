var board = [];
var emptyIdX = "3";
var emptyIdY = "3";
var puzzleBoardId = createPuzzleBoard();
var lock = false;
var NUMBERS_COUNT = 16;



$(document).ready(function() {

	board.length = NUMBERS_COUNT;
	puzGetBoard();
	puzGetEndGameState();
});

function puzGetBoard() {

	$.get("PuzzleGetBoard.html", function(response) {

		for (var i = 0; i < NUMBERS_COUNT; i++) {
			board[i] = response[i];
		}

		for ( var i = 0; i < puzzleBoardId.length; i++) {
			for ( var j = 0; j < puzzleBoardId[i].length; j++) {
				puzzleBoardId[i][j] = board[(j + 1 + (4 * (i))) - 1];
			}
		}

		for ( var i = 0; i < puzzleBoardId.length; i++) {
			for ( var j = 0; j < puzzleBoardId[i].length; j++) {
				if (puzzleBoardId[i][j] != 0) {
					$('#PX' + i + 'PY' + j + '> img').attr(
							'src',
							'images/Tab/puzzle/number_'
									+ board[(j + 1 + (4 * (i))) - 1] + '.png');
				} else {
					emptyIdX = i;
					emptyIdY = j;
				}
			}
		}

		$('#PX' + emptyIdX + 'PY' + emptyIdY).css('background-image', 'url()');
	});
	
	
}

function puzGetEndGameState() {
	
	$.get("PuzzleGetEndGameState.html", function(response) {
		
		lock = response;
		if (lock == true) {
			$('#puz_winner > img').attr('src',
			'images/Tab/puzzle/puzzle_winner.gif');
		}

	});
}

function makeMove(id) {
	
	if (!lock) {

		var xCoord = puzParseX(id);
		var yCoord = puzParseY(id);

		if ((parseInt(xCoord) + 1 == emptyIdX && yCoord == emptyIdY)
				|| (parseInt(xCoord) - 1 == emptyIdX && yCoord == emptyIdY)
				|| (parseInt(yCoord) + 1 == emptyIdY && xCoord == emptyIdX)
				|| (parseInt(yCoord) - 1 == emptyIdY && xCoord == emptyIdX)) {

			$('#' + id).css('background-image', 'url()');

			$('#PX' + xCoord + 'PY' + yCoord + ' > img').attr('src', "images/Points/square.png");
			$('#PX' + emptyIdX + 'PY' + emptyIdY + ' > img').attr(
					'src',
					'images/Tab/puzzle/number_' + puzzleBoardId[xCoord][yCoord]
							+ '.png');
			$('#PX' + emptyIdX + 'PY' + emptyIdY)
					.css(
							'background-image',
							'url(http://'
									+ location.hostname
									+ ':'
									+ location.port
									+ '/School/images/Tab/puzzle/number_background.png)');

			var temp = puzzleBoardId[emptyIdX][emptyIdY];
			puzzleBoardId[emptyIdX][emptyIdY] = puzzleBoardId[xCoord][yCoord];
			puzzleBoardId[xCoord][yCoord] = temp;
			
			
			var numberOld = (parseInt(emptyIdY) + 1 + (4 * parseInt(emptyIdX))) - 1;
			var numberNew = (parseInt(yCoord) + 1 + (4 * parseInt(xCoord))) - 1;
			
			temp = board[numberNew];
			board[numberNew] = board[numberOld];
			board[numberOld] = temp;
			board.length = NUMBERS_COUNT;

			emptyIdX = xCoord;
			emptyIdY = yCoord;
			
			$.post("PuzzleSaveBoard.html",{board : JSON.stringify(board)}, function(response) {
			});

			if (isEndOfGame()) {
				lock = true;
				$('#puz_winner > img').attr('src',
						'images/Tab/puzzle/puzzle_winner.gif');
				$.get("PuzzleEndGame.html", function(response) {
				});
			}

		}

	} 

}

function isEndOfGame() {

	for ( var i = 0; i < puzzleBoardId.length; i++) {
		for ( var j = 0; j < puzzleBoardId[i].length; j++) {
			if (i != 3 || j != 3) {
				if (puzzleBoardId[j][i] != (j + 1 + (4 * (i)))) {
					return false;
				}
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
