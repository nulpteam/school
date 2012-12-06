<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--  <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="SHORTCUT ICON" href="images/favicon.ico" type="image/x-icon"> 

<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/Infection/InfectionMenu.js" type="text/javascript"></script>
<title>School Games<!/title>
</head>
<body>-->
<div class="paperList">
	<script src="js/jquery.js" type="text/javascript"></script>
	<script src="js/Infection/InfectionMenu.js" type="text/javascript"></script>

	<div class="homeButton" onclick="goTo('Menu.html');"></div>
	<div class="refreshButton" onclick=refreshButtonClick();></div>
	
	<div id="infection_title">${langPack['Infection']}</div>
	<div class="button" id="infNewGame" onClick=create();>
		<center>
			<div class="buttonText">${langPack['INF_newgame']}</div>
		</center>
	</div>
	<div class="button" id="infConnectGame" onClick=getConnectionList();>
		<center>
			<div class="buttonText">${langPack['INF_connect']}</div>
		</center>
	</div>
	<div class="button" id="infRules" onClick="goTo('InfectionRules.html');">
		<center>
			<div class="buttonText">${langPack['INF_rules']}</div>
		</center>
	</div>
	<div class="button" id="infStatistic" onClick="goTo('InfectionStatistic.html');">
		<center>
			<div class="buttonText">${langPack['INF_statistic']}</div>
		</center>
	</div>
</div>
