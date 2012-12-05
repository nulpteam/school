<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div class="paperList">
	<script src="js/jquery.js" type="text/javascript"></script>
	<script src="js/Points/PointsMenu.js" type="text/javascript"></script>

	<div id="pts_rules">
		<label>${langPack['Pts_rules']}</label>
	</div>

	<div class="homeButton" onclick="goTo('Menu.html')"></div>
	<div class="backButton" onClick="goTo('Points.html')"></div>
	<div class="ptsRefreshButton" onclick="goTo('PointsConnectList.html')"></div>
</div>