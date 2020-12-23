/**
 * 
 */
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
		start: "0% 30%",
		end: "0%",
		toggleActions: 'play none none repeat'
	}
});