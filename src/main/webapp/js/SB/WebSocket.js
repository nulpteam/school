
var userName;
var gameId;
var socket;


$(document).ready(function(){
	userName = $("#userName").attr("class");
	gameId = $('#gameID').attr("class");
	
	console.log(userName);
	console.log(gameId);
	
	socket = new WebSocket("ws://localhost:8081");
	socket.onopen = function () {
		  socket.send("777"+"&" + userName);
		  console.log("------------------------------Соединение открылось-----------------------------");
		};
		socket.onmessage = function (event) {
			  console.log ("Пришло сообщение с содержанием:", event.data);
		};
});
	

function wtest(message) {
	socket.send(message);
};