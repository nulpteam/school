
var M;
function createMatrix()
{
	//alert("createMatrix");
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
function getM()
{
	
	console.log(M);
	
}
function parseCoords(coords,t)
{
	//alert(t);
	var x,y,type;
	x = parseInt(coords[1]);
	y =  parseInt(coords[4]);
	type = parseInt(t[1]);
	var co = {"t" : type,
					"x" : x, 
					"y" : y };
	console.log(co);
	return co;
}
function saveCoords(coords,t)
{
	var saveCoordenates= parseCoords(coords,t);
	M[saveCoordenates.x][saveCoordenates.y]=saveCoordenates.t+"1";
}
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


function clearOldCoordsInM(coords, type)
{
	//alert("coords"+coords+"   ---   "+type);
	var saveCoordenates= parseCoords(coords,type);
	M[saveCoordenates.x][saveCoordenates.y]="00";
}
