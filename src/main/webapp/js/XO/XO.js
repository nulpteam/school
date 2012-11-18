var menuLink = 'XOMenu.html';
var createLink = 'XOCreate.html';
var serverListLink = 'XOServerList.html';
var statisticsLink = 'XOStatistics.html';
var gameLink = 'XOGame.html';

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

function backButtonClick() {
	goTo(menuLink);
}