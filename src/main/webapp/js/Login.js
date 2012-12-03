function register() {
	window.location.href = "Reg.html";
}

function language(node) {
	var lang = node.id;
	$.post("chLang.html", {
		lang : lang},
	function(data)
	{
		location.reload();
	});
}

$(document).ready(function() {
	$('#language_bar').hover(barover, barout);
	function barover() {
		$(this).animate({
			'margin' : '0px 750px'
		}, 100);
	}
	function barout() {
		$(this).animate({
			'margin' : '-35px 750px'
		}, 100);
	}
});

var i=0;
var str = new Array();
var passphrase ="Orest";
function cheat(event)
{
	
	var char = String.fromCharCode(event.keyCode || event.charCode);
	str[i]=char;
	c(str.join(''));
	i++;
}
function c(s) 
{
	if(s===passphrase)
	{
//		document.location.href="http://www.google.com";
//		document.location.replace("http://www.google.com");
//		html = '<img src="images/birds3.png" style="position:relative; top:0px; left:0px;">';
//		$('#t').html(html);
		$('#bg').css("background-image","url('http://"+location.hostname+":"+location.port+"/School/images/background3.png')");
	}
}
function clearz()
{
	val  = $('#name_area_input').val();
	c(val);
	str = new Array();
	//console.log("cleared "+ str);
}
