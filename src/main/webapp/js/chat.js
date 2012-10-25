function chatStart() {
	// $('#chat').hover(mouseover, mouseout);
	// var chatVisible = false;
	// function mouseover() {
	// if (chatVisible)
	// return;
	// $(this).animate({
	// 'marginLeft' : '-15px'
	// }, 100);
	// chatVisible = true;
	// }
	// function mouseout() {
	// if (!chatVisible)
	// return;
	// $(this).animate({
	// 'marginLeft' : '-420px'
	// }, 100);
	// chatVisible = false;
	// }
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

var collor = false;

function add(msgArray) {
	var open = '<tr><td class="sender">';
	var openC = '<tr class="collor"><td class="sender">';
	var mid1 = ':</td><td class="time">';
	var mid2 = '</td></tr><tr><td colspan="2" class="msg">';
	var mid2C = '</td></tr><tr class="collor"><td colspan="2" class="msg">';
	var close = '</td></tr>';
	var tag;
	for ( var i = 0; i < msgArray.length; i++) {
		if (collor) {
			tag = openC + msgArray[i].sender.name + mid1 + msgArray[i].time
					+ mid2C + msgArray[i].text + close;
			collor = false;
		} else {
			tag = open + msgArray[i].sender.name + mid1 + msgArray[i].time
					+ mid2 + msgArray[i].text + close;
			collor = true;
		}

		$('#chatTable').append(tag);
	}
}