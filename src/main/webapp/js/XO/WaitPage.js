var started = false;

function waitClient() {
	$('#outText p').text(msg3);
	var inter1 = setInterval(check, 1000);
	function check() {
		$.post('XOGetClient.html', function(response) {
			if (response.id != null) {
				clearInterval(inter1);
				$('#outText p').text(response.name + msg4);
				$('#startButton').show();
				started = true;
			}
		});
	}
}

function startButtonClick() {
	location.href = 'XOGame.html';
}

function waitPageHomeButton() {
	if (started) {
		var bool = confirm(msg2);
		if (bool) {
			$.post('XOLose.html', function(response) {
				location.href = 'index.html';
			});
		}
	} else {
		$.post('XOClear.html', function(response) {
			location.href = 'index.html';
		});
	}
}

function waitPageBackButton() {
	if (started) {
		var bool = confirm(msg2);
		if (bool) {
			$.post('XOLose.html', function(response) {
				location.href = 'XO.html';
			});
		}
	} else {
		$.post('XOClear.html', function(response) {
			location.href = 'XO.html';
		});
	}
}