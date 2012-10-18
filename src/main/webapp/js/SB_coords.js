
var M;
function createMatrix()
{
	alert("createMatrix");
	M = new Array();
	for(var i=0;i<10;i++)
	{
		M[i] = new Array();
		for(var j=0;j<10;j++)
		{
			M[i][j]=0;
		}
	}
	return M;
}
function getM()
{
	
	console.log(M);
	
}
function parseCoords(coords)
{
	var x,y;
	x = parseInt(coords[1]);
	y =  parseInt(coords[4]);
	var co = {"x" : x, 
					"y" : y };
	console.log(co);
	return co;
}
function saveCoords(coords)
{
	var saveCoordenates= parseCoords(coords);
	M[saveCoordenates.x][saveCoordenates.y]=1;
}
