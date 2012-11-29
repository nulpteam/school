/**
 * @author SergiyManko
 */
var userName, gameId;
$(document)
		.ready(
				function() {
					userName = $("#userName").attr("class");
					gameId = $("#gameID").attr("class");
					socket = new WebSocket("ws://" + location.hostname
							+ ":8085");
					socket.onopen = function() {
						socket.send("connection&" + gameId + "&" + userName);
						console
								.log("------------------------------Opened Reversy socket!-----------------------------");
					};
					socket.onmessage = function(event) {
						if (event.data == "connected") {
							alert(event.data);
						};
						if (event.data == "changes") {
							alert(event.data);
							$.post("changes.html", {
								gameID : $("#gameID").attr("class")
							}, function(data) {
								location.reload();
							});
						};
						
					};
				});