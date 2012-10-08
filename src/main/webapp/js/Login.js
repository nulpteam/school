function register() {
	alert("REGISTER");
}

function language(node) {
	var lang = node.id;
	$.post("Language.html", {
		lang : lang
	});
	alert(lang);
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