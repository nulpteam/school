function chatStart() {
	$('#cabinetTable #name').hide();
	$('#cabinetTable #oldPass').hide();
	$('#cabinetTable #newPass').hide();
	$('#cabinetTable #pass').hide();
}

var nameVisible = false;
function nameButton() {
	if (nameVisible) {
		$('#cabinetTable #name').hide();
		nameVisible = false;
	} else {
		$('#cabinetTable #name').show();
		nameVisible = true;
	}
}

function nameButtonDo() {
	var name = $('#name input').val();
	$.post("ChangeName.html", {
		name : name
	});
	$('#name input').val('');
	alert('ім`я змінено на ' + name);
	nameButton();
}

var passVisible = false;
function passButton() {
	if (passVisible) {
		$('#cabinetTable #oldPass').hide();
		$('#cabinetTable #newPass').hide();
		$('#cabinetTable #pass').hide();
		passVisible = false;
	} else {
		$('#cabinetTable #oldPass').show();
		$('#cabinetTable #newPass').show();
		$('#cabinetTable #pass').show();
		passVisible = true;
	}
}

function passButtonDo() {
	var oldPass = $('#oldPass input').val();
	var newPass = $('#newPass input').val();
	$.post("ChangePass.html", {
		oldPass : oldPass,
		newPass : newPass
	}, function(resp){
		if (resp) {
			alert('пароль змінено з ' + oldPass + ' на ' + newPass);
			passButton();
		} else {
			alert('ви ввели не правильний пароль');
		}
	});
}