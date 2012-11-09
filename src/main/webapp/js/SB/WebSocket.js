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
			alert ("lock ocured");
			$("#locker").css("visibility", "visible");
	}
	
	
	socket = new WebSocket("ws://localhost:8081");
	socket.onopen = function () {
		  socket.send(gameId + "&" + userName+"&"+connectionType);
		  console.log("------------------------------Соединение открылось-----------------------------");
		};
		socket.onmessage = function (event) {
			  alert("Пришло сообщение с содержанием: " + event.data);
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

