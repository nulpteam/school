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
					player2 = $("#player2").attr("class");
					console.log(player1);
					console.log(player2);
					if (myName == player1) {
						myFigure = $("#figure1").attr("class");
						myGameView = $("#gameView1").attr("class");
					} else {
						myFigure = $("#figure2").attr("class");
						myGameView = $("#gameView2").attr("class");
					}
					nextMove = $("#nextMove").attr("class");
					if (nextMove != player1) {
						$(".player1").css("opacity", "0.6");
					} else {
						$(".player1").css("opacity", "1");
					}
					if (nextMove != player2) {
						$(".player2").css("opacity", "0.6");
					} else {
						$(".player2").css("opacity", "1");
					}
						if ((player1 != "") && (player2 != "") && (nextMove == myName)) {
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
							};
						}
					socket = new WebSocket("ws://" + location.hostname
							+ ":8085");
					socket.onopen = function() {
						socket.send("connection&" + gameId + "&" + myName);
						console
								.log("------------------------------Opened Reversy socket!-----------------------------");
					};
					socket.onmessage = function(event) {
						var temp = event.data.split("&");
						if (event.data == "surrender") {
							if (myName == player1) {
								victory(player1, 64, player2, 0);
							}
							if (myName == player2) {
								victory(player1, 0, player2, 64);
							}
						}
						if (temp[0] == "connected") {
							console.log(event.data);
							player2 = temp[1];
							oppFigure = temp[2];
							nextMove = temp[3];
							xs = 0;
							os = 0;
							if (nextMove != player1) {
								$(".player1").css("opacity", "0.6");
							} else {
								$(".player1").css("opacity", "1");
							}
							if (nextMove != player2) {
								$(".player2").css("opacity", "0.6");
							} else {
								$(".player2").css("opacity", "1");
							}
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
								xs = 0;
								os = 0;
								nextMove = temp[2];
								if (nextMove != player1) {
									$(".player1").css("opacity", "0.6");
								} else {
									$(".player1").css("opacity", "1");
								}
								if (nextMove != player2) {
									$(".player2").css("opacity", "0.6");
								} else {
									$(".player2").css("opacity", "1");
								}
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
								if (nextMove == "end") {
									if (myFigure == "x") {
										if (xs > os) {
											victory(player1, xs, player2, os);
										}
										if (xs < os) {
											defeat(player1, xs, player2, os);
										}
										if (xs == os) {
											draw(player1, xs, player2, os);
										}
									}
									if (myFigure == "o") {
										if (xs < os) {
											victory(player1, xs, player2, os);
										}
										if (xs > os) {
											defeat(player1, xs, player2, os);
										}
										if (xs == os) {
											draw(player1, xs, player2, os);
										}
									}
								}
							};
						};
					};
				});