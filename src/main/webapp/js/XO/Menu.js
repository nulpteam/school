function createServerButton() {
	location.href = "XOCreate.html";
}

function serverListButton() {
	location.href = "XOServerList.html";
}

function statisticsButton() {
	location.href = "XOStatistics.html";
}

function connect(id) {
	if (id == myID) {
		alert(msg1);
	} else {
		$.post("XOConnect.html", {
			serverID : id
		}, function(response) {
			if (response) {
				location.href = "XOGame.html";
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
	location.href = "XO.html";
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
	location.reload();
}