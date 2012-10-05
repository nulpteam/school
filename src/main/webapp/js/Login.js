function register() {
	alert("REGISTER");
}
function language(node) {
	var lang = node.id;
	$.post("Language.html", {
		lang : lang
	});
	alert(lang);
}