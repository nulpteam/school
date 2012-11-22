$(document).ready(function() {
	userAgent = navigator.userAgent;
	//
	bsound = new Audio;
	
	if( userAgent.indexOf("Chrome")!=-1 )
	{
		bsound.src = "sound/Infection/pageTurn.mp3";
	}

	if( userAgent.indexOf("Firefox")!=-1)
	{
		bsound.src = "sound/Infection/pageTurn.mp3";
	}
	bsound.loop=false;
});


function create(){
	startbsound();
	$.get("InfectionCreateGame.html", function(response) {
		//location.href = "InfectionGame.html";
		goTo('InfectionGame.html');
	});
}

function connect(game_Id) {
	startbsound();
	$.post("InfectionConnect.html", { gameId : game_Id }, function(response) {
		//location.href = "InfectionGame.html";
		goTo('InfectionGame.html');
	});	
}

function getConnectionList(){
	startbsound();
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

function startbsound(){
	bsound.volume=0.9;
	bsound.play();
}



