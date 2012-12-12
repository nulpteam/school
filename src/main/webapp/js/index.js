var bsoundFlag;
$(document).ready(function() {
	WEB_SOCKET_SWF_LOCATION = "js/WebSocket/WebSocketMain.swf";
	WEB_SOCKET_DEBUG = true;
	document.onselectstart = function() {
		return false;
	};
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
	alert('deprecated');
	goTo('Menu.html');
}

function refreshButtonClick() {
	alert('deprecated');
	goTo('CurrentPos.html');
}

function language(node) {
	var lang = node.id;
	$.post("chLang.html", {
		lang : lang
	}, function(data) {
		location.reload();
	});
}