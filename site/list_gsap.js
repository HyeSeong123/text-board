gsap.registerPlugin(ScrollTrigger);
var tl1 = gsap.timeline();

tl1.to('.balloon1', {
	x: 600,
	opacity: 1,
	duration: 1,
	ease : "none"
},"+=0.2");

tl1.to('.balloon2', {
	x: -600,
	opacity: 1,
	duration: 1,
	ease : "none"
});

gsap.to('.balloon3', {
	scrollTrigger: {
		trigger: ".balloon2",
		markers: false,
		start: "top 15%",
		end: "bottom 10%",
		toggleActions: "play none reset none"
	},
	x: 600,
	ease: "none",
	opacity: 1,
	duration: 1
})

gsap.to('.balloon4', {
	scrollTrigger: {
		trigger: ".balloon2",
		markers: false,
		start: "top 15%",
		end: "bottom 10%",
		toggleActions: "play none reset none"
	},
	x: -600,
	ease: "none",
	opacity: 1,
	duration: 1
});

gsap.to('.balloon5', {
	scrollTrigger: {
		trigger: ".balloon4",
		markers: false,
		start:  "top 15%",
		end: "bottom 10%",
		toggleActions: "play none none none"
	},
	x: 600,
	ease: "none",
	opacity: 1,
	duration: 1
})

gsap.to('.balloon6', {
	scrollTrigger: {
		trigger: ".balloon4",
		markers: false,
		start: "top 15%",
		end: "bottom 10%",
		toggleActions: "play none none none"
	},
	x: -600,
	ease: "none",
	opacity: 1,
	duration: 1
})

gsap.to('.balloon7', {
	scrollTrigger: {
		trigger: ".balloon6",
		markers: false,
		start: "top 15%",
		end: "bottom 10%",
		toggleActions: "play none reset none"
	},
	x: 600,
	ease: "none",
	opacity: 1,
	duration: 1
})

gsap.to('.balloon8', {
	scrollTrigger: {
		trigger: ".balloon6",
		markers: false,
		start: "top 15%",
		end: "bottom 10%",
		toggleActions: "play none reset none"
	},
	x: -600,
	ease: "none",
	opacity: 1,
	duration: 1
})

gsap.to('.balloon9', {
	scrollTrigger: {
		trigger: ".balloon8",
		markers: false,
		start: "top 15%",
		end: "bottom 10%",
		toggleActions: "play none reset none"
	},
	x: 600,
	ease: "none",
	opacity: 1,
	duration: 1
})

gsap.to('.balloon10', {
	scrollTrigger: {
		trigger: ".balloon8",
		markers: false,
		start: "top 15%",
		end: "bottom 10%",
		toggleActions: "play none reset none"
	},
	x: -600,
	ease: "none",
	opacity: 1,
	duration: 1
})