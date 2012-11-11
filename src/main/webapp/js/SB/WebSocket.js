/**
 * @author Gutey Bogdan
 * 
 */
var userName;
var gameId;
var socket;
var lock;


$(document).ready(function(){
	console.log("WEBSOCKET");
	userName = $("#userName").attr("class");
	gameId = $("#gameID").attr("class");
	connectionType = $("#ConnectionType").attr("class");
	lock = $("#lock").attr("class");
	
	console.log(userName);
	console.log(gameId);
	console.log(connectionType);
	console.log(lock);
	
	//lock
	if (connectionType!=lock)
	{
//			alert ("lock ocured " + lock);
			$("#locker").css("visibility", "hidden");
			
	} else {
//		alert ("lock unocured " + lock);
		$("#locker").css("visibility", "visible");
	}
	
	
	
	
	socket = new WebSocket("ws://localhost:8081");
	socket.onopen = function () {
		  socket.send(gameId + "&" + userName+"&"+connectionType);
		  console.log("------------------------------Соединение открылось-----------------------------");
		};
	socket.onmessage = function (event) {
			var msg = JSON.parse(event.data);
			if (msg.sheep == "00") {
//				alert("msg.sheep: " + msg.sheep);
				lock = "";
			} else {
//				alert("msg.sheep: " + msg.sheep);
				lock = connectionType;
			}
			if (msg.sheep == "10") {
//				alert("одиничку вбили нахуй!" + msg.sheep);
			}
			
			if (connectionType!=lock) {			
//					alert ("lock ocured " + lock);
					$("#locker").css("visibility", "hidden");
			} else {
//				alert ("lock unocured " + lock);
				$("#locker").css("visibility", "visible");
			}
//			  alert("Пришло сообщение с содержанием: " + event.data);
			  console.log(event.data);
	};
});
	

function wtest(message) {
	socket.send(message);
};


function testWS()
{
	$.get("Test.html"); 
}

