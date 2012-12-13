<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//tdr HTML 4.01 transitional//EN" "http://www.w3.org/tr/html4/loose.tdr">
<div id="hanoi" class="display">
	<script src="js/Tab/Hanoi.js" type="text/javascript"></script>
	<div id="cont">
	<table id="gameTable" style="display: none;">
		<tbody>
			<tr id="hanoiA">
				<td><div id="hanoia1" class="peg"></div></td>
				<td><div id="hanoia2" class="peg"></div></td>
				<td><div id="hanoia3" class="peg"></div></td>
			</tr>
			<tr id="hanoiB">
				<td><div id="hanoib1" class="peg"></div></td>
				<td><div id="hanoib2" class="peg"></div></td>
				<td><div id="hanoib3" class="peg"></div></td>
			</tr>
			<tr id="hanoiC">
				<td><div id="hanoic1" class="peg"></div></td>
				<td><div id="hanoic2" class="peg"></div></td>
				<td><div id="hanoic3" class="peg"></div></td>
			</tr>
			<tr id="hanoiD">
				<td><div id="hanoid1" class="peg"></div></td>
				<td><div id="hanoid2" class="peg"></div></td>
				<td><div id="hanoid3" class="peg"></div></td>
			</tr>
			<tr id="hanoiE">
				<td><div id="hanoie1" class="peg"></div></td>
				<td><div id="hanoie2" class="peg"></div></td>
				<td><div id="hanoie3" class="peg"></div></td>
			</tr>
			<tr id="hanoiF">
				<td><div id="hanoif1" class="peg"></div></td>
				<td><div id="hanoif2" class="peg"></div></td>
				<td><div id="hanoif3" class="peg"></div></td>
			</tr>
			<tr id="hanoiG">
				<td><div id="hanoig1" class="peg"></div></td>
				<td><div id="hanoig2" class="peg"></div></td>
				<td><div id="hanoig3" class="peg"></div></td>
			</tr>
			<tr id="hanoiH">
				<td><div id="hanoih1" class="peg"></div></td>
				<td><div id="hanoih2" class="peg"></div></td>
				<td><div id="hanoih3" class="peg"></div></td>
			</tr>
			<tr id="hanoiI">
				<td><div id="hanoif1" class="base"></div></td>
				<td><div id="hanoif2" class="base"></div></td>
				<td><div id="hanoif3" class="base"></div></td>
			</tr>		
		</tbody>
	</table>
	<div id="hanoimoves" style="display: none;">
	0
	</div>
	<div id="hanoimessage">
		 <br>
		 <br>
	</div>
	<div id="hanoihome" style="display: none;"  onclick="tabGoTo('Hanoi.html')">
	</div>
	
	<div id="hanoibest" style="display: none;"></div>
	<div id="hanoiMenu">
		<div id="hanoi3" onclick="startHanoi3()"></div>
		<div id="hanoi4" onclick="startHanoi4()"></div>
		<div id="hanoi5" onclick="startHanoi5()"></div>
		<div id="hanoi6" onclick="startHanoi6()"></div>
		<div id="hanoi7" onclick="startHanoi7()"></div>
	</div>
	</div>
</div>