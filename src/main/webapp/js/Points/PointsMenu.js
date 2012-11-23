$(document).ready(function() {

	$("#pts_menu_connect").mouseover(function() {
		$("#pts_menu_connect > img").attr('src', "images/Points/Connect2.png");
	});
	$("#pts_menu_connect").mouseout(function() {
		$("#pts_menu_connect > img").attr('src', "images/Points/Connect1.png");
	});
	$("#pts_menu_create").mouseover(function() {
		$("#pts_menu_create > img").attr('src', "images/Points/create.gif");
	});
	$("#pts_menu_create").mouseout(function() {
		$("#pts_menu_create > img").attr('src', "images/Points/Create1.png");
	});
	$("#pts_menu_statistics").mouseout(function() {
		$("#pts_menu_statistics > img").attr('src', "images/Points/statistics1.png");
	});
	$("#pts_menu_statistics").mouseover(function() {
		$("#pts_menu_statistics > img").attr('src', "images/Points/statistics2.png");
	});
	$("#pts_menu_rules").mouseover(function() {
		$("#pts_menu_rules > img").attr('src', "images/Points/rules2.png");
	});
	$("#pts_menu_rules").mouseout(function() {
		$("#pts_menu_rules > img").attr('src', "images/Points/rules1.png");
	});
	
	$('#pts_menu_connect').click(function() {
		goTo('PointsConnectList.html');
	});
	
});

function create() {
	$.get("PointsCreateGame.html", function(response) {
		// location.href = "PointsGame.html";
		goTo('PointsGame.html');
	});
}

function connect(game_Id) {
	$.post("PointsConnect.html", {
		gameId : game_Id
	}, function(response) {
		// location.href = "PointsGame.html";
		goTo('PointsGame.html');
	});
}
