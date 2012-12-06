<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div id="personalPage" class="paperList">
	<script src="js/Personal/personal.js" type="text/javascript"></script>
	<script src="js/Personal/lang_${lang}.js" type="text/javascript"></script>
	<script src="js/Personal/jquery-ui-datepicker.js"
		type="text/javascript"></script>
	<script src="js/Personal/jquery.ui.datepicker-${lang}.js"
		type="text/javascript"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$('#date').datepicker({
        		changeMonth: true,
        		changeYear: true,
        		dateFormat: 'dd.mm.yy',
        		yearRange: '1980:2012'
    		});
		});
	</script>

	<div class="homeButton" onclick=homeButtonClick();></div>
	<div class="refreshButton" onclick=refreshButtonClick();></div>
	<div class="title">
		<p align="center">${langPack['PP_title']}</p>
	</div>
	<table cellpadding="0" cellspacing="0">
		<tr id="name" class="name">
			<td class="param">${langPack['Name']}</td>
			<td class="value">${user.name}</td>
			<td class="editButton"><div onclick=editShowHide(this);></div></td>
		</tr>
		<tr class="edit">
			<td class="error"></td>
			<td><input></td>
			<td class="saveButton"><div onclick=saveName();></div></td>
		</tr>
		<tr id="email">
			<td class="param">Email:</td>
			<td class="value">${userAddInfo.email}</td>
			<td class="editButton"><div onclick=editShowHide(this);></div></td>
		</tr>
		<tr class="edit">
			<td class="error"></td>
			<td><input></td>
			<td class="saveButton"><div onclick=saveEmail();></div></td>
		</tr>
		<tr id="birthday">
			<td class="param">${langPack['PP_birthday']}</td>
			<td class="value">${userAddInfo.birthday}</td>
			<td class="editButton"><div onclick=editShowHide(this);></div></td>
		</tr>
		<tr class="edit">
			<td class="error"></td>
			<td><input id="date"></input></td>
			<td class="saveButton"><div onclick=saveBirthday();></div></td>
		</tr>
		<tr id="about">
			<td class="param">${langPack['PP_about']}</td>
			<td class="value">${userAddInfo.about}</td>
			<td class="editButton"><div onclick=editShowHide(this);></div></td>
		</tr>
		<tr class="edit">
			<td class="error"></td>
			<td><textarea maxlength="100" rows="5"></textarea></td>
			<td class="saveButton"><div onclick=saveAbout();></div></td>
		</tr>
		<tr id="pass">
			<td class="param">${langPack['PP_password']}</td>
			<td class="error"></td>
			<td class="editButton"><div onclick=editShowHide(this);></div></td>
		</tr>
		<tr class="edit">
			<td class="pass"><p>${langPack['PP_newPassword']}</p>
				<input id="old" type="password"></td>
			<td class="pass"><p>${langPack['PP_oldPassword']}</p>
				<input id="new" type="password"></td>
			<td class="saveButton"><div onclick=savePass();></div></td>
		</tr>
	</table>
</div>