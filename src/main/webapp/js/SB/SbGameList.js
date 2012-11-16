/**
 * 
 * @author SergiyManko
 *
 */

$(document).ready(function(){
	console.log("SBGAMELISTJS");
});

function connect(ID) {
	$.post("SbGameSelected.html", 
			{ gameID: ID },
			function(response) {
				if (response === "OK") {
					//location.href = "BsGame.html";
					goTo("BsGame.html");
				} else {
					//location.href = "index.html";
					goTo("index.html");
				}
		}
	);
};

