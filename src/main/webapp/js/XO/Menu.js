function buttonCreateServer() {
	location.href = "XOCreate.html";
}

function buttonServerList() {
	location.href = "XOServerList.html";
}

function buttonStatistics() {
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
	location.href = "XO.html";
}