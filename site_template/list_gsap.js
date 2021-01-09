gsap.registerPlugin(ScrollTrigger);

gsap.from('.balloon1', {
  scrollTrigger:{
    trigger:".balloon1",
    markers:false,
    start:"top 20%",
    end : "bottom 10%",
    toggleActions: "play none reset none"
  },
  x: -200,
  opacity: 0,
  duration : 1
})

gsap.from('.balloon2', {
  scrollTrigger:{
    trigger:".balloon1",
    markers:false,
    start:"top 20%",
    end : "bottom 10%",
    toggleActions: "play none reset none"
  },
  x: 200,
  opacity: 0,
  duration : 1
})

gsap.from('.balloon3', {
  scrollTrigger:{
    trigger:".balloon2",
    markers:false,
    start:"top 20%",
    end : "bottom 10%",
    toggleActions: "play none reset none"
  },
  x: -200,
  opacity: 0,
  duration : 1
})

gsap.from('.balloon4', {
  scrollTrigger:{
    trigger:".balloon2",
    markers:false,
    start:"top 20%",
    end : "bottom 10%",
    toggleActions: "play none reset none"
  },
  x: 200,
  opacity: 0,
  duration : 1
})

gsap.from('.balloon5', {
  scrollTrigger:{
    trigger:".balloon4",
    markers:false,
    start:"top 20%",
    end : "bottom 10%",
    toggleActions: "play none none none"
  },
  x: -200,
  opacity: 0,
  duration : 1
})

gsap.from('.balloon6', {
  scrollTrigger:{
    trigger:".balloon4",
    markers:false,
    start:"top 20%",
    end : "bottom 10%",
    toggleActions: "play none none none"
  },
  x: 200,
  opacity: 0,
  duration : 1
})

gsap.from('.balloon7', {
  scrollTrigger:{
    trigger:".balloon6",
    markers:false,
    start:"top 20%",
    end : "bottom 10%",
    toggleActions: "play none reset none"
  },
  x: -200,
  opacity: 0,
  duration : 1
})

gsap.from('.balloon8', {
  scrollTrigger:{
    trigger:".balloon6",
    markers:false,
    start:"top 20%",
    end : "bottom 10%",
    toggleActions: "play none reset none"
  },
  x: 200,
  opacity: 0,
  duration : 1
})

gsap.from('.balloon9', {
  scrollTrigger:{
    trigger:".balloon8",
    markers:false,
    start:"top 20%",
    end : "bottom 10%",
    toggleActions: "play none reset none"
  },
  x: -200,
  opacity: 0,
  duration : 1
})

gsap.from('.balloon10', {
  scrollTrigger:{
    trigger:".balloon8",
    markers:false,
    start:"top 20%",
    end : "bottom 10%",
    toggleActions: "play none reset none"
  },
  x: 200,
  opacity: 0,
  duration : 1
})