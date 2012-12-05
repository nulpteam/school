/*
/*
 *  @author Gutey Bogdan
 */
var userAgent, bsound, M, damagedSheep = 0, unlockDroppableInfo, sheepCounter = 1;
var img01 = null, img02 = null, img03 = null, img04 = null, img05 = null,
	img06 = null, img07 = null, img08 = null, img09 = null, img10 = null,
	img01x = null, img02x = null, img03x = null, img04x = null, img05x = null,
	img06x = null, img07x = null, img08x = null, img09x = null, img10x = null,
	img01y = null, img02y = null, img03y = null, img04y = null, img05y = null,
	img06y = null, img07y = null, img08y = null, img09y = null, img10y = null;

$(document).ready(function() {
	
	
	
//	getValues();
	var ctrl = false;
	
//	$(document).keydown(function(e) {
//		if (ctrl && (e.keyCode == 107 || e.keyCode == 109 || e.keyCode == 61 || e.keyCode == 173)) {
//			return false;
//		}
////		if (e.keyCode == 17) {
////			ctrl = true;
////			var mousewheelevt=(/Firefox/i.test(navigator.userAgent))? "DOMMouseScroll" : "mousewheel";
////			if (document.attachEvent) {
////				document.attachEvent("on" + mousewheelevt, function(e){
////					return false;
////				});
////				} else if (document.addEventListener) {
////					document.addEventListener(mousewheelevt, function(e){return false;}, false);
////				}
////		}
//	});

//	$(document).keyup(function(e) {
//		if (e.keyCode == 17) {
//			ctrl = false;
//		}
//	});

	userAgent = navigator.userAgent;
	bsound = new Audio;
	if (userAgent.indexOf("Chrome") != -1) {
		bsound.src = "sound/More1.mp3";
	}

	if (userAgent.indexOf("Firefox") != -1) {
		bsound.src = "sound/More9.wav";
	}
	bsound.loop = false;
	startbsound();
});

function stopbsound() {
	bsound.pause();
}

function startbsound() {
	bsound.volume = 0.1;
	bsound.play();
}
function chSound() {
	id = $('.sound img').attr('id');
	if (id == "s_on") {
		s_off = '<img id="s_off" src="images/SB/s_off.png" onclick="chSound();">';
		$('.sound').html(s_off);
		stopbsound();
	} else if (id == "s_off") {
		s_on = '<img id="s_on" src="images/SB/s_on.png" onclick="chSound();">';
		$('.sound').html(s_on);
		startbsound();
	}
}

// Перевертає корабель якщо корабель не в полі бою
function rotate(obj) {
	//console.log(obj);
	id = $(obj).attr('id');
	//console.log(id);
	//infield = $(obj)[0].classList[1] === "infield";
	//console.log(infield);
	isDisabled = $(obj/* '#' + id */).draggable('option', 'disabled');
	if (!isDisabled /*&& !infield*/) {
		var c = $(obj).attr("class");
		orientation = c[0];
		newOrientation = 'H';

		if (orientation === 'H') {
			newOrientation = 'V';
			$(obj).attr("src", "images/SB/0" + id[6] + "_90.png");
		} else if (orientation === 'V') {
			newOrientation = 'H';
			$(obj).attr("src", "images/SB/0" + id[6] + ".png");
		}
		var set = c.substring(1, c.length);
		set = newOrientation + set;
		$(obj).attr("class", set);
	} else {

		// Ф-ія має розблоковувати всі заблоковіні дропабли навколо корабля
		// протележна до disableDroppables()
		enableDroppables(unlockDroppableInfo);

		var c = $(obj).attr("class");
		orientation = c[0];
		newOrientation = 'H';

		if (orientation === 'H') {
			newOrientation = 'V';
			$(obj).attr("src", "images/SB/0" + id[6] + "_90.png");
		} else if (orientation === 'V') {
			newOrientation = 'H';
			$(obj).attr("src", "images/SB/0" + id[6] + ".png");
		}
		var set = c.substring(1, c.length);
		set = newOrientation + set;
		$(obj).attr("class", set);
	}
}

// Створює пусту матрицю
function createMatrix() {
	M = new Array();
	for ( var i = 0; i < 10; i++) {
		M[i] = new Array();
		for ( var j = 0; j < 10; j++) {
			M[i][j] = "00";
		}
		;
	}
	return M;
}

// Виводить в консоль поточний стан матриці
function getM() {
	console.log(M);
}

// Створює обєкт
/**
 * t= тип корабля r = горизонтальне/вертикальне положення x\y = координати
 * положення корабля на полі Доробити положення горизонтальне/вертикальне
 */
function parseCoords(coords, ui) {
	if (ui.draggable.context.className != undefined) {
		var x, y, type;

		x = parseInt(coords[1]);
		y = parseInt(coords[4]);
		type = parseInt(ui.draggable.context.id[6]);
		var co = {
			"t" : type,
			"r" : ui.draggable.context.className[0],
			"x" : x,
			"y" : y,
			"img" : ui.draggable[0],
			"ui" : ui,
		};
		return co;
	}
	;
}

/**
 * Зберігає положення корабля в матрицю Доробити положення
 * горизонтальне/вертикальне
 * 
 */
