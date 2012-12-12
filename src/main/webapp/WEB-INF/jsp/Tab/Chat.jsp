<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="chat" class="display">
	<script src="js/Tab/Chat.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			chatStart();
		});
	</script>

	<div id="chatOutText">
		<table id="chatTable" cellpadding="0" cellspacing="0">
		</table>
	</div>

	<div id="chatForm">
		<input id="chatInText">
	</div>
	
	<table id="userInfo" cellpadding="0" cellspacing="0">
		<tr><td id="name" class="param_name">${langPack['Name']}</td><td class="param"></td></tr>
		<tr><td id="email" class="param_name">Email:</td><td class="param"></td></tr>
		<tr><td id="birthday" class="param_name">${langPack['PP_birthday']}</td><td class="param"></td></tr>
		<tr><td id="about" class="param_name">${langPack['PP_about']}</td><td class="param"></td></tr>
		<tr><td colspan="2" onclick="$('#userInfo').hide()" align="center">закрити</td></tr>
	</table>
</div>