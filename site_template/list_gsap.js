gsap.registerPlugin(ScrollTrigger);

function applyGsapToSearchResult() {
	
	$('.balloon__a').each(function(index, node) {
		const gsapSetDone = $(node).data('gsap-set-done');
		var a = 0;
		if ( gsapSetDone !== true ) {
			gsap.to(node, {
				scrollTrigger : {
					trigger : node,
					markers : false,
					start : "top 15%",
					end : "bottom 10%",
					strub:true
				},
				if($('.balloon__a > div').hasClass('balloon-left')){
					a = 600;
					x : a,
					opacity : 1,
					duration : 1
				}
				else if($('.balloon__a > div').hasClass('balloon-right')){
					a = -600;
					x : a,
					opacity : 1,
					duration : 1
				}
			});
			
			$(node).data('gsap-set-done', true);
		}
	});
}