function saveCoords(saveCoordenates) {
	// Деактивовуємо дроппабли в які вже встановлено кораблик
	disableDroppables(saveCoordenates);
	// зберігає

	M[saveCoordenates.x][saveCoordenates.y] = saveCoordenates.t + "1";

	if (saveCoordenates.t > 1) {
		if (saveCoordenates.r === "H") {
			M[saveCoordenates.x + 1][saveCoordenates.y] = saveCoordenates.t
					+ "1";
		}
		if (saveCoordenates.r === "V") {
			M[saveCoordenates.x][saveCoordenates.y + 1] = saveCoordenates.t
					+ "1";
		}
		if (saveCoordenates.t > 2) {

			if (saveCoordenates.r === "H") {
				M[saveCoordenates.x + 2][saveCoordenates.y] = saveCoordenates.t
						+ "1";
			}
			if (saveCoordenates.r === "V") {
				M[saveCoordenates.x][saveCoordenates.y + 2] = saveCoordenates.t
						+ "1";
			}
			if (saveCoordenates.t > 3) {

				if (saveCoordenates.r === "H") {
					M[saveCoordenates.x + 3][saveCoordenates.y] = saveCoordenates.t
							+ "1";
				}
				if (saveCoordenates.r === "V") {
					M[saveCoordenates.x][saveCoordenates.y + 3] = saveCoordenates.t
							+ "1";
				}
			}
		}
	}
	img = saveCoordenates.img;
	count = counter(saveCoordenates) + 1;
	if (saveCoordenates.r === "H" || saveCoordenates.r === "u") {
		$('#sp' + saveCoordenates.t + count).html(
				'<img id="sheep_' + saveCoordenates.t
						+ '" class="H infield" src="images/SB/0'
						+ saveCoordenates.t
						+ '.png" ondblclick="bbb(this,event);"/>');
		$('#sp' + saveCoordenates.t + count).css("top",
				saveCoordenates.ui.position.top + "px");
		$('#sp' + saveCoordenates.t + count).css("left",
				saveCoordenates.ui.position.left + "px");
		$('#sp' + saveCoordenates.t + count).css("display", "block");
	} else if (saveCoordenates.r === "V") {
		$('#sp' + saveCoordenates.t + count).html(
				'<img id="sheep_' + saveCoordenates.t
						+ '" class="V infield" src="images/SB/0'
						+ saveCoordenates.t
						+ '_90.png" ondblclick="bbb(this,event);"/>');
		$('#sp' + saveCoordenates.t + count).css("top",
				saveCoordenates.ui.position.top + "px");
		$('#sp' + saveCoordenates.t + count).css("left",
				saveCoordenates.ui.position.left + "px");
		$('#sp' + saveCoordenates.t + count).css("display", "block");
	}

	if (count - 1 == 0) {

		$("#" + saveCoordenates.ui.draggable.context.id).draggable('disable');
		$('#' + saveCoordenates.ui.draggable.context.id).hide(1000);
	}
	// посилаємо на сервер
	sendM();
}

//
function bbb(t, event) {
	if ((event.ctrlKey == 1)
			&& ((sheepCount.sheep1 + sheepCount.sheep2 + sheepCount.sheep3 + sheepCount.sheep4) <= 0)) {
		d = $(t).parent();
		sheepId = $(t).attr('id');
		topPx = d[0].offsetTop;
		leftPx = d[0].offsetLeft;
		placeHolderId = d[0].id;
		rotation = d[0].firstChild.className[0];

		if (($(t).css("top")) != "auto") {
			a = parseInt($(t).css("top"));
		} else {
			a = 0;
		}
		if (($(t).css("left")) != "auto") {
			b = parseInt($(t).css("left"));
		} else {
			b = 0;
		}

		unlockDroppableInfo = {
			"sheepId" : sheepId,
			"topPx" : (topPx + a),
			"leftPx" : (leftPx + b),
			"placeHolderId" : placeHolderId,
			"rotation" : rotation
		};
		$(t).css("top", "0");
		$(t).css("left", "0");
		$("#" + placeHolderId).css("top",
				(parseInt($("#" + placeHolderId).css("top")) + a));
		$("#" + placeHolderId).css("left",
				(parseInt($("#" + placeHolderId).css("left")) + b));

		// Активовуємо драгабл на кораблі по якому даблклікнули+CTRL
		$(t).attr('ondblclick', 'rotate(this);');
		$(t).draggable();
		$(t).draggable("enable");
		$(t).draggable({
			revert : "invalid",
			helper : 'original',
			cursorAt : {
				top : 10,
				left : 10
			},
			snap : ".ui-droppable",
			start : function(event, ui) {
				enableDroppables(unlockDroppableInfo);
			},
			stop : function(event, ui) {
				$(t).draggable("disable");
				$(t).attr('ondblclick', "bbb(this,event);");
				d[0].ofsetTop = 0;
				d[0].ofsetLeft = 0;
			}
		});
	}
}

