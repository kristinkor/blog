function windowScroll() {
    const e = document.getElementById("navbar");
    e && (document.body.scrollTop >= 50 || document.documentElement.scrollTop >= 50 ? e.classList.add("nav-sticky") : e.classList.remove("nav-sticky"))
}

function fadeIn() {
    var e = document.getElementById("error-msg")
      , t = 0
      , r = setInterval(function() {
        t < 1 ? (t += .5,
        e.style.opacity = t) : clearInterval(r)
    }, 200)
}
function toggleSwitcher() {
    var e = document.getElementById("style-switcher");
    "-189px" === e.style.left ? e.style.left = "-0px" : e.style.left = "-189px"
}
function setColor(e) {
    document.getElementById("color-opt").href = "./css/colors/" + e + ".css",
    toggleSwitcher(!1)
}
window.addEventListener("scroll", e=>{
    e.preventDefault(),
    windowScroll()
}
),
feather.replace();
