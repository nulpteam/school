<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//tdr HTML 4.01 transitional//EN" "http://www.w3.org/tr/html4/loose.tdr">
<div id="brain" class="display">
	<script src="js/Tab/Brain.js" type="text/javascript"></script>
		<script type="text/javascript">
		$(document).ready(function() {
			startAll()
		});
		</script>
	<div id="cont">
	<table id="gameTable" style="display: none;">
		<tbody>
			<tr>
				<td><div class="ask"></div></td>
			</tr>
			<tr>
				<td><div id="A" class="answer" onclick="choise(this.id)"></div></td>
			</tr>
			<tr>
				<td><div id="B" class="answer" onclick="choise(this.id)"></div></td>
			</tr>
			<tr>
				<td><div id="C" class="answer" onclick="choise(this.id)"></div></td>
			</tr>
			<tr>
				<td><div id="D" class="answer" onclick="choise(this.id)"></div></td>
			</tr>
		</tbody>
	</table>
	<div id="brainmessage">
		 <br>
		 <br>
		 <br>
	</div>
	<div id="brainhome" style="display: none;"  onclick="tabGoTo('Brain.html')">
	</div>
	<div id="brainnext" style="display: none;"  onclick="nextQuestion()">
	</div>
	<div id="brainMenu">
		<div id="brain1" onclick="start1()"></div>
		<div id="brain2" onclick="start2()"></div>
		<div id="brain3" onclick="start3()"></div>
		<div id="brain4" onclick="startAll()"></div>
	</div>
	</div>
</div>