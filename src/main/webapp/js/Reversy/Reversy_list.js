/**
 * 
 * @author SergiyManko
 *
 */

$(document).ready(function(){
	console.log("Reversy_list script");
});
function connectGame(id) {
	$.post("ReversyConnectGame.html", {gameID: id},
		function(response) {
			if (response === "true") {
				goTo("Reversy.html");
			}
		}
	);
};