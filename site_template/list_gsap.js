gsap.registerPlugin(ScrollTrigger);

function applyGsapToSearchResult() {

	$('.balloon__a').each(function(index, node) {
		const gsapSetDone = $(node).data('gsap-set-done');
		if (gsapSetDone !== true) {
			gsap.to(node, {
				scrollTrigger: {
					trigger: node,
					markers: true,
					start: "-150px 25%",
					end: "-100px 5%",
					scrub: true
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