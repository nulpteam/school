function login() {
	var name = $('#login #user_name').val();
	var pass = $('#login #user_pass').val();
	if (name == '' | pass == '') {
		$('#login .formError').text(inputEmptyMsg);
		return;
	}
	$.post('Login.html', {
		user_name : name,
		password : pass
	}, function(resp) {
		if (resp == true) {
			goTo('Menu.html');
		} else {
			$('#login .formError').text(userNotFoundMsg);
		}
	});
}

function register() {
	var name = $('#register #user_name').val();
	var pass = $('#register #user_pass').val();
	var passConfirm = $('#register #user_pass_confirm').val();
	var regExp = /\w{4,10}/;
	var value = regExp.exec(name);
	if (name == '' | pass == '' | passConfirm == '') {
		$('#register .formError').text(inputEmptyMsg);
		return;
	} else if (value == null) {
		$('#register .formError').text(failMsg);
		return;
	} else if (pass != passConfirm) {
		$('#register .formError').text(passConfirmMsg);
		return;
	}
	$.post('Register.html', {
		user_name : value[0],
		password : pass
	}, function(resp) {
		if (resp == true) {
			goTo('Menu.html');
		} else {
			$('#register .formError').text(userExistMsg);
		}
	});
}

//$(document).ready(function() {
//	$('#language_bar').hover(barover, barout);
//	function barover() {
//		$(this).animate({
//			'margin' : '0px 750px'
//		}, 100);
//	}
//	function barout() {
//		$(this).animate({
//			'margin' : '-35px 750px'
//		}, 100);
//	}
//});

//var i=0;
//var str = new Array();
//var passphrase ="Orest";
//function cheat(event)
//{
//	
//	var char = String.fromCharCode(event.keyCode || event.charCode);
//	str[i]=char;
//	c(str.join(''));
//	i++;
//}
//function c(s) 
//{
//	if(s===passphrase)
//	{
////		document.location.href="http://www.google.com";
////		document.location.replace("http://www.google.com");
////		html = '<img src="images/birds3.png" style="position:relative; top:0px; left:0px;">';
////		$('#t').html(html);
//		$('#bg').css("background-image","url('http://"+location.hostname+":"+location.port+"/School/images/background3.png')");
//	}
//}
//function clearz()
//{
//	val  = $('#name_area_input').val();
//	c(val);
//	str = new Array();
//	//console.log("cleared "+ str);
//}