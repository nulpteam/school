/**
 * 
 * @author SergiyManko
 *
 */

$(document).ready(function() {
	console.log("Reversy_menu script");
});

function goToList(ID) {
	alert("goToList(ID)");
//	$.post("G.html", 
//			{ gameID: ID },
//			function(response) {
//				if (response === "OK") {
					location.href = "ReversyGamesList.html";
//				} else {
//					location.href = "index.html";
//				}
//		}
//	);
};

function create() {
	alert("create()");
	location.href = "Reversy.html";
};