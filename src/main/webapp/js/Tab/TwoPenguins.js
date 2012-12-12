$(document).ready(function() {
	alert("load");
	board = createBoard();
	refreshGameBox();
	drawBoard();
});

var board;
var twoFlipped = false;
var oneFlipped = false;
var firstFlippedValue = 0;
var secondFlippedValue = 0;
var firstFlippedX = 0;
var firstFlippedY = 0;
var secondFlippedX = 0;
var secondFlippedY = 0;
var firstFindValue = 0; 
var firstFindX = 0;
var firstFindY = 0; 
var secondFindValue = 0; 
var secondFindX = 0;
var secondFindY = 0; 
function send(td) {

	i = parseX(td.id);
	j = parseY(td.id);

	

	if (twoFlipped == true) {
		$('#X' + firstFlippedX + 'Y' + firstFlippedY + ' > img').attr('src',
				'images/Tab/twoPenguins/penguinCard.png');
		$('#X' + secondFlippedX + 'Y' + secondFlippedY + ' > img').attr('src',
				'images/Tab/twoPenguins/penguinCard.png');
	}
	if (oneFlipped == true) {
		flip(i, j);
		if (board[i][j] == board[firstFlippedX][firstFlippedY]) {
			
		} else {
			secondFlippedValue = board[i][j];
			secondFlippedX = i;
			secondFlippedY = j;
			twoFlipped = true;
		}

	} else {
		flip(i, j);
		firstFlippedValue = board[i][j];
		firstFlippedX = i;
		firstFlippedY = j;
		oneFlipped = true;
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
