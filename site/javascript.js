var str = "Baobab Study Blog.";
var c = 0;

function aaa() {
	setInterval(function() {
		if (c < 18)
			$('#txt').append(str[c]);
		c++;
	}, 300);
}
setTimeout(aaa, 3000);

// 유튜브 플러그인 시작
function youtubePlugin() {
	toastui.Editor.codeBlockManager.setReplacer('youtube', youtubeId => {
		// Indentify multiple code blocks
		const wrapperId = `yt${Math.random().toString(36).substr(2, 10)}`;

		// Avoid sanitizing iframe tag
		setTimeout(renderYoutube.bind(null, wrapperId, youtubeId), 0);

		return `<div id="${wrapperId}"></div>`;
	});
}

function renderYoutube(wrapperId, youtubeId) {
	const el = document.querySelector(`#${wrapperId}`);

	el.innerHTML = `<div class="toast-ui-youtube-plugin-wrap"><iframe src="https://www.youtube.com/embed/${youtubeId}" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe></div>`;
}
// 유튜브 플러그인 끝

/* 코드펜 에디터 */
function codepenPlugin() {
	toastui.Editor.codeBlockManager.setReplacer('codepen', url => {
		const wrapperId = `yt${Math.random().toString(36).substr(2, 10)}`;

		// Avoid sanitizing iframe tag
		setTimeout(renderCodepen.bind(null, wrapperId, url), 0);

		return `<div id="${wrapperId}"></div>`;
	});
}

function renderCodepen(wrapperId, url) {
	const el = document.querySelector(`#${wrapperId}`);

	var urlParams = new URLSearchParams(url.split('?')[1]);
	var height = urlParams.get('height');

	el.innerHTML = `<div class="toast-ui-codepen-plugin-wrap"><iframe height="${height}" scrolling="no" src="${url}" frameborder="no" loading="lazy" allowtransparency="true" allowfullscreen="true"></iframe></div>`;
}
/* 코드펜 에디터 */


function Editor__init() {
	$('.toast-ui-editor').each(function(index, node) {
		var initialValue = $(node).prev().html().trim().replace(/<!--REPLACE:script-->/gi, 'script');

		var editor = new toastui.Editor({
			el: node,
			previewStyle: 'vertical',
			initialValue: initialValue,
			height: 1000,
			plugins: [toastui.Editor.plugin.codeSyntaxHighlight, youtubePlugin, codepenPlugin]
		});
	});
}
Editor__init();

function EditorViewer1__init() {
	$('.toast-ui-viewer').each(function(index, node) {
		var initialValue = $(node).prev().html().trim().replace(/<!--REPLACE:script-->/gi, 'script');
		var viewer = new toastui.Editor.factory({
			el: node,
			initialValue: initialValue,
			viewer: true,
			plugins: [toastui.Editor.plugin.codeSyntaxHighlight, youtubePlugin,codepenPlugin]
		});
	});
}

function TopBar__init() {
	$(window).scroll("wheel", function(event) {
		var scrollTop = $(this).scrollTop();
		if (scrollTop > 100) {
			$('.top-side-bar').addClass('active');
		}
		else {
			$('.top-side-bar').removeClass('active');
		}
	});
	$(window).off("wheel", function(event) {
		$('.top-side-bar').removeClass('active');
	});
	$('.x-icon-cover').mouseenter(function() {
		$('.top-side-bar').addClass('leftIsZero');
	});
	$('.top-side-bar').mouseleave(function() {
		$('.top-side-bar').removeClass('leftIsZero');
	});
	$('.x-icon-cover').click(function() {
		$('.top-side-bar').removeClass('leftIsZero');
	});
}
TopBar__init();
EditorViewer1__init();