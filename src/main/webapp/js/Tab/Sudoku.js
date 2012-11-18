var fail = 'red';
var good = 'green';
var locked = 'maroon';

function sudokuNewGame(level) {
	$.post('SudokuNewGame.html', {
		level : level
	}, function(resp) {
		$('.display').remove();
		$('#tab').append(resp);
	});
}

function getFailed() {
	$.post('SudokuGetFailed.html', function(resp) {
		$('#sudoku #field td .unlockedBox').css({
			color : good
		});
		$('#sudoku #field td .lockedBox').css({
			color : locked
		});
		for ( var i = 0; i < resp.length; i++) {
			var id = "" + resp[i].line + resp[i].colum;
			$('#sudoku #field td #' + id).css({
				color : fail,
			});
		}
	});
}

var box;
function boxClick(elem) {
	if ($(elem).attr('class') == 'lockedBox') {
		$('#sudoku #value').hide();
		if (boxHightlight == true) {
			boxHighlightClear();
			boxHightlight = false;
		}
	} else {
		boxHightlight = true;
		boxHighlight(elem.parentNode);

		this.box = elem;
		var position = $(elem).position();
		$('#sudoku #value').css({
			marginTop : position.top + 140,
			marginLeft : position.left + 35
		}).show();
	}
}

function valueClick(value) {
	$.post('SudokuPut.html', {
		id : box.id,
		value : value
	}, function(resp) {
		if (resp == true) {
			if (value == 0) {
				$(box).text('');
			} else {
				$(box).text(value);
			}
			getFailed();
		}
	});
	$('#sudoku #value').hide();
	boxHighlightClear();
	boxHightlight = false;
}

var boxHightlight = false;
function boxHighlight(elem) {
	boxHighlightClear();
	var elements = '#sudoku #field td[id^=' + elem.id.charAt(0)
			+ '] div, #sudoku #field td[id$=' + elem.id.charAt(1)
			+ '] div, #sudoku #field td[class=' + $(elem).attr('class')
			+ '] div';
	$(elements).css({
		backgroundImage : 'url("images/Tab/sudoku/blue.png")'
	});
	$('#sudoku #field td[id$=' + elem.id + '] div').css({
		backgroundImage : 'url("images/Tab/sudoku/green.png")'
	});
}

function boxHighlightClear() {
	$('#sudoku #field td div').css({
		backgroundImage : 'none'
	});
}

function valueOver(elem) {
	$(elem).css({
		color : 'red'
	});
}

function valueOut(elem) {
	$(elem).css({
		color : ''
	});
}

function boxOver(elem) {
	if (boxHightlight == false) {
		boxHighlight(elem);
	}
}

function fieldOut() {
	if (boxHightlight == false) {
		boxHighlightClear();
	}
}