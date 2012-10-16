var end = false;

function createServer() {
	$('#outText').text('Чекайте на підключення');
	var inter1 = setInterval(check, 1000);
	function check() {
		$.post("XOAGetClient.html", function(response) {
			if (response != "") {
				clearInterval(inter1);
				$('#outText').text('Клієнт ' + response.name + ' підключився');
				$('#opName').text(response.name);
			}
		});
	}
}

//function connect(id) {
//	$.post("XOGameClient.html", {
//		serverID : id
//	}, function(resp) {
//		$('#outText').text('Чекайте на хід суперника');
//		$('#table').remove();
//		document.write(resp);
//	});
//	checker();
//}

function put(img) {
	if (end)
		return;
	$.post("XOAction.html", {
		xy : img.id
	}, function(response) {
		if (response == -5) {
			setImg(img, status);
			end = true;
			$('#outText').text('Ви перемогли !!!');
			// location.href = "XO.html";
		} else if (response == -3) {
		} else if (response == -2) {
			alert('Клітинка зайнята !!!');
		} else if (response == -1) {
			alert('Не ваша черга!!!');
		} else {
			status = response;
			setImg(img, response);
			$('#outText').text('Чекайте на хід суперника');
			checker();
		}
	});
}

function checker() {
	var inter = setInterval(check, 1000);
	function check() {
		$.post("XOACheck.html", function(response) {
			if (response == -5) {
				clearInterval(inter);
				change();
				end = true;
				$('#outText').text('Ви програли !!!');
				// location.href = "XO.html";
			} else if (response != 0) {
				clearInterval(inter);
				change();
				$('#outText').text('Ваш хід');
			}
		});
	}
}

function change() {
	$.post("XOAGet.html", function(box) {
		var id = "X" + box.x + "Y" + box.y;
		var img = document.getElementById(id);
		setImg(img, box.status);
	});
}

function setImg(img, status) {
	if (status == 0) {
		img.src = "images/XO/0.png";
	} else if (status == -8) {
		img.src = "images/XO/X.png";
	} else if (status == -9) {
		img.src = "images/XO/O.png";
	}
}