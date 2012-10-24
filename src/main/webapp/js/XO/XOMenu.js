function createServer() {
	$.post("XOClear.html", function(response) {
		location.href = "XOGameServer.html";
	});
}

function serverListPage() {
	location.href = "XOServerList.html";
}

function connect(id) {
	if (id == myID) {
		alert(msg1);
	} else {
		$.post("XOClear.html", function(response) {
			location.href = "XOGameClient.html?serverID=" + id;
		});
	}
}

function returnToMenu() {
	location.href = "XO.html";
}