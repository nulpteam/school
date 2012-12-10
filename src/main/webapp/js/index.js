$(document).ready(function() {
	WEB_SOCKET_SWF_LOCATION = "js/WebSocket/WebSocketMain.swf";
	WEB_SOCKET_DEBUG = true;
	goTo('CurrentPos.html');
});

function goTo(link) {
	$('.paperList').remove();
	$('.page').append('<div class="paperList">'
			+ '<img id="wait_response" src="images/paperList/load.gif"></div>');
	$.post(link, function(resp) {
		$('.paperList').remove();
		$('.page').append(resp);
	});
}
function goTo2(link, param) {
	$.post(link, {
		connType : param
	}, function(resp) {
		$('.paperList').remove();
		$('.page').append(resp);
	});
}

function homeButtonClick() {
	goTo('Menu.html');
}

function refreshButtonClick() {
	goTo('CurrentPos.html');
}

function backButtonClick() {
	alert("deprecated");
	goTo('Menu.html');
}

function language(node) {
	var lang = node.id;
	$.post("chLang.html", {
		lang : lang
	}, function(data) {
		location.reload();
	});
}