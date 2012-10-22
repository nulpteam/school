/*author Gutey Bogdan*/




//Перевертає корабель якщо корабель не в полі бою
function rotate(obj)
{
	
	id = $(obj).attr('id');
	isDisabled = $('#'+id).draggable( 'option', 'disabled');
	if(!isDisabled)
	{
	var c= $(obj).attr("class");
	
	var orientation = c[0];
	var newOrientation = 'H';
	
	if(orientation==='H')
		{
			newOrientation='V';
			width = $(obj).css("width");
			height = $(obj).css("height");
			temp = width;
			width = height;
			height = temp;
			$(obj).css("height",height);
			$(obj).css("width",width);
		}
	else
		if(orientation==='V')
		{
			newOrientation='H';
			width = $(obj).css("width");
			height = $(obj).css("height");
			temp = width;
			width = height;
			height = temp;
			$(obj).css("height",height);
			$(obj).css("width",width);
		}
		var set = c.substring(1, c.length);
		set = newOrientation+set;
		$(obj).attr("class",set);
	}
}

// матриця розташування кораблів
var M;
// Створює пусту матрицю
function createMatrix()
{
	M = new Array();
	for(var i=0;i<10;i++)
	{
		M[i] = new Array();
		for(var j=0;j<10;j++)
		{
			M[i][j]="00";
		}
	}
	return M;
}



// Виводить в консоль поточний стан матриці
function getM()
{
	console.log(M);
}



// Створює обєкт
/**
 * t= тип корабля r = горизонтальне/вертикальне положення x\y = координати
 * положення корабля на полі Доробити положення горизонтальне/вертикальне
 */
function parseCoords(coords,t,c)
{
	//if (c !== undefined) {
		var x,y,type;
		
		x = parseInt(coords[1]);
		y =  parseInt(coords[4]);
		type = parseInt(t[6]);
		var co = {		"t" : type,
						"r" : c[0],
						"x" : x, 
						"y" : y };
		console.log(co);
		return co;
	//}
}

/**
 * Зберігає положення корабля в матрицю Доробити положення
 * горизонтальне/вертикальне
 * 
 */
var i=0;
function saveCoords(coords,t,c)
{
	
	var saveCoordenates = parseCoords(coords,t,c);
	// Деактивовуємо дроппабли в які вже встановлено кораблик
	disableDroppables(saveCoordenates);
	// зберігає
	M[saveCoordenates.x][saveCoordenates.y]=saveCoordenates.t+"1";
	i++;
	alert(i);
	alert(saveCoordenates.t);
	
	if(i==saveCoordenates.t)
	{		alert('SEND');
	// посилаємо на сервер
		sendM();
		i=0;
	}
	
}



