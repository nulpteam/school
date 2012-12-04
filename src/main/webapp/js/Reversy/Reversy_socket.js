/**
 * @author SergiyManko
 */

var myName, gameId, player1, player2, myFigure, oppFigure, myGameView, nextMove;
$(document)
		.ready(
				function() {
					myName = $("#userName").attr("class");
					gameId = $("#gameID").attr("class");
					player1 = $("#player1").attr("class");
					player2 = $("#player1").attr("class");
					if (myName == player1) {
						myFigure = $("#figure1").attr("class");
						myGameView = $("#gameView1").attr("class");
					} else {
						myFigure = $("#figure2").attr("class");
						myGameView = $("#gameView2").attr("class");
					}
					nextMove = $("#nextMove").attr("class");
					socket = new WebSocket("ws://" + location.hostname
							+ ":8085");
					socket.onopen = function() {
						socket.send("connection&" + gameId + "&" + myName);
						console
								.log("------------------------------Opened Reversy socket!-----------------------------");
					};
					socket.onmessage = function(event) {
						var temp = event.data.split("&");
						if (temp[0] == "connected") {
							console.log(event.data);
							player2 = temp[1];
							oppFigure = temp[2];
							nextMove = temp[3];
							xs = 0;
							os = 0;
							for (var i = 1; i <= 64; i++) {
								x = String.fromCharCode(parseInt(((i - 1)/ 8 + 97)));
								y = (i - 1) % 8 +1;
								if ($("#" + x + y).attr("class") ==  "canX") {
									if (myFigure == "x") {
										$("#" + x + y).attr("onclick", "clickX(this.id)");
									} else {
										$("#" + x + y).attr("onclick", "");
									}
								} else if ($("#" + x + y).attr("class") ==  "canO") {
									if (myFigure == "o") {
										$("#" + x + y).attr("onclick", "clickO(this.id)");
									} else {
										$("#" + x + y).attr("onclick", "");
									}
								}
								if ($("#" + x + y).attr("class") ==  "x") {
									xs++;
								}
								if ($("#" + x + y).attr("class") ==  "o") {
									os++;
								}
							};
							$(".player1").html(player1 + " (" + myFigure + ") <div class='player1count'>" + xs + "</div>");
							$(".player2").html(player2 + " (" + oppFigure + ") <div class='player2count'>" + os + "</div>");
						} else {
							if (temp[0] == "changes") {
								$.post("changes.html", {
									gameID : $("#gameID").attr("class")
								}, function(data) {
									
								});
								//TODO
								xs = 0;
								os = 0;
								nextMove = temp[2];
								for (var i = 1; i <= 64; i++) {
									x = String.fromCharCode(parseInt(((i - 1)/ 8 + 97)));
									y = (i - 1) % 8 +1;
									$("#" + x + y).attr("class", temp[i + 2]);
									if (temp[i + 2] == "canX") {
										if (myFigure == "x") {
											$("#" + x + y).attr("onclick", "clickX(this.id)");
										} else {
											$("#" + x + y).attr("onclick", "");
										}
									}
									if (temp[i + 2] == "canO") {
										if (myFigure == "o") {
											$("#" + x + y).attr("onclick", "clickO(this.id)");
										} else {
											$("#" + x + y).attr("onclick", "");
										}
									}
									if ((temp[i + 2] != "canO")&&(temp[i + 2] != "canX")) {
										$("#" + x + y).attr("onclick", "");
									}
									if ($("#" + x + y).attr("class") ==  "x") {
										xs++;
									}
									if ($("#" + x + y).attr("class") ==  "o") {
										os++;
									}
								};
								$(".player1count").text(xs);
								$(".player2count").text(os);
								//TODO game end
								if (nextMove == "end") {
									if (myFigure == "x") {
										if (xs > os) {goTo("Victory.html");}
										if (xs < os) {goTo("Loose.html");}
										if (xs == os) {goTo("Nichya.html");}
									}
									if (myFigure == "o") {
										if (xs > os) {goTo("Victory.html");}
										if (xs < os) {goTo("Loose.html");}
										if (xs == os) {goTo("Nichya.html");}
									}
								}
							};
						};
					};
				});