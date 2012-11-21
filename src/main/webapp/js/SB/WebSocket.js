/**
 * @author Gutey Bogdan
 * 
 */
var userName;
var gameId;
var socket;
var lock;
var myDamagedSheeps = 0;
var flag = false;

$(document)
		.ready(
				function() {
					// console.log("WEBSOCKET");
					userName = $("#userName").attr("class");
					gameId = $("#gameID").attr("class");
					connectionType = $("#ConnectionType").attr("class");
					lock = $("#lock").attr("class");
					if (connectionType == "client"
							|| $("#oponent").attr("class") != undefined) {
						flag = true;
					}
					if (($("#bothStarted") == "true")
							&& (connectionType != lock)) {
						$("#locker").css("visibility", "hidden");
					} else {
						$("#locker").css("visibility", "visible");
					}

					socket = new WebSocket("ws://" + location.hostname
							+ ":8081");
					socket.onopen = function() {
						socket.send(gameId + "&" + userName + "&"
								+ connectionType);
						console
								.log("------------------------------Соединение открылось-----------------------------");
					};

					/*
					 * 
					 * 
					 * onMessage
					 * 
					 * 
					 */
					socket.onmessage = function(event) {

						if (event.data == "ready") {
							alert(event.data);
							if (connectionType == "client"
									|| $("#oponent").attr("class") != undefined) {
								flag = true;
							};
							alert($("#bothStarted").attr("class"));
							alert(connectionType);
							alert(lock);
							
							if (connectionType != lock) {
								$("#locker").css("visibility", "hidden");
							} else {
								// alert ("lock unocured " + lock);
								$("#locker").css("visibility", "visible");
							}
						} else if (event.data === 'kill') {
							victory();
						} else if (event.data === 'connected') {
							flag = true;
							if ((sheepCount.sheep1 + sheepCount.sheep2
									+ sheepCount.sheep3 + sheepCount.sheep4) <= 0) {
								$(".BSGo").css("visibility", "visible");
							}
						} else {
							var msg = JSON.parse(event.data);
							if (msg.sheep == "00") {
								$("#" + msg.point).attr("background",
										"images/SB/cant_be.png");
								lock = "";
							} else {
								lock = connectionType;
							}
							if (msg.sheep != "00") {
								$("#" + msg.point).attr("background",
										"images/SB/firePoint2.png");
								myDamagedSheeps++;
								if (myDamagedSheeps >= 20) {
									loose();
								}

							}

							if (connectionType != lock) {
								$("#locker").css("visibility", "hidden");
							} else {
								$("#locker").css("visibility", "visible");
							}
							console.log(event.data);
						}
					};
				});

function wtest(message) {
	socket.send(message);
};

function testWS() {
	$.get("Test.html");
}