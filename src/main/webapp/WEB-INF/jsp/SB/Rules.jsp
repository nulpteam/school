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
	<div class="backButton" onclick="goTo('Sb.html');"></div>
	<div class="clear"></div>
	<div class="SbRules">
		<p>
			${langPack['Sb_Rules_text']}
		</p>
	</div>
</div>
