/**
 * @author SergiyManko
 */

$(document).ready(function(){
    $(".board").click(function(){
        console.log(this.id);
        $("#" + this.id).attr("class", "x");
    });
});