// Ф-ія має розблоковувати всі заблоковіні дропабли навколо корабля
// +встановлювати в матриці 00 на місце де був розташований корабель
// протележна до disableDroppables()
function enableDroppables(unlockDroppableInfo) {
	var x0 = parseInt((parseInt(unlockDroppableInfo.leftPx) - 1) / 20) - 7 - 1;
	x1 = parseInt((parseInt(unlockDroppableInfo.leftPx) - 1) / 20) - 7 + 1;
	x2 = parseInt((parseInt(unlockDroppableInfo.leftPx) - 1) / 20) - 7;
	x3 = parseInt((parseInt(unlockDroppableInfo.leftPx) - 1) / 20) - 7 + 2;
	x4 = parseInt((parseInt(unlockDroppableInfo.leftPx) - 1) / 20) - 7 + 3;
	x5 = parseInt((parseInt(unlockDroppableInfo.leftPx) - 1) / 20) - 7 + 4;
	y0 = parseInt((parseInt(unlockDroppableInfo.topPx) + 1) / 20) - 1;
	y1 = parseInt((parseInt(unlockDroppableInfo.topPx) + 1) / 20) + 1;
	y2 = parseInt((parseInt(unlockDroppableInfo.topPx) + 1) / 20);
	y3 = parseInt((parseInt(unlockDroppableInfo.topPx) + 1) / 20) + 2;
	y4 = parseInt((parseInt(unlockDroppableInfo.topPx) + 1) / 20) + 3;
	y5 = parseInt((parseInt(unlockDroppableInfo.topPx) + 1) / 20) + 4;

	if (unlockDroppableInfo.sheepId == "sheep_1") {
		$("#X" + x2 + "_Y" + y2).attr("sheep", false);
		M[x2][y2] = "00";
		var sheepsNear = 0;

		for ( var i = x0; i <= x1; i++) {
			for ( var j = y0; j <= y1; j++) {
				for ( var m = (-1 + i); m <= (1 + i); m++) {
					for ( var n = (-1 + j); n <= (1 + j); n++) {
						if (($("#X" + m + "_Y" + n).attr("sheep") != undefined)
								&& ($("#X" + m + "_Y" + n).attr("sheep") == "true")) {
							sheepsNear++;
						}
					}
				}

				if (sheepsNear == 0) {
					$("#X" + i + "_Y" + j).droppable("option", "disabled",
							false);
					$("#X" + i + "_Y" + j).attr("aria-disabled", false);
				}
				sheepsNear = 0;
			}
		}
	}

	if (unlockDroppableInfo.rotation == "H") {
		if (unlockDroppableInfo.sheepId == "sheep_2") {
			$("#X" + x2 + "_Y" + y2).attr("sheep", false);
			M[x2][y2] = "00";
			$("#X" + x1 + "_Y" + y2).attr("sheep", false);
			M[x1][y2] = "00";

			for ( var i = x0; i <= x3; i++) {
				for ( var j = y0; j <= y1; j++) {
					$("#X" + i + "_Y" + j).droppable("option", "disabled",
							false);
					$("#X" + i + "_Y" + j).attr("aria-disabled", false);
				}
			}
		}
		if (unlockDroppableInfo.sheepId == "sheep_3") {
			$("#X" + x2 + "_Y" + y2).attr("sheep", false);
			M[x2][y2] = "00";
			$("#X" + x1 + "_Y" + y2).attr("sheep", false);
			M[x1][y2] = "00";
			$("#X" + x3 + "_Y" + y2).attr("sheep", false);
			M[x3][y2] = "00";

			for ( var i = x0; i <= x4; i++) {
				for ( var j = y0; j <= y1; j++) {
					$("#X" + i + "_Y" + j).droppable("option", "disabled",
							false);
					$("#X" + i + "_Y" + j).attr("aria-disabled", false);
				}
			}
		}
		if (unlockDroppableInfo.sheepId == "sheep_4") {
			$("#X" + x2 + "_Y" + y2).attr("sheep", false);
			M[x2][y2] = "00";
			$("#X" + x1 + "_Y" + y2).attr("sheep", false);
			M[x1][y2] = "00";
			$("#X" + x3 + "_Y" + y2).attr("sheep", false);
			M[x3][y2] = "00";
			$("#X" + x4 + "_Y" + y2).attr("sheep", false);
			M[x4][y2] = "00";

			for ( var i = x0; i <= x5; i++) {
				for ( var j = y0; j <= y1; j++) {
					$("#X" + i + "_Y" + j).droppable("option", "disabled",
							false);
					$("#X" + i + "_Y" + j).attr("aria-disabled", false);
				}
			}
		}
		;
	}
	if (unlockDroppableInfo.rotation == "V") {
		if (unlockDroppableInfo.sheepId == "sheep_2") {
			$("#X" + x2 + "_Y" + y2).attr("sheep", false);
			M[x2][y2] = "00";
			$("#X" + x2 + "_Y" + y1).attr("sheep", false);
			M[x2][y1] = "00";

			for ( var i = x0; i <= x1; i++) {
				for ( var j = y0; j <= y3; j++) {
					$("#X" + i + "_Y" + j).droppable("option", "disabled",
							false);
					$("#X" + i + "_Y" + j).attr("aria-disabled", false);
				}
			}
		}
		if (unlockDroppableInfo.sheepId == "sheep_3") {
			$("#X" + x2 + "_Y" + y2).attr("sheep", false);
			M[x2][y2] = "00";
			$("#X" + x2 + "_Y" + y1).attr("sheep", false);
			M[x2][y1] = "00";
			$("#X" + x2 + "_Y" + y3).attr("sheep", false);
			M[x2][y3] = "00";

			for ( var i = x0; i <= x1; i++) {
				for ( var j = y0; j <= y4; j++) {
					$("#X" + i + "_Y" + j).droppable("option", "disabled",
							false);
					$("#X" + i + "_Y" + j).attr("aria-disabled", false);
				}
			}
		}
		if (unlockDroppableInfo.sheepId == "sheep_4") {
			// remove class "sheep"
			$("#X" + x2 + "_Y" + y2).attr("sheep", false);
			M[x2][y2] = "00";
			$("#X" + x2 + "_Y" + y1).attr("sheep", false);
			M[x2][y1] = "00";
			$("#X" + x2 + "_Y" + y3).attr("sheep", false);
			M[x2][y3] = "00";
			$("#X" + x2 + "_Y" + y4).attr("sheep", false);
			M[x2][y4] = "00";

			for ( var i = x0; i <= x1; i++) {
				for ( var j = y0; j <= y5; j++) {
					$("#X" + i + "_Y" + j).droppable("option", "disabled",
							false);
					$("#X" + i + "_Y" + j).attr("aria-disabled", false);
				}
			}
		}
		;
	}
	;
}

