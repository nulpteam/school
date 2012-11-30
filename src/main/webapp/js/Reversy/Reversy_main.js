/**
 * @author SergiyManko
 */

$(document).ready(function(){
	
    $(".canX").click(function(){
        clickX(this.id);
    });
    
    $(".canO").click(function(){
        clickO(this.id);
    });
});
function clickX(id) {
	 $.post("move.html", {
     	gameID : $("#gameID").attr("class"),
 		x : parseInt(id.charCodeAt(0))-97,
 		y : parseInt(id[1]-1),
 		figure : "x",
 		playerName : $("#userName").attr("class")
 	}, function(data) {
 	});
};
function clickO(id) {
	$.post("move.html", {
    	gameID : $("#gameID").attr("class"),
		x : parseInt(id.charCodeAt(0))-97,
		y : parseInt(id[1]-1),
		figure : "o",
		playerName : $("#userName").attr("class")
	}, function(data) {
	});
};