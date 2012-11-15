var started = false;
var waitClientInterval;

function waitClient() {
	$('#outText p').text(msgWaitPlayer);
	waitClientInterval = setInterval(check, 1000);
	function check() {
		$.post('XOGetClient.html', function(resp) {
			if (resp.id != null) {
				clearInterval(waitClientInterval);
				$('#outText p').text(resp.name + msgConnected);
				$('#startButton').show();
				started = true;
			}
		});
	}
}

function startButtonClick() {
	$.post('XOGameStarted.html', function() {
		goTo(gameLink);
	});
}

function waitPageHomeButton() {
	if (started == true) {
		var bool = confirm(msgExit);
		if (bool == true) {
			clearInterval(waitClientInterval);
			$.post('XOLose.html', function(response) {
				homeButtonClick();
			});
		}
	} else {
		clearInterval(waitClientInterval);
		$.post('XOClear.html', function(response) {
			homeButtonClick();
		});
	}
}

function waitPageBackButton() {
	if (started == true) {
		var bool = confirm(msgExit);
		if (bool == true) {
			clearInterval(waitClientInterval);
			$.post('XOLose.html', function(response) {
				backButtonClick();
			});
		}
	} else {
		clearInterval(waitClientInterval);
		$.post('XOClear.html', function(response) {
			backButtonClick();
		});
	}
}