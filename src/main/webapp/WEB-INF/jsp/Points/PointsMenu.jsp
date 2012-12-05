<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="SHORTCUT ICON" href="images/favicon.ico" type="image/x-icon"> 

<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/Points/PointsMenu.js" type="text/javascript"></script>
<title>School Games</title>
</head>
<body>-->
<div class="paperList">
	<script src="js/jquery.js" type="text/javascript"></script>
	<script src="js/Points/PointsMenu.js" type="text/javascript"></script>

	<div id="pts_menu_create">
		<img src="images/Points/Create1.png" onClick=create();>
		<label id="pts_label_create">Create</label>
	</div>
	<div id="pts_menu_connect" onClick=connect(this.id);>
		<img src="images/Points/Connect1.png">
		<label id="pts_label_connect">Connect</label>
	</div>
	<div id="pts_menu_statistics">
		<img src="images/Points/statistics1.png">
		<label id="pts_label_statistics">Statistics</label>
	</div>
	<div id="pts_menu_rules">
		<img src="images/Points/rules1.png">
		<label id="pts_label_rules">Rules</label>
	</div>
	
	<div class="homeButton" onClick="goTo('Menu.html')"></div>
	<div class="refreshButton" onclick="goTo('Points.html')"></div>
</div>