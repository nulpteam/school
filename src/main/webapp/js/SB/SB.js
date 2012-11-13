/*
 * @author Gutey Bogdan
 * 
 */

var store;
var str1;
var str2;
var str3;

var img01;
var img02;
var img03;
var img04;
var img05;
var img06;
var img07;
var img08;
var img09;
var img10;

var img01x;
var img02x;
var img03x;
var img04x;
var img05x;
var img06x;
var img07x;
var img08x;
var img09x;
var img10x;

var img01y;
var img02y;
var img03y;
var img04y;
var img05y;
var img06y;
var img07y;
var img08y;
var img09y;
var img10y;

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
		co = parseCoords(id, ui);
		saveCoords(co);
		if (i == 1) {
			img01 = ("images/SB/0" + co.t + ".png");
			console.log(img01);
			img01x = ui.position.left+2;
			img01y = ui.position.top;
			i--;
		}
		if (i == 2) {
			img02 = ("images/SB/0" + co.t + ".png");
			console.log(img02);
			img02x = ui.position.left+2;
			img02y = ui.position.top;
			i--;
		}
		if (i == 3) {
			img03 = ("images/SB/0" + co.t + ".png");
			console.log(img03);
			img03x = ui.position.left+2;
			img03y = ui.position.top;
			i--;
		}
		if (i == 4) {
			img04 = ("images/SB/0" + co.t + ".png");
			console.log(img04);
			img04x = ui.position.left+2;
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
			img05x = ui.position.left+2;
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
			img06x = ui.position.left+2;
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
			img07x = ui.position.left+2;
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
			img08x = ui.position.left+2;
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
			img09x = ui.position.left+2;
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
			img10x = ui.position.left+2;
			img10y = ui.position.top;
			i--;
		}
	}

//	function fOut(id1, id2) {
//		console.log("out");
////		remHover();
//		//clearOldCoordsInM(id1, id2);
//	}

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
	
	$('#table1 td').each(function(){$(this).droppable({
		tolerance : "pointer",
		hoverClass : 'hover',
		drop : function(event, ui) {
			fDrop(event, ui, this.id);
		},
		over : function(event, ui) {
			fOver(event, ui, this.id);
		}
//		,
//		out : function(event, ui) {
//			fOut(event, ui);
//		}
	});
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
	$.post("sheepsReady.html", 
			{sheepsReady : stringa},
			function(data)
			{
				if(data=="OK")
					{
						location.href="BsGameStart.html";
					}
			});
};