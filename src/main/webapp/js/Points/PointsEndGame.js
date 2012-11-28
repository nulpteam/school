function goToMainMenu() {
	$.post("PointsClearPointsMenuSession.html", function(data) {
		goTo('Menu.html');
	});
}

function goToPointsMenu() {
	$.post("PointsClearPointsGameSession.html", function(data) {
		goTo('Points.html');
	});
}