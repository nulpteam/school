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
//	var Mat = createMatrix();
		createMatrix();
//	console.log(Mat);

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
		saveCoords(co);
	}


	function fOver(event, ui, coordinate) {
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