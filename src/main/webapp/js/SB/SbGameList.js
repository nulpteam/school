/**
 * 
 * @author SergiyManko
 *
 */

//$(document).ready(function(){
//	console.log("SBGAMELISTJS");
//});

function connect(ID) {
	$.post("SbGameSelected.html", 
			{ gameID: ID },
			function(response) {
				if (response === "OK") {
					goTo("BsGame.html");
				} else {
					goTo("index.html");
				}
		}
	);
};