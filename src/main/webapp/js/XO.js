var end = false;

function createServer() {
	var inter1 = setInterval(check, 1000);
	function check() {
		$.post("XOAGetClient.html", function(response) {
			if (response != -3) {
				clearInterval(inter1);
				alert("Client connected");
			}
		});
	}
}

function connect(id) {
	$.post("XOGameClient.html", {
		id : id
	}, function(resp) {
		$('#table').remove();
		document.write(resp);
	});
	checker();
}

function put(img) {
	if (end)
		return;
	$.post("XOAction.html", {
		xy : img.id
	}, function(response) {
		if (response == -5) {
			setImg(img, status);
			end = true;
			alert("You WIN !!!!!!!!!!!!");
			// location.href = "XO.html";
		} else if (response == -3) {
			alert("Wait for client");
		} else if (response == -2) {
			alert("Field is not empty");
		} else if (response == -1) {
			alert("Not your turn");
		} else {
			status = response;
			setImg(img, response);
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
				alert("YOU LOSE !!!");
				// location.href = "XO.html";
			} else if (response != 0) {
				clearInterval(inter);
				change();
			}
		});
	}
}

function change() {
	$.post("XOAGet.html", function(box) {
		var id = "" + box.x + box.y;
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