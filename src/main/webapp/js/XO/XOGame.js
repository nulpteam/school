var lock = true;
var end = false;

// Координати
var tickX1 = '235px';
var tickX2 = '475px';

function returnToMenu() {
	if (end) {
		location.href = "XO.html";
	} else {
		var bool = confirm(msg2);
		if (bool) {
			$.post("XOLose.html", function(response) {
				location.href = "XO.html";
			});
		}
	}
}

function statShow(id) {
	$('#outText').hide();
	$('#'+id+'Stat').show();
}

function statHide(id) {
	$('#outText').show();
	$('#' + id).hide();
}

function getClient() {
	end = true;
	$('#outText').text(msg3);
	var inter1 = setInterval(check, 1000);
	function check() {
		$.post("XOGetClient.html", function(response) {
			if (response != "") {
				clearInterval(inter1);
				getClientStat(response.id);
				$('#outText').text(response.name + msg4);
				$('#opNameText').text(response.name);
				$('#tick').animate({
					marginLeft : tickX1
				}, 1000);
				end = false;
				lock = false;
			}
		});
	}
}

function getClientStat(id) {
	$.post("XOGetClientStat.html", { id : id }, function(response) {
		$('#opNameStat').html('<table class="statTable"><tr><td>Wins:</td><td>'+response.wins+'</td></tr><tr><td>Losses:</td><td>'+response.losses+'</td></tr><tr><td>Total:</td><td>'+response.total+'</td></tr></table>');
	});
}

function put(img) {
	if (lock)
		return;
	$.post("XOPut.html", {
		xy : img.id
	}, function(response) {
		if (response == -5) {
			lock = true;
			end = true;
			setImg(img, status);
			$('#outText').text(msg5);
			$('#win').css({
				zIndex : 1
			});
		} else if (response == -4) {
			lock = true;
			end = true;
			$('#outText').text($('#opName').text() + msg6);
		} else if (response == -3) {
		} else if (response == -2) {
			alert(msg7);
		} else if (response == -1) {
			alert(msg8);
		} else {
			lock = true;
			status = response;
			setImg(img, status);
			$('#outText').text(msg9);
			$('#tick').animate({
				marginLeft : tickX2
			}, 1000);
			checker();
		}
	});
}

function checker() {
	var inter = setInterval(check, 1000);
	function check() {
		$.post("XOCheck.html", function(response) {
			if (response == -5) {
				end = true;
				clearInterval(inter);
				change();
				$('#outText').text(msg10);
			} else if (response == -4) {
				end = true;
				$('#outText').text($('#opName').text() + msg6);
			} else if (response == -3) {
				clearInterval(inter);
				getClient();
			} else if (response != 0) {
				clearInterval(inter);
				change();
				$('#outText').text(msg11);
				lock = false;
				$('#tick').animate({
					marginLeft : tickX1
				}, 1000);
			}
		});
	}
}

function change() {
	$.post("XOGet.html", function(box) {
		var id = "X" + box.x + "Y" + box.y;
		var img = document.getElementById(id);
		setImg(img, box.status);
	});
}

function setImg(img, status) {
	if (status == 0) {
		img.src = "images/XO/0.png";
	} else if (status == -8) {
		img.src = "images/XO/X" + getRandomInt(0, 4) + ".png";
	} else if (status == -9) {
		img.src = "images/XO/O" + getRandomInt(0, 4) + ".png";
	}
}

function getRandomInt(min, max) {
	return Math.floor(Math.random() * (max - min + 1)) + min;
}