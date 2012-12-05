	$(document)
		.ready(
				function() {
//					console.log(location.hostname);
					  if (!("WebSocket" in window))
					  {
					    // the browser doesn't support WebSockets
					    alert("WebSockets NOT supported here!\r\n\r\nBrowser: " + navigator.userAgent + "\n");
					  }

					//Set URL of your WebSocketMain.swf here:
					WEB_SOCKET_SWF_LOCATION = "js/SB/WebSocketMain.swf";
					// Set this to dump debug message from Flash to console.log:
					WEB_SOCKET_DEBUG = true;
//					console.log(WEB_SOCKET_SWF_LOCATION);
				});	
					
function goTo(link) {
	$.post(link, function(resp) {
		$('.paperList').remove();
		$('.page').append(resp);
		//console.log(resp);
	});
}
function goTo2(link,param) {
	$.post(link, {
		connType : param
	},function(resp) {
		$('.paperList').remove();
		$('.page').append(resp);
		//console.log(resp);
	});
}

function homeButtonClick() {
	goTo('Menu.html');
}

function refreshButtonClick() {
	goTo('CurrentPos.html');
}

function backButtonClick() {
	goTo('Menu.html');
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