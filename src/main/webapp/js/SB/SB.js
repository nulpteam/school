var store = null;

$(function() {

	//матриця розташування кораблів(XY) координати
	var Mat = createMatrix();
	console.log(Mat);

	//кораблі
	$("#sheep_1").draggable({
		revert : "invalid",
		helper : "clone",
		revertDuration : 500,
		cursorAt : {
			top : 9,
			left : 9
		}
	});
	$("#sheep_2").draggable({
		revert : "invalid",
		helper : "clone",
		revertDuration : 500,
		cursorAt : {
			top : 9,
			left : 9
		}
	});
	$("#sheep_3").draggable({
		revert : "invalid",
		helper : "clone",
		revertDuration : 500,
		cursorAt : {
			top : 9,
			left : 9
		}
	});
	$("#sheep_4").draggable({
		revert : "invalid",
		helper : "clone",
		revertDuration : 500,
		cursorAt : {
			top : 9,
			left : 9
		}
	});

	//this.id - ідентифікатор комірки
	//ui.draggable.context.id - тип корабля (витягується з id корабля)
	/*+++++++-Y0-+++++++*/
	//	$("#X0_Y0").droppable({
	//		over : function(event, ui) {
	//			console.log($("#sheep_4"));
	//			console.log(parseCoords(this.id, ui).r);
	//			console.log(parseCoords(this.id, ui).t);
	//			console.log(this);
	//			console.log(((parseCoords(this.id, ui).t == 3)&&(parseCoords(this.id, ui).r === "H")&&(($("#X1_Y0").droppable("option", "disabled"))||($("#X3_Y0").droppable("option", "disabled"))||($("#X2_Y0").droppable("option", "disabled")))));
	//			var removed = false;
	//			if ((parseCoords(this.id, ui).t == 3)&&(parseCoords(this.id, ui).r === "H")&&(($("#X1_Y0").droppable("option", "disabled"))||($("#X3_Y0").droppable("option", "disabled"))||($("#X2_Y0").droppable("option", "disabled")))) {
	//				
	//				$("#X0_Y0").removeClass("hover");
	//				$("#X0_Y0").droppable("option", "disabled", true);
	//				removed = true;
	//				console.log("disabled");
	//				return removed;
	//			};
	//			if (removed){
	//				$("#X0_Y0").droppable("option", "disabled", false);
	//				console.log("enabled");
	//			};
	//		},
	//		out : function() {
	//			console.log("out");
	//			console.log($("#X0_Y0").droppable().over());
	//		},
	//		activate : function() {
	//			console.log("activate");
	//		},
	//		deactivate : function() {
	//			console.log("deactivate");
	//		},
	//		tolerance : "pointer",
	//		hoverClass : 'hover',
	//		drop : function(event, ui) {
	//			console.log(event);
	//			console.log(ui);
	//			saveCoords(parseCoords(this.id, ui));
	//		}
	//	});
	function lock(str) {
		$("#" + str).droppable("option", "disabled", true);
		store = ("#" + str);
	}

	function unlock(str) {
		$(str).droppable("option", "disabled", false);
		store = null;
	}

	function fDrop(event, ui, id) {
		console.log("drop");
		console.log(event);
		console.log(ui);
		saveCoords(parseCoords(id, ui));
	}

	function fOut(id1, id2) {
		clearOldCoordsInM(id1, id2);
	}

	function fOver(event, ui, coordinate) {
		console.log("over");
		var x = coordinate.charAt(1);
		var x1 = ++x;
		var x2 = ++x;
		var x3 = ++x;
		x = 0;
		console.log(coordinate.charAt(1), x, x1, x2, x3);
		var y = coordinate.charAt(4);
		var y1 = ++y;
		var y2 = ++y;
		var y3 = ++y;
		y = 0;
		console.log(coordinate.charAt(4), y, y1, y2, y3);
		if ((store != null) && (store != ("#" + coordinate))) {
			unlock(store);
			console.log("unlocked");
		}
		
//		(parseCoords(coordinate, ui).r === "H")
//		&& (($("#X" + x1 + "_Y" + y).droppable("option", "disabled"))
//				|| ($("#X" + x2 + "_Y" + y).droppable("option",
//						"disabled")) || ($("#X" + x3 + "_Y" + y)
//				.droppable("option", "disabled")))
		
//		(parseCoords(coordinate, ui).r === "V")
//		&& (($("#X" + x + "_Y" + y1).droppable("option", "disabled"))
//				|| ($("#X" + x + "_Y" + y2).droppable("option",
//						"disabled")) || ($("#X" + x + "_Y" + y3)
//				.droppable("option", "disabled")))
		
		
		console.log(parseCoords(coordinate, ui).r === "H");
		console.log(parseCoords(coordinate, ui).r === "V");
		if (parseCoords(coordinate, ui).t == 4){
			if (parseCoords(coordinate, ui).r === "H") {
				console.log("4 - H");
				if ($("#X" + x1 + "_Y" + coordinate.charAt(4)).droppable("option", "disabled")){
					console.log(("#X" + x1 + "_Y" + coordinate.charAt(4)));
//					lock(coordinate);
//					$("#" + coordinate).removeClass("hover");
//					console.log("locked");
				};
			};
			if (parseCoords(coordinate, ui).r === "V") {
				console.log("4 - V");
				if (($("#X" + coordinate.charAt(1) + "_Y" + y1).droppable("option", "disabled"))||($("#X" + coordinate.charAt(1) + "_Y" + y2).droppable("option", "disabled"))||($("#X" + coordinate.charAt(1) + "_Y" + y3).droppable("option", "disabled"))){
					console.log(("#X" + coordinate.charAt(1) + "_Y" + coordinate.charAt(4)));
//				lock(coordinate);
//				$("#" + coordinate).removeClass("hover");
//				console.log("locked");
				};
			};
		};
	}

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

	/*+++++++-Y1-+++++++*/
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

	/*+++++++-Y2-+++++++*/
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
	/*+++++++-Y3-+++++++*/
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
	/*+++++++-Y4-+++++++*/
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
	/*+++++++-Y5-+++++++*/
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
	/*+++++++-Y6-+++++++*/
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
	/*+++++++-Y7-+++++++*/
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
	/*+++++++-Y8-+++++++*/
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
	/*+++++++-Y9-+++++++*/
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