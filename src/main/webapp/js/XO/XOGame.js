var lock = true;
var end = false;

function returnToXO() {
	if (end) {
		location.href = "XO.html";
	} else {
		var bool = confirm('Якщо ви вийдете, ви автоматично програєте!!!');
		if (bool) {
			$.post("XOLose.html", function(response) {
				location.href = "XO.html";
			});
		}
	}
}
function getClient() {
	end = true;
	$('#outText').text('Чекайте на підключення');
	var inter1 = setInterval(check, 1000);
	function check() {
		$.post("XOGetClient.html", function(response) {
			if (response != "") {
				clearInterval(inter1);
				$('#outText').text(response.name + ' підключився');
				$('#opName').text(response.name);
				$('#tick').animate({
					marginLeft : '200px'
				}, 1000);
				end = false;
				lock = false;
			}
		});
	}
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
			$('#outText').text('Перемога :)');
			$('#win').css({zIndex: 1});
		} else if (response == -4) {
			lock = true;
			end = true;
			$('#outText').text($('#opName').text() + ' вийшов');
		} else if (response == -3) {
		} else if (response == -2) {
			alert('Клітинка зайнята !!!');
		} else if (response == -1) {
			alert('Не ваша черга!!!');
		} else {
			lock = true;
			status = response;
			setImg(img, status);
			$('#outText').text('Чекайте');
			$('#tick').animate({
				marginLeft : '525px'
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
				$('#outText').text('Програш :(');
			} else if (response == -4) {
				end = true;
				$('#outText').text($('#opName').text() + ' вийшов');
			} else if (response == -3) {
				clearInterval(inter);
				getClient();
			} else if (response != 0) {
				clearInterval(inter);
				change();
				$('#outText').text('Ваш хід');
				lock = false;
				$('#tick').animate({
					marginLeft : '200px'
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