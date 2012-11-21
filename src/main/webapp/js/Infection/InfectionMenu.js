//$(document).ready(function() {
//	$('#connect').click(function() {
//		location.href = "InfectionConnectList.html";
//		//goTo('InfectionConnectList.html');
//	});
//});


function create(){
	$.get("InfectionCreateGame.html", function(response) {
		//location.href = "InfectionGame.html";
		goTo('InfectionGame.html');
	});
}

function connect(game_Id) {
	$.post("InfectionConnect.html", { gameId : game_Id }, function(response) {
		//location.href = "InfectionGame.html";
		goTo('InfectionGame.html');
	});	
}

function getConnectionList(){
			goTo('InfectionConnectList.html');
}

function PageHomeButton(){
	goTo('Infection.html');
}

function gameRefreshButton() {
	clearInterval(checkerInterval);
	clearInterval(timerInterval);
	refreshButtonClick();
}





