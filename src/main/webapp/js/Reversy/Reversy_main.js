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
        $("#" + this.id).attr("class", "x");
    });
    
    $(".canO").click(function(){
        console.log(this.id);
        $("#" + this.id).attr("class", "o");
    });
});