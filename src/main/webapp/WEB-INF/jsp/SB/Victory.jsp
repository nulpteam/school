<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="plbs  paperList">
<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/SB/Victory.js" type="text/javascript"></script>
<div class="SbMButtonRightHome" onclick="closeAndgoTo('Menu.html')";></div>
<div class="backButton2" onclick="closeAndgoTo('Sb.html');"></div>
	<div class = "winloose">
		<h1><c:out value="${langPack['Sb_win']}"/></h1>
		<img alt="Victory" src="images/SB/BSVictory.gif" height="400px" width="400px">
	</div>
</div>