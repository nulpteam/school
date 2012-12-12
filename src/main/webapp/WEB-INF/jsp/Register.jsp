<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div id="register" class="paperList">
	<script src="js/Login.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#register input').keypress(function(ev) {
				if (ev.keyCode == 13) {
					register();
				}
			});
		});
	</script>
	
	<div class="title">
		<p align="center">${langPack['Who_are_you']}</p>
	</div>
	<div id="registerForm">
		<div class="formError">
			<c:if test="${msg.alreadyReg=='true'}">
		        <b><c:out value="${langPack['User_exist']}" /></b>
		    </c:if>
		</div>
		<div class="formText">${langPack['Name']}</div>
		<div class="input">
			<input id="user_name">
		</div>
		<div class="formText">${langPack['Password']}</div>
		<div class="input">
			<input id="user_pass" type="password">
		</div>
		<div class="formText">${langPack['Confirm']}</div>
		<div class="input">
			<input id="user_pass_confirm" type="password">
		</div>
		<div class="button" onclick="register();">
			<p class="buttonText">${langPack['Register']}</p>
		</div>
	</div>
</div>