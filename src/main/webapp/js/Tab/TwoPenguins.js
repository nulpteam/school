$(document).ready(function() {
	board = createBoard();
	refreshGameBox();
	drawBoard();

});

var board;
var currentValue;
var currentX;
var currentY;
var previousValue = 0;
var previousX;
var previousY;
var twoDifCards = false;

var firstToFlipBackX;
var firstToFlipBackY;

var secondToFlipBackX;
var secondToFlipBackY;
var score = 1000;
var compareCounter = 0;
var lastFindFX = 0;
var lastFindFY = 0;

var lastFindSX = 0;
var lastFindSY = 0;
var lockX = 25;
var lockY = 25;
var lockValue = 0;
var twoSame = false;
function send(td) {

	i = parseX(td.id);
	j = parseY(td.id);

	currentValue = board[i][j];
	currentX = i;
	currentY = j;

	getFieldID(currentX, currentY);

	if (getFieldID(currentX, currentY) != getFieldID(lockX, lockY)) {

		flip(currentX, currentY);

		setScore();

		if (twoSame == true) {

			$('#X' + lastFindFX + 'Y' + lastFindFY).css("visibility", "hidden");
			$('#X' + lastFindSX + 'Y' + lastFindSY).css("visibility", "hidden");
			twoSame = false;
		}

		if (twoDifCards == true) {
			flipBack(firstToFlipBackX, firstToFlipBackY);
			flipBack(secondToFlipBackX, secondToFlipBackY);
			previousValue = 0;
			twoDifCards = false;
		}

		if (previousValue == 0) {
			previousValue = currentValue;
			previousX = currentX;
			previousY = currentY;
			lockX = previousX;
			lockY = previousY;
			lockValue = previousValue;
		} else {
			if (currentValue == previousValue) {

				incScore();
				setScore();
				compareCounter++;
				lastFindFX = currentX;
				lastFindFY = currentY;
				lastFindSX = previousX;
				lastFindSY = previousY;
				resetBuffer();
				if (compareCounter == 6) {
					endGame();
					compareCounter = 0;
				}
				twoSame = true;

			} else {
				twoDifCards = true;
				firstToFlipBackX = previousX;
				firstToFlipBackY = previousY;

				secondToFlipBackX = currentX;
				secondToFlipBackY = currentY;
				decScore();
				setScore();
				// setTimeout(flipCard(currentX,
				// currentY,previousX,previousY),8000);
			}
		}

	} else {

	}

}

function refreshGameBox() {
	$.post('TPRefresh.html', function(resp) {
		for ( var i = 0; i <= 2; i++) {
			for ( var j = 0; j <= 3; j++) {
				board[i][j] = resp[i][j];

			}
		}
	});
}

function drawBoard() {
	for ( var i = 0; i <= 2; i++) {
		for ( var j = 0; j <= 3; j++) {
			$('#X' + i + 'Y' + j + ' > img').attr('src',
					'images/Tab/twoPenguins/penguinCard.png');
		}
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

function createBoard() {
	var board = new Array();
	for ( var i = 0; i <= 2; i++) {
		board[i] = new Array();
		for ( var j = 0; j <= 3; j++) {
			board[i][j] = 0;
		}
	}
	return board;
}

function flip(i, j) {
	if (board[i][j] == 2) {
		$('#X' + i + 'Y' + j + ' > img').attr('src',
				'images/Tab/twoPenguins/penguin2.png');
	}
	if (board[i][j] == 3) {
		$('#X' + i + 'Y' + j + ' > img').attr('src',
				'images/Tab/twoPenguins/penguin3.png');
	}
	if (board[i][j] == 4) {
		$('#X' + i + 'Y' + j + ' > img').attr('src',
				'images/Tab/twoPenguins/penguin4.png');
	}
	if (board[i][j] == 5) {
		$('#X' + i + 'Y' + j + ' > img').attr('src',
				'images/Tab/twoPenguins/penguin5.png');
	}
	if (board[i][j] == 6) {
		$('#X' + i + 'Y' + j + ' > img').attr('src',
				'images/Tab/twoPenguins/penguin6.png');
	}
	if (board[i][j] == 7) {
		$('#X' + i + 'Y' + j + ' > img').attr('src',
				'images/Tab/twoPenguins/penguin7.png');
	}
}

function flipBack(i, j) {
	$('#X' + i + 'Y' + j + ' > img').attr('src',
			'images/Tab/twoPenguins/penguinCard.png');
}

function resetBuffer() {
	previousX = 25;
	previousY = 25;

	currentX = 25;
	currentY = 25;
}

function decScore() {
	score = score - 10;
}

function incScore() {
	score = score + 100;
}

function setScore() {
	$('#penguinScore > label').text(score);
}

function setEmptyField(i, i2, j, j2) {

	$('#X' + i + 'Y' + i2 + ' > img').attr('src',
			'images/Tab/twoPenguins/emptyCard.png');
	$('#X' + j + 'Y' + j2 + ' > img').attr('src',
			'images/Tab/twoPenguins/emptyCard.png');

}

function flipCard(i, j, i2, j2) {
	flipBack(i, j);
	flipBack(i2, j2);
}

function endGame() {
	$('#penguinScoreMessage > label').text("YOUR SCORE: " + score);
	$('#penguinScoreMessage').css("visibility", "visible");
}

function getFieldID(x, y) {
	var field = "";
	field = field + x;
	field = field + y;
	return field;
}