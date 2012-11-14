/*
 * @author Gutey Bogdan
 * 
 */
var userAgent;
var bsound;
//матриця розташування кораблів
var M;
var damagedSheep = 0;
var unlockDroppableInfo;


$(document).ready(function() {
	userAgent = navigator.userAgent;
	bsound = new Audio;
	if( userAgent.indexOf("Chrome")!=-1 )
	{
		bsound.src = "sound/More1.mp3";
	}
	
	if( userAgent.indexOf("Firefox")!=-1)
	{
		bsound.src = "sound/More9.wav";
	}
	bsound.loop=true;
	startbsound();
});

function stopbsound() {
	bsound.pause();
}

function startbsound() {
	bsound.volume=0.1;
	bsound.play();
}

function chSound() {
	id = $('.sound img').attr('id');
	if(id=="s_on") {
			s_off = '<img id="s_off" src="images/SB/s_off.png" onclick="chSound();">';
			$('.sound').html(s_off);
			stopbsound();
	} else 	if(id=="s_off")	{
		s_on = '<img id="s_on" src="images/SB/s_on.png" onclick="chSound();">';
		$('.sound').html(s_on);
		 startbsound();
	}
}

//Перевертає корабель якщо корабель не в полі бою
function rotate(obj) {
	console.log($(obj));
	id = $(obj).attr('id');
	infield = $(obj)[0].classList[1] === "infield";
	console.log(infield);
	isDisabled = $(obj/*'#' + id*/).draggable('option', 'disabled');
	console.log(isDisabled);
	if (!isDisabled && !infield) {
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
	else{
		
		console.log("rotate корабля в полі");
		//Ф-ія має розблоковувати всі заблоковіні дропабли навколо корабля
		// протележна до disableDroppables()
		enableDroppables(unlockDroppableInfo);
			
		
		
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
		};
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
		//console.log(co);
		return co;
	};
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
				'<img id="sheep_' + saveCoordenates.t + '" class="H infield" src="images/SB/0'
						+ saveCoordenates.t + '.png" ondblclick="bbb(this,event);"/>');
		$('#sp' + saveCoordenates.t + count).css("top",
				saveCoordenates.ui.position.top + "px");
		$('#sp' + saveCoordenates.t + count).css("left",
				saveCoordenates.ui.position.left + "px");
		$('#sp' + saveCoordenates.t + count).css("display", "block");
	} else if (saveCoordenates.r === "V") {
		console.log(saveCoordenates.ui);
		$('#sp' + saveCoordenates.t + count).html(
				'<img id="sheep_' + saveCoordenates.t + '" class="V infield" src="images/SB/0'
						+ saveCoordenates.t + '_90.png" ondblclick="bbb(this,event);"/>');
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
function bbb(t,event)
{
	
	if (event.ctrlKey==1)
	  {
		//alert("The CTRL key was pressed!");
		//console.log(t);
		//console.log(event);
		
		
		d = $(t).parent();
		
		
		sheepId = $(t).attr('id');
		topPx=d[0].offsetTop;
		leftPx=d[0].offsetLeft;
		placeHolderId=d[0].id; 
		rotation = d[0].firstChild.className[0];
		
		unlockDroppableInfo ={
				"sheepId" : sheepId,
				"topPx" : topPx,
				"leftPx" : leftPx,
				"placeHolderId" : placeHolderId, 
				"rotation" : rotation
		};
			
		//console.log(d);
		console.log("top="+unlockDroppableInfo.topPx);
		console.log("left="+unlockDroppableInfo.leftPx);
		console.log("sheepId="+unlockDroppableInfo.sheepId);
		console.log("placeHolderId="+unlockDroppableInfo.placeHolderId);
		console.log("rotation="+unlockDroppableInfo.rotation);

		//Активовуємо драгабл на кораблі по якому даблклікнули+CTRL
		$(t).draggable({
			revert : "invalid",
			//helper : "clone",
			//revertDuration : 500,
			cursorAt : {
				top : 10,
				left : 10
			},
			snap:".ui-droppable",
			start : function(event,ui)
			{
				console.log("druging started");
				enableDroppables(unlockDroppableInfo);
			}
		});
		
		
		
		$(t).attr('ondblclick','rotate(this);');
		
	}
}

//Ф-ія має розблоковувати всі заблоковіні дропабли навколо корабля
//+встановлювати в матриці 00 на місце де був розташований корабель  
// протележна до disableDroppables()
function enableDroppables(unlockDroppableInfo)
{
	console.log("провірити чи дективовані дропабли навколо корабля. " +
						"Якщо дективовані то активувати всі заблоковані дропабли навколо корабля"
						+"встановлювати в матриці 00 на місце де був розташований корабель");
	setOldCoordsInM();
}

function setOldCoordsInM()
{}






















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
			$("#X" + x1 + "_Y" + y1).droppable("option", "disabled", true);
			$("#X" + x3 + "_Y" + y0).droppable("option", "disabled", true);
			$("#X" + x3 + "_Y" + y2).droppable("option", "disabled", true);
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
			$("#X" + x1 + "_Y" + y1).droppable("option", "disabled", true);
			$("#X" + x3 + "_Y" + y0).droppable("option", "disabled", true);
			$("#X" + x3 + "_Y" + y2).droppable("option", "disabled", true);
			$("#X" + x3 + "_Y" + y1).droppable("option", "disabled", true);
			$("#X" + x4 + "_Y" + y0).droppable("option", "disabled", true);
			$("#X" + x4 + "_Y" + y2).droppable("option", "disabled", true);
			$("#X" + x4 + "_Y" + y1).droppable("option", "disabled", true);
			$("#X" + x5 + "_Y" + y0).droppable("option", "disabled", true);
			$("#X" + x5 + "_Y" + y2).droppable("option", "disabled", true);
			$("#X" + x5 + "_Y" + y1).droppable("option", "disabled", true);
		};
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
			$("#X" + x2 + "_Y" + y3).droppable("option", "disabled", true);
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
			$("#X" + x2 + "_Y" + y3).droppable("option", "disabled", true);
			$("#X" + x2 + "_Y" + y4).droppable("option", "disabled", true);
			$("#X" + x2 + "_Y" + y5).droppable("option", "disabled", true);
			$("#X" + x1 + "_Y" + y0).droppable("option", "disabled", true);
			$("#X" + x1 + "_Y" + y2).droppable("option", "disabled", true);
			$("#X" + x1 + "_Y" + y1).droppable("option", "disabled", true);
			$("#X" + x1 + "_Y" + y3).droppable("option", "disabled", true);
			$("#X" + x1 + "_Y" + y4).droppable("option", "disabled", true);
			$("#X" + x1 + "_Y" + y5).droppable("option", "disabled", true);
		};
	};
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
		"j" : M[9],
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
function allreadyShooted()
{
	alert("You allready shoot in this point");
}

