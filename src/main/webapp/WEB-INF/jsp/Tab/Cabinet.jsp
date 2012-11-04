<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link href="css/Tab/cabinet.css" type="text/css" rel="stylesheet">
<script src="js/Tab/cabinet.js" type="text/javascript"></script>
<div id="cabinet">
	<%-- <table id="cabinetTable" cellpadding="0" cellspacing="0">
		<tr onclick=nameButton();>
			<td class="param"><p>Name:</p></td>
			<td class="value"><p>${user.name}</p></td>
		</tr>
		<tr id="name">
			<td colspan="2"><input class="input"></td>
			<td class="button"><button onclick=nameButtonDo();>Change</button></td>
		</tr>
		<tr onclick=passButton();>
			<td class="param" colspan="2"><p>Pass:</p></td>
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
	</table> --%>
	<div id="name" class="button" onmouseover=buttonOver(this.id); onmouseout=buttonOut(this.id); onclick=nameEdit();>
		<p align="center" class="text">Name: ${user.name}</p>
		<div id="edit">
			<p align="center" class="text">Enter new name</p>
			<input class="input">
		</div>
	</div>
	<div id="pass" class="button" onmouseover=buttonOver(this.id); onmouseout=buttonOut(this.id); onclick=passEdit();>
		<p align="center" class="text">Edit password</p>
		<div id="edit">
			<p align="center" class="text">Enter new password</p>
			<input class="input">
			<p align="center" class="text">Confirm</p>
			<input class="input">
		</div>
	</div>
	
	<div id="stat" class="button" onmouseover=buttonOver(this.id); onmouseout=buttonOut(this.id); onclick=statShowHide();>
		<p align="center" class="text">5inR Statistics</p>
		<table id="list">
			<tr><th>Name:</th><th>Wins</th><th>Losses</th><th>Total</th></tr>
		</table>
	</div>
</div>