function createServer() {
	$.post("XOClear.html", function(response) {
		location.href = "XOGameServer.html";
	});
}

function connect(id) {
	$.post("XOClear.html", function(response) {
		location.href = "XOGameClient.html?serverID=" + id;
	});
}