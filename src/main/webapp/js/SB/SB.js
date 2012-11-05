/*
 * @author Gutey Bogdan
 * 
 */

var store = null;
var str1 = null;
var str2 = null;
var str3 = null;

var img01 = null;
var img02 = null;
var img03 = null;
var img04 = null;
var img05 = null;
var img06 = null;
var img07 = null;
var img08 = null;
var img09 = null;
var img10 = null;

var img01x = null;
var img02x = null;
var img03x = null;
var img04x = null;
var img05x = null;
var img06x = null;
var img07x = null;
var img08x = null;
var img09x = null;
var img10x = null;

var img01y = null;
var img02y = null;
var img03y = null;
var img04y = null;
var img05y = null;
var img06y = null;
var img07y = null;
var img08y = null;
var img09y = null;
var img10y = null;

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
	
	function addHover() {
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
	function remHover() {
		console.log("remHover", str1, str2, str3);
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
	};

	function fDrop(event, ui, id) {
//		console.log(event);
//		console.log(ui);
		co = parseCoords(id, ui);
		saveCoords(co);
		if (i == 1) {
			if (co.r == "H") {
				img01 = ("images/SB/0" + co.t + ".png");
				console.log(img01);
			}
			if (co.r == "V") {
				img01 = ("images/SB/0" + co.t + "_90.png");
				console.log(img01);
			}
			img01x = ui.position.left;
			img01y = ui.position.top;
			i--;
		}
		if (i == 2) {
			if (co.r == "H") {
				img02 = ("images/SB/0" + co.t + ".png");
				console.log(img02);
			}
			if (co.r == "V") {
				img02 = ("images/SB/0" + co.t + "_90.png");
				console.log(img02);
			}
			img02x = ui.position.left;
			img02y = ui.position.top;
			i--;
		}
		if (i == 3) {
			if (co.r == "H") {
				img03 = ("images/SB/0" + co.t + ".png");
				console.log(img03);
			}
			if (co.r == "V") {
				img03 = ("images/SB/0" + co.t + "_90.png");
				console.log(img03);
			}
			img03x = ui.position.left;
			img03y = ui.position.top;
			i--;
		}
		if (i == 4) {
			if (co.r == "H") {
				img04 = ("images/SB/0" + co.t + ".png");
				console.log(img04);
			}
			if (co.r == "V") {
				img04 = ("images/SB/0" + co.t + "_90.png");
				console.log(img04);
			}
			img04x = ui.position.left;
			img04y = ui.position.top;
			i--;
		}
		if (i == 5) {
			if (co.r == "H") {
				img05 = ("images/SB/0" + co.t + ".png");
				console.log(img05);
			}
			if (co.r == "V") {
				img05 = ("images/SB/0" + co.t + "_90.png");
				console.log(img05);
			}
			img05x = ui.position.left;
			img05y = ui.position.top;
			i--;
		}
		if (i == 6) {
			if (co.r == "H") {
				img06 = ("images/SB/0" + co.t + ".png");
				console.log(img06);
			}
			if (co.r == "V") {
				img06 = ("images/SB/0" + co.t + "_90.png");
				console.log(img06);
			}
			img06x = ui.position.left;
			img06y = ui.position.top;
			i--;
		}
		if (i == 7) {
			if (co.r == "H") {
				img07 = ("images/SB/0" + co.t + ".png");
				console.log(img07);
			}
			if (co.r == "V") {
				img07 = ("images/SB/0" + co.t + "_90.png");
				console.log(img07);
			}
			img07x = ui.position.left;
			img07y = ui.position.top;
			i--;
		}
		if (i == 8) {
			if (co.r == "H") {
				img08 = ("images/SB/0" + co.t + ".png");
				console.log(img08);
			}
			if (co.r == "V") {
				img08 = ("images/SB/0" + co.t + "_90.png");
				console.log(img08);
			}
			img08x = ui.position.left;
			img08y = ui.position.top;
			i--;
		}
		if (i == 9) {
			if (co.r == "H") {
				img09 = ("images/SB/0" + co.t + ".png");
				console.log(img09);
			}
			if (co.r == "V") {
				img09 = ("images/SB/0" + co.t + "_90.png");
				console.log(img09);
			}
			img09x = ui.position.left;
			img09y = ui.position.top;
			i--;
		}
		if (i == 10) {
			if (co.r == "H") {
				img10 = ("images/SB/0" + co.t + ".png");
				console.log(img10);
			}
			if (co.r == "V") {
				img10 = ("images/SB/0" + co.t + "_90.png");
				console.log(img10);
			}
			img10x = ui.position.left;
			img10y = ui.position.top;
			i--;
		}
	}

	function fOut(id1, id2) {
		console.log("out");
//		remHover();
		clearOldCoordsInM(id1, id2);
	}

	function fOver(event, ui, coordinate) {
		console.log("over");
		remHover();
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
					$("#" + coordinate).removeClass("hover");
				} else {
					str1 = "#X" + x1 + "_Y" + coordinate.charAt(4);
					str2 = "#X" + x2 + "_Y" + coordinate.charAt(4);
					str3 = "#X" + x3 + "_Y" + coordinate.charAt(4);
					addHover();
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
					addHover();
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
					addHover();
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
					addHover();
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
					addHover();
				};
			};
			if (parseCoords(coordinate, ui).r === "V") {
				if ($("#X" + coordinate.charAt(1) + "_Y" + y1).droppable(
						"option", "disabled")) {
					lock(coordinate);
					$("#" + coordinate).removeClass("hover");
				} else {
					str1 = "#X" + coordinate.charAt(1) + "_Y" + y1;
					addHover();
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
	
	$(".img01").attr("src", img01);
	$(".img01").css("position", "absolute");
	$(".img01").attr("top", img01y);
	$(".img01").attr("left", img01x);
	
});



function start() {
	sheep01 = {
		"img" : img01,
		"x" : img01x,
		"y" : img01y
	};
	sheep02 = {
			"img" : img02,
			"x" : img02x,
			"y" : img02y
		};
	sheep03 = {
			"img" : img03,
			"x" : img03x,
			"y" : img03y
		};
	sheep04 = {
				"img" : img04,
				"x" : img04x,
				"y" : img04y
			};
	sheep05 = {
			"img" : img05,
			"x" : img05x,
			"y" : img05y
		};
	sheep06 = {
			"img" : img06,
			"x" : img06x,
			"y" : img06y
		};
	sheep07 = {
			"img" : img07,
			"x" : img07x,
			"y" : img07y
		};
	sheep08 = {
			"img" : img08,
			"x" : img08x,
			"y" : img08y
		};
	sheep09 = {
			"img" : img09,
			"x" : img09x,
			"y" : img09y
		};
	sheep10 = {
			"img" : img10,
			"x" : img10x,
			"y" : img10y
		};
	sheeps = {
			"sheep01" : sheep01,
			"sheep02" : sheep02,
			"sheep03" : sheep03,
			"sheep04" : sheep04,
			"sheep05" : sheep05,
			"sheep06" : sheep06,
			"sheep07" : sheep07,
			"sheep08" : sheep08,
			"sheep09" : sheep09,
			"sheep10" : sheep10
	};
	stringa = JSON.stringify(sheeps);
	console.log(stringa);
	$.post("sheepsReady.html", {sheepsReady : stringa});
};