function allreadyDamaged() {
	alert("You allready damaged this point");
}

function cantBe() {
	alert("There cant be sheep!");
}

function lockWhereCantBe(id) {
	x1 = parseInt(id[2]) - 1;
	y1 = parseInt(id[5]) - 1;
	x2 = parseInt(id[2]);
	y2 = parseInt(id[5]);
	x3 = 1 + parseInt(id[2]);
	y3 = 1 + parseInt(id[5]);
	if ($("#X" + x1 + "_Y" + y1).attr("onclick") == "fire(this)") {
		$("#X" + x1 + "_Y" + y1).html("<img id='cant_be" + x1 + y1 + "' src='images/SB/cant_be.png'>");
		$("#X" + x1 + "_Y" + y1).attr("onclick", "cantBe()");
	}
	if ($("#X" + x2 + "_Y" + y1).attr("onclick") == "fire(this)") {
		$("#X" + x2 + "_Y" + y1).html("<img id='cant_be" + x2 + y1 + "' src='images/SB/cant_be.png'>");
		$("#X" + x2 + "_Y" + y1).attr("onclick", "cantBe()");
	}
	if ($("#X" + x3 + "_Y" + y1).attr("onclick") == "fire(this)") {
		$("#X" + x3 + "_Y" + y1).html("<img id='cant_be" + x3 + y1 + "' src='images/SB/cant_be.png'>");
		$("#X" + x3 + "_Y" + y1).attr("onclick", "cantBe()");
	}
	if ($("#X" + x1 + "_Y" + y2).attr("onclick") == "fire(this)") {
		$("#X" + x1 + "_Y" + y2).html("<img id='cant_be" + x1 + y2 + "' src='images/SB/cant_be.png'>");
		$("#X" + x1 + "_Y" + y2).attr("onclick", "cantBe()");
	}
	if ($("#X" + x3 + "_Y" + y2).attr("onclick") == "fire(this)") {
		$("#X" + x3 + "_Y" + y2).html("<img id='cant_be" + x3 + y2 + "' src='images/SB/cant_be.png'>");
		$("#X" + x3 + "_Y" + y2).attr("onclick", "cantBe()");
	}
	if ($("#X" + x1 + "_Y" + y3).attr("onclick") == "fire(this)") {
		$("#X" + x1 + "_Y" + y3).html("<img id='cant_be" + x1 + y3 + "' src='images/SB/cant_be.png'>");
		$("#X" + x1 + "_Y" + y3).attr("onclick", "cantBe()");
	}
	if ($("#X" + x2 + "_Y" + y3).attr("onclick") == "fire(this)") {
		$("#X" + x2 + "_Y" + y3).html("<img id='cant_be" + x2 + y3 + "' src='images/SB/cant_be.png'>");
		$("#X" + x2 + "_Y" + y3).attr("onclick", "cantBe()");
	}
	if ($("#X" + x3 + "_Y" + y3).attr("onclick") == "fire(this)") {
		$("#X" + x3 + "_Y" + y3).html("<img id='cant_be" + x3 + y3 + "' src='images/SB/cant_be.png'>");
		$("#X" + x3 + "_Y" + y3).attr("onclick", "cantBe()");
	}
}
function victory() {
	location.href = "Victory.html";
}

