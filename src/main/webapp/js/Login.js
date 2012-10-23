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