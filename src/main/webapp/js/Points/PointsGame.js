$(document).ready(function(){


});

function check(){
    $.get("PointCheck.html", function(responseMas) {
		
    });
}

function getChanges() {
	$.get("PointsGetChanges.html", function(response) {
		
	});
}

function putPoint(td_point) {
    $('#' + td_point.id + ' > img').attr('src', 'images/Points/point1.png');
    $.post("PointPut.html", { xy : td_point.id }, function(response) {
    	
    });
}