// Деактивовує елементи droppable за координатами
function disableDroppables(obj) {
	var x0 = obj.x - 1;
	x1 = obj.x + 1;
	x2 = obj.x;
	x3 = obj.x + 2;
	x4 = obj.x + 3;
	x5 = obj.x + 4;
	y0 = obj.y - 1;
	y1 = obj.y + 1;
	y2 = obj.y;
	y3 = obj.y + 2;
	y4 = obj.y + 3;
	y5 = obj.y + 4;

	if (obj.r == "u") {
		for ( var i = x0; i <= x1; i++) {
			for ( var j = y0; j <= y1; j++) {
				$("#X" + i + "_Y" + j).droppable("option", "disabled", true);
				if ((i == x2) && (j == y2)) {
					$("#X" + i + "_Y" + j).attr("sheep", true);
				}
			}
		}
	}

	if (obj.r == "H") {
		if (obj.t == "2") {

			for ( var i = x0; i <= x3; i++) {
				for ( var j = y0; j <= y1; j++) {
					$("#X" + i + "_Y" + j)
							.droppable("option", "disabled", true);
					if (((i == x2) || (i == x1)) && (j == y2)) {
						$("#X" + i + "_Y" + j).attr("sheep", true);
					}
				}
			}
		}
		if (obj.t == "3") {

			for ( var i = x0; i <= x4; i++) {
				for ( var j = y0; j <= y1; j++) {
					$("#X" + i + "_Y" + j)
							.droppable("option", "disabled", true);
					if (((i == x2) || (i == x1) || (i == x3)) && (j == y2)) {
						$("#X" + i + "_Y" + j).attr("sheep", true);
					}
				}
			}
		}
		if (obj.t == "4") {

			for ( var i = x0; i <= x5; i++) {
				for ( var j = y0; j <= y1; j++) {
					$("#X" + i + "_Y" + j)
							.droppable("option", "disabled", true);
					if (((i == x2) || (i == x1) || (i == x3) || (i == x4))
							&& (j == y2)) {
						$("#X" + i + "_Y" + j).attr("sheep", true);
					}
				}
			}
		}
		;
	}
	if (obj.r == "V") {
		if (obj.t == "2") {

			for ( var i = x0; i <= x1; i++) {
				for ( var j = y0; j <= y3; j++) {
					$("#X" + i + "_Y" + j)
							.droppable("option", "disabled", true);
					if ((i == x2) && ((j == y2) || (j == y1))) {
						$("#X" + i + "_Y" + j).attr("sheep", true);
					}
				}
			}
		}
		if (obj.t == "3") {

			for ( var i = x0; i <= x1; i++) {
				for ( var j = y0; j <= y4; j++) {
					$("#X" + i + "_Y" + j)
							.droppable("option", "disabled", true);
					if ((i == x2) && ((j == y2) || (j == y1) || (j == y3))) {
						$("#X" + i + "_Y" + j).attr("sheep", true);
					}
				}
			}
		}
		if (obj.t == "4") {

			for ( var i = x0; i <= x1; i++) {
				for ( var j = y0; j <= y5; j++) {
					$("#X" + i + "_Y" + j)
							.droppable("option", "disabled", true);
					if ((i == x2)
							&& ((j == y2) || (j == y1) || (j == y3) || (j == y4))) {
						$("#X" + i + "_Y" + j).attr("sheep", true);
					}
				}
			}
		}
		;
	}
	;
}

/**
 * Відсилає матрицю на сервер
 * 
 */
function sendM() {
	if (((sheepCount.sheep1 + sheepCount.sheep2 + sheepCount.sheep3 + sheepCount.sheep4) <= 0)
			&& flag == true) {
		$(".BSGo").css("visibility", "visible");
	}
	var j = {
		"a" : M[0],
		"b" : M[1],
		"c" : M[2],
		"d" : M[3],
		"e" : M[4],
		"f" : M[5],
		"g" : M[6],
		"h" : M[7],
		"i" : M[8],
		"j" : M[9],
	};
	var Send = JSON.stringify(j);
	$.ajax({
		url : 'init_sheeps.html',
		type : 'POST',
		data : {
			sheeps : Send
		},
		success : function(data) {
			;
		},
		error : function() {
			alert("ERROR");
		}
	});
};

