function createServer() {
	$.post("XOCreate.html", function(response) {
		if (response) {
			location.href = "XOGame.html";
		}
	});
}

function serverListPage() {
	location.href = "XOServerList.html";
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

function returnToMenu() {
	location.href = "XO.html";
}