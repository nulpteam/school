var game, figToMove, figFrom, disks = 0;

$(document).ready(function() {

});
function hanoiclick1(id) {
	tower = parseInt(id[6]) - 1;
	minimal = hanoigetMin(tower);
	for ( var i = 0; i < 3; i++) {
		for ( var int = 0; int < 9; int++) {
			letter = String.fromCharCode(parseInt(int + 97));
			$("#hanoi" + letter + (i + 1)).attr("onclick", "none()");
		}
	}
	for ( var i = 0; i < 3; i++) {
		if (hanoigetMin(i) > minimal) {
			for ( var int = 0; int < 9; int++) {
				letter = String.fromCharCode(parseInt(int + 97));
				$("#hanoi" + letter + (i + 1)).attr("onclick",
						"hanoiclick2(this.id)");
			}
		} else {
			for ( var int = 0; int < 9; int++) {
				letter = String.fromCharCode(parseInt(int + 97));
				$("#hanoi" + letter + (i + 1)).css("opacity", 0.6);
			}
		}
	}
	figToMove = minimal;
	figFrom = tower;
}
function hanoiclick2(id) {
	for ( var i = 0; i < 3; i++) {
		for ( var int = 0; int < 9; int++) {
			letter = String.fromCharCode(parseInt(int + 97));
			$("#hanoi" + letter + (i + 1)).css("opacity", 1);
		}
	}
	tower = parseInt(id[6]) - 1;
	for ( var i = 0; i < disks; i++) {
		if (game[figFrom][i] == figToMove) {
			game[figFrom][i] = 10;
		}
	}
	for ( var r = disks - 1; r >= 0; r--) {
		if (parseInt(game[tower][r]) == 10) {
			game[tower][r] = figToMove;
			break;
		} else {
			continue;
		}
	}
	for ( var i = 0; i < 3; i++) {
		for ( var int = 0; int < 9; int++) {
			letter = String.fromCharCode(parseInt(int + 97));
			$("#hanoi" + letter + (i + 1)).attr("onclick", "none()");
		}
	}
	for ( var i = 0; i < 3; i++) {
		temp = hanoigetMin(i);
		for ( var j = 0; j < 3; j++) {
			if (j == i) {
				continue;
			}
			if (hanoigetMin(j) < temp) {
				for ( var int = 0; int < 9; int++) {
					letter = String.fromCharCode(parseInt(int + 97));
					$("#hanoi" + letter + (j + 1)).attr("onclick",
							"hanoiclick1(this.id)");
				}
			}
		}
	}
	moves = parseInt($("#hanoimoves").html());
	moves++;
	$("#hanoimoves").html(moves);
	draw();
	checkEnd();
}

function hanoigetMin(data) {
	min = 10;
	for ( var k = 0; k < disks; k++) {
		if (min > game[data][k]) {
			min = game[data][k];
		}
	}
	return min;
}

function draw() {
	for ( var int = 1; int < 9; int++) {
		letter = String.fromCharCode(parseInt(int + 97));
		if (($("#hanoi" + letter + 1).attr("class") != undefined)
				&& ($("#hanoi" + letter + 1).attr("class") != "base")) {
			if (parseInt(game[0][int - 1]) == 10) {
				$("#hanoi" + letter + 1).attr("class", "peg");
			} else {
				clas = "disk" + game[0][int - 1];
				$("#hanoi" + letter + 1).attr("class", clas);
			}

		}
		if (($("#hanoi" + letter + 2).attr("class") != undefined)
				&& ($("#hanoi" + letter + 2).attr("class") != "base")) {
			if (parseInt(game[1][int - 1]) == 10) {
				$("#hanoi" + letter + 2).attr("class", "peg");
			} else {
				clas = "disk" + game[1][int - 1];
				$("#hanoi" + letter + 2).attr("class", clas);
			}

		}
		if (($("#hanoi" + letter + 3).attr("class") != undefined)
				&& ($("#hanoi" + letter + 3).attr("class") != "base")) {
			if (parseInt(game[2][int - 1]) == 10) {
				$("#hanoi" + letter + 3).attr("class", "peg");
			} else {
				clas = "disk" + game[2][int - 1];
				$("#hanoi" + letter + 3).attr("class", clas);
			}

		}
	}
}

function startHanoi3() {
	disks = 3;
	$("#hanoibest").html("7");
	$("#hanoiMenu").css("display", "none");
	$("#gameTable").css("display", "inline");
	$("#hanoihome").css("display", "block");
	$("#hanoiE").css("display", "none");
	$("#hanoiF").css("display", "none");
	$("#hanoiG").css("display", "none");
	$("#hanoiH").css("display", "none");
	init();
}
function startHanoi4() {
	disks = 4;
	$("#hanoibest").html("15");
	$("#hanoiMenu").css("display", "none");
	$("#gameTable").css("display", "inline");
	$("#hanoihome").css("display", "block");
	$("#hanoiF").css("display", "none");
	$("#hanoiG").css("display", "none");
	$("#hanoiH").css("display", "none");
	init();
}
function startHanoi5() {
	disks = 5;
	$("#hanoibest").html("31");
	$("#hanoiMenu").css("display", "none");
	$("#gameTable").css("display", "inline");
	$("#hanoihome").css("display", "block");
	$("#hanoiG").css("display", "none");
	$("#hanoiH").css("display", "none");
	init();
}
function startHanoi6() {
	disks = 6;
	$("#hanoibest").html("63");
	$("#hanoiMenu").css("display", "none");
	$("#gameTable").css("display", "inline");
	$("#hanoihome").css("display", "block");
	$("#hanoiH").css("display", "none");
	init();
}
function startHanoi7() {
	disks = 7;
	$("#hanoibest").html("127");
	$("#hanoiMenu").css("display", "none");
	$("#gameTable").css("display", "inline");
	$("#hanoihome").css("display", "block");
	init();
}

function init() {
	for ( var int = 0; int < 9; int++) {
		letter = String.fromCharCode(parseInt(int + 97));
		$("#hanoi" + letter + 1).attr("onclick", "hanoiclick1(this.id)");
	}
	game = new Array();
	for ( var i = 0; i < 3; i++) {
		game[i] = new Array();
		for ( var j = 0; j < disks; j++) {
			game[i][j] = 10;
		}
	}
	for ( var m = 0; m < disks; m++) {
		game[0][m] = m + 1;
	}
	draw();
}

function checkEnd() {
	if ((parseInt(hanoigetMin(0)) == 10) && (parseInt(hanoigetMin(1)) == 10)) {
		best = $("#hanoibest").html();
		moves = $("#hanoimoves").html();
		if (best != moves) {
			$("#hanoimessage").html("You result is " + moves + " moves,<br>absolute result is " + best + " moves!");
		} else {
			$("#hanoimessage").html("You result is " + moves + " moves,<br>its absolute result congratulations!");
		}
		for ( var i = 0; i < 3; i++) {
			for ( var int = 0; int < 9; int++) {
				letter = String.fromCharCode(parseInt(int + 97));
				$("#hanoi" + letter + (i + 1)).attr("onclick", "none()");
			}
		}
	}
}

function none() {

}