$(document).ready(function() {

});

var myVar;

function check() {
	$.get("PointCheck.html", function(lastChanges) {

	});
}

function getChanges() {


	$.get("PointsGetChanges.html", function(lastChanges) {

		if (lastChanges.coordsOfChanges != 'none') {

			if (lastChanges.userThatChanged == 'server') {
				$('#' + lastChanges.coordsOfChanges + ' > img').attr('src',
						'images/Points/point1.png');
			} else {
				$('#' + lastChanges.coordsOfChanges + ' > img').attr('src',
						'images/Points/point2.png');
			}
		}
	});
}

function putPoint(td_point) {

	myVar = setInterval(function() {
		getChanges();
	}, 1000);
	
	$.post("PointPut.html", {
		point_xy : td_point.id
	}, function(response) {
		if (response == 'server') {
			$('#' + td_point.id + ' > img').attr('src',
					'images/Points/point1.png');
		} else {
			$('#' + td_point.id + ' > img').attr('src',
					'images/Points/point2.png');
		}
	});
}