// обєкт кількості кораблів
var sheepCount = {
	"sheep4" : 1,
	"sheep3" : 2,
	"sheep2" : 3,
	"sheep1" : 4

};
sheepCount.div1 = function() {
	return --sheepCount.sheep1;
};
sheepCount.div2 = function() {
	--sheepCount.sheep2;
	if (sheepCount.sheep2 == 0) {
		$("#sheep_1").css("display", "inline");
	}
	return sheepCount.sheep2;

};
sheepCount.div3 = function() {
	--sheepCount.sheep3;
	if (sheepCount.sheep3 == 0) {
		$("#sheep_2").css("display", "inline");
	}
	return sheepCount.sheep3;
};
sheepCount.div4 = function() {
	--sheepCount.sheep4;
	if (sheepCount.sheep4 == 0) {
		$("#sheep_3").css("display", "inline");
	}
	return sheepCount.sheep4;
};

// ф-ія зменшує к-ть кораблів на 1 в залежності від типу
function counter(obj) {

	switch (obj.t) {
	case 1: {
		return sheepCount.div1();
	}
	case 2: {
		return sheepCount.div2();
	}
	case 3: {
		return sheepCount.div3();
	}
	case 4: {
		return sheepCount.div4();
	}
	}
}

function allreadyShooted() {
	// alert(SbMsgAllreadyShooted);
}

function allreadyDamaged() {
	// alert(SbMsgAllreadyShooted);
}

function cantBe() {
	// alert(SbMsgCantBeSheep);
}

function lockWhereCantBe(id) {
	x1 = parseInt(id[2]) - 1;
	y1 = parseInt(id[5]) - 1;
	x2 = parseInt(id[2]);
	y2 = parseInt(id[5]);
	x3 = 1 + parseInt(id[2]);
	y3 = 1 + parseInt(id[5]);

	for ( var i = x1; i <= x3; i++) {
		for ( var j = y1; j <= y3; j++) {
			if (((i == x2) || (i == x1) || (i == x3))
					&& ((j == y2) || (j == y1) || (j == y3))) {
				if ($("#X" + i + "_Y" + j).attr("onclick") == "fire(this)") {
					$("#X" + i + "_Y" + j).css("background-image",
							"url('images/SB/cant_be.png')");
					$("#X" + i + "_Y" + j).attr("onclick", "cantBe()");
					$("#X" + i + "_Y" + j).attr("class", "none");
				}
			}
		}
	}
}
function victory() {
	goTo("Victory.html");
}
function loose() {
	goTo("Loose.html");
}

function playShootSound(miss) {

	if (miss == "demage") {
		if (userAgent.indexOf("Chrome") != -1) {
			sound = new Audio;
			sound.src = "sound/Shoot01.mp3";
			sound.play();
		}

		if (userAgent.indexOf("Firefox") != -1) {
			sound = new Audio;
			sound.src = "sound/Shoot01.wav";
			sound.play();
		}
	} else if (miss == "miss") {
		if (userAgent.indexOf("Chrome") != -1) {
			sound = new Audio;
			sound.src = "sound/miss.mp3";
			sound.play();
		}

		if (userAgent.indexOf("Firefox") != -1) {
			sound = new Audio;
			sound.src = "sound/miss.wav";
			sound.play();
		}
	}
}



