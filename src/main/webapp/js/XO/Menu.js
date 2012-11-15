var menuLink = 'XOMenu.html';
var createLink = 'XOCreate.html';
var serverListLink = 'XOServerList.html';
var statisticsLink = 'XOStatistics.html';
var gameLink = 'XOGame.html';

function goTo(link) {
	$.post(link, function(resp) {
		$('.paperList').remove();
		$('.page').append(resp);
	});
}

function connect(id) {
	if (id == myId) {
		alert(msgYourSelf);
	} else {
		$.post("XOConnect.html", {
			serverID : id
		}, function(response) {
			if (response == true) {
				goTo(gameLink);
			}
		});
	}
}

function homeButtonOver(elem) {
	$(elem).css({
		backgroundImage : 'url("images/XO/home1.png")'
	});
}

function homeButtonOut(elem) {
	$(elem).css({
		backgroundImage : 'url("images/XO/home.png")'
	});
}

function homeButtonClick() {
	location.href = "index.html";
}

function backButtonOver(elem) {
	$(elem).css({
		backgroundImage : 'url("images/XO/back1.png")'
	});
}

function backButtonOut(elem) {
	$(elem).css({
		backgroundImage : 'url("images/XO/back.png")'
	});
}

function backButtonClick() {
	goTo(menuLink);
}

function refreshButtonOver(elem) {
	$(elem).css({
		backgroundImage : 'url("images/XO/refresh1.png")'
	});
}

function refreshButtonOut(elem) {
	$(elem).css({
		backgroundImage : 'url("images/XO/refresh.png")'
	});
}

function refreshButtonClick() {
	goTo('XOCurrentPos.html');
}