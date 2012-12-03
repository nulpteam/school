<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="paperList">
	<c:forEach items="${sbJSLoader.scripts}" var="script">
		<script src="<c:out value="${script}"/>" type="text/javascript"></script>
	</c:forEach>
	<div class="caption"><c:out value="${langPack['Sb_title']}" /></div>
	<div class="SbMButtonRightHome" onclick="goTo('Menu.html')"></div>
	<div class="SbMButtonRightStat" onclick="goTo('SBStatistics.html')"></div>
	<div class="clear"></div>
	<div class="SbMenu">
		<div class="SbMSheep">
			<img id="SheepImg" alt="Sheep" src="images/SB/BS.gif">
		</div>
		<div class="clear"></div>
		<div class="SbMButtons">
			<div class="SbMCreateGPlaceholder">
				<div class="SbMCreateG"  onclick="createSbGame();"></div>
				<div class="b_text">${langPack['Sb_Create']}</div>
			</div>
			<div class="SbMConnectGPlaceholder">
				<div class="SbMConnectG" onclick="connectSbGame();"></div>
				<div class="b_text">${langPack['Sb_Connect']}</div>
			</div>
			<div class="SbMHelpPlaceholder">
				<div class="SbMHelp" onclick="showRules();"></div>
				<div class="b_text">${langPack['Sb_Rules']}</div>
			</div>
		</div>
	</div>
</div>
<!-- </body> -->
<!-- </html> -->