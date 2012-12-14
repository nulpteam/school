var puzBoard = [];
var emptyIdX = "3";
var emptyIdY = "3";
var puzzlepuzBoardId = createPuzzlepuzBoard();
var puzLock = false;
var NUMBERS_COUNT = 16;



$(document).ready(function() {

	puzBoard.length = NUMBERS_COUNT;
	puzGetpuzBoard();
	puzGetEndGameState();
});

function puzGetpuzBoard() {

	$.get("PuzzleGetBoard.html", function(response) {

		for (var i = 0; i < NUMBERS_COUNT; i++) {
			puzBoard[i] = response[i];
		}

		for ( var i = 0; i < puzzlepuzBoardId.length; i++) {
			for ( var j = 0; j < puzzlepuzBoardId[i].length; j++) {
				puzzlepuzBoardId[i][j] = puzBoard[(j + 1 + (4 * (i))) - 1];
			}
		}

		for ( var i = 0; i < puzzlepuzBoardId.length; i++) {
			for ( var j = 0; j < puzzlepuzBoardId[i].length; j++) {
				if (puzzlepuzBoardId[i][j] != 0) {
					$('#PX' + i + 'PY' + j + '> img').attr(
							'src',
							'images/Tab/puzzle/number_'
									+ puzBoard[(j + 1 + (4 * (i))) - 1] + '.png');
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
		
		puzLock = response;
		if (puzLock == true) {
			$('#puz_winner > img').attr('src',
			'images/Tab/puzzle/puzzle_winner.png');
		}

	});
}

function makeMove(id) {
	
	if (!puzLock) {

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
					'images/Tab/puzzle/number_' + puzzlepuzBoardId[xCoord][yCoord]
							+ '.png');
			$('#PX' + emptyIdX + 'PY' + emptyIdY)
					.css(
							'background-image',
							'url(http://'
									+ location.hostname
									+ ':'
									+ location.port
									+ '/School/images/Tab/puzzle/number_background.png)');

			var temp = puzzlepuzBoardId[emptyIdX][emptyIdY];
			puzzlepuzBoardId[emptyIdX][emptyIdY] = puzzlepuzBoardId[xCoord][yCoord];
			puzzlepuzBoardId[xCoord][yCoord] = temp;
			
			
			var numberOld = (parseInt(emptyIdY) + 1 + (4 * parseInt(emptyIdX))) - 1;
			var numberNew = (parseInt(yCoord) + 1 + (4 * parseInt(xCoord))) - 1;
			
			temp = puzBoard[numberNew];
			puzBoard[numberNew] = puzBoard[numberOld];
			puzBoard[numberOld] = temp;
			puzBoard.length = NUMBERS_COUNT;

			emptyIdX = xCoord;
			emptyIdY = yCoord;
			
			$.post("PuzzleSavepuzBoard.html",{puzBoard : JSON.stringify(puzBoard)}, function(response) {
			});

			if (isEndOfGame()) {
				puzLock = true;
				$('#puz_winner > img').attr('src',
						'images/Tab/puzzle/puzzle_winner.png');
				$.get("PuzzleEndGame.html", function(response) {
				});
			}

		}

	} 

}

function isEndOfGame() {

	for ( var i = 0; i < puzzlepuzBoardId.length; i++) {
		for ( var j = 0; j < puzzlepuzBoardId[i].length; j++) {
			if (i != 3 || j != 3) {
				if (puzzlepuzBoardId[j][i] != (j + 1 + (4 * (i)))) {
					return false;
				}
			}
		}
	}

	return true;

}

function createPuzzlepuzBoard() {
	var puzBoard = new Array();
	for ( var i = 0; i < 4; i++) {
		puzBoard[i] = new Array();
		for ( var j = 0; j < 4; j++) {
			puzBoard[i][j] = 0;
		}
	}
	return puzBoard;
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
