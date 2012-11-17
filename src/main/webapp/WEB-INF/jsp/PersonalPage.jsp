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
        		dateFormat: 'dd M, yy',
        		yearRange: '1980:2012'
    		});
		});
	</script>

	<div class="homeButton" onclick=homeButtonClick();></div>
	<div class="refreshButton" onclick=refreshButtonClick();></div>
	<div class="title">
		<p align="center">Personal Page</p>
	</div>
	<table cellpadding="0" cellspacing="0">
		<tr id="name" class="name">
			<td class="param">${langPack['Name']}</td>
			<td class="value">${user.name}</td>
			<td class="ppButton"><div onclick=editShowHide(this);>Edit</div></td>
		</tr>
		<tr class="edit">
			<td class="error"></td>
			<td><input></td>
			<td class="ppButton"><div onclick=saveName();>Save</div></td>
		</tr>
		<tr id="email">
			<td class="param">Email:</td>
			<td class="value">${userAddInfo.email}</td>
			<td class="ppButton"><div onclick=editShowHide(this);>Edit</div></td>
		</tr>
		<tr class="edit">
			<td class="error"></td>
			<td><input></td>
			<td class="ppButton"><div onclick=saveEmail();>Save</div></td>
		</tr>
		<tr id="birthday">
			<td class="param">Дата народження:</td>
			<td class="value">${userAddInfo.birthday}</td>
			<td class="ppButton"><div onclick=editShowHide(this);>Edit</div></td>
		</tr>
		<tr class="edit">
			<td class="error"></td>
			<td><input id="date"></input></td>
			<td class="ppButton"><div onclick=saveBirthday();>Save</div></td>
		</tr>
		<tr id="about">
			<td class="param">Про себе:</td>
			<td class="value">${userAddInfo.about}</td>
			<td class="ppButton"><div onclick=editShowHide(this);>Edit</div></td>
		</tr>
		<tr class="edit">
			<td class="error"></td>
			<td><textarea rows="5"></textarea></td>
			<td class="ppButton"><div onclick=saveAbout();>Save</div></td>
		</tr>
	</table>
	<div id="pass"></div>
	<div class="edit"></div>
</div>