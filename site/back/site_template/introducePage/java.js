/**
 * 
 */
gsap.registerPlugin(ScrollTrigger);

gsap.from('.panel1>div>span', {
  duration: 1,
  scale:0,
  opacity:0,
  stagger:{
    amount : 1.5,
    from :"start"
  },
  scrollTrigger:{
    trigger:'.panel1',
    start:"0% 10%",
    end:"0%",
    toggleActions: 'play none reverse reverse'
  }
});

gsap.from('.panel2>div>span', {
  duration: 1,
  scale:0,
  opacity:0,
  stagger:{
    amount : 1.5,
    from :"start"
  },
  scrollTrigger:{
    trigger:'.panel2',
    start:"50% 0%",
    end:"0%",
    toggleActions: 'play none reverse reverse'
  }
});
gsap.from('.panel3>div>span', {
  duration: 1,
  scale:0,
  opacity:0,
  stagger:{
    amount : 2,
    from :"start"
  },
  scrollTrigger:{
    trigger:".panel3",
    start:"170% 0%",
    end:"0%",
    toggleActions: 'play none reverse reverse'
  }
});

gsap.from('.panel4>div>span', {
  duration: 1,
  scale:0,
  opacity:0,
  stagger:{
    amount : 2,
    from :"start"
  },
  scrollTrigger:{
    trigger:".panel4",
    start:"290% 0%",
    end:"0%",
    toggleActions: 'play none reverse reverse'
  }
});
gsap.to('.panel4>div>span', {
  duration: 2,
  color : "white",
  stagger:{
    amount : 3,
    from :"start"
  },
  scrollTrigger:{
	trigger:".panel4",
	start:"290% 0%",
	end:"0%",
	toggleActions: 'play none reverse reverse'
  }
});
gsap.from('.panel5>div>span', {
  duration: 1,
  scale:0,
  opacity:0,
  stagger:{
    amount : 2,
    from :"start"
  },
  stagger:{
    amount : 2,
    from :"start"
  },
  scrollTrigger:{
    trigger:".panel5",
    markers: true,
    start:"410% 0%",
    end:"0%",
    toggleActions: 'play none reverse reverse'
  }
});
gsap.to('.panel5>div>span', {
  duration: 1,
  color : "white",
  scrollTrigger:{
	trigger:".panel5",
	start:"410% 0%",
	end:"0%",
	toggleActions: 'play none reverse reverse'
  }
});

gsap.to('nav', {
  duration: 1,
  color : "white",
  scrollTrigger:{
	trigger:".panel-home-white",
	start:"250% 0%",
	end:"0%",
	toggleActions: 'play none reverse reverse'
  }
});
gsap.to('nav', {
  duration: 1,
  color : "white",
  scrollTrigger:{
	trigger:".panel-home-white",
	start:"250% 0%",
	end:"0%",
	toggleActions: 'play none reverse reverse'
  }
});

let sections = gsap.utils.toArray("section"),
    currentSection = sections[0];

gsap.defaults({overwrite: 'auto', duration: 0.3});

// stretch out the body height according to however many sections there are.
gsap.set("body", {height: (sections.length * 100) + "%"});

// create a ScrollTrigger for each section
sections.forEach((section, i) => {
  ScrollTrigger.create({
    // use dynamic scroll positions based on the window height (offset by half
	// to make it feel natural)
    start: () => (i - 0.5) * innerHeight,
    end: () => (i + 0.5) * innerHeight,
    // when a new section activates (from either direction), set the section
	// accordinglyl.
    onToggle: self => self.isActive && setSection(section)
  });
});

function setSection(newSection) {
  if (newSection !== currentSection) {
    gsap.to(currentSection, {scale: 0.8, autoAlpha: 0})
    gsap.to(newSection, {scale: 1, autoAlpha: 1});
    currentSection = newSection;
  }
}
ScrollTrigger.create({
  start: 1,
  end: () => ScrollTrigger.maxScroll(window) - 1,
  onLeaveBack: self => self.scroll(ScrollTrigger.maxScroll(window) - 2),
  onLeave: self => self.scroll(2)
}).scroll(2);

