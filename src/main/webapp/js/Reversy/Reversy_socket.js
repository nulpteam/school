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
							console.log(event.data);
						} else {
							var temp = event.data.split(" ");
							if (temp[0] == "changes") {
								console.log(event.data);
								$.post("changes.html", {
									gameID : $("#gameID").attr("class")
								}, function(data) {
									
								});
								//TODO
								for (var i = 1; i <= 64; i++) {
									x = String.fromCharCode(parseInt(((i - 1)/ 8 + 97)));
									y = (i - 1) % 8 +1;
									console.log(x + y);
									$("#" + x + y).attr("class", temp[i]);
									if (temp[i] == "canX") {
										$("#" + x + y).attr("onclick", "clickX(this.id)");
									} else if (temp[i] == "canO") {
										$("#" + x + y).attr("onclick", "clickO(this.id)");
									} else {
										$("#" + x + y).attr("onclick", "");
									}
								};
							};
						};
					};
				});