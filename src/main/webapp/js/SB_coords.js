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

//матриця розташування кораблів
var M;
//Створює пусту матрицю
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



//Створює обєкт
/**
 * t= тип корабля
 * r = горизонтальне/вертикальне положення
 * x\y = координати положення корабля на полі
 * Доробити положення горизонтальне/вертикальне
 * */
function parseCoords(coords,t,c)
{
	var x,y,type;
	
	x = parseInt(coords[1]);
	y =  parseInt(coords[4]);
	type = parseInt(t[6]);
	var co = {"t" : type,
					"r" : c[0],
					"x" : x, 
					"y" : y };
	console.log(co);
	return co;
}

/**
 * Зберігає положення корабля в матрицю 
 * Доробити положення горизонтальне/вертикальне
 * 
 * */
var i=0;
function saveCoords(coords,t,c)
{
	
	var saveCoordenates = parseCoords(coords,t,c);
	console.log(coords,t,c);
	//Деактивовуємо дроппабли в які вже встановлено кораблик
	disableDroppables(saveCoordenates);
	//зберігає
	M[saveCoordenates.x][saveCoordenates.y]=saveCoordenates.t+"1";
	i++;
	if(i==saveCoordenates.t)
	{		
		// посилаємо на сервер
		sendM();
		i=0;
	}
}



//Деактивовує елементи droppable за координатами
//Доробити!!!!!!!!!!!!!!!!!!!!!!!
function disableDroppables(obj)
{
	console.log(obj);
//	//ВСІ ЗАЙНЯТІ
//	$('#X'+OBJ.X+'_Y'+OBJ.Y).DROPPABLE( 'OPTION', 'DISABLED', TRUE);
//	
//	//ПЕРИМЕТР
//	IF(OBJ.R==='H')
//	{
//		
//	}
//	ELSE IF(OBJ.R==='V')
//	{
//		
//	}
//	$('#X'+(OBJ.X+1)+'_Y'+OBJ.Y).DROPPABLE( 'OPTION', 'DISABLED', TRUE);
//	$('#X'+OBJ.X+'_Y'+(OBJ.Y+1)).DROPPABLE( 'OPTION', 'DISABLED', TRUE);
//	
	
	
//	$('#X'+(obj.x-1)+'_Y'+obj.y).droppable( 'option', 'disabled', true);
	
//	$('#X'+obj.x+'_Y'+(obj.y-1)).droppable( 'option', 'disabled', true);
//	$('#X'+(obj.x+1)+'_Y'+(obj.y+1)).droppable( 'option', 'disabled', true);
//	$('#X'+(obj.x-1)+'_Y'+(obj.y-1)).droppable( 'option', 'disabled', true);
}






/**
 * Відсилає матрицю на сервер
 * 
 * */
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
	var saveCoordenates= parseCoords(coords,type);
	M[saveCoordenates.x][saveCoordenates.y]="00";
}
