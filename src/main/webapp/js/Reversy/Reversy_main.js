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
			} else {
				goTo("ReversyGamesList.html");
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
/*
 * game end
 */
function victory(player1, xs, player2, os) {
	console.log("victory", player1, xs, player2, os);
	$.post("end.html", {
		player1 : player1,
		xs : xs,
		player2 : player2,
		os : os
	}, function(data) {
		goTo("ReversyVictory.html");
	});
}
function defeat(player1, xs, player2, os) {
	console.log("defeat", player1, xs, player2, os);
	$.post("end.html", {
		player1 : player1,
		xs : xs,
		player2 : player2,
		os : os
	}, function(data) {
		goTo("ReversyDefeat.html");
	});
}
function draw(player1, xs, player2, os) {
	console.log("draw", player1, xs, player2, os);
	$.post("end.html", {
		player1 : player1,
		xs : xs,
		player2 : player2,
		os : os
	}, function(data) {
		goTo("ReversyDraw.html");
	});
}
function surrender(gameID) {
	console.log("surrender", gameID, myName);
	$.post("ReversySurrender.html", {
		gameID : gameID,
		playerName : myName,
	}, function(data) {
		if (myName == player2) {
			defeat(player1, 64, player2, 0);
		}
		if (myName == player1) {
			defeat(player1, 0, player2, 64);
		}
	});
}