function playShootSound()
{
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
}


function fire(point) {
	playShootSound();

	p = $(point).attr('id');
	p = p[1] + '' + p[4];
	$.post("fire.html", {
		firePoint : p
	}, function(data) {
		obj = eval(data);
		//Міняєм ф-ію на обстріляній клітинці
		if (obj.miss==="00") {
			$(point).attr("onclick", "allreadyShooted();");
		} else {
			$(point).attr("onclick", "allreadyDamaged();");
		}
			
			
			
		rand = Math.floor((Math.random() * 5) + 1);
		if(obj.miss==="00")
		{
			html = "<img id='fireP" + p + "' src='images/SB/missPoint" + rand + ".png'>";
			$("#locker").css("visibility", "visible");
		}
		else
		{		
			html = "<img id='fireP" + p + "' src='images/SB/firePoint" + rand + ".png'>";
			$("#locker").css("visibility", "hidden");
		}
		if(obj.miss==="10") {
			if (damagedSheep == 20) {
				victory();
			}
			lockWhereCantBe("#" + point.id);
			damagedSheep++;
			if (damagedSheep == 20) {
				victory();
			}
		}
		if (obj.miss==="20") {
			x1 = parseInt(point.id[1]) - 1;
			y1 = parseInt(point.id[4]) - 1;
			x2 = parseInt(point.id[1]);
			y2 = parseInt(point.id[4]);
			x3 = 1 + parseInt(point.id[1]);
			y3 = 1 + parseInt(point.id[4]);
			leftP = "#X" + x1 + "_Y" + y2;
			topP =  "#X" + x2 + "_Y" + y1;
			rightP =  "#X" + x3 + "_Y" + y2;
			bottomP =  "#X" + x2 + "_Y" + y3;
			
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
		if (obj.miss==="30") {
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
			
			topP1 =  "#X" + x3 + "_Y" + y1;
			topP2 =  "#X" + x3 + "_Y" + y2;
			
			rightP1 =  "#X" + x4 + "_Y" + y3;
			rightP2 =  "#X" + x5 + "_Y" + y3;
			
			bottomP1 =  "#X" + x3 + "_Y" + y4;
			bottomP2 =  "#X" + x3 + "_Y" + y5;
			
			
			if (($(leftP1).attr("onclick") == "allreadyDamaged();") && ($(leftP2).attr("onclick") == "allreadyDamaged();")) {
				lockWhereCantBe("#" + point.id);
				lockWhereCantBe(leftP1);
				lockWhereCantBe(leftP2);
			}
			if (($(rightP1).attr("onclick") == "allreadyDamaged();") && ($(leftP2).attr("onclick") == "allreadyDamaged();")) {
				lockWhereCantBe("#" + point.id);
				lockWhereCantBe(rightP1);
				lockWhereCantBe(leftP2);
			}
			if (($(rightP1).attr("onclick") == "allreadyDamaged();") && ($(rightP2).attr("onclick") == "allreadyDamaged();")) {
				lockWhereCantBe("#" + point.id);
				lockWhereCantBe(rightP1);
				lockWhereCantBe(rightP2);
			}
			if (($(topP1).attr("onclick") == "allreadyDamaged();") && ($(topP2).attr("onclick") == "allreadyDamaged();")) {
				lockWhereCantBe("#" + point.id);
				lockWhereCantBe(topP1);
				lockWhereCantBe(topP2);
			}
			if (($(bottomP1).attr("onclick") == "allreadyDamaged();") && ($(topP2).attr("onclick") == "allreadyDamaged();")) {
				lockWhereCantBe("#" + point.id);
				lockWhereCantBe(bottomP1);
				lockWhereCantBe(topP2);
			}
			if (($(bottomP1).attr("onclick") == "allreadyDamaged();") && ($(bottomP2).attr("onclick") == "allreadyDamaged();")) {
				lockWhereCantBe("#" + point.id);
				lockWhereCantBe(bottomP1);
				lockWhereCantBe(bottomP2);
			}
			damagedSheep++;
			if (damagedSheep == 20) {
				victory();
			}
		}
		if (obj.miss==="40") {
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
			
			topP1 =  "#X" + x4 + "_Y" + y1;
			topP2 =  "#X" + x4 + "_Y" + y2;
			topP3 =  "#X" + x4 + "_Y" + y3;
			
			rightP1 =  "#X" + x5 + "_Y" + y4;
			rightP2 =  "#X" + x6 + "_Y" + y4;
			rightP3 =  "#X" + x7 + "_Y" + y4;
			
			bottomP1 =  "#X" + x4 + "_Y" + y5;
			bottomP2 =  "#X" + x4 + "_Y" + y6;
			bottomP3 =  "#X" + x4 + "_Y" + y7;
			
			
			if (($(leftP1).attr("onclick") == "allreadyDamaged();") && ($(leftP2).attr("onclick") == "allreadyDamaged();") && ($(leftP3).attr("onclick") == "allreadyDamaged();")) {
				lockWhereCantBe("#" + point.id);
				lockWhereCantBe(leftP1);
				lockWhereCantBe(leftP2);
				lockWhereCantBe(leftP3);
			}
			if (($(rightP1).attr("onclick") == "allreadyDamaged();") && ($(leftP2).attr("onclick") == "allreadyDamaged();") && ($(leftP3).attr("onclick") == "allreadyDamaged();")) {
				lockWhereCantBe("#" + point.id);
				lockWhereCantBe(rightP1);
				lockWhereCantBe(leftP2);
				lockWhereCantBe(leftP3);
			}
			if (($(rightP1).attr("onclick") == "allreadyDamaged();") && ($(rightP2).attr("onclick") == "allreadyDamaged();") && ($(leftP3).attr("onclick") == "allreadyDamaged();")) {
				lockWhereCantBe("#" + point.id);
				lockWhereCantBe(rightP1);
				lockWhereCantBe(rightP2);
				lockWhereCantBe(leftP3);
			}
			if (($(rightP1).attr("onclick") == "allreadyDamaged();") && ($(rightP2).attr("onclick") == "allreadyDamaged();") && ($(rightP3).attr("onclick") == "allreadyDamaged();")) {
				lockWhereCantBe("#" + point.id);
				lockWhereCantBe(rightP1);
				lockWhereCantBe(rightP2);
				lockWhereCantBe(rightP3);
			}
			if (($(topP1).attr("onclick") == "allreadyDamaged();") && ($(topP2).attr("onclick") == "allreadyDamaged();") && ($(topP3).attr("onclick") == "allreadyDamaged();")) {
				lockWhereCantBe("#" + point.id);
				lockWhereCantBe(topP1);
				lockWhereCantBe(topP2);
				lockWhereCantBe(topP3);
			}
			if (($(bottomP1).attr("onclick") == "allreadyDamaged();") && ($(topP2).attr("onclick") == "allreadyDamaged();") && ($(topP3).attr("onclick") == "allreadyDamaged();")) {
				lockWhereCantBe("#" + point.id);
				lockWhereCantBe(bottomP1);
				lockWhereCantBe(topP2);
				lockWhereCantBe(topP3);
			}
			if (($(bottomP1).attr("onclick") == "allreadyDamaged();") && ($(bottomP2).attr("onclick") == "allreadyDamaged();") && ($(topP3).attr("onclick") == "allreadyDamaged();")) {
				lockWhereCantBe("#" + point.id);
				lockWhereCantBe(bottomP1);
				lockWhereCantBe(bottomP2);
				lockWhereCantBe(topP3);
			}
			if (($(bottomP1).attr("onclick") == "allreadyDamaged();") && ($(bottomP2).attr("onclick") == "allreadyDamaged();") && ($(bottomP3).attr("onclick") == "allreadyDamaged();")) {
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
		$(point).html(html);
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
};