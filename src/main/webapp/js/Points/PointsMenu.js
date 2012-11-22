$(document).ready(function() {
	$('#connect').click(function() {
		//location.href = "PointsConnectList.html";
		goTo('PointsConnectList.html');
	});
});

function create() {
	$.get("PointsCreateGame.html", function(response) {
		//location.href = "PointsGame.html";
		goTo('PointsGame.html');
	});
}
	
function connect(game_Id) {
	$.post("PointsConnect.html", { gameId : game_Id }, function(response) {
		//location.href = "PointsGame.html";
		goTo('PointsGame.html');
	});	
}
