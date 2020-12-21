gsap.registerPlugin(ScrollTrigger);

function EditorViewer1__init() {
	var body = document.querySelector('.viewer');
	var initialValue = body.innerHTML.trim();
	var viewer = new toastui.Editor.factory({
		el: body,
		initialValue: initialValue,
		viewer: true,
		plugins: [toastui.Editor.plugin.codeSyntaxHighlight]
	});
}
function EditorViewer2__init() {
	var body = document.querySelector('.content');
	var initialValue = body.innerHTML.trim();
	var viewer = new toastui.Editor.factory({
		el: body,
		initialValue: initialValue,
		viewer: true,
		plugins: [toastui.Editor.plugin.codeSyntaxHighlight]
	});
}

gsap.from('.sentence-content>span', {
	duration: 1.3,
	y: 350,
	opacity: 0,
	stagger: {
		amount: 1,
		from: "start"
	},
	scrollTrigger: {
		trigger: '.sentence-content',
		markers: true,
		start: "0% 30%",
		end: "0%",
		toggleActions: 'play none none repeat'
	}
});


EditorViewer1__init();
EditorViewer2__init();