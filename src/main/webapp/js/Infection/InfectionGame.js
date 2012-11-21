var socket = new WebSocket("ws://localhost:8086");
var field="";
var x="0";
var y="0";
var X="X";
var Y="Y";


$(document).ready(function(){
	
}
);

function move(td) {
	x = parseX(td.id);
	y = parseY(td.id);
	var userType = $('#infgame_table').attr('userType');
	
	var move = {
			"type" : "firstmove",
			"userType" : userType,
			"gameId" : gameId,
			"xcoord": x,
			"ycoord": y,
			"moveType":userType
	};
	socket.send(JSON.stringify(move));
}

function lightFields(td){
	
	//socket.send(td.id);
	
	x = parseX(td.id);
	y = parseY(td.id);
	
	var xTemp = x-0;
	var yTemp = y-0;
	
	//3x3 cover
	var fieldX1 = xTemp-1;
	var fieldY1 = yTemp-1;
	
	var fieldX2 = xTemp;
	var fieldY2 = yTemp-1;
		
	var fieldX3 = xTemp+1;
	var fieldY3 = yTemp-1;
	
	var fieldX4 = xTemp-1;
	var fieldY4 = yTemp;
	
	var fieldX5 = xTemp+1;
	var fieldY5 = yTemp;
		
	var fieldX6 = xTemp-1;
	var fieldY6 = yTemp+1;
		
	var fieldX7 =  xTemp; 
	var fieldY7 = yTemp+1;
    		
	var fieldX8 = xTemp+1;
	var fieldY8 = yTemp+1;
	
	//5x5 cover
	var fieldX9 = xTemp-2;
	var fieldY9 = yTemp-2;
	
	var fieldX10 = xTemp-1;
	var fieldY10 = yTemp-2;
	
	var fieldX11 = xTemp;
	var fieldY11 = yTemp-2;
	
	var fieldX12 = xTemp+1;
	var fieldY12 = yTemp-2;
	
	
	var fieldX13 = xTemp+2;
	var fieldY13 = yTemp-2;
	
	var fieldX14 = xTemp-2;
	var fieldY14 = yTemp-1;
	
	
	var fieldX15 = xTemp+2;
	var fieldY15 = yTemp-1;
	
	var fieldX16 = xTemp-2;
	var fieldY16 = yTemp;
		
	var fieldX17 = xTemp+2;
	var fieldY17 = yTemp;
	
	var fieldX18 = xTemp-2;
	var fieldY18 = yTemp+1;
	
	var fieldX19 = xTemp+2;
	var fieldY19 = yTemp+1;
	
	var fieldX20 = xTemp-2;
	var fieldY20 = yTemp+2;
	
	var fieldX21 = xTemp-1;
	var fieldY21 = yTemp+2;
	
	var fieldX22 = xTemp;
	var fieldY22 = yTemp+2;
	
	var fieldX23 = xTemp+1;
	var fieldY23 = yTemp+2;
	
	var fieldX24 = xTemp+2;
	var fieldY24 = yTemp+2;
	
	
	//3x3
	$('#' + X + fieldX1 + Y + fieldY1 + '> img').attr('src', "images/Infection/hover_cell.png");
	$('#' + X + fieldX2 + Y + fieldY2 + '> img').attr('src', "images/Infection/hover_cell.png");
	$('#' + X + fieldX3 + Y + fieldY3 + '> img').attr('src', "images/Infection/hover_cell.png");
	$('#' + X + fieldX4 + Y + fieldY4 + '> img').attr('src', "images/Infection/hover_cell.png");
	$('#' + X + fieldX5 + Y + fieldY5 + '> img').attr('src', "images/Infection/hover_cell.png");
	$('#' + X + fieldX6 + Y + fieldY6 + '> img').attr('src', "images/Infection/hover_cell.png");
	$('#' + X + fieldX7 + Y + fieldY7 + '> img').attr('src', "images/Infection/hover_cell.png");
	$('#' + X + fieldX8 + Y + fieldY8 + '> img').attr('src', "images/Infection/hover_cell.png");
	
	//5x5

	$('#' + X + fieldX9 + Y + fieldY9 + '> img').attr('src', "images/Infection/hover2_cell.png");
	$('#' + X + fieldX10 + Y + fieldY10 + '> img').attr('src', "images/Infection/hover2_cell.png");
	$('#' + X + fieldX11 + Y + fieldY11 + '> img').attr('src', "images/Infection/hover2_cell.png");
	$('#' + X + fieldX12 + Y + fieldY12 + '> img').attr('src', "images/Infection/hover2_cell.png");
	$('#' + X + fieldX13 + Y + fieldY13 + '> img').attr('src', "images/Infection/hover2_cell.png");
	$('#' + X + fieldX14 + Y + fieldY14 + '> img').attr('src', "images/Infection/hover2_cell.png");
	$('#' + X + fieldX15 + Y + fieldY15 + '> img').attr('src', "images/Infection/hover2_cell.png");
	$('#' + X + fieldX16 + Y + fieldY16 + '> img').attr('src', "images/Infection/hover2_cell.png");
	$('#' + X + fieldX17 + Y + fieldY17 + '> img').attr('src', "images/Infection/hover2_cell.png");
	$('#' + X + fieldX18 + Y + fieldY18 + '> img').attr('src', "images/Infection/hover2_cell.png");
	$('#' + X + fieldX19 + Y + fieldY19 + '> img').attr('src', "images/Infection/hover2_cell.png");
	$('#' + X + fieldX20 + Y + fieldY20 + '> img').attr('src', "images/Infection/hover2_cell.png");
	$('#' + X + fieldX21 + Y + fieldY21 + '> img').attr('src', "images/Infection/hover2_cell.png");
	$('#' + X + fieldX22 + Y + fieldY22 + '> img').attr('src', "images/Infection/hover2_cell.png");
	$('#' + X + fieldX23 + Y + fieldY23 + '> img').attr('src', "images/Infection/hover2_cell.png");
	$('#' + X + fieldX24 + Y + fieldY24 + '> img').attr('src', "images/Infection/hover2_cell.png");
}

function removeField(td){
	$('#' + td.id + '> img').attr('src', "images/Infection/empty_cell.png");
}

function putBluePoint(td){
	$('#' + td.id + '> img').attr('src', "images/Infection/blue_chip.png");
}

function putPointOnCoords(event){
	$('#' + event.data + '> img').attr('src', "images/Infection/red_chip.png");
}


function parseX(strPoint){
	var indexY = strPoint.indexOf('Y');
	return strPoint.substring(1, indexY);
}

function parseY(strPoint){
	var indexY = strPoint.indexOf('Y');
	return strPoint.substring(indexY + 1);
}