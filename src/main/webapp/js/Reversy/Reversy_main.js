/**
 * @author SergiyManko
 */

function clickX(id) {
	 $.post("move.html", {
     	gameID : $("#gameID").attr("class"),
 		x : parseInt(id.charCodeAt(0))-97,
 		y : parseInt(id[1]-1),
 		figure : "x",
 		playerName : $("#userName").attr("class")
 	}, function(data) {
 	});
};
function clickO(id) {
	$.post("move.html", {
    	gameID : $("#gameID").attr("class"),
		x : parseInt(id.charCodeAt(0))-97,
		y : parseInt(id[1]-1),
		figure : "o",
		playerName : $("#userName").attr("class")
	}, function(data) {
	});
};
/*
 * games
 */
function connectGame(id) {
	$.post("ReversyConnectGame.html", {gameID: id},
		function(response) {
			if (response === "true") {
				goTo("Reversy.html");
			}
		}
	);
};
/*
 * menu
 */
function goToList(ID) {
	goTo("ReversyGamesList.html");
};

function goToRules() {
	goTo("ReversyRules.html");
};

function create() {
	$.post("ReversyCreateGame.html", 
			function(response) {
					goTo("Reversy.html");
			});
};