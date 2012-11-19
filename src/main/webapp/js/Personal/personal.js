function editShowHide(node) {
	var param = node.parentNode.parentNode.id;
	var edit = $('#personalPage #' + param + ' + .edit');
	if (edit.is(':visible')) {
		edit.hide();
	} else {
		$('#personalPage #name + .edit').hide();
		$('#personalPage #email + .edit').hide();
		$('#personalPage #birthday + .edit').hide();
		$('#personalPage #about + .edit').hide();
		$('#personalPage #pass + .edit').hide();
		$('#personalPage #' + param + ' + .edit .error').text(editMsg);
		edit.show();
	}
}

function saveName() {
	var input = $('#personalPage #name + .edit input');
	var error = $('#personalPage #name + .edit .error');
	var regExp = /\w{4,}/;
	var value = regExp.exec(input.val());
	if (value == null) {
		error.text(failMsg);
	} else {
		$.post('ChangeName.html', {
			name : value[0]
		}, function(resp) {
			if (resp == true) {
				$('#personalPage #name .value').text(value[0]);
				$('#personalPage #name + .edit').hide();
				input.val('');
				error.text('');
			} else {
				error.text(userExistMsg);
			}
		});
	}
}

function saveEmail() {
	var input = $('#personalPage #email + .edit input');
	var error = $('#personalPage #email + .edit .error');
	var regExp = /^[-._a-z0-9]+@(?:[a-z0-9][-a-z0-9]+\.)+[a-z]{2,6}$/;
	var value = regExp.exec(input.val());
	if (value == null) {
		error.text(failMsg);
	} else {
		$.post('ChangeEmail.html', {
			email : value[0]
		}, function(resp) {
			if (resp == true) {
				$('#personalPage #email .value').text(value[0]);
				$('#personalPage #email + .edit').hide();
				input.val('');
				error.text('');
			}
		});
	}
}

function saveBirthday() {
	var input = $('#personalPage #birthday + .edit input');
	var error = $('#personalPage #birthday + .edit .error');
	var regExp = /(0[1-9]|[12][0-9]|3[01])(.)(0[1-9]|1[012])(.)(19|20)\d\d/;
	var value = regExp.exec(input.val());
	if (value == null) {
		error.text(failMsg);
	} else {
		$.post('ChangeBirthday.html', {
			birthday : input.val()
		}, function(resp) {
			if (resp == true) {
				$('#personalPage #birthday .value').text(value[0]);
				$('#personalPage #birthday + .edit').hide();
				input.val('');
				error.text('');
			}
		});
	}
}

function saveAbout() {
	var input = $('#personalPage #about + .edit textarea');
	$.post('ChangeAbout.html', {
		about : input.val()
	}, function(resp) {
		if (resp != null) {
			$('#personalPage #about .value').text(resp);
			$('#personalPage #about + .edit').hide();
			input.val('');
		}
	});
}

function savePass() {
	var inputOld = $('#personalPage #pass + .edit #old');
	var inputNew = $('#personalPage #pass + .edit #new');
	var error = $('#personalPage #pass .error');
	$.post('ChangePass.html', {
		oldPass : inputOld.val(),
		newPass : inputNew.val()
	}, function(resp) {
		if (resp == true) {
			$('#personalPage #pass + .edit').hide();
			inputOld.val('');
			inputNew.val('');
			error.text('');
		} else {
			error.text(failMsg);
		}
	});
}