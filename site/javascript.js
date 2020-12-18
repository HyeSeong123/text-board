function EditorViewer1__init() {
	var body = document.querySelector('.viewer');
	var initialValue = body.innerHTML.trim();
	var viewer = new toastui.Editor.factory({
		el : body,
		initialValue : initialValue,
		viewer : true,
		plugins: [toastui.Editor.plugin.codeSyntaxHighlight]
	});
}
function EditorViewer2__init() {
	var body = document.querySelector('.content');
	var initialValue = body.innerHTML.trim();
	var viewer = new toastui.Editor.factory({
		el : body,
		initialValue : initialValue,
		viewer : true,
		plugins: [toastui.Editor.plugin.codeSyntaxHighlight]
	});
}
EditorViewer1__init();
EditorViewer2__init();