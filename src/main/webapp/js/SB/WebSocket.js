var socket;
$(document).ready(function(){
//	socket = new WebSocket("ws://localhost:8081");
//	socket.onopen = function () {
//		  console.log("------------------------------Соединение открылось-----------------------------");
//		  socked.send("connection created)");
//		};
//		socket.onmessage = function (event) {
//			  console.log ("Пришло сообщение с содержанием:", event.data);
//		};
	alert("ready");
});
	

function wtest(message) {
	socket.send(message);
};