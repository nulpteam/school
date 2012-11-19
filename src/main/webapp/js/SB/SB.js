/*
 * @author Gutey Bogdan
 * 
 */

var store = null;
var str1 = null;
var str2 = null;
var str3 = null;

var i = 10;



$(function() {

	// матриця розташування кораблів(XY) координати
	var Mat = createMatrix();
	console.log(Mat);

	// кораблі
	$("#sheep_1").draggable({
		revert : "invalid",
		helper : "clone",
		revertDuration : 500,
		cursorAt : {
			top : 10,
			left : 10
		},
		snap:".ui-droppable"
	});
	$("#sheep_2").draggable({
		revert : "invalid",
		helper : "clone",
		revertDuration : 500,
		cursorAt : {
			top : 10,
			left : 10
		},
		snap:".ui-droppable"
	});
	$("#sheep_3").draggable({
		revert : "invalid",
		helper : "clone",
		revertDuration : 500,
		cursorAt : {
			top : 10,
			left : 10
		},
		snap:".ui-droppable"
	});
	$("#sheep_4").draggable({
		revert : "invalid",
		helper : "clone",
		revertDuration : 500,
		cursorAt : {
			top : 10,
			left : 10
		},
		snap:".ui-droppable"
	});

	function lock(str) {
		$("#" + str).droppable("option", "disabled", true);
		store = ("#" + str);
	};

	function unlock(str) {
		$(str).droppable("option", "disabled", false);
		store = null;
	};
	
	function fDrop(event, ui, id) {
		co = parseCoords(id, ui);
		console.log(co);
		console.log(id);
		saveCoords(co);
//		if (i == 1) {
//			img01 = ("images/SB/0" + co.t + ".png");
//			console.log(img01);
//			img01x = ui.position.left+1;
//			img01y = ui.position.top;
//			i--;
//		}
//		if (i == 2) {
//			img02 = ("images/SB/0" + co.t + ".png");
//			console.log(img02);
//			img02x = ui.position.left+1;
//			img02y = ui.position.top;
//			i--;
//		}
//		if (i == 3) {
//			img03 = ("images/SB/0" + co.t + ".png");
//			console.log(img03);
//			img03x = ui.position.left+1;
//			img03y = ui.position.top;
//			i--;
//		}
//		if (i == 4) {
//			img04 = ("images/SB/0" + co.t + ".png");
//			console.log(img04);
//			img04x = ui.position.left+1;
//			img04y = ui.position.top;
//			i--;
//		}
//		if (i == 5) {
//			if (co.r == "H") {
//				img05 = ("images/SB/0" + co.t + ".png");
//				console.log(img05);
//			}
//			if (co.r == "V") {
//				img05 = ("images/SB/0" + co.t + "_90.png");
//				console.log(img05);
//			}
//			img05x = ui.position.left+1;
//			img05y = ui.position.top;
//			i--;
//		}
//		if (i == 6) {
//			if (co.r == "H") {
//				img06 = ("images/SB/0" + co.t + ".png");
//				console.log(img06);
//			}
//			if (co.r == "V") {
//				img06 = ("images/SB/0" + co.t + "_90.png");
//				console.log(img06);
//			}
//			img06x = ui.position.left+1;
//			img06y = ui.position.top;
//			i--;
//		}
//		if (i == 7) {
//			if (co.r == "H") {
//				img07 = ("images/SB/0" + co.t + ".png");
//				console.log(img07);
//			}
//			if (co.r == "V") {
//				img07 = ("images/SB/0" + co.t + "_90.png");
//				console.log(img07);
//			}
//			img07x = ui.position.left+1;
//			img07y = ui.position.top;
//			i--;
//		}
//		if (i == 8) {
//			if (co.r == "H") {
//				img08 = ("images/SB/0" + co.t + ".png");
//				console.log(img08);
//			}
//			if (co.r == "V") {
//				img08 = ("images/SB/0" + co.t + "_90.png");
//				console.log(img08);
//			}
//			img08x = ui.position.left+1;
//			img08y = ui.position.top;
//			i--;
//		}
//		if (i == 9) {
//			if (co.r == "H") {
//				img09 = ("images/SB/0" + co.t + ".png");
//				console.log(img09);
//			}
//			if (co.r == "V") {
//				img09 = ("images/SB/0" + co.t + "_90.png");
//				console.log(img09);
//			}
//			img09x = ui.position.left+1;
//			img09y = ui.position.top;
//			i--;
//		}
//		if (i == 10) {
//			if (co.r == "H") {
//				img10 = ("images/SB/0" + co.t + ".png");
//				console.log(img10);
//			}
//			if (co.r == "V") {
//				img10 = ("images/SB/0" + co.t + "_90.png");
//				console.log(img10);
//			}
//			img10x = ui.position.left+1;
//			img10y = ui.position.top;
//			i--;
//		}
	}


	function fOver(event, ui, coordinate) {
		console.log("over");
		var x = coordinate.charAt(1);
		var x1 = ++x;
		var x2 = ++x;
		var x3 = ++x;
		x = 0;
		var y = coordinate.charAt(4);
		var y1 = ++y;
		var y2 = ++y;
		var y3 = ++y;
		y = 0;
		if ((store != null) && (store != ("#" + coordinate))) {
			unlock(store);
		}
		
		if (parseCoords(coordinate, ui).t == 4) {
			if (parseCoords(coordinate, ui).r === "H") {
				if ($("#X" + x1 + "_Y" + coordinate.charAt(4)).droppable(
						"option", "disabled")
						|| ($("#X" + x2 + "_Y" + coordinate.charAt(4))
								.droppable("option", "disabled"))
						|| ($("#X" + x3 + "_Y" + coordinate.charAt(4))
								.droppable("option", "disabled"))) {
					lock(coordinate);
				} else {
					str1 = "#X" + x1 + "_Y" + coordinate.charAt(4);
					str2 = "#X" + x2 + "_Y" + coordinate.charAt(4);
					str3 = "#X" + x3 + "_Y" + coordinate.charAt(4);
				};
			};
			if (parseCoords(coordinate, ui).r === "V") {
				if (($("#X" + coordinate.charAt(1) + "_Y" + y1).droppable(
						"option", "disabled"))
						|| ($("#X" + coordinate.charAt(1) + "_Y" + y2)
								.droppable("option", "disabled"))
						|| ($("#X" + coordinate.charAt(1) + "_Y" + y3)
								.droppable("option", "disabled"))) {
					lock(coordinate);
				} else {
					str1 = "#X" + coordinate.charAt(1) + "_Y" + y1;
					str2 = "#X" + coordinate.charAt(1) + "_Y" + y2;
					str3 = "#X" + coordinate.charAt(1) + "_Y" + y3;
				};
			};
		};
		
		if (parseCoords(coordinate, ui).t == 3) {
			if (parseCoords(coordinate, ui).r === "H") {
				if ($("#X" + x1 + "_Y" + coordinate.charAt(4)).droppable(
						"option", "disabled")
						|| ($("#X" + x2 + "_Y" + coordinate.charAt(4))
								.droppable("option", "disabled"))) {
					lock(coordinate);
				} else {
					str1 = "#X" + x1 + "_Y" + coordinate.charAt(4);
					str2 = "#X" + x2 + "_Y" + coordinate.charAt(4);
				};
			};
			if (parseCoords(coordinate, ui).r === "V") {
				if (($("#X" + coordinate.charAt(1) + "_Y" + y1).droppable(
						"option", "disabled"))
						|| ($("#X" + coordinate.charAt(1) + "_Y" + y2)
								.droppable("option", "disabled"))) {
					lock(coordinate);
				} else {
					str1 = "#X" + coordinate.charAt(1) + "_Y" + y1;
					str2 = "#X" + coordinate.charAt(1) + "_Y" + y2;
				};
			};
		};
		
		if (parseCoords(coordinate, ui).t == 2) {
			if (parseCoords(coordinate, ui).r === "H") {
				if ($("#X" + x1 + "_Y" + coordinate.charAt(4)).droppable(
						"option", "disabled")) {
					lock(coordinate);
				} else {
					str1 = "#X" + x1 + "_Y" + coordinate.charAt(4);
				};
			};
			if (parseCoords(coordinate, ui).r === "V") {
				if ($("#X" + coordinate.charAt(1) + "_Y" + y1).droppable(
						"option", "disabled")) {
					lock(coordinate);
				} else {
					str1 = "#X" + coordinate.charAt(1) + "_Y" + y1;
				};
			};
		};
		
	};
	
	$('#table1 td').each(function(){$(this).droppable({
		tolerance : "pointer",
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		}
	});
});
	
});