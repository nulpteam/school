var locked = false;

function msPut(elem) {
	if (locked == true) {
		return;
	}
	$.post('MSOpen.html', {
		id : elem.id
	}, function(resp) {
		msChange(resp, $('#mineSweeper #' + elem.id + ' div'));
		msRefresh();
		msGetStatus();
	});
}

function msLock(elem) {
	if (locked == true) {
		return;
	}
	if ($(elem).attr('class') == 'unVisible') {
		$.post('MSLock.html', {
			id : elem.parentNode.id
		}, function(resp) {
			$(elem).attr('class', 'locked');
		});
	} else if ($(elem).attr('class') == 'locked') {
		$.post('MSLock.html', {
			id : elem.parentNode.id
		}, function(resp) {
			$(elem).attr('class', 'unVisible');
		});
	}
}

function msRefresh() {
	$.post('MSRefresh.html', function(resp) {
		for ( var i = 0; i < resp.length; i++) {
			for ( var j = 0; j < resp[i].length; j++) {
				msChange(resp[i][j], $('#mineSweeper #' + i + j + " div"));
			}
		}
	});
}

function msChange(box, $elem) {
	if (box.visible == true) {
		if (box.mine == true) {
			$elem.attr('class', 'mine');
		} else {
			$elem.attr('class', 'visible');
			if (box.minesAround > 0) {
				$elem.text(box.minesAround);
			}
		}
	}
}

function msGetStatus() {
	$.post('MSGetStatus.html', function(resp) {
		if (resp.win == true) {
			locked = true;
			alert("WIN !!!!!!!!!");
		} else if (resp.loose == true) {
			locked = true;
			alert("LOOSE !!!!!!!!");
		}
	});
}

function msStart() {
	$('#mineSweeper #msField td div').each(function() {
		$(this).bind("contextmenu", function(e) {
			e.preventDefault();
			msLock(this);
		});
	});
}