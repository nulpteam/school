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
function send(td) {

	
	
	i = parseX(td.id);
	j = parseY(td.id);

	currentValue = board[i][j];
	currentX = i;
	currentY = j;

	flip(currentX, currentY);
    
	setScore();
	
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
	} else {
		if (currentValue == previousValue) {
			resetBuffer();
			incScore();
			setScore();
			compareCounter++;
			if (compareCounter ==6){
				endGame();
			}
			//setTimeout(setEmptyField(currentX, currentY,previousX,previousY),8000);
		} else {
			twoDifCards = true;
			firstToFlipBackX = previousX;
			firstToFlipBackY = previousY;

			secondToFlipBackX = currentX;
			secondToFlipBackY = currentY;
			decScore();
			setScore();
			//setTimeout(flipCard(currentX, currentY,previousX,previousY),8000);
		}
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

function resetBuffer(){
	previousX = 25;
	previousY = 25;

	currentX = 25;
	currentY = 25;
}

function decScore(){
	score = score - 10;
}

function incScore(){
	score = score + 100;
}

function setScore(){
	$('#penguinScore > label').text(score);
}

function setEmptyField(i,j,i2,j2){
	$('#X' + i + 'Y' + j + ' > img').attr('src',
	'images/Tab/twoPenguins/emptyCard.png');
	$('#X' + i2 + 'Y' + j2 + ' > img').attr('src',
	'images/Tab/twoPenguins/emptyCard.png');
}

function flipCard(i,j,i2,j2){
	flipBack(i, j);
	flipBack(i2, j2);
}

function endGame(){
	$('#penguinScoreMessage > label').text("YOUR SCORE: "+score);
	$('#penguinScoreMessage').css("visibility","visible");
}