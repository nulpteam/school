function newGame() {	
	$.post('SudokuNewGame.html', function(resp) {
		var i = 0;
		$('#sudoku #field td div').each(function() {
			if (resp[i] == 0) {
				$(this).text('');
				$(this).attr('class', 'unlockedBox');
			} else {
				$(this).text(resp[i]);
				$(this).attr('class', 'lockedBox');
			}
			i++;
		});
	});
	getFailed();
	$('#sudoku #value').hide();
}

function getFailed() {
	$.post('SudokuGetFailed.html', function(resp) {
		$('#sudoku #field .lockedBox').css({
			color : 'black'
		});
		$('#sudoku #field .unlockedBox').css({
			color : 'inherit'
		});
		for ( var i = 0; i < resp.length; i++) {
			var id = "" + resp[i].line + resp[i].colum;
			$('#sudoku #field td #' + id).css({
				color : 'red'
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
			marginTop : position.top + 15,
			marginLeft : position.left + 15
		}).show();
	}
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

var boxHightlight = false;
function boxHighlight(elem) {
	boxHighlightClear();
	var elements = '#sudoku #field td[id^=' + elem.id.charAt(0)
			+ '] div, #sudoku #field td[id$=' + elem.id.charAt(1)
			+ '] div, #sudoku #field td[class=' + $(elem).attr('class')
			+ '] div';
	$(elements).css({
		borderColor : 'yellow'
	});
	$('#sudoku #field td[id$=' + elem.id + '] div').css({
		borderColor : 'lawnGreen'
	});
}

function boxHighlightClear() {
	$('#sudoku #field td div').css({
		borderColor : 'inherit'
	});
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

function valueOver(elem) {
	$(elem).css({
		color : "red"
	});
}

function valueOut(elem) {
	$(elem).css({
		color : "inherit"
	});
}