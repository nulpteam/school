<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div class="paperList">
	<script src="js/jquery.js" type="text/javascript"></script>
	<script src="js/Points/PointsMenu.js" type="text/javascript"></script>

	<div id="pts_menu_create">
		<img src="images/Points/Create1.png" onClick=create();>
		<label id="pts_label_create">${langPack['Pts_create_label']}</label>
	</div>
	<div id="pts_menu_connect">
		<img src="images/Points/Connect1.png">
		<label id="pts_label_connect">${langPack['Pts_connect_label']}</label>
	</div>
	<div id="pts_menu_statistics">
		<img src="images/Points/statistics1.png">
		<label id="pts_label_statistics">${langPack['Pts_statistics_label']}</label>
	</div>
	<div id="pts_menu_rules">
		<img src="images/Points/rules1.png">
		<label id="pts_label_rules">${langPack['Pts_rules_label']}</label>
	</div>
	
	<div class="homeButton" onClick="goTo('Menu.html')"></div>
	<div class="refreshButton" onclick="goTo('Points.html')"></div>
</div>