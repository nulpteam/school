$(document).ready(function() {
	$('#connect').click(function() {
		alert("Connect");
		location.href = "PointsConnect.html";
	});
});

function create() {
	$.get("PointsCreateGame.html", function(response) {
		location.href = "PointsGame.html";
	});

}