function fire(point) {
	// playShootSound();
	p = $(point).attr('id');
	c = $(point).attr('id');
	p = p[1] + '' + p[4];
	$.post("fire.html", {
		firePoint : p
	}, function(data) {
		if(!jQuery.isPlainObject(data))
		{
			//session fail
			alert(SbMsgSessionFail);
			window.location.reload();
		}
		else
		{
			obj = eval(data);
		// Міняєм ф-ію на обстріляній клітинці
		if (obj.miss === "00") {
			$(point).attr("onclick", "allreadyShooted();");
		} else {
			$(point).attr("onclick", "allreadyDamaged();");
		}

		rand = Math.floor((Math.random() * 5) + 1);
		if (obj.miss === "00") {
			playShootSound("miss");
			$("#" + c).css("background-image",
					"url('images/SB/missPoint" + rand + ".png')");
			$("#" + c).attr("class", "none");
			$("#locker").css("visibility", "visible");
		} else {
			playShootSound("demage");
			$("#" + c).css("background-image",
					"url('images/SB/firePoint" + rand + ".png')");
			$("#" + c).attr("class", "none");
			$("#locker").css("visibility", "hidden");
		}
		if (obj.miss === "10") {
			if (damagedSheep == 20) {
				victory();
			}
			lockWhereCantBe("#" + point.id);
			damagedSheep++;
			if (damagedSheep == 20) {
				victory();
			}
		}
		if (obj.miss === "20") {
			x1 = parseInt(point.id[1]) - 1;
			y1 = parseInt(point.id[4]) - 1;
			x2 = parseInt(point.id[1]);
			y2 = parseInt(point.id[4]);
			x3 = 1 + parseInt(point.id[1]);
			y3 = 1 + parseInt(point.id[4]);
			leftP = "#X" + x1 + "_Y" + y2;
			topP = "#X" + x2 + "_Y" + y1;
			rightP = "#X" + x3 + "_Y" + y2;
			bottomP = "#X" + x2 + "_Y" + y3;

			if (($(leftP).attr("onclick") == "allreadyDamaged();")) {
				lockWhereCantBe("#" + point.id);
				lockWhereCantBe(leftP);
			}
			if (($(topP).attr("onclick") == "allreadyDamaged();")) {
				lockWhereCantBe("#" + point.id);
				lockWhereCantBe(topP);
			}
			if (($(rightP).attr("onclick") == "allreadyDamaged();")) {
				lockWhereCantBe("#" + point.id);
				lockWhereCantBe(rightP);

			}
			if (($(bottomP).attr("onclick") == "allreadyDamaged();")) {
				lockWhereCantBe("#" + point.id);
				lockWhereCantBe(bottomP);
			}
			damagedSheep++;
			if (damagedSheep == 20) {
				victory();
			}
		}
		if (obj.miss === "30") {
			x1 = parseInt(point.id[1]) - 2;
			y1 = parseInt(point.id[4]) - 2;
			x2 = parseInt(point.id[1]) - 1;
			y2 = parseInt(point.id[4]) - 1;
			x3 = parseInt(point.id[1]);
			y3 = parseInt(point.id[4]);
			x4 = parseInt(point.id[1]) + 1;
			y4 = parseInt(point.id[4]) + 1;
			x5 = parseInt(point.id[1]) + 2;
			y5 = parseInt(point.id[4]) + 2;

			leftP1 = "#X" + x1 + "_Y" + y3;
			leftP2 = "#X" + x2 + "_Y" + y3;

			topP1 = "#X" + x3 + "_Y" + y1;
			topP2 = "#X" + x3 + "_Y" + y2;

			rightP1 = "#X" + x4 + "_Y" + y3;
			rightP2 = "#X" + x5 + "_Y" + y3;

			bottomP1 = "#X" + x3 + "_Y" + y4;
			bottomP2 = "#X" + x3 + "_Y" + y5;

			if (($(leftP1).attr("onclick") == "allreadyDamaged();")
					&& ($(leftP2).attr("onclick") == "allreadyDamaged();")) {
				lockWhereCantBe("#" + point.id);
				lockWhereCantBe(leftP1);
				lockWhereCantBe(leftP2);
			}
			if (($(rightP1).attr("onclick") == "allreadyDamaged();")
					&& ($(leftP2).attr("onclick") == "allreadyDamaged();")) {
				lockWhereCantBe("#" + point.id);
				lockWhereCantBe(rightP1);
				lockWhereCantBe(leftP2);
			}
			if (($(rightP1).attr("onclick") == "allreadyDamaged();")
					&& ($(rightP2).attr("onclick") == "allreadyDamaged();")) {
				lockWhereCantBe("#" + point.id);
				lockWhereCantBe(rightP1);
				lockWhereCantBe(rightP2);
			}
			if (($(topP1).attr("onclick") == "allreadyDamaged();")
					&& ($(topP2).attr("onclick") == "allreadyDamaged();")) {
				lockWhereCantBe("#" + point.id);
				lockWhereCantBe(topP1);
				lockWhereCantBe(topP2);
			}
			if (($(bottomP1).attr("onclick") == "allreadyDamaged();")
					&& ($(topP2).attr("onclick") == "allreadyDamaged();")) {
				lockWhereCantBe("#" + point.id);
				lockWhereCantBe(bottomP1);
				lockWhereCantBe(topP2);
			}
			if (($(bottomP1).attr("onclick") == "allreadyDamaged();")
					&& ($(bottomP2).attr("onclick") == "allreadyDamaged();")) {
				lockWhereCantBe("#" + point.id);
				lockWhereCantBe(bottomP1);
				lockWhereCantBe(bottomP2);
			}
			damagedSheep++;
			if (damagedSheep == 20) {
				victory();
			}
		}
		if (obj.miss === "40") {
			x1 = parseInt(point.id[1]) - 3;
			y1 = parseInt(point.id[4]) - 3;
			x2 = parseInt(point.id[1]) - 2;
			y2 = parseInt(point.id[4]) - 2;
			x3 = parseInt(point.id[1]) - 1;
			y3 = parseInt(point.id[4]) - 1;
			x4 = parseInt(point.id[1]);
			y4 = parseInt(point.id[4]);
			x5 = parseInt(point.id[1]) + 1;
			y5 = parseInt(point.id[4]) + 1;
			x6 = parseInt(point.id[1]) + 2;
			y6 = parseInt(point.id[4]) + 2;
			x7 = parseInt(point.id[1]) + 3;
			y7 = parseInt(point.id[4]) + 3;

			leftP1 = "#X" + x1 + "_Y" + y4;
			leftP2 = "#X" + x2 + "_Y" + y4;
			leftP3 = "#X" + x3 + "_Y" + y4;

			topP1 = "#X" + x4 + "_Y" + y1;
			topP2 = "#X" + x4 + "_Y" + y2;
			topP3 = "#X" + x4 + "_Y" + y3;

			rightP1 = "#X" + x5 + "_Y" + y4;
			rightP2 = "#X" + x6 + "_Y" + y4;
			rightP3 = "#X" + x7 + "_Y" + y4;

			bottomP1 = "#X" + x4 + "_Y" + y5;
			bottomP2 = "#X" + x4 + "_Y" + y6;
			bottomP3 = "#X" + x4 + "_Y" + y7;

			if (($(leftP1).attr("onclick") == "allreadyDamaged();")
					&& ($(leftP2).attr("onclick") == "allreadyDamaged();")
					&& ($(leftP3).attr("onclick") == "allreadyDamaged();")) {
				lockWhereCantBe("#" + point.id);
				lockWhereCantBe(leftP1);
				lockWhereCantBe(leftP2);
				lockWhereCantBe(leftP3);
			}
			if (($(rightP1).attr("onclick") == "allreadyDamaged();")
					&& ($(leftP2).attr("onclick") == "allreadyDamaged();")
					&& ($(leftP3).attr("onclick") == "allreadyDamaged();")) {
				lockWhereCantBe("#" + point.id);
				lockWhereCantBe(rightP1);
				lockWhereCantBe(leftP2);
				lockWhereCantBe(leftP3);
			}
			if (($(rightP1).attr("onclick") == "allreadyDamaged();")
					&& ($(rightP2).attr("onclick") == "allreadyDamaged();")
					&& ($(leftP3).attr("onclick") == "allreadyDamaged();")) {
				lockWhereCantBe("#" + point.id);
				lockWhereCantBe(rightP1);
				lockWhereCantBe(rightP2);
				lockWhereCantBe(leftP3);
			}
			if (($(rightP1).attr("onclick") == "allreadyDamaged();")
					&& ($(rightP2).attr("onclick") == "allreadyDamaged();")
					&& ($(rightP3).attr("onclick") == "allreadyDamaged();")) {
				lockWhereCantBe("#" + point.id);
				lockWhereCantBe(rightP1);
				lockWhereCantBe(rightP2);
				lockWhereCantBe(rightP3);
			}
			if (($(topP1).attr("onclick") == "allreadyDamaged();")
					&& ($(topP2).attr("onclick") == "allreadyDamaged();")
					&& ($(topP3).attr("onclick") == "allreadyDamaged();")) {
				lockWhereCantBe("#" + point.id);
				lockWhereCantBe(topP1);
				lockWhereCantBe(topP2);
				lockWhereCantBe(topP3);
			}
			if (($(bottomP1).attr("onclick") == "allreadyDamaged();")
					&& ($(topP2).attr("onclick") == "allreadyDamaged();")
					&& ($(topP3).attr("onclick") == "allreadyDamaged();")) {
				lockWhereCantBe("#" + point.id);
				lockWhereCantBe(bottomP1);
				lockWhereCantBe(topP2);
				lockWhereCantBe(topP3);
			}
			if (($(bottomP1).attr("onclick") == "allreadyDamaged();")
					&& ($(bottomP2).attr("onclick") == "allreadyDamaged();")
					&& ($(topP3).attr("onclick") == "allreadyDamaged();")) {
				lockWhereCantBe("#" + point.id);
				lockWhereCantBe(bottomP1);
				lockWhereCantBe(bottomP2);
				lockWhereCantBe(topP3);
			}
			if (($(bottomP1).attr("onclick") == "allreadyDamaged();")
					&& ($(bottomP2).attr("onclick") == "allreadyDamaged();")
					&& ($(bottomP3).attr("onclick") == "allreadyDamaged();")) {
				lockWhereCantBe("#" + point.id);
				lockWhereCantBe(bottomP1);
				lockWhereCantBe(bottomP2);
				lockWhereCantBe(bottomP3);
			}
			damagedSheep++;
			if (damagedSheep == 20) {
				victory();
			}
		}
		sendMess();
		// $(point).html(html);
	}});
}

