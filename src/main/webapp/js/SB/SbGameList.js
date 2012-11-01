/**
 * 
 * @author SergiyManko
 *
 */

$(document).ready(function(){
	console.log("SBGAMELISTJS");
});

function connect(ID) {
	alert("Game ID = " + ID);
	$.post("SbGameSelected.html", 
			{ gameID: ID },
			function(response) {
				if (response === "OK") {
					location.href = "BsGame.html";
				} else {
					location.href = "index.html";
				}
		}
	);
};