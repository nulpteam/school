function chatStart() {
	$('#chatForm').submit(function(eo) {
		eo.preventDefault();
		var msg = $('#chatInText');
		if (msg.val() != '') {
			$.post("Send.html", {
				msg : msg.val()
			}, function(resp) {
				msg.val('');
				add(resp);
			});
		}
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
		if (resp.length != 0) {
			add(resp);
		}
	});
}
var open = '<tr><td class="sender">';
var openC = '<tr class="collor"><td class="sender">';
var mid1 = ':</td><td class="time">';
var mid2 = '</td></tr><tr><td colspan="2" class="msg">';
var mid2C = '</td></tr><tr class="collor"><td colspan="2" class="msg">';
var close = '</td></tr>';
var collor = false;
var tag;
function add(msgArray) {
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
	if (msgArray.length > 0){
		$('#chatOutText').animate({scrollTop: 99999}, 500);
	}
}