// Деактивовує елементи droppable за координатами
// Доробити!!!!!!!!!!!!!!!!!!!!!!!
function disableDroppables(obj)
{
	console.log(obj);
 var x0 = obj.x - 1;
 var x1 = obj.x + 1;
 var x2 = obj.x;
 var x3 = obj.x + 2;
 var x4 = obj.x + 3;
 var x5 = obj.x + 4;
 var y0 = obj.y - 1;
 var y1 = obj.y + 1;
 var y2 = obj.y;
 var y3 = obj.y + 2;
 var y4 = obj.y + 3;
 var y5 = obj.y + 4;
 
	if (obj.r == "u") {
		$("#X"+x0+"_Y"+y0).droppable( "option", "disabled", true);
		$("#X"+x0+"_Y"+y2).droppable( "option", "disabled", true);
		$("#X"+x0+"_Y"+y1).droppable( "option", "disabled", true);
		$("#X"+x2+"_Y"+y0).droppable( "option", "disabled", true);
		$("#X"+x2+"_Y"+y2).droppable( "option", "disabled", true);
		$("#X"+x2+"_Y"+y1).droppable( "option", "disabled", true);
		$("#X"+x1+"_Y"+y0).droppable( "option", "disabled", true);
		$("#X"+x1+"_Y"+y2).droppable( "option", "disabled", true);
		$("#X"+x1+"_Y"+y1).droppable( "option", "disabled", true);
	}
	
	if (obj.r == "H") {
		if (obj.t == "2") {
			$("#X"+x0+"_Y"+y0).droppable( "option", "disabled", true);
			$("#X"+x0+"_Y"+y2).droppable( "option", "disabled", true);
			$("#X"+x0+"_Y"+y1).droppable( "option", "disabled", true);
			$("#X"+x2+"_Y"+y0).droppable( "option", "disabled", true);
			$("#X"+x2+"_Y"+y2).droppable( "option", "disabled", true);
			$("#X"+x2+"_Y"+y1).droppable( "option", "disabled", true);
			$("#X"+x1+"_Y"+y0).droppable( "option", "disabled", true);
			$("#X"+x1+"_Y"+y2).droppable( "option", "disabled", true);
			$("#X"+x1+"_Y"+y1).droppable( "option", "disabled", true);
			$("#X"+x3+"_Y"+y0).droppable( "option", "disabled", true);
			$("#X"+x3+"_Y"+y2).droppable( "option", "disabled", true);
			$("#X"+x3+"_Y"+y1).droppable( "option", "disabled", true);
		}
		if (obj.t == "3") {
			$("#X"+x0+"_Y"+y0).droppable( "option", "disabled", true);
			$("#X"+x0+"_Y"+y2).droppable( "option", "disabled", true);
			$("#X"+x0+"_Y"+y1).droppable( "option", "disabled", true);
			$("#X"+x2+"_Y"+y0).droppable( "option", "disabled", true);
			$("#X"+x2+"_Y"+y2).droppable( "option", "disabled", true);
			$("#X"+x2+"_Y"+y1).droppable( "option", "disabled", true);
			$("#X"+x1+"_Y"+y0).droppable( "option", "disabled", true);
			$("#X"+x1+"_Y"+y2).droppable( "option", "disabled", true);
			$("#X"+x1+"_Y"+y1).droppable( "option", "disabled", true);
			$("#X"+x3+"_Y"+y0).droppable( "option", "disabled", true);
			$("#X"+x3+"_Y"+y2).droppable( "option", "disabled", true);
			$("#X"+x3+"_Y"+y1).droppable( "option", "disabled", true);
			$("#X"+x4+"_Y"+y0).droppable( "option", "disabled", true);
			$("#X"+x4+"_Y"+y2).droppable( "option", "disabled", true);
			$("#X"+x4+"_Y"+y1).droppable( "option", "disabled", true);
		}
		if (obj.t == "4") {
			$("#X"+x0+"_Y"+y0).droppable( "option", "disabled", true);
			$("#X"+x0+"_Y"+y2).droppable( "option", "disabled", true);
			$("#X"+x0+"_Y"+y1).droppable( "option", "disabled", true);
			$("#X"+x2+"_Y"+y0).droppable( "option", "disabled", true);
			$("#X"+x2+"_Y"+y2).droppable( "option", "disabled", true);
			$("#X"+x2+"_Y"+y1).droppable( "option", "disabled", true);
			$("#X"+x1+"_Y"+y0).droppable( "option", "disabled", true);
			$("#X"+x1+"_Y"+y2).droppable( "option", "disabled", true);
			$("#X"+x1+"_Y"+y1).droppable( "option", "disabled", true);
			$("#X"+x3+"_Y"+y0).droppable( "option", "disabled", true);
			$("#X"+x3+"_Y"+y2).droppable( "option", "disabled", true);
			$("#X"+x3+"_Y"+y1).droppable( "option", "disabled", true);
			$("#X"+x4+"_Y"+y0).droppable( "option", "disabled", true);
			$("#X"+x4+"_Y"+y2).droppable( "option", "disabled", true);
			$("#X"+x4+"_Y"+y1).droppable( "option", "disabled", true);
			$("#X"+x5+"_Y"+y0).droppable( "option", "disabled", true);
			$("#X"+x5+"_Y"+y2).droppable( "option", "disabled", true);
			$("#X"+x5+"_Y"+y1).droppable( "option", "disabled", true);
		}
	}
	if (obj.r == "V") {
		if (obj.t == "2") {
			$("#X"+x0+"_Y"+y0).droppable( "option", "disabled", true);
			$("#X"+x0+"_Y"+y2).droppable( "option", "disabled", true);
			$("#X"+x0+"_Y"+y1).droppable( "option", "disabled", true);
			$("#X"+x0+"_Y"+y3).droppable( "option", "disabled", true);
			$("#X"+x2+"_Y"+y0).droppable( "option", "disabled", true);
			$("#X"+x2+"_Y"+y2).droppable( "option", "disabled", true);
			$("#X"+x2+"_Y"+y1).droppable( "option", "disabled", true);
			$("#X"+x2+"_Y"+y3).droppable( "option", "disabled", true);
			$("#X"+x1+"_Y"+y0).droppable( "option", "disabled", true);
			$("#X"+x1+"_Y"+y2).droppable( "option", "disabled", true);
			$("#X"+x1+"_Y"+y1).droppable( "option", "disabled", true);
			$("#X"+x1+"_Y"+y3).droppable( "option", "disabled", true);
		}
		if (obj.t == "3") {
			$("#X"+x0+"_Y"+y0).droppable( "option", "disabled", true);
			$("#X"+x0+"_Y"+y2).droppable( "option", "disabled", true);
			$("#X"+x0+"_Y"+y1).droppable( "option", "disabled", true);
			$("#X"+x0+"_Y"+y3).droppable( "option", "disabled", true);
			$("#X"+x0+"_Y"+y4).droppable( "option", "disabled", true);
			$("#X"+x2+"_Y"+y0).droppable( "option", "disabled", true);
			$("#X"+x2+"_Y"+y2).droppable( "option", "disabled", true);
			$("#X"+x2+"_Y"+y1).droppable( "option", "disabled", true);
			$("#X"+x2+"_Y"+y3).droppable( "option", "disabled", true);
			$("#X"+x2+"_Y"+y4).droppable( "option", "disabled", true);
			$("#X"+x1+"_Y"+y0).droppable( "option", "disabled", true);
			$("#X"+x1+"_Y"+y2).droppable( "option", "disabled", true);
			$("#X"+x1+"_Y"+y1).droppable( "option", "disabled", true);
			$("#X"+x1+"_Y"+y3).droppable( "option", "disabled", true);
			$("#X"+x1+"_Y"+y4).droppable( "option", "disabled", true);
		}
		if (obj.t == "4") {
			$("#X"+x0+"_Y"+y0).droppable( "option", "disabled", true);
			$("#X"+x0+"_Y"+y2).droppable( "option", "disabled", true);
			$("#X"+x0+"_Y"+y1).droppable( "option", "disabled", true);
			$("#X"+x0+"_Y"+y3).droppable( "option", "disabled", true);
			$("#X"+x0+"_Y"+y4).droppable( "option", "disabled", true);
			$("#X"+x0+"_Y"+y5).droppable( "option", "disabled", true);
			$("#X"+x2+"_Y"+y0).droppable( "option", "disabled", true);
			$("#X"+x2+"_Y"+y2).droppable( "option", "disabled", true);
			$("#X"+x2+"_Y"+y1).droppable( "option", "disabled", true);
			$("#X"+x2+"_Y"+y3).droppable( "option", "disabled", true);
			$("#X"+x2+"_Y"+y4).droppable( "option", "disabled", true);
			$("#X"+x2+"_Y"+y5).droppable( "option", "disabled", true);
			$("#X"+x1+"_Y"+y0).droppable( "option", "disabled", true);
			$("#X"+x1+"_Y"+y2).droppable( "option", "disabled", true);
			$("#X"+x1+"_Y"+y1).droppable( "option", "disabled", true);
			$("#X"+x1+"_Y"+y3).droppable( "option", "disabled", true);
			$("#X"+x1+"_Y"+y4).droppable( "option", "disabled", true);
			$("#X"+x1+"_Y"+y5).droppable( "option", "disabled", true);
		}
	}
}






/**
 * Відсилає матрицю на сервер
 * 
 */
function sendM()
{
	console.log(M);
	
	var j = {
			"a":M[0],
			"b":M[1],
			"c":M[2],
			"d":M[3],
			"e":M[4],
			"f":M[5],
			"g":M[6],
			"h":M[7],
			"i":M[8],
			"j":M[9]			
	};
	console.log(j);
	var Send = JSON.stringify(j);
	console.log(Send);
	
	$.ajax({
		  url: 'init_sheeps.html',
		  type: 'POST',
		  data: {sheeps : Send},
		  dataType :'json',
		  success: function(data) {
		    alert(data);
		  },
		  error: function()
		  {
			  alert("ERROR");
		  }
		});
	
}

/**
 * Видалає з матриці старі координати
 * 
 */
function clearOldCoordsInM(coords, type)
{
	var saveCoordenates = parseCoords(coords,type);
	if (saveCoordenates !== undefined) {
		M[saveCoordenates.x][saveCoordenates.y]="00";
	}
}
