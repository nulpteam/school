var xoLink = 'XOMenu.html';
var ppLink = 'PersonalPage.html';

function goTo(link) {
	$.post(link, function(resp) {
		$('.paperList').remove();
		$('.page').append(resp);
	});
}

function homeButtonOver(elem) {
	$(elem).css({
		backgroundImage : 'url("images/paperList/homeOver.png")'
	});
}

function homeButtonOut(elem) {
	$(elem).css({
		backgroundImage : 'url("images/paperList/home.png")'
	});
}

function homeButtonClick() {
	goTo('Menu.html');
}

function refreshButtonOver(elem) {
	$(elem).css({
		backgroundImage : 'url("images/paperList/refreshOver.png")'
	});
}

function refreshButtonOut(elem) {
	$(elem).css({
		backgroundImage : 'url("images/paperList/refresh.png")'
	});
}

function refreshButtonClick() {
	goTo('CurrentPos.html');
}

function backButtonOver(elem) {
	$(elem).css({
		backgroundImage : 'url("images/paperList/backOver.png")'
	});
}

function backButtonOut(elem) {
	$(elem).css({
		backgroundImage : 'url("images/paperList/back.png")'
	});
}

function backButtonClick() {
	goTo('Menu.html');
}