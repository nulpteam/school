/*
 * @author Gutey Bogdan
 * 
 */

var store = null;
var str1 = null;
var str2 = null;
var str3 = null;

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
	
	function addHover(str1, str2, str3) {
		if(str1 != null) {
			$(str1).addClass("hover");
		};
		if(str2 != null) {
			$(str2).addClass("hover");
		};
		if(str3 != null) {
			$(str3).addClass("hover");
		};
		console.log("addHover", str1, str2, str3);
	};
	function remHover(str1, str2, str3) {
		if(str1 != null) {
			$(str1).removeClass("hover");
			str1 = null;
		};
		if(str2 != null) {
			$(str2).removeClass("hover");
			str2 = null;
		};
		if(str3 != null) {
			$(str3).removeClass("hover");
			str3 = null;
		};
		console.log("remHover", str1, str2, str3);
	};

	function fDrop(event, ui, id) {
//		console.log(event);
//		console.log(ui);
		saveCoords(parseCoords(id, ui));
		var c = ui.position.left;
        	d = ui.position.top;
        console.log(c);
        console.log(d);
	}

	function fOut(id1, id2) {
		remHover(str1, str2, str3);
		clearOldCoordsInM(id1, id2);
	}

	function fOver(event, ui, coordinate) {
		remHover(str1, str2, str3);
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
				console.log("4 - H");
				if ($("#X" + x1 + "_Y" + coordinate.charAt(4)).droppable(
						"option", "disabled")
						|| ($("#X" + x2 + "_Y" + coordinate.charAt(4))
								.droppable("option", "disabled"))
						|| ($("#X" + x3 + "_Y" + coordinate.charAt(4))
								.droppable("option", "disabled"))) {
					lock(coordinate);
					$("#" + coordinate).removeClass("hover");
				} else {
					str1 = "#X" + x1 + "_Y" + coordinate.charAt(4);
					str2 = "#X" + x2 + "_Y" + coordinate.charAt(4);
					str3 = "#X" + x3 + "_Y" + coordinate.charAt(4);
					addHover(str1, str2, str3);
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
					$("#" + coordinate).removeClass("hover");
				} else {
					str1 = "#X" + coordinate.charAt(1) + "_Y" + y1;
					str2 = "#X" + coordinate.charAt(1) + "_Y" + y2;
					str3 = "#X" + coordinate.charAt(1) + "_Y" + y3;
					addHover(str1, str2, str3);
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
					$("#" + coordinate).removeClass("hover");
				} else {
					str1 = "#X" + x1 + "_Y" + coordinate.charAt(4);
					str2 = "#X" + x2 + "_Y" + coordinate.charAt(4);
					addHover(str1, str2, str3);
				};
			};
			if (parseCoords(coordinate, ui).r === "V") {
				if (($("#X" + coordinate.charAt(1) + "_Y" + y1).droppable(
						"option", "disabled"))
						|| ($("#X" + coordinate.charAt(1) + "_Y" + y2)
								.droppable("option", "disabled"))) {
					lock(coordinate);
					$("#" + coordinate).removeClass("hover");
				} else {
					str1 = "#X" + coordinate.charAt(1) + "_Y" + y1;
					str2 = "#X" + coordinate.charAt(1) + "_Y" + y2;
					addHover(str1, str2, str3);
				};
			};
		};
		
		if (parseCoords(coordinate, ui).t == 2) {
			if (parseCoords(coordinate, ui).r === "H") {
				if ($("#X" + x1 + "_Y" + coordinate.charAt(4)).droppable(
						"option", "disabled")) {
					lock(coordinate);
					$("#" + coordinate).removeClass("hover");
				} else {
					str1 = "#X" + x1 + "_Y" + coordinate.charAt(4);
					addHover(str1, str2, str3);
				};
			};
			if (parseCoords(coordinate, ui).r === "V") {
				if ($("#X" + coordinate.charAt(1) + "_Y" + y1).droppable(
						"option", "disabled")) {
					lock(coordinate);
					$("#" + coordinate).removeClass("hover");
				} else {
					str1 = "#X" + coordinate.charAt(1) + "_Y" + y1;
					str2 = "#X" + coordinate.charAt(1) + "_Y" + y2;
					addHover(str1, str2, str3);
				};
			};
		};
		
	};

	$("#X0_Y0").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X1_Y0").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X2_Y0").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X3_Y0").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X4_Y0").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X5_Y0").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X6_Y0").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X7_Y0").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X8_Y0").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X9_Y0").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});

	/* +++++++-Y1-+++++++ */
	$("#X0_Y1").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});

	$("#X1_Y1").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X2_Y1").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X3_Y1").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X4_Y1").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X5_Y1").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X6_Y1").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X7_Y1").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X8_Y1").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X9_Y1").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});

	/* +++++++-Y2-+++++++ */
	$("#X0_Y2").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});

	$("#X1_Y2").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X2_Y2").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X3_Y2").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X4_Y2").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X5_Y2").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X6_Y2").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X7_Y2").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X8_Y2").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X9_Y2").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	/* +++++++-Y3-+++++++ */
	$("#X0_Y3").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});

	$("#X1_Y3").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X2_Y3").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X3_Y3").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X4_Y3").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X5_Y3").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X6_Y3").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X7_Y3").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X8_Y3").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X9_Y3").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	/* +++++++-Y4-+++++++ */
	$("#X0_Y4").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});

	$("#X1_Y4").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X2_Y4").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X3_Y4").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X4_Y4").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X5_Y4").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X6_Y4").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X7_Y4").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X8_Y4").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X9_Y4").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	/* +++++++-Y5-+++++++ */
	$("#X0_Y5").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});

	$("#X1_Y5").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X2_Y5").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X3_Y5").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X4_Y5").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X5_Y5").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X6_Y5").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X7_Y5").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X8_Y5").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X9_Y5").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	/* +++++++-Y6-+++++++ */
	$("#X0_Y6").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});

	$("#X1_Y6").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X2_Y6").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X3_Y6").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X4_Y6").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X5_Y6").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X6_Y6").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X7_Y6").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X8_Y6").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X9_Y6").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	/* +++++++-Y7-+++++++ */
	$("#X0_Y7").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});

	$("#X1_Y7").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X2_Y7").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X3_Y7").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X4_Y7").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X5_Y7").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X6_Y7").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X7_Y7").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X8_Y7").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X9_Y7").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	/* +++++++-Y8-+++++++ */
	$("#X0_Y8").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});

	$("#X1_Y8").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X2_Y8").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X3_Y8").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X4_Y8").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X5_Y8").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X6_Y8").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X7_Y8").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X8_Y8").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X9_Y8").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	/* +++++++-Y9-+++++++ */
	$("#X0_Y9").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});

	$("#X1_Y9").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X2_Y9").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X3_Y9").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X4_Y9").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X5_Y9").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X6_Y9").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X7_Y9").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X8_Y9").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
	$("#X9_Y9").droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		},
		out : function(event, ui) {
			fOut(event, ui);
		}
	});
});