function userInfo(elem) {
	$.post('GetUserInfo.html', {
		id : elem.id
	}, function(resp) {
		$('#userInfo #name + .param').text($(elem).text());
		$('#userInfo #email + .param').text(
				resp.email == null ? '' : resp.email);
		$('#userInfo #about + .param').text(
				resp.about == null ? '' : resp.about);
		$('#userInfo #birthday + .param').text(
				resp.birthday == null ? '' : resp.birthday);
		$('#userInfo').show();
	});
}

function chatStart() {
	chatSocket = new WebSocket("ws://" + location.hostname + ":8089");
	chatSocket.onmessage = function(event) {
		refresh();
	};
	$('#chatForm #chatInText').keypress(function(ev) {
		if (ev.keyCode == 13) {
			var msg = $('#chatInText');
			if (msg.val() != '') {
				$.post("Send.html", {
					msg : msg.val()
				}, function(resp) {
					if (resp == true) {
						msg.val('');
					}
				});
			}
		}
	});
	refresh();
};

function refresh() {
	$.post("Refresh.html", function(resp) {
		if (resp.length != 0) {
			add(resp);
		}
	});
}

var open = '<tr><td class="sender" onclick=userInfo(this); id="';
var openC = '<tr class="collor"><td class="sender" onclick=userInfo(this); id="';
var mid1 = '</td><td class="time">';
var mid2 = '</td></tr><tr><td colspan="2" class="msg">';
var mid2C = '</td></tr><tr class="collor"><td colspan="2" class="msg">';
var close = '</td></tr>';
var smile = '<div class="fuckAndDig"></div>';
var collor = false;
var tag;
var msg;
function add(msgArray) {
	for ( var i = 0; i < msgArray.length; i++) {
		msg = msgArray[i].text == '(fuckAndDig)' ? smile : msgArray[i].text;
		if (collor == true) {
			tag = openC + msgArray[i].sender.id + '">'
					+ msgArray[i].sender.name + mid1 + msgArray[i].time + mid2C
					+ msg + close;
			collor = false;
		} else {
			tag = open + msgArray[i].sender.id + '">' + msgArray[i].sender.name
					+ mid1 + msgArray[i].time + mid2 + msg + close;
			collor = true;
		}

		$('#chatTable').append(tag);
	}
	if (msgArray.length > 0) {
		$('#chatOutText').animate({
			scrollTop : 99999
		}, 500);
	}
}