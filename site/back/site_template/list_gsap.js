gsap.registerPlugin(ScrollTrigger);

function applyGsapToSearchResult() {
	$('.balloon__a').each(function(index, node) {
		const gsapSetDone = $(node).data('gsap-set-done');
		
		if ( gsapSetDone !== true ) {
			gsap.to(node, {
				scrollTrigger : {
					trigger : node,
					markers : false,
					start : "top 15%",
					end : "bottom 10%",
					strub:true
				},
				x : 600,
				opacity : 1,
				duration : 1
			});
			
			$(node).data('gsap-set-done', true);
		}
	});
}