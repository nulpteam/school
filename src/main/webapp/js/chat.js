function chatStart() {
	$('#chat').hover(mouseover, mouseout);
	var chatVisible = false;
	function mouseover() {
		if (chatVisible)
			return;
		$(this).animate({
			'marginLeft' : '-15px'
		}, 100);
		chatVisible = true;
	}
	function mouseout() {
		if (!chatVisible)
			return;
		$(this).animate({
			'marginLeft' : '-420px'
		}, 100);
		chatVisible = false;
	}
	$('#chatForm').submit(function(eo) {
		eo.preventDefault();
		$.post("Send.html", {
			msg : $('#chatInText').val()
		}, function(resp) {
			$('#chatInText').val('');
			add(resp);
		});
	});

	$.post("StartChat.html");

	refresh();
	msgScanner();
};

function msgScanner() {
	setInterval(refresh, 5000);
}

function refresh() {
	$.post("Refresh.html", function(resp) {
		if (resp != "") {
			add(resp);
		}
	});
}

function add(msgArray) {
	var open = '<tr><td class="time">';
	var mid1 = '</td><td class="sender">';
	var mid2= '</td><td class="msg">';
	var close = '</td></tr>';
	for ( var i = 0; i < msgArray.length; i++) {
		$('#chatTable').append(
				open + msgArray[i].time + mid1 + msgArray[i].sender.name + ":    " + mid2
						+ msgArray[i].text + close);
	}
}