function sbGame() {
	goTo("BsGame.html");
}
function createSbGame() {
	goTo("BsCreateGame.html");
}
function connectSbGame() {
	goTo("BsConectGame.html");
};
function start(ct) {
	getSheeps();
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
	$.post("sheepsReady.html", {
		sheepsReady : stringa,
		connType : ct
	}, function(data) {
		if (data == "OK") {
			goTo("BsGameStart.html");
		}
	});
};
function getSheeps() {
	M1 = new Array();
	for ( var i = 0; i < 15; i++) {
		M1[i] = new Array();
		for ( var j = 0; j < 15; j++) {
			if ((i < 10) && (j < 10)) {
				M1[i][j] = M[i][j];
			} else {
				M1[i][j] = "00";
			}
		}
		;
	}
	;
	for ( var k = 0; k <= 9; k++) {
		for ( var i = 0; i <= 9; i++) {
			for ( var j = 0; j <= 9; j++) {
				if ((M1[i][j] == "41") && (sheepCounter == 10)) {
					if ((M1[i + 1][j] == "41") && (M1[i + 2][j] == "41")
							&& (M1[i + 3][j] == "41")) {
						img10 = ("images/SB/04.png");
						M1[i][j] = "00";
						M1[i + 1][j] = "00";
						M1[i + 2][j] = "00";
						M1[i + 3][j] = "00";
						img10x = i * 20 + 200;
						img10y = j * 20;
						sheepCounter++;
					} else if ((M1[i][j] == "41") && (M1[i][j + 1] == "41")
							&& (M1[i][j + 2] == "41") && (M1[i][j + 3] == "41")) {
						img10 = ("images/SB/04_90.png");
						M1[i][j] = "00";
						M1[i][j + 1] = "00";
						M1[i][j + 2] = "00";
						M1[i][j + 3] = "00";
						img10x = i * 20 + 200;
						img10y = j * 20;
						sheepCounter++;
					}
				}
				if ((M1[i][j] == "31") && (sheepCounter == 9)) {
					if ((M1[i + 1][j] == "31") && (M1[i + 2][j] == "31")) {
						img09 = ("images/SB/03.png");
						M1[i][j] = "00";
						M1[i + 1][j] = "00";
						M1[i + 2][j] = "00";
						img09x = i * 20 + 200;
						img09y = j * 20;
						sheepCounter++;
					} else if ((M1[i][j] == "31") && (M1[i][j + 1] == "31")
							&& (M1[i][j + 2] == "31")) {
						img09 = ("images/SB/03_90.png");
						M1[i][j] = "00";
						M1[i][j + 1] = "00";
						M1[i][j + 2] = "00";
						img09x = i * 20 + 200;
						img09y = j * 20;
						sheepCounter++;
					}

				}
				if ((M1[i][j] == "31") && (sheepCounter == 8)) {
					if ((M1[i + 1][j] == "31") && (M1[i + 2][j] == "31")) {
						img08 = ("images/SB/03.png");
						M1[i][j] = "00";
						M1[i + 1][j] = "00";
						M1[i + 2][j] = "00";
						img08x = i * 20 + 200;
						img08y = j * 20;
						sheepCounter++;
					} else if ((M1[i][j] == "31") && (M1[i][j + 1] == "31")
							&& (M1[i][j + 2] == "31")) {
						img08 = ("images/SB/03_90.png");
						M1[i][j] = "00";
						M1[i][j + 1] = "00";
						M1[i][j + 2] = "00";
						img08x = i * 20 + 200;
						img08y = j * 20;
						sheepCounter++;
					}
				}
				if ((M1[i][j] == "21") && (sheepCounter == 7)) {
					if (M1[i + 1][j] == "21") {
						img07 = ("images/SB/02.png");
						M1[i][j] = "00";
						M1[i + 1][j] = "00";
						img07x = i * 20 + 200;
						img07y = j * 20;
						sheepCounter++;
					} else if ((M1[i][j] == "21") && (M1[i][j + 1] == "21")) {
						img07 = ("images/SB/02_90.png");
						M1[i][j] = "00";
						M1[i][j + 1] = "00";
						img07x = i * 20 + 200;
						img07y = j * 20;
						sheepCounter++;
					}
				}
				if ((M1[i][j] == "21") && (sheepCounter == 6)) {
					if (M1[i + 1][j] == "21") {
						img06 = ("images/SB/02.png");
						M1[i][j] = "00";
						M1[i + 1][j] = "00";
						img06x = i * 20 + 200;
						img06y = j * 20;
						sheepCounter++;
					} else if ((M1[i][j] == "21") && (M1[i][j + 1] == "21")) {
						img06 = ("images/SB/02_90.png");
						M1[i][j] = "00";
						M1[i][j + 1] = "00";
						img06x = i * 20 + 200;
						img06y = j * 20;
						sheepCounter++;
					}
				}
				if ((M1[i][j] == "21") && (sheepCounter == 5)) {
					if ((M1[i][j] == "21") && (M1[i + 1][j] == "21")) {
						img05 = ("images/SB/02.png");
						M1[i][j] = "00";
						M1[i + 1][j] = "00";
						img05x = i * 20 + 200;
						img05y = j * 20;
						sheepCounter++;
					} else if ((M1[i][j] == "21") && (M1[i][j + 1] == "21")) {
						img05 = ("images/SB/02_90.png");
						M1[i][j] = "00";
						M1[i][j + 1] = "00";
						img05x = i * 20 + 200;
						img05y = j * 20;
						sheepCounter++;
					}
				}
				if ((M1[i][j] == "11") && (sheepCounter == 4)) {
					img04 = ("images/SB/01.png");
					M1[i][j] = "00";
					img04x = i * 20 + 200;
					img04y = j * 20;
					sheepCounter++;
				}
				if ((M1[i][j] == "11") && (sheepCounter == 3)) {
					img03 = ("images/SB/01.png");
					M1[i][j] = "00";
					img03x = i * 20 + 200;
					img03y = j * 20;
					sheepCounter++;
				}
				if ((M1[i][j] == "11") && (sheepCounter == 2)) {
					img02 = ("images/SB/01.png");
					M1[i][j] = "00";
					img02x = i * 20 + 200;
					img02y = j * 20;
					sheepCounter++;
				}
				if ((M1[i][j] == "11") && (sheepCounter == 1)) {
					img01 = ("images/SB/01.png");
					M1[i][j] = "00";
					img01x = i * 20 + 200;
					img01y = j * 20;
					sheepCounter++;
				}
			}
		}
	}
};

function showRules() {
	goTo("rules.html");
}


/*
 * 
 * 
 * 
 * 
 */

//$(window).resize(function() {
//	getScale();
//	console.log(this.size);
//});

//var sw = screen.width;
//var sh = screen.height;
//var iw = window.innerWidth;
//var ih = window.innerHeight;
//function getValues(){
//  sw = screen.width;
//  sh = screen.height;
//  iw = window.innerWidth;
//  ih = window.innerHeight;
//  
//  console.log(sw, sh, iw, ih);
//  
//}
//function getScale() {
//  if (Math.round(window.innerWidth*100/iw) !=     Math.round(window.innerHeight*100/ih)){
//    //зум не изменился, поменялись размеры окна
//    getValues(); //обновим значения ширины и высоты
//  }
//  else {
//    //изменился уровень зума
//    scale = Math.round(iw/window.innerWidth * 100);
//    console.log(scale);
//  }
//}