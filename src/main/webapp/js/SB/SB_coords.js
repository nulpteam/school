/*
 * @author Gutey Bogdan
 * 
 */
var userAgent;
var bsound;
//матриця розташування кораблів
var M;


$(document).ready(function() 
{
	userAgent = navigator.userAgent;
	//
	bsound = new Audio;
	if( userAgent.indexOf("Chrome")!=-1 )
	{
		bsound.src = "sound/More1.mp3";
	}
	
	if( userAgent.indexOf("Firefox")!=-1)
	{
		bsound.src = "sound/More13.wav";
	}
	bsound.loop=true;
	startbsound();
});
function stopbsound()
{
	bsound.pause();
}
function startbsound()
{
	bsound.volume=0.3;
	bsound.play();
}
function chSound()
{
	id = $('.sound img').attr('id');
	if(id=="s_on")
		{
			s_off = '<img id="s_off" src="images/SB/s_off.png" onclick="chSound();">';
			$('.sound').html(s_off);
			stopbsound();
		}else
	if(id=="s_off")
	{
		s_on = '<img id="s_on" src="images/SB/s_on.png" onclick="chSound();">';
		$('.sound').html(s_on);
		 startbsound();
	}
}

//Перевертає корабель якщо корабель не в полі бою
function rotate(obj) {
	console.log(obj);
	id = $(obj).attr('id');
	isDisabled = $('#' + id).draggable('option', 'disabled');
	if (!isDisabled) {
		var c = $(obj).attr("class");
			orientation = c[0];
			newOrientation = 'H';

		if (orientation === 'H') {
			newOrientation = 'V';
			$(obj).attr("src", "images/SB/0" + id[6] + "_90.png");
			console.log(obj);
		} else if (orientation === 'V') {
			newOrientation = 'H';
			$(obj).attr("src", "images/SB/0" + id[6] + ".png");
			console.log(obj);
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
			"ui" : ui
		};
		console.log(co);
		return co;
	}
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
	console.log(img);
	count = counter(saveCoordenates) + 1;
	if (saveCoordenates.r === "H" || saveCoordenates.r === "u") {
		console.log(saveCoordenates.ui);
		$('#sp' + saveCoordenates.t + count).html(
				'<img id="sheep_' + saveCoordenates.t + '" src="images/SB/0'
						+ saveCoordenates.t + '.png"/>');
		$('#sp' + saveCoordenates.t + count).css("top",
				saveCoordenates.ui.position.top + "px");
		$('#sp' + saveCoordenates.t + count).css("left",
				saveCoordenates.ui.position.left + "px");
		$('#sp' + saveCoordenates.t + count).css("display", "block");
	} else if (saveCoordenates.r === "V") {
		console.log(saveCoordenates.ui);
		$('#sp' + saveCoordenates.t + count).html(
				'<img id="sheep_' + saveCoordenates.t + '" src="images/SB/0'
						+ saveCoordenates.t + '_90.png"/>');
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

// Деактивовує елементи droppable за координатами
function disableDroppables(obj) {
	// console.log(obj);
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
		$("#X" + x0 + "_Y" + y0).droppable("option", "disabled", true);
		$("#X" + x0 + "_Y" + y2).droppable("option", "disabled", true);
		$("#X" + x0 + "_Y" + y1).droppable("option", "disabled", true);
		$("#X" + x2 + "_Y" + y0).droppable("option", "disabled", true);
		$("#X" + x2 + "_Y" + y2).droppable("option", "disabled", true);
		$("#X" + x2 + "_Y" + y1).droppable("option", "disabled", true);
		$("#X" + x1 + "_Y" + y0).droppable("option", "disabled", true);
		$("#X" + x1 + "_Y" + y2).droppable("option", "disabled", true);
		$("#X" + x1 + "_Y" + y1).droppable("option", "disabled", true);
	}

	if (obj.r == "H") {
		if (obj.t == "2") {
			$("#X" + x0 + "_Y" + y0).droppable("option", "disabled", true);
			$("#X" + x0 + "_Y" + y2).droppable("option", "disabled", true);
			$("#X" + x0 + "_Y" + y1).droppable("option", "disabled", true);
			$("#X" + x2 + "_Y" + y0).droppable("option", "disabled", true);
			$("#X" + x2 + "_Y" + y2).droppable("option", "disabled", true);
			$("#X" + x2 + "_Y" + y1).droppable("option", "disabled", true);
			$("#X" + x1 + "_Y" + y0).droppable("option", "disabled", true);
			$("#X" + x1 + "_Y" + y2).droppable("option", "disabled", true);
			$("#X" + x1 + "_Y" + y2).removeClass("hover");
			$("#X" + x1 + "_Y" + y1).droppable("option", "disabled", true);
			$("#X" + x3 + "_Y" + y0).droppable("option", "disabled", true);
			$("#X" + x3 + "_Y" + y2).droppable("option", "disabled", true);
			$("#X" + x3 + "_Y" + y1).droppable("option", "disabled", true);
		}
		if (obj.t == "3") {
			$("#X" + x0 + "_Y" + y0).droppable("option", "disabled", true);
			$("#X" + x0 + "_Y" + y2).droppable("option", "disabled", true);
			$("#X" + x0 + "_Y" + y1).droppable("option", "disabled", true);
			$("#X" + x2 + "_Y" + y0).droppable("option", "disabled", true);
			$("#X" + x2 + "_Y" + y2).droppable("option", "disabled", true);
			$("#X" + x2 + "_Y" + y1).droppable("option", "disabled", true);
			$("#X" + x1 + "_Y" + y0).droppable("option", "disabled", true);
			$("#X" + x1 + "_Y" + y2).droppable("option", "disabled", true);
			$("#X" + x1 + "_Y" + y2).removeClass("hover");
			$("#X" + x1 + "_Y" + y1).droppable("option", "disabled", true);
			$("#X" + x3 + "_Y" + y0).droppable("option", "disabled", true);
			$("#X" + x3 + "_Y" + y2).droppable("option", "disabled", true);
			$("#X" + x3 + "_Y" + y2).removeClass("hover");
			$("#X" + x3 + "_Y" + y1).droppable("option", "disabled", true);
			$("#X" + x4 + "_Y" + y0).droppable("option", "disabled", true);
			$("#X" + x4 + "_Y" + y2).droppable("option", "disabled", true);
			$("#X" + x4 + "_Y" + y1).droppable("option", "disabled", true);
		}
		if (obj.t == "4") {
			$("#X" + x0 + "_Y" + y0).droppable("option", "disabled", true);
			$("#X" + x0 + "_Y" + y2).droppable("option", "disabled", true);
			$("#X" + x0 + "_Y" + y1).droppable("option", "disabled", true);
			$("#X" + x2 + "_Y" + y0).droppable("option", "disabled", true);
			$("#X" + x2 + "_Y" + y2).droppable("option", "disabled", true);
			$("#X" + x2 + "_Y" + y1).droppable("option", "disabled", true);
			$("#X" + x1 + "_Y" + y0).droppable("option", "disabled", true);
			$("#X" + x1 + "_Y" + y2).droppable("option", "disabled", true);
			$("#X" + x1 + "_Y" + y2).removeClass("hover");
			$("#X" + x1 + "_Y" + y1).droppable("option", "disabled", true);
			$("#X" + x3 + "_Y" + y0).droppable("option", "disabled", true);
			$("#X" + x3 + "_Y" + y2).droppable("option", "disabled", true);
			$("#X" + x3 + "_Y" + y2).removeClass("hover");
			$("#X" + x3 + "_Y" + y1).droppable("option", "disabled", true);
			$("#X" + x4 + "_Y" + y0).droppable("option", "disabled", true);
			$("#X" + x4 + "_Y" + y2).droppable("option", "disabled", true);
			$("#X" + x4 + "_Y" + y2).removeClass("hover");
			$("#X" + x4 + "_Y" + y1).droppable("option", "disabled", true);
			$("#X" + x5 + "_Y" + y0).droppable("option", "disabled", true);
			$("#X" + x5 + "_Y" + y2).droppable("option", "disabled", true);
			$("#X" + x5 + "_Y" + y1).droppable("option", "disabled", true);
		}
	}
	if (obj.r == "V") {
		if (obj.t == "2") {
			$("#X" + x0 + "_Y" + y0).droppable("option", "disabled", true);
			$("#X" + x0 + "_Y" + y2).droppable("option", "disabled", true);
			$("#X" + x0 + "_Y" + y1).droppable("option", "disabled", true);
			$("#X" + x0 + "_Y" + y3).droppable("option", "disabled", true);
			$("#X" + x2 + "_Y" + y0).droppable("option", "disabled", true);
			$("#X" + x2 + "_Y" + y2).droppable("option", "disabled", true);
			$("#X" + x2 + "_Y" + y1).droppable("option", "disabled", true);
			$("#X" + x2 + "_Y" + y1).removeClass("hover");
			$("#X" + x2 + "_Y" + y3).droppable("option", "disabled", true);
			$("#X" + x1 + "_Y" + y0).droppable("option", "disabled", true);
			$("#X" + x1 + "_Y" + y2).droppable("option", "disabled", true);
			$("#X" + x1 + "_Y" + y1).droppable("option", "disabled", true);
			$("#X" + x1 + "_Y" + y3).droppable("option", "disabled", true);
		}
		if (obj.t == "3") {
			$("#X" + x0 + "_Y" + y0).droppable("option", "disabled", true);
			$("#X" + x0 + "_Y" + y2).droppable("option", "disabled", true);
			$("#X" + x0 + "_Y" + y1).droppable("option", "disabled", true);
			$("#X" + x0 + "_Y" + y3).droppable("option", "disabled", true);
			$("#X" + x0 + "_Y" + y4).droppable("option", "disabled", true);
			$("#X" + x2 + "_Y" + y0).droppable("option", "disabled", true);
			$("#X" + x2 + "_Y" + y2).droppable("option", "disabled", true);
			$("#X" + x2 + "_Y" + y1).droppable("option", "disabled", true);
			$("#X" + x2 + "_Y" + y1).removeClass("hover");
			$("#X" + x2 + "_Y" + y3).droppable("option", "disabled", true);
			$("#X" + x2 + "_Y" + y3).removeClass("hover");
			$("#X" + x2 + "_Y" + y4).droppable("option", "disabled", true);
			$("#X" + x1 + "_Y" + y0).droppable("option", "disabled", true);
			$("#X" + x1 + "_Y" + y2).droppable("option", "disabled", true);
			$("#X" + x1 + "_Y" + y1).droppable("option", "disabled", true);
			$("#X" + x1 + "_Y" + y3).droppable("option", "disabled", true);
			$("#X" + x1 + "_Y" + y4).droppable("option", "disabled", true);
		}
		if (obj.t == "4") {
			$("#X" + x0 + "_Y" + y0).droppable("option", "disabled", true);
			$("#X" + x0 + "_Y" + y2).droppable("option", "disabled", true);
			$("#X" + x0 + "_Y" + y1).droppable("option", "disabled", true);
			$("#X" + x0 + "_Y" + y3).droppable("option", "disabled", true);
			$("#X" + x0 + "_Y" + y4).droppable("option", "disabled", true);
			$("#X" + x0 + "_Y" + y5).droppable("option", "disabled", true);
			$("#X" + x2 + "_Y" + y0).droppable("option", "disabled", true);
			$("#X" + x2 + "_Y" + y0).droppable("option", "disabled", true);
			$("#X" + x2 + "_Y" + y2).droppable("option", "disabled", true);
			$("#X" + x2 + "_Y" + y1).droppable("option", "disabled", true);
			$("#X" + x2 + "_Y" + y1).removeClass("hover");
			$("#X" + x2 + "_Y" + y3).droppable("option", "disabled", true);
			$("#X" + x2 + "_Y" + y3).removeClass("hover");
			$("#X" + x2 + "_Y" + y4).droppable("option", "disabled", true);
			$("#X" + x2 + "_Y" + y4).removeClass("hover");
			$("#X" + x2 + "_Y" + y5).droppable("option", "disabled", true);
			$("#X" + x1 + "_Y" + y0).droppable("option", "disabled", true);
			$("#X" + x1 + "_Y" + y2).droppable("option", "disabled", true);
			$("#X" + x1 + "_Y" + y1).droppable("option", "disabled", true);
			$("#X" + x1 + "_Y" + y3).droppable("option", "disabled", true);
			$("#X" + x1 + "_Y" + y4).droppable("option", "disabled", true);
			$("#X" + x1 + "_Y" + y5).droppable("option", "disabled", true);
		}
	}
}

/**
 * Відсилає матрицю на сервер
 * 
 */
function sendM() {
	console.log(M);

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
		"j" : M[9]
	};
	var Send = JSON.stringify(j);
	console.log(Send);

	$.ajax({
		url : 'init_sheeps.html',
		type : 'POST',
		data : {
			sheeps : Send,
		},
		success : function(data) {
		},
		error : function() {
			alert("ERROR");
		}
	});
}

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

function fire(point) {
	if( userAgent.indexOf("Chrome")!=-1 )
	{
		sound = new Audio;
		sound.src = "sound/Shoot01.mp3";
		sound.play();
	}
	
	if( userAgent.indexOf("Firefox")!=-1)
	{
		sound = new Audio;
		sound.src = "sound/Shoot01.wav";
		sound.play();
	}

	p = $(point).attr('id');
	p = p[1] + '' + p[4];
	$.post("fire.html", {
		firePoint : p
	}, function(data) {
		if(data==="00")
			{
				rand = Math.floor((Math.random() * 5) + 1);
				$(point).html(
						"<img id='fireP" + p + "' src='images/SB/missPoint" + rand
								+ ".png'>");
				}
		else
			{
				rand = Math.floor((Math.random() * 5) + 1);
				$(point).html(
						"<img id='fireP" + p + "' src='images/SB/firePoint" + rand
								+ ".png'>");
			}
	});
}


function sbGame() {
	location.href = "BsGame.html";
}
function createSbGame() {
	location.href = "BsCreateGame.html";
}
function connectSbGame() {
	location.href = "BsConectGame.html";
}