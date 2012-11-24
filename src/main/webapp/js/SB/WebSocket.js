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
var save = $("#mess").attr("class");

//$(window).on("beforeunload", sendMess());


$(document)
		.ready(
				function() {
					if (save != undefined) {
						getMess();
					}
					
					
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
						console.log("socket.onclose");
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
								sendMess();
								$("#" + msg.point).css("background-image", "url('images/SB/cant_be.png')");
								$("#" + msg.point).attr("class", "cant_be.png");
								lock = "";
							} else {
								lock = connectionType;
							}
							if (msg.sheep != "00") {
								$("#" + msg.point).css("background-image", "url('images/SB/cant_be.png')");
								$("#" + msg.point).attr("class", "cant_be.png");
								myDamagedSheeps++;
								sendMess();
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

function sendMess() {
	mess = "close&" + damagedSheep + "&" + myDamagedSheeps + "&";
	for ( var i = 0; i < 10; i++) {
		for ( var j = 0; j < 10; j++) {
			if ($("#" + i + j).css("background-image") != undefined) {
				c = $("#X" + i + "_Y" + j).attr("onclick");
				if ($("#" + i + j).attr("class") == "cant_be.png") {
					a = "url('images/SB/cant_be.png')";
				} else a = "none";
				
				if (c == "allreadyShooted();") {
					b = "url('images/SB/missPoint3.png')";
				}
				if (c == "allreadyDamaged();") {
					b = "url('images/SB/firePoint3.png')";
				}
				if (c == "cantBe()") {
					b = "url('images/SB/cant_be.png')";
				}
				if (c == "fire(this)") {
					b = "none";
				}
				mess = mess + a + "&" + b + "&" + c + "&";
			}
		}
	}
	console.log(mess);
	$.post("mess.html", {mess : mess}, function() {
		
	});
}

function getMess() {
	if (save != undefined) {
		arr = save.split("&");
		count = 0;
		if (arr[0] == "close") {
			count++;
			damagedSheep = parseInt(arr[count]);
			count++;
			myDamagedSheeps = parseInt(arr[count]);
			for ( var i = 0; i < 10; i++) {
				for ( var j = 0; j < 10; j++) {
					count++;
					$("#" + i + j).css("background-image", arr[count]);
					if (arr[count] == "url('images/SB/cant_be.png')") {
						$("#" + i + j).attr("class", "cant_be.png");
					}
					count++;
					$("#X" + i + "_Y" + j).css("background-image", arr[count]);
					count++;
					$("#X" + i + "_Y" + j).attr("onclick", arr[count]);
				}
			}
		}
	}
}

function sayHi() {
	alert("hi!");
}