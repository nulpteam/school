/**
 * @author SergiyManko
 */

$(document).ready(function(){
	
//	for ( var i = 97; i < 105; i++) {
//		for ( var j = 0; j < 9; j++) {
//			console.log(String.fromCharCode(i));
//			console.log(j);
//			$("#" + String.fromCharCode(i) + j).attr("class", "o");
//		}
//	}
	
    $(".canX").click(function(){
        console.log(this.id);
        console.log(parseInt(this.id.charCodeAt(0))-97);
        console.log(parseInt(this.id[1]));
        
        $.post("move.html", {
        	gameID : $("#gameID").attr("class"),
    		x : parseInt(this.id.charCodeAt(0))-97,
    		y : parseInt(this.id[1]-1),
    		figure : "x",
    		playerName : $("#userName").attr("class")
    	}, function(data) {
    	});
    });
    
    $(".canO").click(function(){
        console.log(this.id);
        console.log(parseInt(this.id.charCodeAt(0))-97);
        console.log(parseInt(this.id[1]));
        
        $.post("move.html", {
        	gameID : $("#gameID").attr("class"),
    		x : parseInt(this.id.charCodeAt(0))-97,
    		y : parseInt(this.id[1]-1),
    		figure : "o",
    		playerName : $("#userName").attr("class")
    	}, function(data) {
    	});
    });
});