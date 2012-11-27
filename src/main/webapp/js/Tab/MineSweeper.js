function msPut(elem) {
	$.post('MSPut.html', {
		id : elem.id
	}, function(resp) {
		if (resp == true) {
			alert("game over you lose");
		} else {
			msRefresh();
		}
	});
}

function msLock(elem) {
	if ($(elem).attr('class') == 'unVisible') {
		$.post('MSLock.html', {
			id : elem.parentNode.id
		}, function(resp) {
			if (resp == true) {
				alert("game over you win");
			} else {
				$(elem).attr('class', 'locked');
			}
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
				if (resp[i][j].visible == true) {
					$('#mine #' + i + j + " div").attr('class', 'visible');
					$('#mine #' + i + j + " div").text(resp[i][j].minesAround);
				} else {
				}
			}
		}
	});
}

function msStart() {
	$('#msField td div').each(function() {
		$(this).bind("contextmenu", function(e) {
			e.preventDefault();
			msLock(this);
		});
	});
}