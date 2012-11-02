<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link href="css/Tab/cabinet.css" type="text/css" rel="stylesheet">
<script src="js/Tab/cabinet.js" type="text/javascript"></script>
<div id="cabinet">
	<table id="cabinetTable" cellpadding="0" cellspacing="0">
		<tr>
			<td class="param"><p>Name:</p></td>
			<td class="value"><p>${user.name}</p></td>
			<td class="button"><button onclick=nameButton();>Edit</button></td>
		</tr>
		<tr id="name">
			<td colspan="2"><input class="input"></td>
			<td class="button"><button onclick=nameButtonDo();>Change</button></td>
		</tr>
		<tr>
			<td class="param" colspan="2"><p>Pass:</p></td>
			<td class="button"><button onclick=passButton();>Edit</button></td>
		</tr>
		<tr id="oldPass">
			<td colspan="3"><input class="input"></td>
		</tr>
		<tr id="newPass">
			<td colspan="3"><input class="input"></td>
		</tr>
		<tr id="pass">
			<td colspan="3" class="button"><button onclick=passButtonDo();>Change</button></td>
		</tr>
	</table>
</div>