//var xoStatSize;
//function chatStart() {
//	$.post('GetXOStatistics.html', function(resp) {
//		var start = '<tr><td>';
//		var midl = '</td><td>';
//		var end = '</td></tr>';
//		xoStatSize = resp.length;
//		for ( var i = 0; i < resp.length; i++) {
//			$('#stat #list').append(
//					start + resp[i].name + midl + resp[i].wins + midl
//							+ resp[i].losses + midl + resp[i].total + end);
//		}
//	});
//}
//
//function buttonOver(id) {
//	$('#' + id).css({
//		borderColor : "cornflowerBlue"
//	});
//}
//
//function buttonOut(id) {
//	$('#' + id).css({
//		borderColor : "chartreuse"
//	});
//}
//
//var nameEditable = false;
//function nameEdit() {
//	if (nameEditable) {
//		$('#name').animate({
//			height : "40px"
//		}, 500);
//		$('#name #edit').hide();
//		nameEditable = false;
//	} else {
//		$('#name').animate({
//			height : "100px"
//		}, 500);
//		$('#name #edit').show();
//		nameEditable = true;
//	}
//}
//
//var passEditable = false;
//function passEdit() {
//	if (passEditable) {
//		$('#pass').animate({
//			height : "40px"
//		}, 500);
//		$('#pass #edit').hide();
//		passEditable = false;
//	} else {
//		$('#pass').animate({
//			height : "165px"
//		}, 500);
//		$('#pass #edit').show();
//		passEditable = true;
//	}
//}
//
//var statVisible = false;
//function statShowHide() {
//	if (statVisible) {
//		$('#stat').animate({
//			height : "40px"
//		}, 500);
//		$('#stat #list').hide();
//		statVisible = false;
//	} else {
//		$('#stat').animate({
//			height : 70 + xoStatSize * 23 + "px"
//		}, 500);
//		$('#stat #list').show();
//		statVisible = true;
//	}
//}
//function nameButtonDo() {
//	var name = $('#name input').val();
//	$.post("ChangeName.html", {
//		name : name
//	});
//	$('#name input').val('');
//	alert('ім`я змінено на ' + name);
//	nameButton();
//}
//
//function passButtonDo() {
//	var oldPass = $('#oldPass input').val();
//	var newPass = $('#newPass input').val();
//	$.post("ChangePass.html", {
//		oldPass : oldPass,
//		newPass : newPass
//	}, function(resp) {
//		if (resp) {
//			alert('пароль змінено з ' + oldPass + ' на ' + newPass);
//			passButton();
//		} else {
//			alert('ви ввели не правильний пароль');
//		}
//	});
//}