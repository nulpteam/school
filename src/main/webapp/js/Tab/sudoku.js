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
		getFailed();
	});
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
	} else {
		boxHighlight(elem.parentNode);
		boxHightlight = true;
		
		this.box = elem;
		var position = $(elem).position();
		$('#sudoku #value').css({
			marginTop : position.top + 30,
			marginLeft : position.left + 30
		}).show();
	}
}

function boxOver(elem) {
	if (boxHightlight == false) {
		boxHighlight(elem);
	}
}

function fieldOut(){
	if (boxHightlight == false) {
		boxHighlightClear();
	}
}

var boxHightlight = false;
function boxHighlight(elem){
	boxHighlightClear();
	var id = elem.id.charAt(0);
	$('#sudoku #field td[id^=' + id + '] div').css({
		borderColor: 'gold'
	});
	id = elem.id.charAt(1);
	$('#sudoku #field td[id$=' + id + '] div').css({
		borderColor: 'gold'
	});
	$('#sudoku #field td[class=' + $(elem).attr('class') + '] div').css({
		borderColor: 'gold'
	});
	$('#sudoku #field td[id$=' + elem.id + '] div').css({
		borderColor: 'lawnGreen'
	});
}

function boxHighlightClear() {
	$('#sudoku #field td div').css({
		borderColor: 'inherit'
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
	boxHightlight = false;
	boxHighlightClear();
}

function valueOver(elem) {
	$(elem).css({
		color : "red"
	});
}

function valueOut(elem) {
	$(elem).css({
		color : "black"
	});
}