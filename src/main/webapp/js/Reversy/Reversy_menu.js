/**
 * 
 * @author SergiyManko
 *
 */

$(document).ready(function() {
	console.log("Reversy_menu script");
});

function goToList(ID) {
	goTo("ReversyGamesList.html");
};

function goToRules() {
	goTo("ReversyRules.html");
};

function create() {
	$.post("ReversyCreateGame.html", 
			function(response) {
					goTo("Reversy.html");
			});
};

