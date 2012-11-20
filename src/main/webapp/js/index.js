function goTo(link) {
	$.post(link, function(resp) {
		$('.paperList').remove();
		$('.page').append(resp);
		//console.log(resp);
	});
}
function goTo2(link,param) {
	$.post(link, {
		connType : param
	},function(resp) {
		$('.paperList').remove();
		$('.page').append(resp);
		//console.log(resp);
	});
}

function homeButtonClick() {
	goTo('Menu.html');
}

function refreshButtonClick() {
	goTo('CurrentPos.html');
}

function backButtonClick() {
	goTo('Menu.html');
}