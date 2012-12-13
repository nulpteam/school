/*author BogdanGutey*/
var p;
$(document).ready(function() {
	
	initPics();
	function second_passed() {
		hideAllPics();
		}
		setTimeout(second_passed, 3000);
});
 p =[];

function showPic(t)
{//console.log(t);
	if($(t).attr("lock")!=1)
	{
		$(t).hide(0);
		$(t).attr("src","images/Tab/picsGame/"+t.id+".png");
		$(t).show(0);
	
		if(p[0]===undefined)
		{
			p[0] = t.id;
			//console.log("e pershyj elementy masyvu");
		}
		else	if((p[0]!=undefined) && (p[1]==undefined))
		{
			p[1] = t.id;
			//console.log("e druhyj elementy masyvu");
		}
		console.log(p[0]+" sss "+p[1]);
		
		if(p[0]!=undefined && p[1]!=undefined)
			{
			//console.log("e dva elementy masyvu");
				if(p[0]!=p[1])
				{ 
					console.log(p[0]);
					console.log(p[1]);
					//alert("nerivni");
					x = p[0];
					y = p[1];
					setTimeout(function() {
						none(x, y);
					},750);
				}
				else
				{
					$("."+p[0]).each(function(){
						$(this).attr("lock","1");
					});
				}
				p[0] = undefined;
				p[1] = undefined;
				//console.log("vudalennya masyvu");
				//console.log(p[0]+" after "+p[1]);
			}
	}
}
function v()
{}
function initPics()
{	var p = getRandPicsIds();
	var i=0;
	$('.picsCell img').each(function(){
			$(this).attr("src","images/Tab/picsGame/p"+p[i]+".png");
			$(this).attr("class","p"+p[i]);
			$(this).attr("id","p"+p[i]);
			$(this).attr("lock",'1');
			
			i++;
		});		
}

function hideAllPics()
{
	$('.picsCell img').each(function(){
		$(this).fadeOut(500).delay(500);
		$(this).attr("src","images/Tab/picsGame/ramka.png");
		$(this).fadeIn(500);
		$(this).attr("lock",'0');
	
		
	});
}
function getRandArray()
{
	var arr = [];
	while(arr.length < 14){
	  var randomnumber=Math.ceil(Math.random()*14);
	  var found=false;
	  for(var i=0;i<arr.length;i++){
	    if(arr[i]==randomnumber){found=true;break;}
	  }
	  if(!found)arr[arr.length]=randomnumber;
	}
	console.log(arr);
	return arr;
}
 function getRandPicsIds()
 {
	 var arr = getRandArray();
	 var res = [];
	 res = res.concat(arr,arr);
	 console.log(res);
	 res = fisherYates(res);
	 console.log(res);
	 return res;
	}
 function fisherYates ( myArray ) {
	  var i = myArray.length;
	  if ( i == 0 ) return false;
	  while ( --i ) {
	     var j = Math.floor( Math.random() * ( i + 1 ) );
	     var tempi = myArray[i];
	     var tempj = myArray[j];
	     myArray[i] = tempj;
	     myArray[j] = tempi;
	   }
	  return myArray;
}
function none(a, b) {
	console.log("none ", a, b);
	$("#pics #"+a).fadeOut(0).delay(0).attr("src","images/Tab/picsGame/ramka.png").fadeIn(0).delay(0);
	$("#pics #"+b).fadeOut(0).delay(0).attr("src","images/Tab/picsGame/ramka.png").fadeIn(0).delay(0);
}