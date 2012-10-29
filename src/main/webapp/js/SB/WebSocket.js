var socket;
function go()
{
	socket = new WebSocket("ws://localhost:8081");
	socket.onopen = function () {
		  console.log("Соединение открылось");
		};
		socket.onmessage = function (event) {
			  console.log ("Пришло сообщение с содержанием:", event.data);
			};

}
	

function wtest(message)
{
	socket.send(message);
}