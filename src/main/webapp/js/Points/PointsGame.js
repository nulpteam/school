$(document).ready(function(){


});

function check(){
    $.get("PointCheck.html", function(responseMas){
		
    });
}

function putPoint(td_point){
    $('#' + td_point.id + ' > img').attr('src', 'images/Points/point1.png');
}
