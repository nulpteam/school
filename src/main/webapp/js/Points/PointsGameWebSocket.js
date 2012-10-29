var changes;
var waitingForClient;
var socket;

// TODO таски 1.замутити промальовку гри при рефреші
// 2.логіка самої гри!!!!!!!!!!!!!!
//

$(document).ready(function() {

	socket = new WebSocket("ws://localhost:8082");
	socket.onopen = function() {
		console.log("open socket");
	};
	socket.onmessage = function(event) {
		var eventData = event.data;
		console.log(eventData);
		var msg = JSON.parse(event.data);
		switch (msg.type) {
		case "message":
			console.log(msg.userThatChanged);
			console.log(msg.coordsOfChanges);
			break;
		}
	};

	// waitingForClient = setInterval(waitForClient, 1000);
	// if ($('#div_table').attr('type') == "client") {
	// waitForFirstMove();
	// }

});

function sendMessage() {
	console.log("send message");
	socket.send("1234");
}

// function waitForFirstMove() {
// changes = setInterval(getChanges, 1000);
// }
//
// function waitForClient() {
// $.get("WaitingForClient.html", function(response) {
// if (response == '') {
// $('#player_label_2 > label').text("WAITING");
// } else {
// $('#player_label_2 > label').text(response);
// clearInterval(waitingForClient);
// }
// });
// }
//
// function check() {
// $.get("PointCheck.html", function(lastChanges) {
//
// });
// }

// function put(td_point) {
//
// $.post("PointPut.html", {
// point_xy : td_point.id
// }, function(response) {
// if (response == 'server') {
// $('#' + td_point.id + ' > img').attr('src',
// 'images/Points/point1.png');
// } else {
// $('#' + td_point.id + ' > img').attr('src',
// 'images/Points/point2.png');
// }
// });
// console.log("waiting for changes");
// changes = setInterval(getChanges, 1000);
//
// }
//
// function getChanges() {
//
// $.get("PointsGetChanges.html", function(lastChanges) {
// if (lastChanges.coordsOfChanges != 'none') {
//
// if (lastChanges.userThatChanged == 'server') {
//
// $('#' + lastChanges.coordsOfChanges + ' > img').attr('src',
// 'images/Points/point1.png');
//
// } else {
//
// $('#' + lastChanges.coordsOfChanges + ' > img').attr('src',
// 'images/Points/point2.png');
//
// }
// clearInterval(changes);
// }
//
// });
//
// }
//
// function putPoint(td_point) {
//
// $.get("PointCheckMove.html", function(boolMove) {
// if (boolMove == false) {
// alert("not your move");
// } else {
// put(td_point);
// }
// });
//
// }
