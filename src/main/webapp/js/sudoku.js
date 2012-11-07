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

var box;
function boxClick(elem) {
	if ($(elem).attr('class') == 'lockedBox') {
		$('#sudoku #value').hide();
	} else {
		this.box = elem;
		var position = $(elem).position();
		$('#sudoku #value').css({
			marginTop : position.top + 30,
			marginLeft : position.left + 30
		}).show();
	}
}

function boxOver(elem) {
//	var id = elem.id.charAt(0);
//	$('#sudoku #field td[id^=' + id + ']').css({
//		backgroundColor: 'lawnGreen'
//	});
//	id = elem.id.charAt(1);
//	$('#sudoku #field td[id$=' + id + ']').css({
//		backgroundColor: 'lawnGreen'
//	});
}

function boxOut(elem) {
//	$('#sudoku #field td').css({
//		backgroundColor: 'inherit'
//	});
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