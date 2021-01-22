gsap.registerPlugin(ScrollTrigger);

function applyGsapToSearchResult() {

	$('.balloon__a').each(function(index, node) {
		const gsapSetDone = $(node).data('gsap-set-done');
		if (gsapSetDone !== true) {
			gsap.to(node, {
				scrollTrigger: {
					trigger: node,
					markers: false,
					start: "-370px 25%",
					end: "-170px 20%",
				},
				x: 750,
				opacity: 1,
				duration: 1
			});
			$(node).data('gsap-set-done', true);
		}
	});
}
applyGsapToSearchResult();