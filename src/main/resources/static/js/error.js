  const svg = gsap.set("svg", { visibility: "visible" });

  const animateElement = (element, options) => {
    gsap.to(element, {
      ...options,
    });
  };

  const animateHeadStripe = () => {
    animateElement("#headStripe", {
      y: 0.5,
      rotation: 1,
      yoyo: true,
      repeat: -1,
      ease: "sine.inOut",
      duration: 1,
    });
  };

  const animateSpaceman = () => {
    animateElement("#spaceman", {
      y: 0.5,
      rotation: 1,
      yoyo: true,
      repeat: -1,
      ease: "sine.inOut",
      duration: 1,
    });
  };

  const animateCraterSmall = () => {
    animateElement("#craterSmall", {
      x: -3,
      yoyo: true,
      repeat: -1,
      duration: 1,
      ease: "sine.inOut",
    });
  };

  const animateCraterBig = () => {
    animateElement("#craterBig", {
      x: 3,
      yoyo: true,
      repeat: -1,
      duration: 1,
      ease: "sine.inOut",
    });
  };

  const animatePlanet = () => {
    animateElement("#planet", {
      rotation: -2,
      yoyo: true,
      repeat: -1,
      duration: 1,
      ease: "sine.inOut",
      transformOrigin: "50% 50%",
    });
  };

  const animateStarsBig = () => {
    animateElement("#starsBig g", {
      rotation: "random(-30,30)",
      transformOrigin: "50% 50%",
      yoyo: true,
      repeat: -1,
      ease: "sine.inOut",
    });
  };

  const animateStarsSmall = () => {
    animateElement(
      "#starsSmall g",
      {
        scale: 0,
        transformOrigin: "50% 50%",
      },
      {
        scale: 1,
        transformOrigin: "50% 50%",
        yoyo: true,
        repeat: -1,
        stagger: 0.1,
      }
    );
  };

  const animateCirclesSmall = () => {
    animateElement("#circlesSmall circle", {
      y: -4,
      yoyo: true,
      duration: 1,
      ease: "sine.inOut",
      repeat: -1,
    });
  };

  const animateCirclesBig = () => {
    animateElement("#circlesBig circle", {
      y: -2,
      yoyo: true,
      duration: 1,
      ease: "sine.inOut",
      repeat: -1,
    });
  };

  gsap.set("#glassShine", { x: -68 });

  const animateGlassShine = () => {
    animateElement("#glassShine", {
      x: 80,
      duration: 2,
      rotation: -30,
      ease: "expo.inOut",
      transformOrigin: "50% 50%",
      repeat: -1,
      repeatDelay: 8,
      delay: 2,
    });
  };


