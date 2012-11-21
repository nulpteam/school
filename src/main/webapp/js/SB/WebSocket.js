/**
 * @author Gutey Bogdan
 * 
 */
var userName;
var gameId;
var socket;
var lock;
var myDamagedSheeps = 0;
var flag=false;

$(document).ready(function(){
//	console.log("WEBSOCKET");
	userName = $("#userName").attr("class");
	gameId = $("#gameID").attr("class");
	connectionType = $("#ConnectionType").attr("class");
	lock = $("#lock").attr("class");
	console.log($("#oponent").attr("class"));
	console.log(connectionType);
	if(connectionType=="client" || $("#oponent").attr("class")!="")
	{
		flag=true;
	}
	if (($("#bothStarted") == "true") && (connectionType!=lock)) {
		$("#locker").css("visibility", "hidden");
	}
	
//	console.log(userName);
//	console.log(gameId);
//	console.log(connectionType);
//	console.log(lock);
	
	//lock
	if (connectionType!=lock)
	{
//			alert ("lock ocured " + lock);
			$("#locker").css("visibility", "hidden");
			
	} else {
//		alert ("lock unocured " + lock);
		$("#locker").css("visibility", "visible");
	}
	
	
	
	
	socket = new WebSocket("ws://"+location.hostname+":8081");
//	console.log(location.hostname);
	socket.onopen = function () {
		  socket.send(gameId + "&" + userName+"&"+connectionType);
		  console.log("------------------------------Соединение открылось-----------------------------");
		};
	socket.onmessage = function (event) {
		if(event.data==='kill')
		{
//			alert('kill');
			victory();
//			goTo2("SbKill.html",connectionType);
		}
		else if(event.data==='connected')
		{
			flag=true;
			if((sheepCount.sheep1 + sheepCount.sheep2 + sheepCount.sheep3 + sheepCount.sheep4) <= 0)
			{
				$(".BSGo").css("visibility", "visible");
			}
		}
		else
		{
			var msg = JSON.parse(event.data);
			if (msg.sheep == "00") {
				$("#" + msg.point).attr("background", "images/SB/cant_be.png");
//				alert("msg.sheep: " + msg.sheep);
				lock = "";
			} else {
//				alert("msg.sheep: " + msg.sheep);
				lock = connectionType;
			}
			if (msg.sheep != "00") {
				$("#" + msg.point).attr("background", "images/SB/firePoint2.png");
				myDamagedSheeps++;
				if (myDamagedSheeps >= 20) {
					loose();
				}
				
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
		}
	};
});
	

function wtest(message) {
	socket.send(message);
};


function testWS()
{
	$.get("Test.html"); 
}