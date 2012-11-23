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
					userName = $("#userName").attr("class");
					gameId = $("#gameID").attr("class");
					connectionType = $("#ConnectionType").attr("class");
					lock = $("#lock").attr("class");
					
					console.log("********************************* info connectionType bothStarted lock ++++++++++++++++++++++++++++++");
					console.log(connectionType);
					console.log($("#bothStarted").attr("class"));
					console.log(lock);
					console.log("********************************* info ++++++++++++++++++++++++++++++");
					if (connectionType == "client"
							|| $("#oponent").attr("class") != "" ) {
						console.log(connectionType);
						console.log($("#oponent").attr("class"));
						
						flag = true;
					}
					if (($("#bothStarted").attr("class") == "true")
							&& (connectionType != lock)) {
						$("#locker").css("visibility", "hidden");
					} else {
						$("#locker").css("visibility", "visible");
					}

					socket = new WebSocket("ws://" + location.hostname
							+ ":8081");
					socket.onopen = function() {
						socket.send("open&" + gameId + "&" + userName + "&"
								+ connectionType);
						console
								.log("------------------------------Соединение открылось-----------------------------");
						
					};
					socket.onclose = function() {
						alert("onclose");
						mess = "close&";
						for ( var i = 0; i < 10; i++) {
							for ( var j = 0; j < 10; j++) {
								mess = mess + $("#" + i + j).css("background-image") + "&" + $("#X" + i + "_Y" + j).css("background-image") + "&" + $("#X" + i + "_Y" + j).attr("onclick") + "&";
							}
						}
//						console.log(mess);
					};

					/*
					 * 
					 * 
					 * onMessage
					 * 
					 * 
					 */
					socket.onmessage = function(event) {
						console.log("********************************* on message ++++++++++++++++++++++++++++++");
						console.log(event.data);
						console.log("********************************* on message ++++++++++++++++++++++++++++++");
						
						if (event.data == "ready") {
							if (connectionType == "client") {
								flag = true;
							};
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
								$("#" + msg.point).css("background-image", "url('images/SB/cant_be.png')");
								lock = "";
							} else {
								lock = connectionType;
							}
							if (msg.sheep != "00") {
								$("#" + msg.point).css("background-image", "url('images/SB/cant_be.png')");
								myDamagedSheeps++;
								if (myDamagedSheeps >= 20) {
									loose();
								};

							}

							if (connectionType != lock) {
								$("#locker").css("visibility", "hidden");
							} else {
								$("#locker").css("visibility", "visible");
							}
							console.log(event.data);
						};
					};
				});

function wtest(message) {
	socket.send(message);
};

function testWS() {
	$.get("Test.html");
}