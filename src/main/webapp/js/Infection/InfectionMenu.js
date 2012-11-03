function create(){
	window.location.href="InfectionGame.html";
}

function putPoint(td) {
	$('#' + td.id + '> img').attr('src', "images/Infection/green_chip.png");
}

function putRedPoint(td) {
	$('#' + td.id + '> img').attr('src', "images/Infection/red_chip.png");
}

function putGreenPoint(td) {
	$('#' + td.id + '> img').attr('src', "images/Infection/green_chip.png");
}

function putEmptyPoint(td) {
	$('#' + td.id + '> img').attr('src', "images/Infection/empty_cell.png");
}


