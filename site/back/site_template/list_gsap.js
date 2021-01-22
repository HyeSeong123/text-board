gsap.registerPlugin(ScrollTrigger);

function applyGsapToSearchResult() {
	$('.balloon-left').each(function(index, node) {
		const gsapSetDone = $(node).data('gsap-set-done');
		
		if ( gsapSetDone !== true ) {
			gsap.to(node, {
				scrollTrigger : {
					trigger : node,
					markers : true,
					start : "10% 15%",
					end : "bottom 10%",
					strub:true
				},
				x : 400,
				opacity : 1,
				duration : 1
			});
			
			$(node).data('gsap-set-done', true);
		}
	});
	$('.balloon-right').each(function(index, node) {
		const gsapSetDone = $(node).data('gsap-set-done');
		
		if ( gsapSetDone !== true ) {
			gsap.to(node, {
				scrollTrigger : {
					trigger : node,
					markers : true,
					start : "top 15%",
					end : "bottom 10%",
					strub:true
				},
				x : -400,
				opacity : 1,
				duration : 1
			});
			
			$(node).data('gsap-set-done', true);
		}
	});
}