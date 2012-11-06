var id;

function startSudoku() {
	getFailed();
}

function newGame() {
	$.post('SudokuNewGame.html', function(resp) {
		var i = 0;
		$('#field .box').each(function() {
			if (resp[i] == 0) {
				$(this).text('');
			} else {
				$(this).text(resp[i]);
			}
			i++;
		});
		getFailed();
	});
}

function boxClick(elem) {
	this.id = elem.id;
	var position = $('#sudoku #' + elem.id).position();
	// alert('top=' + position.top + ' left=' + position.left + ' id=' +
	// elem.id);
	$('#sudoku #value').css({
		marginTop : position.top + 30,
		marginLeft : position.left + 30
	}).show();
}

function valueClick(value) {
	$.post('SudokuPut.html', {
		id : id,
		value : value
	}, function(resp) {
		if (resp) {
			if (value == 0) {
				$('#sudoku #' + id).text('');
			} else {
				$('#sudoku #' + id).text(value);
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
		$('#sudoku .box').css({
			color : 'blue'
		});
		for ( var i = 0; i < resp.length; i++) {
			var id = "" + resp[i].line + resp[i].colum;
			$('#sudoku #' + id).css({
				color : 'red'
			});
		}
	});
}