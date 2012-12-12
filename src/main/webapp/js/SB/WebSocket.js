/**
 * @author Gutey Bogdan
 * 
 */

var userName, gameId, socket, lock, myDamagedSheeps = 0, socketFlag=false, flag = false, save = $("#mess").attr("class");



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
					if (connectionType == "client"
							|| $("#oponent").attr("class") != "" ) {
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
						socketFlag = true;
						socket.send("open&" + gameId + "&" + userName + "&"
								+ connectionType);
					};
					socket.onclose = function() {
					socketFlag=false;
					};
					socket.onmessage = function(event) {
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
								$("#sb_game_1 #" + msg.point).css("background-image", "url('images/SB/cant_be.png')");
								$("#sb_game_1 #" + msg.point).attr("class", "cant_be.png");
								sendMess();
								lock = "";
							} else {
								lock = connectionType;
							}
							if (msg.sheep != "00") {
								$("#sb_game_1 #" + msg.point).css("background-image", "url('images/SB/cant_be.png')");
								$("#sb_game_1 #" + msg.point).attr("class", "cant_be.png");
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
				mess = mess + a + "&" + /*b + "&" + */c + "&";
			}
		}
	}
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
					$("#sb_game_1 #" + i + j).css("background-image", arr[count]);
					if (arr[count] == "url('images/SB/cant_be.png')") {
						$("#sb_game_1 #" + i + j).attr("class", "cant_be.png");
					}
					count++;
					$("#X" + i + "_Y" + j).attr("onclick", arr[count]);
					if ($("#X" + i + "_Y" + j).attr("onclick") == "allreadyShooted();") {
						$("#X" + i + "_Y" + j).css("background-image", "url('images/SB/missPoint3.png')");
						$("#X" + i + "_Y" + j).attr("class", "none");
					}
					if ($("#X" + i + "_Y" + j).attr("onclick") == "allreadyDamaged();") {
						$("#X" + i + "_Y" + j).css("background-image", "url('images/SB/firePoint3.png')");
						$("#X" + i + "_Y" + j).attr("class", "none");
					}
					if ($("#X" + i + "_Y" + j).attr("onclick") == "cantBe()") {
						$("#X" + i + "_Y" + j).css("background-image", "url('images/SB/cant_be.png')");
						$("#X" + i + "_Y" + j).attr("class", "none");
					}
				}
			}
		}
	}
}